package pers.qly.concurrent.thread;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 20:56 2019/3/9
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        // Thread 实现了 Runnable 接口
        // 如果没有传递 Runnable 对象实现，空执行(会判断 target 有没有)
//        Thread thread = new Thread(new Runnable() {
//            public void run() {
//                System.out.printf("线程[id : %s] : Hello World!\n",Thread.currentThread().getId());
//            }
//        });

        Thread thread = new Thread(ThreadDemo::sayHelloWorld);

        thread.start(); // 启动线程
        thread.join(); // 等待线程结束,join 可以让线程变成同步

        System.out.println("Hello next...");
        System.out.println(thread.getState());
    }

    public static void sayHelloWorld() {
        System.out.printf("线程[id : %s] : Hello World!\n", Thread.currentThread().getId());
    }
}
