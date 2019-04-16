package pers.qly.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 19:27 2019/4/9
 */
public class ReentrantLockDemo {

    // ReentrantLock 重进入锁：主要是 synchronized API 的实现
    // ReentrantReadWriteLock 重进入读写锁：在 ReentrantLock 基础上增加了读锁（共享锁）和写锁（独占锁），类比数据库事务
    // StampedLock 邮票锁：有一个版本的概念

    // ReentrantLock 与 synchronized 的类似点
    //   互斥(Mutual Exclusion)
    //   重进入(Reentrancy)
    //   隐性 Monitor 机制

    // ReentrantLock 与 synchronized 的不同点
    //   获得顺序（公平锁和非公平）
    //   限时锁定（tryLock）
    //   条件对象支持（Condition Support）
    //   运维方法

//    private final ReentrantLock lock = new ReentrantLock();
//
//    // ...
//
//    public void m(){
//        lock.lock(); // block until condition holds
//        try {
//            // ... method body
//        }finally {
//            lock.unlock();
//        }
//    }

    public static void main(String[] args) {

        lockOpsMethods();
    }

    private static void lockOpsMethods() {
        ReentrantLock lock = new ReentrantLock();
        int count = lock.getHoldCount();
        System.out.printf("在 lock() 方法调用之前的线程 [%s] 重进入数: %d\n", Thread.currentThread().getName(), count);

        lock(lock, 10);
    }

    private static void lock(ReentrantLock lock, int times) {
        if (times < 1) {
            return;
        }

        lock.lock();

        try {
            lock(lock, --times);
            System.out.printf("第 %s 次在 lock() 方法调用之后的线程 [%s] 重进入数: %d\n",
                    times + 1, // times-- 先 load，后 minus 1
                    Thread.currentThread().getName(),
                    lock.getHoldCount());

        } finally {
            lock.unlock();
        }
    }

    private static void conditionObject() {
        Lock lock = new ReentrantLock();

        // 条件变量包括条件，同时它又是线程通讯媒介
        Condition condition = lock.newCondition();

        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void tryLockInTimeout() {
        Lock lock = new ReentrantLock();

        try {
            // 当前仅当在规定时间内获得锁
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                // Lock API 语义补充了 synchronized 原语的不足
                // TODO Add some logic
            }
        } catch (InterruptedException e) {
            // 重置中止状态（防止中途被清除 interrupted 状态）
            Thread.currentThread().interrupt();
            // logger error message
        }
    }

    private static void synchronizedStatement() {
        // 存在问题：假设出现死锁或者饥饿
        synchronized (ReentrantLockDemo.class) {
            if (3 > 2) { // 条件
                // Object 线程通讯状态
                try {
                    ReentrantLockDemo.class.wait();
                } catch (InterruptedException e) {
                    // logger error message
                }
            }
        }
    }
}
