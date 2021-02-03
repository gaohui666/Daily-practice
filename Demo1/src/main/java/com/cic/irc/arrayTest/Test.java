package com.cic.irc.arrayTest;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchThreadPoolException;

import java.util.Arrays;
import java.util.List;

public class Test {

    enum Week{Sum,Mon,Tue,Web,Thu,Fri,Sat};
    public static void main(String[] args) {
//        int[] array_0 = new int[10];
//        System.out.println(array_0.getClass().getName());
//        int[][] array_1 = new int[10][10];
//        System.out.println(array_1.getClass().getName());
//        int array_2[][][] = new int[10][10][10];
//        System.out.println(array_2.getClass().getName());
//        System.out.println(array_2.getClass().getDeclaredFields().length);

        Integer[] datas = new Integer[]{1,2,3,4,5};
        List list = Arrays.asList(datas);
        System.out.println(list.size());
        System.out.println(datas.equals(list.get(0)));

        Week[] weeks = {Week.Sum,Week.Mon,Week.Tue,Week.Web,Week.Thu,Week.Fri};
        List<Week> list1 = Arrays.asList(weeks);
        for (Week week : list1) {
            System.out.println(week);
        }
        list1.add(Week.Sat);


    }
}
