package pers.qly.deep.in.java.stage2.lesson8.collection.algorithm;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author: NoNo
 * @Description: 快速排序
 * @Date: Create in 22:07 2019/2/28
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        int n = values.length;
        int low = 0; // 低位
        int high = n - 1; // 高位

        // [3, 1, 2, 5, 4]
        // pivot = 4
        // -> (3, 1, 2), (4), (5)
        // pIndex = 3
        // [0...2] = (3, 1, 2)
        // [3] = 4
        // [4] = 5

        // [0...2] = (3, 1, 2)
        // pivot = 2
        // -> (1), (2), (3)

        // divide and conquer
        // [0] = 1, [1] = 2,[2] = 3,[3] = 4,[4] = 5

        sort(values, low, high);


    }

    private void sort(T[] values, int low, int high) {
        // 与 pivot 做比较，小的放左边，大的放右边
        if (low < high) {
            // 假设 9 个数, pIndex = 5
            int pIndex = partition(values, low, high); // 中间值
            sort(values, low, pIndex - 1);
            sort(values, pIndex + 1, high);
        }
    }

    /**
     * 获取分区索引
     *
     * @param values 数组对象
     * @param low    低位索引
     * @param high   高位索引
     * @return 分区索引
     */
    int partition(T[] values, int low, int high) {
        // 获取分区索引,轴 pivot = values[high]

        // [3, 1, 2, 5, 4]
        // pivot = 4

        //             (-1)
        // [0] = 3 < 4 (0)
        // [1] = 1 < 4 (1)
        // [2] = 2 < 4 (2)
        // [3] = 5 > 4 (3) 停止
        // -> (3, 1, 2), (4), (5)
        // pIndex = 3
        // [0...2] = (3, 1, 2)
        // [3] = 4
        // [4] = 5

        T pivot = values[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (values[j].compareTo(pivot) < 1) { // <= FIXME 理解下快速排序
                T temp = values[i]; // 低位数据
                values[i] = values[j]; // 低位数据获取高位数据
                values[j] = temp;
                i++; // 游标 -1 -> 0
            }
        }

        T temp = values[i];
        values[i] = values[high];
        values[high] = temp;
        return i; // 滚动游标 + 1
    }

    public static void main(String[] args) {
        Integer[] values = Sort.of(2, 5, 6, 7, 8, 8, 9, 2, 1, 6, 7, 5, 6, 11, 23);
        Sort<Integer> sort = new QuickSort<>();
        sort.sort(values);
        System.out.println(Arrays.asList(values));
    }
}
