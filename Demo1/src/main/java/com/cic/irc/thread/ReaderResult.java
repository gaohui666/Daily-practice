package com.cic.irc.thread;

/**
 * 线程等待
 */
public class ReaderResult extends Thread {
    Calculator c ;

    public ReaderResult(Calculator c) {
        this.c = c;
    }

    @Override
    public void run() {
        synchronized (c) {
            try {
                System.out.println(Thread.currentThread() +"等待计算结果。。。");
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() +"计算结果为： " + c.total);
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();

        new ReaderResult(c).start();
        new ReaderResult(c).start();
        new ReaderResult(c).start();

        c.start();
    }
}

class Calculator extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i <=100; i++) {
                total += i;
            }
            notifyAll();
        }
    }
}