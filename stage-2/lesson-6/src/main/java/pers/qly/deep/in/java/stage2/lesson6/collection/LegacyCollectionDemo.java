package pers.qly.deep.in.java.stage2.lesson6.collection;

import java.util.*;

/**
 * @Author: NoNo
 * @Description: Legacy Collection 遗留集合实现 Vector Stack Hashtable
 * @Date: Create in 22:35 2019/2/16
 */
public class LegacyCollectionDemo {

    public static void main(String[] args) {
        // 几乎所有遗留实现都是线程安全的
        vectorVsList();
        vectorVsStack();
        hashTableVsHashMap();
        enumerationVsEnum();

        bitSet();
    }

    private static void bitSet() {
        // BitSet 用于位运算集合操作，可以搭配 NIO 中 ByteBuffer
        // Member 反射 中的 Modifier 里面也用了很多位运算 ，颜色也用了位运算
    }

    private static void enumerationVsEnum() {
        // Enumeration 主要用于迭代早期实现，由于 java.util.Iterator 从 Java 1.2 引入，属于一个过渡
        String value = "1,2,3";
        // 如果不能用 split 分割，可以用 StringTokenizer 来实现
        StringTokenizer tokenizer = new StringTokenizer(value,",");
        Enumeration enumeration = tokenizer;
        while (enumeration.hasMoreElements()){// 等价 Iterator.hasNext()
            String element = String.valueOf(enumeration.hasMoreElements());
            System.out.println(element);
        }

        // Iterable 从 Java 5 引入，用于for-each (Iterator 不能迭代)
    }

    private static void hashTableVsHashMap() {
        // HashTable 与 HashMap（算法有区别）
        // HashTable 实现 Dictionary 和 Map 接口，线程安全，key 与 Value 都不允许 null
        // HashMap 实现 Map 接口，线程非安全（写操作）,读操作是线程安全的, key 与 Value允许 null
        // 特殊: ConcurrentHashMap 不允许 null key 和 value 的情况
        // (如果 value 为空，ConcurrentHashMap 在查询数据时，会产生歧义,
        // 到底是值为空，还是线程不可见的情况)

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put(null,null);
    }

    private static void vectorVsStack() {
        // Vector 是 FIFO
        // Stack 是 LIFO，是 Vector 的子类
        // Stack 有个问题，达到一定值会扩容，所以构造器为空

    }

    private static void vectorVsList(){
        // Vector 是数组实现，应对比 ArrayList，而不是 LinkedList (List 有两种数据结构)
        // Vector 也实现了 List
        // Vector 是所有操作都是线程安全的，所有操作方法都用synchronized修饰
        // Vector 不推荐用，容易发生死锁
        Vector<String> vector = new Vector<>();
        List<String> list = new ArrayList<>();

        // 如果 Vector 在方法内部使用的话，Synchronized 修饰后的方法基本上没有太多线程切换的性能消耗
        vector.add("A");
        list.add("A");// 两者没什么区别
    }
}
