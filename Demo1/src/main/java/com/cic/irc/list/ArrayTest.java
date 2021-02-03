package com.cic.irc.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        Father[] fathers = new Son[]{};
        System.out.println(fathers.getClass());

        List<String> strings = new MyList();
        System.out.println(strings.toArray().getClass());
    }


}


class Father {}

class Son extends Father {}

class MyList extends ArrayList<String> {

    @Override
    public String[] toArray() {
        return new String[]{"1","22","3"};
    }
}