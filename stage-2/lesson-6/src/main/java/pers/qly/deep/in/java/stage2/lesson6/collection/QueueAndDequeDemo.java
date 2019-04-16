package pers.qly.deep.in.java.stage2.lesson6.collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 21:45 2019/2/16
 */
public class QueueAndDequeDemo {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>();

        Queue<String> queue = new LinkedList<>();

        Deque<String> deque = new LinkedList<>();

        // LinkedList 中 add 和 offer 没区别
        queue.add("A");
        queue.offer("B");
    }
}
