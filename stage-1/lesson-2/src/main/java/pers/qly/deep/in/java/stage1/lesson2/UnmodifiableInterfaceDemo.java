package pers.qly.deep.in.java.stage1.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:14 2019/1/17
 */
public class UnmodifiableInterfaceDemo {

    public static void main(String[] args) {
        Collection<Integer> values = of(1, 2, 3, 4, 5);

        values.add(6);

        System.out.println(values);

        values = unmodifiableOf(1, 2, 3, 4, 5);

        // 不允许修改
        // 所谓线程安全(必然是读或者写都是数据一致的)
        // 只读必然是线程安全(HashMap在不变的情况下也是线程安全的，之所以线程不安全是因为读和写的时候索引构建的时候会产生不一致)
        // 所以只读事务是设计比较好的
        // 如果别人问线程安不安全，需要确认有没有读写并存的情况
        // 例如：HashMap 有没有读写并存的情况
        // 只读事务性能最好
        values.add(6);
    }

    public static Collection<Integer> of(Integer... values) {
        return new ArrayList<Integer>(Arrays.asList(values));
    }

    public static Collection<Integer> unmodifiableOf(Integer... values) {
        return Collections.unmodifiableList(Arrays.asList(values));
    }
}
