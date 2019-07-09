package deep.in.java;

import java.util.concurrent.ExecutionException;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 9:11 2019/7/9
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        // 系统 ClassLoader
        // Java 8 结果：sun.misc.Launcher$AppClassLoader@18b4aac2
        // Java 11 结果：jdk.internal.loader.ClassLoaders$AppClassLoader@14514713
        System.out.println(ClassLoader.getSystemClassLoader());

        // 应用 ClassLoader
        // Java 8 结果：sun.misc.Launcher$AppClassLoader@18b4aac2
        // Java 11 结果：jdk.internal.loader.ClassLoaders$AppClassLoader@14514713
        System.out.println(Thread.currentThread().getContextClassLoader());

        // 如何实现类隔离，通过修改 Thread 上下文 ClassLoader
    }

    private static void changeClassLoader(ClassLoader newClassLoader){
        Thread currentThread = Thread.currentThread();
        // 当前 ClassLoader 无法加载 User.class 类，不过该类能被 newClassLoader 加载
        ClassLoader previousClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(newClassLoader);
            // 利用新的 ClassLoader 来加载类
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            currentThread.setContextClassLoader(previousClassLoader);
        }
    }

    private static void loadSomeClasses(){// 兼容或适配老的 ClassLoader 代码
        // JAXB 通过线程上下文 ClassLoader 切换不同实现 SPI
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try{
            classLoader.loadClass("abc");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
