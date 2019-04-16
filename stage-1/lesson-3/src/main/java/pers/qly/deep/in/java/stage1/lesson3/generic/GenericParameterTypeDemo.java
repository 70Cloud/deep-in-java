package pers.qly.deep.in.java.stage1.lesson3.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * @Author: NoNo
 * @Description: 泛型会在运行时擦写
 * @Date: Create in 13:03 2019/2/16
 */
public class GenericParameterTypeDemo {

    public static void main(String[] args) {

        Container<String> a = new Container("String");

        // Error : Integer 不是 CharSequence 子类
//        Container<Integer> b = new Container("String");// 魔法操作，可以传 String，一般不这么用
//        Container<Integer> b = new Container(2);

        // StringBuffer -> String

        // 编译时：为什么不报错？
        // StringBuffer 是 CharSequence 子类
        // String（参数）也是 CharSequence 子类
        // 运行时：擦除，变为 Object
        Container<StringBuffer> c = new Container("Hello,World");
        Container<StringBuilder> c2 = new Container("Hello,World");
        // 通过构造器传递参数是 String 类型，运行时都是 Object，没有问题
        System.out.println(c.getElement()); // Hello,World
        // 不过当 c 对象申明的类型为 Container<StringBuffer>，
        // E 类型为 StringBuffer，因此 set(E) ，E必须是 StringBuffer
        c.set(new StringBuffer("2019"));
        System.out.println(c.getElement()); // 2019
        // Java 泛型对象操作时，看申明对象泛型参数类型

        add(new ArrayList<>(), "Hello,World");
        add(new ArrayList<>(), 256); // auto-boxing 256 = new Integer(256) <- Integer.valueOf(256)
        add(new HashSet<>(), 2);

        forEach(Arrays.asList(1, 2, 3), System.out::println);
    }

    // extends 申明它上限，E 的上限类型是 CharSequence
    public static class Container<E extends CharSequence> {

        private E element;

        public Container(E e) {
            this.element = e;
        }

        // operations
        public boolean set(E e) {
            this.element = e;
            return true;
        }

        public E getElement() {
            return element;
        }
    }

    // 多界限泛型参数类型
    public static class C {

    }

    public static interface I {

    }

    public static interface I2 {

    }

    // 多界限泛型参数类型 extends 第一个类型允许是具体类（也可以接口）
    // 第二或更多参数类型必须是接口
//    public static class Template<T extends I & C & I2> {
//        // 会报错
//    }
    public static class Template<T extends Serializable & I & I2> {

    }
    // Guava中有这种操作 extends
    public static class TClass /** extends C */
            implements Serializable, I, I2 {

    }

    // 泛型方法和有界类型参数
    // 把一个类型的元素，添加到集合中
    public static <C extends Collection<E>, E extends Serializable> void add(C target, E element) {
        target.add(element);
    }

    public static <C extends Iterable<E>, E extends Serializable> void forEach(C source, Consumer<E> consumer) {
        for (E e : source) {
            consumer.accept(e);
        }
    }
}
