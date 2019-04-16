package pers.qly.deep.in.java.stage1.lesson4;

/**
 * @Author: NoNo
 * @Description: 调试发现注解其实是用代理来实现的
 * @Date: Create in 16:23 2019/2/16
 * @see sun.reflect.annotation.AnnotationInvocationHandler
 */
@DemoAnnotation(value = "hello")
public class DemoAnnotationDemo {

    public static void main(String[] args) {

        DemoAnnotation demoAnnotation = DemoAnnotationDemo.class.getAnnotation(DemoAnnotation.class);
        System.out.println(demoAnnotation.value());
    }
}
