package com.cic.irc.extendTest;

public class Husband extends Person {

    Husband() {
        super("哈哈哈");
        System.out.println("Husband Constrctor...");
    }

    public String toString() {
        setName("呵呵呵");
        return super.toString();
    }

    public static void main(String[] args) {
        Husband husband  = new Husband();

        System.out.println(husband.toString());

        Person.display(husband);
    }


}
