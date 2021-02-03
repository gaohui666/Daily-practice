package com.cic.irc.thread;

import static java.lang.System.*;

/**
 * @author gh
 * @version 1.0
 * @date 2020/11/25.
 */
public class Lambda {
    public static void main(String[] args) {
       Ilike like = new Like();

//       like = () ->{System.out.println("hhhhhh");};

       like.Lambda();
    }
}

interface Ilike {
    void Lambda();
}

class Like implements Ilike {
    @Override
    public void Lambda() {
        out.println("wwwwww");
    }
}