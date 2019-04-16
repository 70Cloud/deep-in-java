package pers.qly.deep.in.java.stage2.lesson8.collection.algorithm;

import java.util.Arrays;

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
            int j = i;
            while (j > 0 && temp.compareTo(values[j - 1]) < 0) {
                // 往后移动让出插入空间
                values[j] = values[j - 1];
                j--;
            }
            // 插入 values[i] 到对应位置
            values[j] = temp;
            System.out.printf("第 %d 轮：%s\n", i, Arrays.toString(values));
        }
    }

    public static void main(String[] args) {
        System.out.println("====== 一般情况 ======");
        Integer[] values = Sort.of(3, 2, 1, 5, 4);
        Sort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        System.out.println(Arrays.toString(values));

        System.out.println("====== 完全逆序 ======");
        values = Sort.of(5, 4, 3, 2, 1);
        sort = new InsertionSort<>();
        sort.sort(values);
        System.out.println(Arrays.toString(values));
    }
}
