package com.encrypt.lib;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/20
 */
import java.io.UnsupportedEncodingException;

public class Base64Util {
    public final static String ENCODING = "UTF-8";

    public static String encode(String data) {
        try {

            byte[] b = Base64.encode(data, Base64.DEFAULT);
            return new String(b, ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String decode(String data) {
        try {
            byte[] b = Base64.decode(data, Base64.DEFAULT);
            return new String(b, ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";

    }
}
