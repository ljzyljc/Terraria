package com.jackie.terraria;

import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/5
 */
public class Foo {

    public byte a(String s) {
        return 0;
    }

    public short b(String s) {
        return 0;
    }

    public long c(String s) {
        return 0;
    }

    public float d(String s) {
        return 0;
    }

    public double e(String s) {
        return 0;
    }

    public boolean f(String s) {
        return true;
    }

    public char g(String s) {
        return 'a';
    }

    public Object i(String s) {
        try {
            int a = 1 / 0;
            int b = 1 / 0;
            System.out.println("jackie" + a);
            System.out.println("jackie" + a);
            System.out.println("jackie" + a);
            System.out.println("jackie" + a);
            System.out.println("jackie" + a);
            System.out.println("jackie" + b);
            return new Object();
        }catch (Exception e){
            ExceptionUtils.handleException(e);
            return ExceptionUtils.handleReturn();
        }

    }

//
//    public Object i(String s) {
//        Object var10000;
//        try {
//            int a = 1 / 0;
//            int b = 1 / 0;
//            System.out.println("jackie" + a);
//            System.out.println("jackie" + a);
//            System.out.println("jackie" + a);
//            System.out.println("jackie" + a);
//            System.out.println("jackie" + a);
//            System.out.println("jackie" + b);
//            var10000 = new Object();
//        } catch (Exception var4) {
//            var10000 = var4;
//            ExceptionUtils.handleReturn(var4);
//        }
//
//        return var10000;
//    }

    public FileInputStream j(String s) throws FileNotFoundException {
        return new FileInputStream("bbc");
    }

//    public short print(String s) {
//        try {
//            System.out.println("test:" + s);
//            short a = 1;
//            System.out.println("test:" + a);
//            return a;
//        } catch (Exception e) {
//            ExceptionUtils.handleException(e);
//        }
//        return ExceptionUtils.handleReturn();
//    }

    @RequiresApi(api = VERSION_CODES.O)
    public static void main(String[] args) throws Throwable {
//        new Foo().print("jackie");
//        Foo foo = new Foo();
//        MethodType methodType = MethodType.methodType(void.class,String.class);  //用来表示方法签名，指定方法的返回值类型和参数类型
//        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(Foo.class,"print",methodType);
//        methodHandle.invokeExact(foo,"world");
    }
}
