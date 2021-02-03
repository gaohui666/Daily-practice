package com.cic.irc.myException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Test1 {
    public void f() throws MyException{
        try {
            FileReader reader = new FileReader("G:\\myfile\\struts.txt");
            Scanner in = new Scanner(reader);
            System.out.println(in.next());
        } catch (FileNotFoundException e) {
            //e 保存异常信息
            throw new MyException("文件没有找到--01", e);
        }
    }

    public void g() throws MyException{
        try {
            f();
        } catch (MyException e) {
            //e 保存异常信息
            throw new MyException("文件没有找到--02", e);
        }
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        try {
            t.g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
