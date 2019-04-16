package pers.qly.deep.in.java.stage1.lesson4;

import java.util.function.Supplier;

/**
 * @Author: NoNo
 * @Description: 特点：只出不进（只有返回，没有入参）
 * @Date: Create in 15:41 2019/2/16
 */
public class SupplierDesignDemo {

    public static void main(String[] args) {

        echo("Hello,World"); // 固定参数

        // 类似延迟加载
        echo(() -> { // 变化实现
            sleep(1000);
            return "Hello,World";
        });

        // 上方代码类似下方，一个固化，一个变化（待执行）
        echo(SupplierDesignDemo::getMessage);

        getMessage(); // 及时返回数据

        Supplier<String> message = supplyMessage(); // 待执行数据

        message.get(); // 实际执行
    }


    private static String getMessage() {
        sleep(1000);
        return "Hello,World";
    }

    private static Supplier<String> supplyMessage() {
        return SupplierDesignDemo::getMessage;
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void echo(String message) { // 拉的模式
        System.out.println(message);
    }

    public static void echo(Supplier<String> message) { // 推的模式
        System.out.println(message.get());
    }
}
