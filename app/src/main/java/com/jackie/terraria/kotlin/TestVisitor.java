package com.jackie.terraria.kotlin;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/20
 */
class TestVisitor extends ClassVisitor {

    public TestVisitor(final int api, final ClassVisitor classVisitor) {
        super(api, classVisitor);
    }
//    override fun visitField(access: Int, name: String?, descriptor: String?, signature: String?, value: Any?): FieldVisitor {
//        if (value != null && value is String
//            && descriptor == Type.getDescriptor(String::class.java)
//            && 0 != (Opcodes.ACC_STATIC and access)
//            && 0 != (Opcodes.ACC_FINAL and access)
//        ) {
//            //添加一个类下的 所有  static final 的字段
//            staticFinalStringFieldNodeList.add(FieldNode(access, name, descriptor, signature, value))
//            return super.visitField(access, name, descriptor, signature, null)
//        }
//        return super.visitField(access, name, descriptor, signature, value)
//    }
public static void main(String[] args) {
    int ACC_STATIC = 0x0008; // field, method
    int ACC_FINAL = 0x0010; // class, field, method, parameter
    int a = 26;
    System.out.println(a & ACC_STATIC);
    System.out.println(a & ACC_FINAL);
    System.out.println(Type.getDescriptor(String.class));
}
}
