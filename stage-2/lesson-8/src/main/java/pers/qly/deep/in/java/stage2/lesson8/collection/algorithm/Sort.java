package pers.qly.deep.in.java.stage2.lesson8.collection.algorithm;

/**
 * @Author: NoNo
 * @Description: 排序接口
 * @Date: Create in 21:17 2019/2/28
 */
public interface Sort<T extends Comparable<T>> {

    // 数组是有大小的，内容可以交换
    // 原地（在地）排序 - In-Place：基本上不会产生额外的空间去排序

    void sort(T[] values);

    static <T> T[] of(T... values) {
        return values;
    }
}
