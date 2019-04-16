package pers.qly.deep.in.java.stage2.lesson6.collection;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 23:18 2019/2/16
 */
public class AbstractCollectionDemo {

    public static void main(String[] args) {

        abstractList();
    }

    private static void abstractList() {
        // 返回了 Arrays.ArrayList 只读，不允许写操作，但是允许下标数据交换
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        // Java 1.4 断言 assertion (可以加参数 -ea 打开)
        assert numbers instanceof AbstractList;

//        numbers.add(0);// 会报错 UnsupportedOperationException

        numbers.set(4,0);
        numbers.forEach(System.out::println);
    }
}
