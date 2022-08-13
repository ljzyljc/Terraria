package com.jackie.terraria;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/5
 */
public class TestB {

    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("jackie");
//            }
//        };
//        runnable.run();

        Runnable r = ()->{
            System.out.println("jackie");
        };
        r.run();
    }
    private static int color;
    private static void age(){

    }

    private void name(){}

    class TestC{
        public void testCC(){

            age();
            TestB t = new TestB();
            t.name();
        }
    }

}
