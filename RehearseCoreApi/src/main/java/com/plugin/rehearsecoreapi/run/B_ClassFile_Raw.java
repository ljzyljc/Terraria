package com.plugin.rehearsecoreapi.run;

import lsieun.classfile.ClassFile;
import lsieun.utils.FileUtils;
import lsieun.utils.ReadUtils;
import lsieun.vs.ClassFileRawVisitor;
import lsieun.vs.Visitor;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/23
 */
class B_ClassFile_Raw {
    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "com/plugin/rehearsecoreapi/MyClass.class";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        // 可以使用 ClassFileRawVisitor、ClassFileSimpleVisitor 或者 ClassFileStandardVisitor
        Visitor v = new ClassFileRawVisitor();
        classfile.accept(v);
    }
}
