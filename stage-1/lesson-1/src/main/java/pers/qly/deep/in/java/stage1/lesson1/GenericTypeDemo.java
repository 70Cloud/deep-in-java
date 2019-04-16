package pers.qly.deep.in.java.stage1.lesson1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Author: NoNo
 * @Description: 泛型实例
 * @Date: Create in 19:47 2019/1/17
 */
public class GenericTypeDemo {

//    public interface Converter{
//        // 泛型会在编译时擦写，所以不能这么用
//    }

    /**
     * @param <S> 来源类型
     * @param <T> 转换类型
     */
    public interface Converter<S, T extends Serializable> {

        T convert(S source);
    }

    public interface StringConverter<T extends Serializable> extends Converter<String, T> {

    }

    public static void main(String[] args) {

        Converter<Integer, String> stringConverter =
                new Converter<Integer, String>() {
                    @Override
                    public String convert(Integer source) {
                        return String.valueOf(source);
                    }
                };

        new Converter<String, Integer>() {

            @Override
            public Integer convert(String source) {
                return Integer.valueOf(source);
            }
        };

        List<String> strings;

        List<Integer> integers;

        List<String> data = Collections.emptyList();

        List data2 = Collections.emptyList();

        data = data2;
    }

    /**
     * 方法签名   #doConvert(List)
     * 方法重载时 List<String> 与 List 会冲突，因为可以看到上面 data = data2
     * 由于编译器或是语法限制，会允许带泛型参数等于一个不带泛型的参数，所以会编译报错
     * @param value
     */
    public static void doConvert(List<String> value) {

    }

    // 方法签名冲突, 方法签名   #doConvert(List)
//    public static void doConvert(List value) {
//
//    }

    public static void doConvert(List<Integer> value, int data) {

    }
}
