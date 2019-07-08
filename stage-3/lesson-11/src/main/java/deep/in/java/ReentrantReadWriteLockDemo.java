package deep.in.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 20:30 2019/4/9
 */
public class ReentrantReadWriteLockDemo {

    // 重进⼊入读写锁 - ReentrantReadWriteLock
    // 继承 ReentrantLock 的特性
    //• 互斥（Mutual Exclusion）
    //• 重进入（Reentrancy）
    //• 获得顺序（公平和非公平）
    //• 中段（Interruption）
    //• 条件对象支持（Condition Support）

    // 超越 ReentrantLock 的特性
    //• 共享-互斥模式（Shared - Exclusive）
    //  • 读锁 - 共享
    //  • 写锁 - 互斥
    //• 锁降级（Lock downgrading）

    public static void main(String[] args) {

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();
    }
}
