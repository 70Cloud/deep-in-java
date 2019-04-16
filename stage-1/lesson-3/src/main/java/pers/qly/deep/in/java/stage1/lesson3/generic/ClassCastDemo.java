package pers.qly.deep.in.java.stage1.lesson3.generic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: NoNo
 * @Description: 泛型就是编译时的辅助
 * @Date: Create in 12:44 2019/2/16
 */
public class ClassCastDemo {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("A");
        // Type jdk 1.5
        Type type = int.class;
        // < jdk 1.5 这么写
        Class intType = int.class;

        List<Object> list2 = list;

        List<String> strList = Collections.emptyList();
        List<String> strList2 = Arrays.asList("1", "2", "3");
        // Diamond 语法
        List<String> strList3 = new ArrayList<>();
        // Java 10 var
        // var strList = new ArrayList<>();
    }

    /**
     * a String List
     * b Integer List
     * String -> Integer
     * for-each
     *
     * @param a
     * @param b
     */
    private static void exchange(List a, List b) {
        a.addAll(b);//编译器不会检查，运行时会报错
        Integer v = (Integer) a.get(0);
    }
}
