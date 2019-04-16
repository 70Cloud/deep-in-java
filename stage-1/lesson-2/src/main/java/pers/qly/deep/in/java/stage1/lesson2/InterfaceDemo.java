package pers.qly.deep.in.java.stage1.lesson2;

import java.io.Serializable;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 21:32 2019/1/17
 */
public class InterfaceDemo {

    public static void main(String[] args) {
        // 强类型约束
        println(1); // 1 -> int -> Integer -> Number

        println((CharSequence) "Hello"); // String 即是 CharSequence 也是 Serializable, 此时需要强转
    }

//    private static void println(Object object){
//
//    }
//
//    private static void println(Number object){
//
//    }

    private static void println(Serializable id) {

    }

    private static void println(CharSequence cs) {
        System.out.println(cs.toString());
    }

    public interface A {
        int VALUE = 1;
    }
}
