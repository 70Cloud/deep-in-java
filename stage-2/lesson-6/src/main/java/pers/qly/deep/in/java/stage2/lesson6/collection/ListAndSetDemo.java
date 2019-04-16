package pers.qly.deep.in.java.stage2.lesson6.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 21:05 2019/2/16
 */
public class ListAndSetDemo {

    // List 可以通过下标访问
    // 疑问：RandomAccess（特点：随机访问） 为什么没有标注在 List 上
    public static void main(String[] args) {
        // HashSet 并不能保证顺序
        Set<String> values = new HashSet<>();
        // 可是有些场景可能让我们误导
        // 字符、字母场景
        values.add("a"); // 97
        values.add("b"); // 98
        values.add("c"); // 99
        values.forEach(System.out::println);

        // 数字场景
        values.clear();
        values.add("1");
        values.add("2");
        values.add("3");
        values.forEach(System.out::println);

        // 以上例子是 ASCII 码
        // HashSet 或者 HashMap 采用对象的 HashCode
        // String hashCode 由 char[] 数组构建
        /**
         * public static int hashCode(byte[] value) {
         *             int h = 0;
         *             for (byte v : value) {
         *                 h = 31 * h + (v & 0xff);
         *             }
         *             return h;
         *         }
         */
        // 在 Java 中 char（2字节）相当于 int（4字节）
        // 汉字通过2个char（4字节），用一个 int（4字节）表示
    }

    // 一致性 Hash 1,2,3(圆环) 用的就是 NavigableSet
    // 3000 个请求，平均每个节点1000个请求
    // 节点1失效，就会尝试获取2，3节点
}
