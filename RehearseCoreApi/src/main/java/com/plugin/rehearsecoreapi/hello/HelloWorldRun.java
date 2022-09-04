package com.plugin.rehearsecoreapi.hello;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.objectweb.asm.Type;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/23
 */
public class HelloWorldRun {

    public static void main(String[] args) throws Exception {

        //从一个描述符(Descriptor) 来获取 Type 对象
        Type t = Type.getType("Ljava/lang/String;");
        System.out.println(t);

        Type t1 = Type.getMethodType("(II)I");
        System.out.println(t1);

        //从一个 java.lang.Class 来获取 Type 对象
        Type t2 = Type.getType(String.class);
        System.out.println(t2);

        //从一个 internal name 来获取 Type 对象
        Type t3 = Type.getObjectType("java/lang/String");
        System.out.println(t3);

        Type t4 = Type.INT_TYPE;
        System.out.println(t4);


//        HelloWordClassLoader classLoader = new HelloWordClassLoader();
//        Class<?> clazz = classLoader.loadClass("com.plugin.rehearsecoreapi.MyClass");
//        Object instance = clazz.newInstance();
//        System.out.println(instance);

//        Class<?> clazz = Class.forName("com.plugin.rehearsecoreapi.MyClassInterface");
//        System.out.println(clazz);


//        Class<?> clazz = Class.forName("com.plugin.rehearsecoreapi.MyClassInterface");
//        Field[] fields = clazz.getDeclaredFields();
//        if (fields.length > 0){
//            System.out.println("field: ");
//            for (Field field:fields) {
//                System.out.println("    "+ field.getName());
//            }
//        }
//        Method[] methods = clazz.getDeclaredMethods();
//        if (methods.length > 0){
//            System.out.println("method: ");
//            for (Method method:methods) {
//                System.out.println("    "+ method.getName());
//            }
//        }

    }
}
