package pers.qly.deep.in.java.stage1.lesson4;

import java.util.function.Consumer;

/**
 * @Author: NoNo
 * @Description: Consumer
 * 特点：只进不出（只有入参，没有返回）
 * 使用场景：执行Callback
 * @Date: Create in 15:22 2019/2/16
 */
public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer consumer = System.out::println;

        consumer.accept("Hello,World");

        Consumer<String> consumer2 = ConsumerDemo::echo;

        // Fluent API
        // consumer2 -> consumer -> consumer
        consumer2.andThen(consumer)
                .andThen(consumer)
                .accept("Hello,NoNo");

    }

    /**
     * 如果是读取泛型数据时，可以运用 extends。如果是操作数据，使用 super 来修饰。
     *
     * @param cs
     * @param message
     */
    public static void print(Consumer<? super CharSequence> cs, String message) {
        cs.accept(message);
    }

    private static void echo(String message) {
        System.out.println("echo : " + message);
    }
}
