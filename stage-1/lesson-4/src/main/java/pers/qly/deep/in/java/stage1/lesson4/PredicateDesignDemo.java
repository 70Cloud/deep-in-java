package pers.qly.deep.in.java.stage1.lesson4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author: NoNo
 * @Description: Predicate
 * 特点:boolean 类型判断
 * 使用场景：过滤、对象比较等
 * @Date: Create in 15:51 2019/2/16
 */
public class PredicateDesignDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Collection<Integer> even = filter(numbers, num -> num % 2 == 0);//偶数

        Collection<Integer> odd = filter(numbers, num -> num % 2 != 0);//奇数

        System.out.println(odd);

        System.out.println(even);

        Stream.of(1, 2, 3, 4, 5)
                .filter(num -> num % 2 == 0)
                .forEachOrdered(System.out::println);
    }

    private static <E> Collection<E> filter(Collection<E> source, Predicate<E> predicate) {
        // 集合类操作，请不要直接利用参数
        List<E> copy = new ArrayList<E>(source);
        Iterator<E> iterator = copy.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (!predicate.test(element)) {
                iterator.remove();
            }
        }
        return Collections.unmodifiableList(copy);
    }

}
