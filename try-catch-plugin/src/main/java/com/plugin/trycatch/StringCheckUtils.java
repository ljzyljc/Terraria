package com.plugin.trycatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCheckUtils {

    //基本数据类型
    static String I_TYPE = "^\\((.*)\\)I";
    static String B_TYPE = "^\\((.*)\\)B";
    static String S_TYPE = "^\\((.*)\\)S";
    static String D_TYPE = "^\\((.*)\\)D";
    static String F_TYPE = "^\\((.*)\\)F";
    static String LONG_TYPE = "^\\((.*)\\)J";
    static String BOOLEAN_TYPE = "^\\((.*)\\)Z";
    static String C_TYPE = "^\\((.*)\\)C";


    public static boolean checkValidity (String str) {
        Pattern p = Pattern.compile("^\\((.*)\\)I");
        Matcher m = p.matcher(str);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(checkValidity("(Ljava/lang/String;)I"));
        System.out.println(checkValidity("([Ljava/lang/String;)V"));
        System.out.println(checkValidity("()V"));
    }
}
