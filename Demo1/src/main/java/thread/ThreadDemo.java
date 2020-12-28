package thread;

/**
 * @author gh
 * @version 1.0
 * @date 2020/11/25.
 */
public class ThreadDemo {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("你好呀")).start();
        new thread.Wedding(new thread.You()).happyMarry();

    }

}

interface Marry{
    void happyMarry();
}

class You implements Marry {

    public void happyMarry() {
        System.out.println("结婚了，真开心" );
    }
}

class Wedding implements Marry{

    private Marry marry;

    public Wedding(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void happyMarry() {
        before();
        this.marry.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后，哈哈哈");
    }

    private void before() {
        System.out.println("结婚前，发请帖");
    }
}
