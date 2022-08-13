package com.jackie.terraria;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/9
 */
//public class ReflectTest {
//    private static int count = 0;
//    public static void foo(){
//        new Exception("test#:"+(count++)).printStackTrace();
//    }
//
//    public static void main(String[] args) throws Exception {
//        Class<?> clazz = Class.forName("ReflectTest");
//        Method method = clazz.getMethod("foo");
//        for (int i = 0; i < 20; i++) {
//            method.invoke(null);
//        }
//    }
//}

public class ReflectTest {

    private static int count = 0;
    public static void foo() {
        new Exception("test#" + (count++)).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("com.jackie.terraria.ReflectTest");
        Method method = clz.getMethod("foo");
        for (int i = 0; i < 20; i++) {
            method.invoke(null);
        }
    }
}
