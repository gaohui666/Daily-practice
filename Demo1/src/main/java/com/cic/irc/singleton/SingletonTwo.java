package com.cic.irc.singleton;

/**
 * @author gh
 * @version 1.0
 * @date 2020/11/27.
 */
public class SingletonTwo {
    public static SingletonTwo singletonTwo = new SingletonTwo();

    private SingletonTwo(){};

    public static SingletonTwo getSingletonTwo() {
        return singletonTwo;
    }
}
