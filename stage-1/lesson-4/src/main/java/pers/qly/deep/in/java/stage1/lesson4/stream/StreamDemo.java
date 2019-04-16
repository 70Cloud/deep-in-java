package pers.qly.deep.in.java.stage1.lesson4.stream;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 15:58 2019/2/16
 */
public class StreamDemo {

    public static void main(String[] args) {

        count(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        line();

        sort(6, 4, 7, 9, 8, 1, 3, 2, 5);
        line();

        // 比较器 , 倒序排序
        sort((x, y) -> (x < y) ? 1 : ((x == y) ? 0 : -1),
                6, 4, 7, 9, 8, 1, 3, 2, 5);
        line();

        parallelSort(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    private static void line() {
        System.out.println();
    }

    private static void parallelSort(Integer... numbers) {
        Stream.of(numbers)
                .sorted()
                .parallel() // 转换并行 Stream 操作(如果数据没有相互依赖可以这么做)
                .forEach(StreamDemo::println);
    }

    private static void println(Object object) {
        System.out.printf("[%s] : %s\n", Thread.currentThread().getName(), object);
    }


    private static void sort(Integer... numbers) {
        Stream.of(numbers)
                .sorted()
                .forEach(System.out::println);
    }

    private static void sort(Comparator<Integer> comparator, Integer... numbers) {
        Stream.of(numbers)
                .sorted(comparator)
                .forEach(System.out::println);
    }

    private static void count(Integer... numbers) {
        Stream.of(numbers)
                .reduce(Integer::sum) // 合并/聚合
                .map(String::valueOf)
                .ifPresent(System.out::println);
    }
}
