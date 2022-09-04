package com.plugin.method_excute_time;


public class Config {

    private static Config instance = new Config();

    public static Config getInstance() {
        return instance;
    }

    public MethodExecuteExtension mMethodExecuteExtension;
}
