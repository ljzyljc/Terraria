package com.plugin.rehearsecoreapi.hello;

import com.android.tools.r8.internal.Me;
import com.plugin.rehearsecoreapi.MethodTimerVisitor;
import com.plugin.rehearsecoreapi.hello.annotation.MyTag;
import lsieun.utils.FileUtils;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/25
 */
public class MyClassGenerateCore implements Opcodes {

    public static void main(String[] args) {
        String path = FileUtils.getFilePath("com/plugin/rehearsecoreapi/MyClass.class");
        byte[] bytes1 = FileUtils.readBytes(path);

        ClassReader cr = new ClassReader(bytes1);

        ClassWriter cw = new ClassWriter(ASM9);

        ClassVisitor cv = new MethodTimerVisitor(ASM9,cw);

        cr.accept(cv,ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);

        byte[] bytes = cw.toByteArray();

        FileUtils.writeBytes(path,bytes);


    }


//    public static void main(String[] args) throws Exception {
//        String path = FileUtils.getFilePath("com/plugin/rehearsecoreapi/MyClass.class");
//        byte[] bytes1 = FileUtils.readBytes(path);
//
//        ClassReader classReader = new ClassReader(bytes1);
//
//        ClassWriter cw = new ClassWriter(ASM9);
//
//        ClassVisitor classVisitor = new ClassVisitor(ASM9,cw) {
//            @Override
//            public void visit(final int version, final int access, final String name, final String signature,
//                    final String superName,
//                    final String[] interfaces) {
//                super.visit(version, access, name, signature, superName, interfaces);
//            }
//        };
//
//
//        classReader.accept(classVisitor,ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
//
//        byte[] bytes2 = cw.toByteArray();
//
//        FileUtils.writeBytes(path,bytes2);
//
//    }
//    public static void main(String[] args) throws Exception {
//        String path = FileUtils.getFilePath("com/plugin/rehearsecoreapi/MyClassInterface.class");
//        byte[] bytes = dump();
//        FileUtils.writeBytes(path, bytes);
//    }

//    public class HelloWorld {
//        public void test() {
//            GoodChild child = new GoodChild("Lucy", 8);
//        }
//    }

    public static byte[] dump() throws Exception {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(V11, ACC_PUBLIC + ACC_SUPER, "com/plugin/rehearsecoreapi/MyClassInterface", null,
                "java/lang/Object", null);
        {
            MethodVisitor mv1 = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv1.visitCode();
            mv1.visitVarInsn(ALOAD, 0);
            mv1.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv1.visitInsn(RETURN);
            mv1.visitMaxs(1, 1);
            mv1.visitEnd();
        }

        {

        }

        cw.visitEnd();

        return cw.toByteArray();
    }

//    public class HelloWorld {
//        static {
//            System.out.println("class initialization method");
//        }
//    }

//    public static byte[] dump() throws Exception {
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//        cw.visit(V11, ACC_PUBLIC + ACC_SUPER, "com/plugin/rehearsecoreapi/MyClassInterface", null,
//                "java/lang/Object", null);
//        {
//            MethodVisitor mv1 = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
//            mv1.visitCode();
//            mv1.visitVarInsn(ALOAD, 0);
//            mv1.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
//            mv1.visitInsn(RETURN);
//            mv1.visitMaxs(1, 1);
//            mv1.visitEnd();
//        }
//
//        {
//            MethodVisitor mv2 = cw.visitMethod(ACC_STATIC,"<clinit>","()V",null,null);
//            mv2.visitCode();
//            mv2.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
//            mv2.visitLdcInsn("class clinit static");
//            mv2.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/String;)V",false);
//            mv2.visitInsn(RETURN);
//            mv2.visitMaxs(2,0);
//
//            mv2.visitEnd();
//
//        }
//
//        cw.visitEnd();
//
//        return cw.toByteArray();
//    }


//    public class HelloWorld {
//        public HelloWorld() {
//            super();
//        }
//    }



//    public static byte[] dump() throws Exception {
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//        cw.visit(V11, ACC_PUBLIC + ACC_SUPER, "com/plugin/rehearsecoreapi/MyClassInterface", null,
//                "java/lang/Object", null);
//        {
//            MethodVisitor mv1 = cw.visitMethod(ACC_PUBLIC,"<init>","()V",null,null);
//            mv1.visitCode();
//            mv1.visitVarInsn(ALOAD,0);
//            mv1.visitMethodInsn(INVOKESPECIAL,"java/lang/Object","<init>","()V",false);
//            mv1.visitInsn(RETURN);
//            mv1.visitMaxs(1,1);
//            mv1.visitEnd();
//
//
//        }
//
//
//        cw.visitEnd();
//
//        return cw.toByteArray();
//    }
//
//    public interface HelloWorld {
//        @MyTag(name = "tomcat", age = 10)
//        int intValue = 100;
//    }
//    public static byte[] dump() throws Exception {
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//        cw.visit(V11, ACC_PUBLIC + ACC_SUPER + ACC_INTERFACE, "com/plugin/rehearsecoreapi/MyClassInterface", null,
//                "java/lang/Object", null);
//        {
//            FieldVisitor fv = cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "intValue", "I", null, 100);
//            {
//                AnnotationVisitor annotationVisitor = fv.visitAnnotation("Lcom/plugin/rehearsecoreapi/hello/annotationn/MyTag",false);
//                annotationVisitor.visit("name","tomact");
//                annotationVisitor.visit("age",10);
//                annotationVisitor.visitEnd();
//            }
//            fv.visitEnd();
//        }
//        cw.visitEnd();
//
//        return cw.toByteArray();
//    }

//    public static byte[] dump() throws Exception {
//
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//        cw.visit(V11, ACC_PUBLIC + ACC_SUPER, "com/plugin/rehearsecoreapi/MyClassInterface", null,"java/lang/Object", null);
//
//        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC,"<init>","()V",null,null);
//        mv.visitCode();
//        mv.visitVarInsn(ALOAD,0);
//        mv.visitMethodInsn(INVOKESPECIAL,"java/lang/Object","<init>","()V",false);
//        mv.visitInsn(RETURN);
//        mv.visitMaxs(1,1);
//        mv.visitEnd();
//
//        //???
////        MethodVisitor m1 = cw.visitMethod(ACC_STATIC,"<clinit>","()V",null,null);
////        m1.visitCode();
////        m1.visitInsn(RETURN);
////        m1.visitMaxs(0,0);
////        m1.visitEnd();
//
//        cw.visitEnd();
//
//        return cw.toByteArray();
//    }

//    int LESS = -1;
//    int EQUAL = 0;
//    int GREATER = 1;
//    int compareTo(Object o);

//    public static byte[] dump() throws Exception {
//
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
//        cw.visit(V11, ACC_PUBLIC | ACC_ABSTRACT | ACC_INTERFACE, "com/plugin/rehearsecoreapi/MyClassInterface", null,
//                "java/lang/Object", new String[]{"java/lang/Cloneable"});
////        cw.visitField(ACC_PUBLIC | ACC_STATIC,"age","I",null,1);
////        cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
//
//        {
//            FieldVisitor f1 = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC,"LESS","I",null,10);
//            f1.visitEnd();
//        }
//
//        {
//            FieldVisitor f2 = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC,"EQUAL","I",null,-1);
//            f2.visitEnd();
//        }
//
//        {
//            FieldVisitor f3 = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC,"NAME","Ljava/lang/String;",null,"30");
//            f3.visitEnd();
//        }
//
//        {
//            MethodVisitor m1 = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT,"compareTo","(Ljava/lang/Object;)I",null,null);
//            m1.visitEnd();
//        }
//
//
//        cw.visitEnd();
//
//        return cw.toByteArray();
//    }
}

//exception:   new String[] { "java/io/FileNotFoundException", "java/io/IOException" }