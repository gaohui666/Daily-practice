package thread;

public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        //需要在调用wait()或者notify()之前，必须使用synchronized语义绑定住被wait/notify的对象。
        synchronized (b){
            try {
                System.out.println("等待B计算完成。。。");
                b.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("计算结果为： " + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 101; i++) {
                total += i;
            }
            notify();
        }
    }
}