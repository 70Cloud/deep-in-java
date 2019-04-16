package pers.qly.deep.in.java.stage2.lesson7.collection;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 21:59 2019/2/23
 */
public class WeakReferenceMapDemo {

    // 一个静态成员变量关联的是 ClassLoader

    public static void main(String[] args) throws InterruptedException {

        demoWeakHashMap();
    }

    private static void demoWeakHashMap() throws InterruptedException {

        // 强引用
        // value 变量是局部变量，存放在栈
        // "abc" 是常量，在 Java 8 之前是存放在 Perm 区域，Java 8+ 是存放在 META 区域
        // 在 demoWeakHashMap() 方法执行结束后，value 变量会立即被回收，"abc" 常量常驻
        String value = "abc";

        ReferenceQueue queue = new ReferenceQueue();

        // 弱引用
        WeakReference<User> userWeakReference = new WeakReference<>(new User("NoNo"), queue);

        // WeakReference 继承 Reference，Reference 有个入队操作：ReferenceQueue
        // 获取引用对象
        User user = userWeakReference.get();

        // WeakHashMap 有个 expungeStaleEntries() 方法 淘汰过期的 Entry

        for (int i = 0; i < 100; i++) {
            Thread.sleep(1 * 1000);
            System.out.println(user); // 当 "NoNo" 为空的时候会被回收
//            queue.poll();
        }

    }

    private static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
