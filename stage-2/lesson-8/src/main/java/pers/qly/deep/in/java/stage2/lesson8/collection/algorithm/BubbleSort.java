package pers.qly.deep.in.java.stage2.lesson8.collection.algorithm;

import java.util.stream.Stream;

/**
 * @Author: NoNo
 * @Description: 冒泡排序
 * @Date: Create in 21:20 2019/2/28
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        // Comparable.compareTo
        // < return -1
        // = return 0
        // < return 1
        int size = values.length;

        // Given array：[3,1,2,5,4]
        // for 1         |
        // for 2           |

        for (int i = 0; i < size; i++) {
            // 第 i 号元素
            T temp = values[i]; // 产生临时变量
            for (int j = i + 1; j < size; j++) {
                // 第 i 号元素与 i + 1 对比
                if (temp.compareTo(values[j]) == 1) { // 低位 > 高位
                    // 交换元素 [i+1] = [i]
                    values[i] = values[j];
                    values[j] = temp;

                    // 如果不用 temp 临时变量可以用如下操作
                    // [0] = 3, [1] = 2
                    // [1] = [0](3) + [1](2) = 5
                    // [0] = [i](5) - [0](3) = 2
                    // [0] = [i](5) - [0](2) = 3
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }


}
