package deep.in.java;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 19:24 2019/4/9
 */
public class AcquireAndReleaseDemo {

    // ReentrantLock 重进入锁：主要是 synchronized API 的实现
    // ReentrantReadWriteLock 重进入读写锁：在 ReentrantLock 基础上增加了读锁（共享锁）和写锁（独占锁）
    // StampedLock 邮票锁：有一个版本的概念

    public static void main(String[] args) {
        // Lock 机制
        // 获得 Acquire
        // Thread 进入 synchronized -> 获得锁
        // 释放 Release
        // 1.当 Thread(hold lock)，调用 Object#wait() 时候，释放锁
        // 2.Thread park -> LockSupport.park(Object)，释放锁
        // 3.Condition#await()，会释放锁
        // 4.运行期发生异常，Thread 消亡
        // 5.Java 9 中自旋 Thread.onSpinWait()，会释放锁
        // 6.Thread.yield()，会释放锁

        // 所谓的公平（Fair）和非公平（UnFair）
        // 公平（Fair）：线程 FIFO
        // 非公平（UnFair）：线程随线程调度
        // 非公平锁的最佳实践：在创建线程时，除非必要，不要调整线程优先级（ThreadFactory#setPriority()）
    }
}
