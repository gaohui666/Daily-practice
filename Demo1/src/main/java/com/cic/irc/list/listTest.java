package com.cic.irc.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);

        //通过构造函数新建一个包含list1的列表list2
        List<Integer> list2 = new ArrayList<Integer>(list1);

        //通过subList生成一个与list1一样的列表 list3
        /**
         * subList返回的只是原列表的一个视图，它所有的操作最终都会作用在原列表上。
         * 查看源码
         */

        List<Integer> list3 = list1.subList(0,list1.size());
        //将list1设置为只读状态
        list1 = Collections.unmodifiableList(list1);

        list3.add(3);
//        list3.add(3);

        System.out.println(list1.equals(list2));        //false
//        System.out.println(list1.equals(list3));        //true

        System.out.println("list1'size：" + list1.size());
        System.out.println("list3'size：" + list3.size());
        System.out.println(list1 + "..." + list2 + "..." + list3);


     }
}
