package pers.qly.concurrent;

/**
 * @Author: NoNo
 * @Description: Thread Starvation 饥饿(线程还没来)，与 FinalReference 相似
 * @Date: Create in 18:39 2019/3/20
 */
public class ThreadStarvationDemo {

    public static void main(String[] args) {
        new ThreadStarvationDemo();
        // 线程忙不过来，无暇顾及，所以没有输出，但是 GC 还是有的
    }

    public void finalize() { // FinalReference
        System.out.printf("Thread[%s] executes current object's finalization.\n", Thread.currentThread().getName());
    }
}
