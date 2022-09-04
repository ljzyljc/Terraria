package com.plugin.rehearsecoreapi.run;

import com.plugin.rehearsecoreapi.hello.HelloWorldDump;
import lsieun.utils.FileUtils;
import lsieun.utils.HexFormat;
import lsieun.utils.HexUtils;
import lsieun.utils.ReadUtils;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/23
 */
class A_File_Hex {

    public static void main(String[] args) {
        //
//        String path = FileUtils.getFilePath("com/plugin/rehearsecoreapi/MyClass.class");
//
//        byte[] bytes = ReadUtils.readByPath(path);
//
//        //Hex
//        String hex = HexUtils.format(bytes, HexFormat.FORMAT_FF_SPACE_FF_32);
//        System.out.println(hex);


        try {
            String path = FileUtils.getFilePath("com/plugin/rehearsecoreapi/TestClass.class");
            byte[] bytes = HelloWorldDump.dump();
            FileUtils.writeBytes(path,bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
