package pers.qly.deep.in.java.stage2.lesson6.collection;

import java.util.List;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 20:25 2019/2/16
 */
public class ArrayCopyDemo {

    public static void main(String[] args) {
        String[] strings1 = new String[]{"Hello", "World"};

        arrayCopy(strings1, strings1);

        // javascript中的字典结构
        // value[1] = 1
        // value['a'] = 1
        // Java中数组相关，大小都有限制，链表则无限制
        // C语言中则不知道数组的长度，传的时候会传个长度

        int value = Integer.MAX_VALUE;

        System.out.println(value + 1);
        System.out.println(value + 1 == Integer.MIN_VALUE);
        System.out.println(value + 2 == Integer.MIN_VALUE + 1);
        // int 在 Java 中只有 4字节（32位）

        // OS 32位（4字节）以及 64位（8字节）
        // long 和 double 是非线程安全的， 两个4字节，高和低位
        // Java 中默认是没有正整数（无符号整数）
        // C 中 unsigned int(size_t)

        List<String> values = List.of();

        // values.size() == 0
        // values.size() < 1 可以用这个，少一点符号，也清晰
    }

    public static void arrayCopy(Object[] src, Object[] destination) {

    }
}
