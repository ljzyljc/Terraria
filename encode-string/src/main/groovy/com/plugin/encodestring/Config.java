package com.plugin.encodestring;


public class Config {

    private final static Config instance = new Config();
    public EncryptStringExtension mEncryptStringExtension;

    public static Config getInstance() {
        return instance;
    }
}
