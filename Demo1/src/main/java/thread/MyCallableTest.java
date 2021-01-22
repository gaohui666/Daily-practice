package thread;

import java.util.concurrent.*;


/**
 * 有返回值的线程
 */
public class MyCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        //创建两个有返回值的任务
        Callable c1 = new MyCallable(23);
        Callable c2 = new MyCallable(22);

        //执行任务获取Future对象
        Future f1 = pool.submit(c1);
        Future f2 = pool.submit(c2);

        System.out.println(f1.get());
        System.out.println(f2.get());

        pool.shutdown();
    }
}

class MyCallable implements Callable {

    private int oid;

    public MyCallable(int oid) {
        this.oid = oid;
    }

    @Override
    public Object call() throws Exception {
        return oid+"任务返回的内容";
    }
}
