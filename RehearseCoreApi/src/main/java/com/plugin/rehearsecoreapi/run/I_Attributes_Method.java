package com.plugin.rehearsecoreapi.run;

import lsieun.classfile.Attributes;
import lsieun.classfile.ClassFile;
import lsieun.classfile.ConstantPool;
import lsieun.classfile.MethodInfo;
import lsieun.utils.ConstantPoolUtils;
import lsieun.utils.FileUtils;
import lsieun.utils.MethodUtils;
import lsieun.utils.ReadUtils;
import lsieun.vs.AttributeStandardVisitor;
import lsieun.vs.Visitor;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/23
 */
class I_Attributes_Method {

    public static void main(String[] args) {
        // 第一步，输入参数
        String relative_path = "com/plugin/rehearsecoreapi/MyClass.class";
        String name_and_type = "test:()V";

        // 第二步，读取数据
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = ReadUtils.readByPath(filepath);

        // 第三步，处理数据
        ClassFile classfile = ClassFile.parse(bytes);
        MethodInfo methodInfo = MethodUtils.findMethod(classfile, name_and_type);

        ConstantPool cp = classfile.constant_pool;
        ConstantPoolUtils.print(cp);

        Attributes attributes = methodInfo.attributes;
        Visitor v = new AttributeStandardVisitor(cp);
        attributes.accept(v);
    }
}
