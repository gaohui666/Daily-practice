package com.cic.irc.thread;

public class DaemonThread extends Thread{

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName() + "...aaaaa..." + i);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName() + "...bbb..." + i);
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(getName() + "...ccccccccc..." + i);
                }
            }
        };

        //设置守护线程
//        t3.setDaemon(true);
        //设置优先级
//        t1.setPriority(1);
//        t3.setPriority(8);
        t1.start();
        // 如果去掉t1.join()这个语句过后， 输出的书序是乱的， 加上这个语句过后， 就会按照顺序输出，
        // 从某种意义上说实现了同步。
        t1.join();
        t2.start();
        t2.join();
//        t3.start();


//        DoSomething d1 = new DoSomething("哈哈");
//        DoSomething d2 = new DoSomething("呵呵");
//        d1.start();
//        d2.start();
    }
}


class DoSomething extends Thread {

    private String name;

    public DoSomething(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "....." + i);
        }
    }
}