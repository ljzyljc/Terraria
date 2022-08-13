package com.jackie.terraria;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/7/31
 */
public class Test {


    public final long a = Long.MAX_VALUE;
    public static void main(String[] args,CASE cCase) {
//        System.out.println("jackie");
        switch (cCase){
            case A:
                System.out.println("A");
                break;
            case B:
                System.out.println("B");
                break;
            case C:
                System.out.println("C");
                break;
            default:
                break;
        }
    }
}



enum CASE{
    A,
    B,
    C
}