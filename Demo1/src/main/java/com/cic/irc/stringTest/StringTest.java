package com.cic.irc.stringTest;

/**
 * String 字符串拼装
 */
public class StringTest {

    public static void main(String[] args) {
        //+
        long start_01 = System.currentTimeMillis();
        String a = "a";
        for(int i = 0 ; i < 100000 ; i++){
            a += "b";
        }
        long end_01 = System.currentTimeMillis();
//        System.out.println(a);
        System.out.println("  +   所消耗的时间：" + (end_01 - start_01) + "毫米");

        // concat
        long start_02 = System.currentTimeMillis();
        String c = "c";
        for (int i = 0; i < 100000; i++) {
            c = c.concat("d");
        }
        long end_02 = System.currentTimeMillis();
        System.out.println("concat  所消耗的时间： " + (end_02 - start_02) + "毫米");

        //append
        long start_03 = System.currentTimeMillis();
        StringBuffer e = new StringBuffer("e");
        for (int i = 0; i < 100000; i++) {
            e.append("f");
        }
        long end_03 = System.currentTimeMillis();
        System.out.println("append  所消耗的时间： " + (end_03 - start_03) + "毫米");
    }
}
