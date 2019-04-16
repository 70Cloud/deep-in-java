package pers.qly.deep.in.java.stage2.lesson5.modular;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;

/**
 * @Author: NoNo
 * @Description: 非命名模块（Unnamed module）：类型加载于 ClassPath，⽽非具体模块，如遗留 jar 文件，暴露所有的 packages
 * @Date: Create in 17:05 2019/2/16
 */
public class UnnamedModuleDemo {

    public static void main(String[] args) {
        MapUtils.isEmpty(Collections.emptyMap());
        StringUtils.isBlank("OK");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext();
        context.close();
    }
}
