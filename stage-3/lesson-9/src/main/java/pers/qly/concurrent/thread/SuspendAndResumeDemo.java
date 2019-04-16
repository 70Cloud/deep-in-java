package pers.qly.concurrent.thread;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:18 2019/3/9
 */
public class SuspendAndResumeDemo {

    public static void main(String[] args) {
        // Thread.suspend() 和 Thread.resume() 方法可以用在任意区域
        // suspend() 指定线程挂起
        // resume() 指定线程恢复
        // Object.wait() 和 Object.notify() 方法只能用在 synchronized 方法或块中
        // 通过 Monitor 控制线程状态
    }
}
