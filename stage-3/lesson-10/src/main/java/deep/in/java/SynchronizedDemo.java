package deep.in.java;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 17:06 2019/3/20
 */
public class SynchronizedDemo {
    // 只读和不变的对象 JVM 底层不会感知
    // Happens-before 主要影响可见性
    public static void main(String[] args) {

        synchronized (SynchronizedDemo.class) {

        }

        new Thread().start();
    }

    private static void changeValue(int value) {
        // 线程私有对象，尽管它也在堆里面
        // 栈保存 value 名称，data 变量名称
        // 堆共享（被其他线程可见）是线程不安全的，保存在内存中
        // 当线程不加以控制数量的话，容易导致 JVM OOM
        Data data = new Data();
        data.setValue(1);
    }

    private static class Data {

        /**
         * 线程安全
         */
        private volatile int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
