package pers.qly.deep.in.java.stage1.lesson4;

/**
 * @Author: NoNo
 * @Description: Action 可以理解为 Runnable ,是函数式接口的隐藏接口
 * @Date: Create in 15:31 2019/2/16
 */
public class ActionDemo {

    public static void main(String[] args) {

        // 匿名内置类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("NoNo");
            }
        };

        // 字节码中 invokedynamic 指令 @since JDK 1.7
        // 请记住 java.lang.invoke.MethodHandle
        // java.lang.invoke.InvokeDynamic
        Runnable runnable2 = () -> {

        };
    }
}
