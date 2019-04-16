package pers.qly.deep.in.java.stage2.lesson7.collection;

import java.util.Collections;
import java.util.List;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 20:50 2019/2/23
 */
public class EmptyCollectionDemo {

    // Iterator 是单向的
    // ListIterator 是双向的 #previous()

    public static void main(String[] args) {
        // 对自己（严格）：所有的返回接口类型的方法禁止返回 null
        // 对别人（宽容）：别人的接口要做 null 判断（尤其在 RPC 场景）

        // 集合方法入参：
        // 1.如果能用 Iterable 尽量用（更抽象）
        // 2.其次是 Collection
        // 3.再者是 List 或 Set
        // 禁止使用具体类型，比如：ArrayList、LinkedHashSet

        // 多用 Arrays.hashCode()或者 Objects.hashCode() 以及 Arrays.toString()

        // 什么是设计？
        // 设计就是要抽象，找共性，找交集，不断重构
    }

    public static List<String> getIdsList(String name) {
        if (name == null || name.length() < 1) {
            return Collections.emptyList();
        }
        // 1、只读 empty List (@return an empty immutable list)
        // 2、实现 Java 序列化 EmptyList 在 RPC 的情况下，不实现序列化会报错
        return Collections.emptyList();
    }
}
