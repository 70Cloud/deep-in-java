package pers.qly.deep.in.java.stage2.lesson7.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: NoNo
 * @Description: 调整迭代器，看看 add(),remove() 报的错
 * @Date: Create in 23:31 2019/2/23
 */
public class IteratorModificationDemo {

    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3));

        Iterator<Integer> iterator = values.iterator();

        while (iterator.hasNext()){
            // List.add(T) 方法在 next() 调用之前会报错 ConcurrentModificationException
//            values.add(4); // 会报错

            // iterator.remove() 方法在 next() 调用之前会报错 IllegalStateException
//            iterator.remove(); // 会报错

            // List.remove(T) 方法在 next() 调用之前会报错 ConcurrentModificationException
//            values.remove(0);
            Integer value = iterator.next();
            // [0] = 1,[1] = 2,[2] = 3
            // cursor -> 1
            // v -> 1
            // [0] = 1,[1] = 2,[2] = 3,[3] = 4
            // cursor -> 2
            // v -> 2
            // [0] = 1,[1] = 2,[2] = 3,[3] = 4,[4] = 4
//            iterator.remove();
            System.out.println(value);
            // 结论：Iterator 只能在 next() 方法执行后，通过 remove() 移除数据，也无法对源 Collection 对象操作
            values.add(4); // ConcurrentModificationException
        }
    }
}
