package pers.qly.deep.in.java.stage1.lesson4;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * @Author: NoNo
 * @Description: Supplier
 * 特点：只出不进（只有返回，没有入参）
 * 使用场景：数据来源，代码替代接口
 * @Date: Create in 15:20 2019/2/16
 */
public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<Long> supplier = getLong();

        // 方法引用之前
        Callable<String> callable = () -> getHelloWorld();

        Callable<String> callable2 = SupplierDemo::getHelloWorld;

    }

    public static String getHelloWorld() {
        return "Hello,World";
    }

    public static Supplier<Long> getLong() {
//        return () -> {
//            return System.currentTimeMillis();
//        };
        return System::currentTimeMillis;
    }
}
