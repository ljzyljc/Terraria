package com.plugin.rehearsecoreapi;

import static com.plugin.rehearsecoreapi.MyClass.TYPE.A;

import java.util.Random;

public class MyClass {

    private static final int intValue = 10;

//    public void test() {
//        int a = 1;
//        int b = 2;
//        int c = a + b;
//        System.out.println(A);
//    }
    @Override
    public String toString() {
        return "Everyone starts somewhere";
    }

    enum TYPE{
        A("A"),
        B("B");

        TYPE(final String a) {
        }
    }

    public void test(int a,int b) throws InterruptedException {
        int c = a + b;
        int d = c * 10;
        Random rand = new Random();
        int value = rand.nextInt(d);
        Thread.sleep(value);
    }
}