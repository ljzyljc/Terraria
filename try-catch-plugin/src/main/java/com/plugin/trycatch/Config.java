package com.plugin.trycatch;


public class Config {

    private static Config instance = new Config();

    public static Config getInstance() {
        return instance;
    }

    public TryCatchExtension mTryCatchExtension;
}
