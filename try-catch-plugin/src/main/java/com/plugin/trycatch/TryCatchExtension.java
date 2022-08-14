package com.plugin.trycatch;

import java.util.List;
import java.util.Map;


public class TryCatchExtension {

    public Map<String, List<String>> hookPoint;

    public Map<String, String> exceptionHandler;

    public Map<String,String> returnHandler;

    @Override
    public String toString() {
        return "TryCatchExtension{" +
                "hookPoint=" + hookPoint +
                ", exceptionHandler=" + exceptionHandler +
                ", returnHandler=" + returnHandler +
                '}';
    }
}
