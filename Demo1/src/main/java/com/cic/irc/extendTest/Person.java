package com.cic.irc.extendTest;

public class Person {
    protected String name;
    protected int age;
    protected String sex;

    Person(String name) {
        System.out.println("Person Constrctor..." + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "this name is " + name;
    }

    public void display(){
        System.out.println("Play Person...");
    }

    static void display(Person person){
        person.display();
    }
}
