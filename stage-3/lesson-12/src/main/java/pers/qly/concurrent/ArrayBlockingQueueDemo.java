package pers.qly.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:23 2019/4/11
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException{
        // ArrayBlockingQueue 是有限队列
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(3);

        // Queue 操作中 offer 安全性高于 add 方法
//        demoOfferMethod(queue);
//        demoAddMethod(queue);

        demoPutMethod(queue);
        // BlockingQueue 操作中 put 要多于 offer 方法
        System.out.println(queue);
    }

    private static void demoPutMethod(ArrayBlockingQueue<Integer> queue) throws InterruptedException {
        queue.put(1);
        queue.put(2);
        queue.put(3);
        // 如果超过了 capacity，会阻塞
        queue.put(4);
    }

    private static void demoAddMethod(ArrayBlockingQueue<Integer> queue) {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // 如果超过了 capacity，会怎么样
        // java.lang.IllegalStateException: Queue full
        queue.add(4);
    }

    private static void demoOfferMethod(ArrayBlockingQueue<Integer> queue) {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        // 如果超过了 capacity，后面的 offer 会阻塞
        queue.offer(4);
    }
}
