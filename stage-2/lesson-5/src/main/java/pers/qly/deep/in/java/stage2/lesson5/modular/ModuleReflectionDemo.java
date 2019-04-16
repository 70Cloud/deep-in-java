package pers.qly.deep.in.java.stage2.lesson5.modular;

import java.lang.module.ModuleDescriptor;

/**
 * @Author: NoNo
 * @Description: 模块化反射
 * @Date: Create in 17:06 2019/2/16
 */
public class ModuleReflectionDemo {

    public static void main(String[] args) {

        Class klass = ModuleReflectionDemo.class;

        // 获取模块
        Module module = klass.getModule();

        String moduleName = module.getName();

        System.out.printf("类 %s 存在于模块 : %s 之中\n", klass.getName(), moduleName);

        ModuleDescriptor moduleDescriptor = module.getDescriptor();

        moduleDescriptor.requires().stream().forEach(requires -> {
                    System.out.printf("requires 模块名称 %s，修饰符定义： %s \n", requires.name(), requires.modifiers());
                }
        );

        moduleDescriptor.exports().stream().forEach(exports -> {
            System.out.printf("exports 包名称 %s，targets： %s \n", exports.source(), exports.targets());
        });
    }
}
