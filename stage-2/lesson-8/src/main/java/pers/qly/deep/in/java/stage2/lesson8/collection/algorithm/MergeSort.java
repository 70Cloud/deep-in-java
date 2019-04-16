package pers.qly.deep.in.java.stage2.lesson8.collection.algorithm;

import java.util.stream.Stream;

/**
 * @Author: NoNo
 * @Description: 归并排序
 * @Date: Create in 22:43 2019/2/28
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    // FIXME 理解下 归并排序

    @Override
    public void sort(T[] values) {
        sort(values, 0, values.length - 1);
    }

    private void merge(T[] values, int low, int mid, int high) {
        // 找到子数组进行合并

        // [3, 1, 2, 5, 4], n = 5
        // low = 0
        // high = n - 1 = 4
        // mid = (0 + 4) / 2 = 2
        // a1 = [0...mid] = [3, 1, 2] = mid(2) - low(0) + 1 = 3个元素
        // a2 = [mid + 1 ... high] = [3...4] = [5, 4] = high(4) - mid(2) = 2个元素

        int n1 = mid - low + 1;
        int n2 = high - mid;

        // 非 In-Place 实现(创建新的数组)
        Comparable[] a1 = new Comparable[n1];
        Comparable[] a2 = new Comparable[n2];

        // 把 values[0...mid] 内容复制给 a1
        System.arraycopy(values, low, a1, 0, n1);
        // 把 values[mid+1...high] 内容复制给 a2
        System.arraycopy(values, mid + 1, a2, 0, n2);

        // 合并
        // i 为 n1 做迭代
        // j 为 n2 做迭代

        // a1 = [0...mid] = [3, 1, 2] = mid(2) - low(0) + 1 = 3个元素
        // a2 = [mid + 1 ... high] = [3...4] = [5, 4] = high(4) - mid(2) = 2个元素
        // k = low(0)
        // a1[0](values[0]) = 3 compare a2[0](values[3]) = 5
        // values[0] = a1[0] = 3
        // i++;j++

        // a1[1](values[1]) = 1 compare a2[1](values[4]) = 4
        // values[0] = a1[1] = 4
        // i++;j++

        // a1[2](values[2]) = 2 compare a2[1](values[4]) = 4
        // values[0] = a1[1] = 4
        // i++;j++

        int k = low; // k 临时保存低位索引值
        int i = 0, j = 0;
        for (; i < n1 && j < n2; i++, j++) {
            // 如果 a1 与 a2 比较
            if (a1[i].compareTo(a2[j]) < 1) { // <=
                values[k] = (T) a1[i];// 低位数值
            } else { // >
                values[k] = (T) a2[j];
            }
            k++;
        }

        // i = 2,n = 3
        // values[k = 0] = 4

        // 复制 a1
        while (i < n1) {
            values[k] = (T) a1[i];
            i++;
            j++;
        }
        while (j < n2) {
            values[k] = (T) a2[j];
            j++;
            k++;
        }
    }

    private void sort(T[] values, int low, int high) {
        if (low < high) {
            // [3, 1, 2, 5, 4], n = 5
            // low = 0
            // high = n - 1 = 4
            // mid = (0 + 4) / 2 = 2
            // [0...mid] = [3, 1, 2]
            // [mid + 1 ... high] = [3...4] = [5, 4]
            // 获取中间值
            // Divide
            int mid = (low + high) / 2;
            // 上半部分
            sort(values, 0, mid);
            // 下班部分
            sort(values, mid + 1, high);

            // Conquer
            merge(values, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new MergeSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
