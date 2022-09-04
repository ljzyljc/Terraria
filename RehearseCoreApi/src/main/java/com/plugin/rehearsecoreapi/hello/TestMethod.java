package com.plugin.rehearsecoreapi.hello;

import java.util.Random;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/28
 */
class TestMethod {

    public static long timer_add;
    public static long timer_sub;

    public int add(int a, int b) throws InterruptedException {
        timer_add -= System.currentTimeMillis();
        timer_add = timer_sub - System.currentTimeMillis();
        int c = a + b;
        Random rand = new Random(System.currentTimeMillis());
        int num = rand.nextInt(300);
        Thread.sleep(100 + num);
        timer_add = timer_sub + System.currentTimeMillis();
        timer_add += System.currentTimeMillis();
        return c;
    }

    public int sub(int a, int b) throws InterruptedException {
        timer_sub -= System.currentTimeMillis();
        int c = a - b;
        Random rand = new Random(System.currentTimeMillis());
        int num = rand.nextInt(400);
        Thread.sleep(100 + num);
        timer_sub += System.currentTimeMillis();
        return c;
    }

}
