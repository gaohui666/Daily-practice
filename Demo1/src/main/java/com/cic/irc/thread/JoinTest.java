package com.cic.irc.thread;

/**
 * 线程的合并的含义就是将几个并行线程的线程合并为一个单线程执行，
 * 应用场景是当一个线程必须等待另一个线程执行完毕才能执行时可以使用join方法。
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread t = new MyThread2();
        t.start();
        for (int i = 0; i < 50; i++) {
            System.out.println("主线程第" + i + "次执行");
            //当 i>10 时，先让线程1执行完毕，主线程再执行
            if (i > 10 ) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程1第" + i + "次执行");
        }
    }
}