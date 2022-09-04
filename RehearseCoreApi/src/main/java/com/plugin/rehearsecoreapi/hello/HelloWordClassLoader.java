package com.plugin.rehearsecoreapi.hello;


public class HelloWordClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        if ("com.plugin.rehearsecoreapi.MyClass".equals(name)){
            byte[] bytes = new byte[0];
            try {
                bytes = HelloWorldDump.dump();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Class<?> clazz = defineClass(name,bytes,0,bytes.length);
            return clazz;

        }
        throw new ClassNotFoundException("Class not found "+ name);
    }
}
