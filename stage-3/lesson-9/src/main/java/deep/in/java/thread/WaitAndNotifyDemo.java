package deep.in.java.thread;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:57 2019/3/9
 */
public class WaitAndNotifyDemo {

    // wait() 语义：在同步（互斥）场景下

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(WaitAndNotifyDemo::sayHelloWorld);
        t1.setName("T1");
        t1.start(); // 启动线程

        Thread t2 = new Thread(WaitAndNotifyDemo::sayHelloWorld);
        t1.setName("T2");
        t2.start();

        // Object.wait() 与 Thread,join() 看起来效果类似
        // 实际上 join() 方法就是调用 wait() 方法
        // 可以调用 notify,notifyAll 释放

        // 调用 wait() 方法的对象，再调用 notify() 方法必须是同一个对象
        // 因此以下调用是错误示范
        Object monitor = WaitAndNotifyDemo.class;
//        synchronized (monitor){
//            t1.notify();
//            t2.notify();
//        }

        // 正确的写法：
        synchronized (monitor){
//            monitor.notify(); // 为什么 notify() 不能保证完全释放
            monitor.notifyAll();
        }

        // Lock 场景：T1、T2,互斥访问资源 R
        // 假设 T1 获取 Lock(T1)-> T2 获取 Lock(T2)
        // T1.wait() T2.wait() 条件被阻塞（停顿）
        // 第三方可以（条件）控制 T1 或者 T2 释放

        // Java 5 condition 条件，await() 等待, signal() 通知

    }

    public static void sayHelloWorld() {
        Thread currentThread = Thread.currentThread();
        Object monitor = WaitAndNotifyDemo.class;
        synchronized (monitor){
            try {
                System.out.printf("线程[%s]进入等待状态...\n",currentThread.getName());
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("线程[id : %s] : Hello World!\n", currentThread.getId());
        System.out.printf("线程[%s]恢复执行...",currentThread.getName());
    }
}
