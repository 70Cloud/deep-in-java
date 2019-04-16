package pers.qly.deep.in.java.stage1.lesson4.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: NoNo
 * @Description: Stream API 高级操作
 * 1.Collect 操作
 * 2.分组操作
 * 3.聚合操作
 * 4.flatMap 操作(二维数组降级成一维数组)
 * 5.reduce 操作
 * @Date: Create in 16:13 2019/2/16
 */
public class StreamCollectDemo {

    public static void main(String[] args) {

        List<Integer> values = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toList());

        System.out.println(values.getClass());

        // 创建数据，前后相加，结果相加
        values = Stream.of(1, 2, 3, 4, 5)
                .collect(LinkedList::new, List::add, List::addAll);

        System.out.println(values.getClass());
    }
}
