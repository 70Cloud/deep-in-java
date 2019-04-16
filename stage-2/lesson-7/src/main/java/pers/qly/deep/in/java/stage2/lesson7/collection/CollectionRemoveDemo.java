package pers.qly.deep.in.java.stage2.lesson7.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:59 2019/2/23
 */
public class CollectionRemoveDemo {

    public static void main(String[] args) {

        // Q：在 ArrayList 遍历的时候，用 list.size() 的方式 remove 一个元素的时候，
        // 出现下标越界的问题而用 iterator 则不会。
        // 那么，iterator的实现机制是什么样的，为什么不会出现这个问题

        List<Integer> values = new ArrayList<>(List.of(1, 2, 3));

        // 常规做法
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        // 成功删除
        values = new ArrayList<>(List.of(1, 2, 3));
        int size = values.size();
        for (int i = 0; i < size; i++) {
            Object value = values.get(0); // 永远取第一个元素
            values.remove(value);
            System.out.println(values.size());
        }

        // 失败操作 1
//        values = new ArrayList<>(List.of(1, 2, 3));
//        size = values.size();
//        for (int i = 0; i < size; i++) {
//            values.remove(i); // IndexOutOfBoundsException
//        }

        // 失败删除 2
//        values = new ArrayList<>(List.of(1, 2, 3));
//
//        for (Integer value : values) {
//            values.remove(value); // ConcurrentModificationException
//        }


    }
}
