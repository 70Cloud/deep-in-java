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

        // ClassLoader previousClassLoader = Thread.currentThread().getContextLoader();
        // previousClassLoader 能够加载 User.class V1 版本（user-api-1.0.0.jar 文件中，在 /classpath1 目录下）
        // User.class V2 版本 （user-api-2.0.0.jar 文件中，在 /classpath2 目录下）
        // loadUser 操作加载 User.class V2 版本

        // previousClassLoader ClassPath -> /classpath1
        // newClassLoader  ClassPath -> /classpath2

        // 通常，系统或者应用（包括自定义） ClassLoader 均为 URLClassLoader 子类
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
        // JAXB 1.x 2.x
        // JDK 提供的 API 1.x
        // 第三方包实现 2.x
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try{
            classLoader.loadClass("User"); // 使用 V2
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//class User { // V1
//
//}

// Class User { // V2
// }
