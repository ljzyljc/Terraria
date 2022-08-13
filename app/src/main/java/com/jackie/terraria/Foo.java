package com.jackie.terraria;

import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
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
    public void print(String s){
        System.out.println("test:"+s);
    }

    @RequiresApi(api = VERSION_CODES.O)
    public static void main(String[] args) throws Throwable {
//        Foo foo = new Foo();
//        MethodType methodType = MethodType.methodType(void.class,String.class);  //用来表示方法签名，指定方法的返回值类型和参数类型
//        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(Foo.class,"print",methodType);
//        methodHandle.invokeExact(foo,"world");
    }
}
