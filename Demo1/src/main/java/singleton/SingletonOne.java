package singleton;

/**
 * @author gh
 * @version 1.0
 * @date 2020/11/27.
 */
public class SingletonOne {
    public static SingletonOne singleton;

    public SingletonOne() {}

    // 懒汉式，用的时候才创建实例
    // 有synchronized 为线程安全的，但效率不高；
    // 无synchronized 为线程不安全的，基本不会使用。
    public static synchronized SingletonOne getSingleton() {
        if(singleton == null ) {
            return new SingletonOne();
        }
        return singleton;
    }
}
