package pers.qly.concurrent;

/**
 * @Author: NoNo
 * @Description: Java 同步元语 - Synchronized：锁定范围：方法（Method）和代码块（Block）
 * 特点：重进入
 * @Date: Create in 17:19 2019/3/20
 */
public class SynchronizedMethodAndBlockDemo {

    public static void main(String[] args) {
        // synchronized 保证互斥
        // 当某个线程 T1 获得锁（1），重新又见到 synchronized（+1）
        // 以此类推
        echo("Hello,World"); //　echo 到底重进入了多少次（看被锁了多少次 synchronized）？3
        // echo -> PrintStream.println -> newLine()
        doEcho("Hello,World"); //　doEcho 到底重进入了多少次？4
        // doEcho -> echo -> PrintStream.println -> newLine()

        // 重进入的好处
        // 锁定了范围，在最外层的 synchronized，做了一层保护
    }

    /**
     * synchronized 修饰代码块（Block）
     * 会添加 monitorenter/monitorexit
     * @param message
     */
    private static void doEcho(String message) {
        Object object = new Object();
        synchronized (object) {
            // wait 和 notify
            echo(message);
        }
    }

    /**
     * synchronized 修饰方法（实例或类）
     * 会添加 ACC_SYNCHRONIZED
     * @param message
     */
    private synchronized static void echo(String message) {
        System.out.println(message);
    }
}
