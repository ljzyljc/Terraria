package com.jackie.terraria;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/22
 */
class ShadowThread extends Thread{


    static final String MARK = "\u200B";

    public ShadowThread(Runnable runnable,String name){

    }

    public static Thread setThreadName(final Thread t, final String prefix) {
        t.setName(makeThreadName(t.getName(), prefix));
        return t;
    }

    public static String makeThreadName(final String name) {
        return name == null ? "" : name.startsWith(MARK) ? name : (MARK + name);
    }

    public static String makeThreadName(final String name, final String prefix) {
        return name == null ? prefix : (name.startsWith(MARK) ? name : (prefix + "#" + name));
    }

    public static void main(String[] args) {
        ShadowThread.setThreadName(new ShadowThread(new Runnable() {
            @Override
            public void run() {

            }
        }, "Test"),"abc");

    }

}
