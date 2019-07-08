package deep.in.java;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 21:31 2019/4/9
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        Semaphore semaphore = new Semaphore(4);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                try {
                    echoThread();
                    semaphore.acquire(); // await() 让计数 -1
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(5 * 100);

        // 当 count 数量等于 0，才会释放
        // 4 - 3 == 1 !=0
        // 再次 await() -1 => 4 - 3 - 1 = 0
//
        // 关闭线程池
        executorService.shutdown();

    }


    private static void echoThread() {
        System.out.printf("当前线程[%s]正在执行...\n", Thread.currentThread().getName());
    }
}
