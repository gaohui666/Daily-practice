package com.cic.irc.thread;

/**
 * 生产者消费者问题
 */

public class ThreadTest1 {
    public static void main(String[] args) {
        Godown godown = new Godown(30);
        Consumer c1 = new Consumer(50, godown);
        Consumer c2 = new Consumer(20, godown);
        Consumer c3 = new Consumer(30, godown);
        Producer p1 = new Producer(10, godown);
        Producer p2 = new Producer(10, godown);
        Producer p3 = new Producer(10, godown);
        Producer p4 = new Producer(10, godown);
        Producer p5 = new Producer(10, godown);
        Producer p6 = new Producer(10, godown);
        Producer p7 = new Producer(80, godown);

        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}

/**
 * 仓库
 */
class Godown {
    public static final int max_size = 100;
    public int curnum;

    public Godown(int curnum) {
        this.curnum = curnum;
    }

    public Godown() {
    }


    /**
     * 生产者生产指定数量的产品
     */
    public synchronized void produce(int neednum) {
        //库存数+生产数大于最大库存数
        while (curnum + neednum > max_size) {
            System.out.println("超过库存量，暂不能生产");
            try {
                //生产等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        curnum += neednum;
        System.out.println(Thread.currentThread().getName() + "已经生产了" + neednum + "个产品，现库存量为： " + curnum );
        notifyAll();
    }

    /**
     * 消费者消费产品
     */
    public synchronized void consume(int neednum) {
        //库存数小于消费数
        while (curnum < neednum) {
            try {
                System.out.println(Thread.currentThread().getName() + "不足消费数，请生产");
                //消费等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费产品
        curnum -= neednum;
        System.out.println(Thread.currentThread().getName() + "消费了" + neednum + "个产品，现库存量为：" + curnum);
        notifyAll();
    }

}

/**
 * 生产者
 */
class Producer extends Thread {
    private int neednum;        //生产产品数量
    private Godown godown;      //仓库

    public Producer(int neednum, Godown godown) {
        this.neednum = neednum;
        this.godown = godown;
    }

    @Override
    public void run() {
        //生产者生产指定数量产品
        godown.produce(neednum);
    }
}

class Consumer extends Thread {
    private int neednum;        //消费产品数量
    private Godown godown;      //仓库

    public Consumer(int neednum, Godown godown) {
        this.neednum = neednum;
        this.godown = godown;
    }

    @Override
    public void run() {
        //消费者消费指定数量产品
        godown.consume(neednum);
    }
}
