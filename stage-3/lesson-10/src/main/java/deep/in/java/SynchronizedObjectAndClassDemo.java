package deep.in.java;

/**
 * @Author: NoNo
 * @Description:  Java 同步元语 - Synchronized：锁定对象：对象（Object）和类（Class）
 * @Date: Create in 17:17 2019/3/20
 */
public class SynchronizedObjectAndClassDemo {
    // 类锁其实就是对象锁

    public static void main(String[] args) {

        Object object = new Object();

        // 对象锁
        synchronized (object) { // Monitor -> Object
            // 对象存在 Heap（堆）
            // ...
        }

        // 类锁
        synchronized (Object.class) {
            // 类对象存在于 Metadata 区域（Java 8+）
            // 或者 Perm 区域（<= Java 7）方法区
            // ...
        }

        // Class 对象就是 Object 实例
        Object objectClass = Object.class;

    }
}
