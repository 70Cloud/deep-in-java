package pers.qly.concurrent.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 23:18 2019/3/9
 */
public class ProcessIdDemo {

    public static void main(String[] args) {
        // Java 9 之前实现
        getProcessIdBeforeJava9();

        getProcessIdInJava9();

        getProcessIdInJava10();
    }

    private static void getProcessIdInJava10() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        long pid = runtimeMXBean.getPid();
        System.out.println("[Java 10]当前进程 ID ：" + pid);

    }

    private static void getProcessIdInJava9() {
        long pid = ProcessHandle.current().pid();
        System.out.println("[Java 9]当前进程 ID ：" + pid);
    }

    private static void getProcessIdBeforeJava9() {

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        String name = runtimeMXBean.getName();
        String pid = name.substring(0, name.indexOf("@"));
        System.out.println("[Java 9 之前]当前进程 ID ：" + pid);
    }
}
