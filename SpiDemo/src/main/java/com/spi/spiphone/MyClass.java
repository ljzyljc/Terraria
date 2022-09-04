package com.spi.spiphone;

import java.util.Iterator;
import java.util.ServiceLoader;

public class MyClass {

    private static Iterator<Phone> mIterator;
    public static void main(String[] args) {
        System.out.println("===========1=======");
        ServiceLoader<Phone> serviceLoader = ServiceLoader.load(Phone.class);
        mIterator = serviceLoader.iterator();
        System.out.println("=========2========="+mIterator.hasNext());

        while (mIterator.hasNext()){
            System.out.println(mIterator.next().getBrand());
        }
        System.out.println("=========3=========");
//        serviceLoader.forEach(provider ->{
//            String systemInfo = provider.getBrand();
//            System.out.println(systemInfo);
//        });
    }
}