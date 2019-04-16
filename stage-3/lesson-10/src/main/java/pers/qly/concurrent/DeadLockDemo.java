package pers.qly.concurrent;

/**
 * @Author: NoNo
 * @Description: Thread DeadLock
 * @Date: Create in 18:36 2019/3/20
 */
public class DeadLockDemo {
    // 何谓死锁？
    // 两个线程相互等待

    public static void main(String[] args) {

        final Object m1 = new Object();
        final Object m2 = new Object();

        new Thread(() -> {
            synchronized (m1) {
                System.out.printf("Thread[ ID : %d] holds m1\n", Thread.currentThread().getId());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (m2) {
                    System.out.printf("Thread[ ID : %d] holds m2\n", Thread.currentThread().getId());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (m2) {
                System.out.printf("Thread[ ID : %d] holds m2\n", Thread.currentThread().getId());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (m1) {
                    System.out.printf("Thread[ ID : %d] holds m1\n", Thread.currentThread().getId());
                }
            }
        }).start();

//        Thread.onSpinWait(); // 相互自旋
    }
}
