package deep.in.java.thread;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:00 2019/3/9
 */
public class DumpThreadDemo {

    public static void main(String[] args) {
        // Thread API
        Thread.dumpStack();

        // Throwable 实现
        new Throwable("Stack Trace").printStackTrace(System.out);

        // Java 9 StackWalker API 对栈处理更优的 API，性能更好
        StackWalker stackWalker = StackWalker.getInstance();
        stackWalker.forEach(System.out::println);
    }
}
