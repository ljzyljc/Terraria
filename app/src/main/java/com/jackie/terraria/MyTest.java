package com.jackie.terraria;

import java.io.IOException;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/3
 */
public class MyTest {
//    public static void main(String[] args) throws IOException {
//        A obj = new B();
//        System.in.read();
//        System.out.println(obj);
//    }

    public void test() {
        long t = System.currentTimeMillis();
        t = System.currentTimeMillis() - t;
        if (t > 50){
            System.out.println("test method execute: " + t);
        }
    }
}

