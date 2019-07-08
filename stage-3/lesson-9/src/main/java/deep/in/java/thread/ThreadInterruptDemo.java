package deep.in.java.thread;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 20:56 2019/3/9
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        // 方法引用
        Thread thread = new Thread(ThreadInterruptDemo::sayHelloWorld);
        // interrupt() 方法在 start 调用之前是没有效果的
        thread.start(); // 启动线程
        // interrupt() 并不能终止线程，但是可以传递 interrupted 状态
        thread.interrupt();// main 线程 interrupt 子线程
        thread.join(); // 等待线程结束,join 可以让线程变成同步

    }

    public static void sayHelloWorld() {
        if(Thread.currentThread().isInterrupted()){
            System.out.printf("线程[id : %s] 被终止！\n", Thread.currentThread().getId());
            return;
        }

        Object monitor = ThreadInterruptDemo.class;
        synchronized (monitor) {
            try {
                monitor.wait(10000);
            } catch (InterruptedException e) {
                // 当前 interrupted 状态被清楚 == false
                e.printStackTrace();
                System.out.printf("线程[id : %s] 当前 interrupted 状态为 : %s\n",
                        Thread.currentThread().getId(), Thread.currentThread().isInterrupted());
            }
        }
        System.out.printf("线程[id : %s] : Hello World!\n", Thread.currentThread().getId());
    }
}
