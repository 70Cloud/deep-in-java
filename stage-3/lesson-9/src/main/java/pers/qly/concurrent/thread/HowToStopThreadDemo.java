package pers.qly.concurrent.thread;

import java.util.concurrent.Executors;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:22 2019/3/9
 */
public class HowToStopThreadDemo {

    // Q：如何停止一个线程?
    // A：1.interrupt 2.volatile stopped 变量

    public static void main(String[] args) {

        StoppableAction action = new StoppableAction();
        Thread thread = new Thread(action);
        // 线程启动（并不一定执行）
        thread.start();
        // main 线程调整 stopped 状态到 true
        action.stop();
        // 如果线程池的话，以上方案可能存在问题
        Executors.newCachedThreadPool();// 几乎无限数量线程
        Executors.newFixedThreadPool(2);// 有且只有2个线程
    }

    private static class StoppableAction implements Runnable{

        // 确保原子操作
        private volatile boolean stopped;

        @Override
        public void run() {
            if(stopped){
                // 通过异常的方式，可以
                System.out.println("Action 终止...");
                return;
            }

            System.out.println("Action 执行...");
        }

        public void stop() {
            this.stopped = true;
        }
    }
}
