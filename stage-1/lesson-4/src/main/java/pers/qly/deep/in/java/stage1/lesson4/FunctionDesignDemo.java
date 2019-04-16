package pers.qly.deep.in.java.stage1.lesson4;

import java.util.function.Function;

/**
 * @Author: NoNo
 * @Description: Function
 * 特点：有进有出
 * 使用场景：类型转换、业务处理等
 * @Date: Create in 15:49 2019/2/16
 */
public class FunctionDesignDemo {

    public static void main(String[] args) {

        Function function = a -> a;

        // Function 可以用于同类转换
        Function<Integer, Integer> divide2 = a -> a / 2;
    }
}
