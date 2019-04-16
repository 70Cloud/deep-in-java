package pers.qly.deep.in.java.stage2.lesson7.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: NoNo
 * @Description: Fail-Fast Fail-Safe
 * @Date: Create in 23:42 2019/2/23
 */
public class FailFastVsFailSafeDemo {

    public static void main(String[] args) {

        demoFailFast();

        demoFailSafe();
    }

    private static void demoFailSafe() {
        removeForEach(new CopyOnWriteArrayList<>(List.of(1, 2, 3)));
    }

    private static void demoFailFast() {
        removeForEach(new ArrayList<>(List.of(1, 2, 3)));
    }

    private static void removeForEach(Collection<?> values) {
        try {
            // 如果是 Fail-Fast 设计的话，那么会抛出 ConcurrentModificationException，如：ArrayList
            // 如果是 Fail-Safe 设计的话，那么就没有关系，比如 j.u.c.CopyOnWriteArrayList

            // 失败删除：for-each 语法
            for (Object value : values) {
                values.remove(value);
            }
            System.out.println("集合删除成功，大小为：" + values.size());
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-Fast 异常！");
        }
    }
}
