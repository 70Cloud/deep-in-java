package deep.in.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 20:42 2019/4/9
 */
public class StampedLockDemo {

    // StampedLock 邮票锁(Java)，在其他地方也叫 SeqLock 序列锁
    // 三种锁模式
    //• 写（Writing）
    //• 读（Reading）
    //• 优化读（Optimistic Reading）

    public static void main(String[] args) {
        // Java 1.8 之后提供
        StampedLock lock = new StampedLock();
        long stamp = lock.tryOptimisticRead();
        Lock readLock = lock.asReadLock();
        try {
            readLock.lock();
            lock.validate(stamp);
        } finally {
            readLock.unlock();
        }
    }
}
