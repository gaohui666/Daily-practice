package com.cic.irc.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞队列
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue queue = new ArrayBlockingQueue(20);
        BlockingDeque deque = new LinkedBlockingDeque(20);

        for (int i = 0; i < 30; i++) {
            //将指定元素添加到此队列中，如果没有可用空间，将一直等待（如果有必要）。
//            queue.put(i);
            deque.putFirst(i);
//            System.out.println("向阻塞队列中添加了元素:" + i);
            System.out.println("向阻塞栈中添加了元素:" + i);
        }
        System.out.println("程序到此运行结束，即将退出----");
    }
}
