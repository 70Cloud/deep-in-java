package pers.qly.deep.in.java.stage1.lesson4;

import java.lang.annotation.*;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 16:22 2019/2/16
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DemoAnnotation {
    String value();
}
