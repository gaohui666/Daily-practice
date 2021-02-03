package com.cic.irc.myException;

/**
 * 自定义异常
 */
public class MyException extends Exception{
    public MyException(){

    }

    public MyException(String message){
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}

class Test {
    public void display(int i) throws MyException{
        if(i == 0){
            throw new MyException("该值不能为0.......");
        }
        else{
            System.out.println( i / 2);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.display(0);
            System.out.println("---------------------");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}