package pers.qly.deep.in.java.stage2.lesson8.collection.algorithm;

import java.util.stream.Stream;

/**
 * @Author: NoNo
 * @Description: 插入排序
 * @Date: Create in 21:39 2019/2/28
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        // Comparable.compareTo
        // < return -1
        // = return 0
        // < return 1
        int size = values.length;
        for (int i = 1; i < size; i++) {
            // 高位数 temp
            // [3, 1, 2, 5, 4]
            // [j = 0] = 3, [i = 1] = 1, temp = [i = 1] = 1
            // [i = 1] = [j = 0](3), [j = 0] = temp =  1
            T temp = values[i]; // 临时变量
            for (int j = i - 1; j >= 0; j--) {
                if (temp.compareTo(values[j]) < 1) { // 高位 < 低位
                    values[i] = values[j]; // 高位获取低位值
                    values[j] = temp; // 低位获得高位的值
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
