package pers.qly.deep.in.java.stage2.lesson7.collection;

import java.util.PriorityQueue;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:53 2019/2/23
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();

        integerQueue.add(1);
        integerQueue.add(1); // Queue 不会去重
        integerQueue.add(2);
        integerQueue.add(3);

        integerQueue.forEach(System.out::println);
    }
}
