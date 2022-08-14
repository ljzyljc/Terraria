package com.jackie.terraria;

////import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
//import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
//import static org.objectweb.asm.Opcodes.ASM7;
//import static org.objectweb.asm.Opcodes.BIPUSH;
//import static org.objectweb.asm.Opcodes.IADD;
//import static org.objectweb.asm.Opcodes.ILOAD;
//import static org.objectweb.asm.Opcodes.IRETURN;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.List;
//import org.objectweb.asm.ClassReader;
//import org.objectweb.asm.ClassVisitor;
//import org.objectweb.asm.ClassWriter;
//import org.objectweb.asm.FieldVisitor;
//import org.objectweb.asm.Label;
//import org.objectweb.asm.MethodVisitor;
//import org.objectweb.asm.Opcodes;
//import org.objectweb.asm.commons.AdviceAdapter;
//import org.objectweb.asm.tree.ClassNode;
//import org.objectweb.asm.tree.FieldNode;
//import org.objectweb.asm.tree.MethodNode;
//
//import java.io.File;
//import java.io.FileInputStream;
//import org.objectweb.asm.ClassReader;
//import org.objectweb.asm.ClassVisitor;
//import org.objectweb.asm.ClassWriter;
//import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/11
 */
public class MyMain {
    public int a = 0;
    public int b = 1;

    public void test01(){}
    public void test02(){}

    public static void main(String[] args) {

//        System.out.println(new MyMain().foo(1));
        new MyMain().foo();

        //=======================================访问类的方法和字段==================================

//        byte[] bytesArray = getBytes();
//        System.out.println(bytesArray.length);

//        ClassReader cr = new ClassReader(bytesArray);
//        ClassWriter cw = new ClassWriter(0);
//        ClassVisitor cv = new ClassVisitor(ASM7,cw) {
//            @Override
//            public FieldVisitor visitField(final int access, final String name, final String descriptor,
//                    final String signature,
//                    final Object value) {
//                System.out.println("field: "+name);
//                return super.visitField(access, name, descriptor, signature, value);
//            }
//
//            @Override
//            public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
//                    final String signature,
//                    final String[] exceptions) {
//                System.out.println("method: "+name);
//                return super.visitMethod(access, name, descriptor, signature, exceptions);
//            }
//        };
//        cr.accept(cv,ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);


        //Tree Api


//        ClassReader cr = new ClassReader(bytesArray);
//        ClassNode cn = new ClassNode();
//        cr.accept(cn,ClassReader.SKIP_DEBUG | ClassReader.SKIP_CODE);
//        List<FieldNode> fieldNodes = cn.fields;
//        for (int i = 0; i < fieldNodes.size(); i++) {
//            FieldNode fieldNode = fieldNodes.get(i);
//            System.out.println("field: "+ fieldNode.name);
//        }
//        List<MethodNode> methodNodes = cn.methods;
//        for (int i = 0; i < methodNodes.size(); i++) {
//            MethodNode methodNode = methodNodes.get(i);
//            System.out.println("method: "+methodNode.name);
//        }
//        ClassWriter cw = new ClassWriter(0);
//        cr.accept(cn,0);
//        byte[] byteModified = cw.toByteArray();


        //=======================================新增一个字段==================================

//        byte[] bytesArray = getBytes();
//        System.out.println(bytesArray.length);
//
//        ClassReader cr = new ClassReader(bytesArray);
//        ClassWriter cw = new ClassWriter(0);
//        ClassVisitor cv = new ClassVisitor(ASM7,cw) {
//            @Override
//            public void visitEnd() {
//                super.visitEnd();
//                FieldVisitor fv = cv.visitField(Opcodes.ACC_PUBLIC,"jackie","Ljava/lang/String;",null,null);
//                if (fv != null) fv.visitEnd();
//            }
//        };
//
//        cr.accept(cv,ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);
//        byte[] byteModifier = cw.toByteArray();
//
//        File file = new File("/Users/jackie/Desktop/WorkPlace/Terraria/app/src/main/java/com/jackie/terraria/MyMain2.class");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(byteModifier);
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        //Tree Api

//        byte[] bytesArray = getBytes();
//        System.out.println(bytesArray.length);
//
//        ClassReader cr = new ClassReader(bytesArray);
//        ClassNode cn = new ClassNode();
//        cr.accept(cn,ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);
//
//        FieldNode fn = new FieldNode(ACC_PUBLIC,"jackie2","Ljava/lang/String;",null,null);
//        cn.fields.add(fn);
//
//        ClassWriter cw = new ClassWriter(0);
//        cn.accept(cw);
//
//        byte[] byteModified = cw.toByteArray();
//
//        File file = new File(
//                "/Users/jackie/Desktop/WorkPlace/Terraria/app/src/main/java/com/jackie/terraria/MyMain2.class");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(byteModified);
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //add method
//        byte[] bytesArray = getBytes();
//        System.out.println(bytesArray.length);
//
//        ClassReader cr = new ClassReader(bytesArray);
//        ClassWriter cw = new ClassWriter(0);
//        ClassVisitor cv = new ClassVisitor(ASM7,cw) {
//            @Override
//            public void visitEnd() {
//                super.visitEnd();
//                MethodVisitor mv = cv.visitMethod(ACC_PUBLIC,"jackie","(ILjava/lang/String;)V",null,null);
//                if(mv != null) mv.visitEnd();
//            }
//        };
//        cr.accept(cv,ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);
//
//        byte[] byteModified = cw.toByteArray();
//        File file = new File(
//                "/Users/jackie/Desktop/WorkPlace/Terraria/app/src/main/java/com/jackie/terraria/MyMain2.class");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(byteModified);
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //Tree Api
//        byte[] bytesArray = getBytes();
//        System.out.println(bytesArray.length);
//        ClassReader cr = new ClassReader(bytesArray);
//        ClassNode cn = new ClassNode();
//        cr.accept(cn,ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);
//
//        MethodNode methodNode = new MethodNode(ACC_PUBLIC,"jackie3","(ILjava/lang/String;)V",null,null);
//        cn.methods.add(methodNode);
//
//        ClassWriter cw = new ClassWriter(0);
//        cn.accept(cw);
//
//
//        byte[] byteModified = cw.toByteArray();
//        File file = new File(
//                "/Users/jackie/Desktop/WorkPlace/Terraria/app/src/main/java/com/jackie/terraria/MyMain2.class");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(byteModified);
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //=======================================移除方法和字段==================================
//        byte[] bytesArray = getBytes();
//        ClassReader cr = new ClassReader(bytesArray);
//        ClassWriter cw = new ClassWriter(0);
//        ClassVisitor cv = new ClassVisitor(ASM7,cw) {
//            @Override
//            public FieldVisitor visitField(final int access, final String name, final String descriptor,
//                    final String signature,
//                    final Object value) {
//                if ("a".equals(name)){
//                    return null;
//                }
//                return super.visitField(access, name, descriptor, signature, value);
//            }
//
//            @Override
//            public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
//                    final String signature,
//                    final String[] exceptions) {
//                if ("test01".equals(name)){
//                    return null;
//                }
//
//                return super.visitMethod(access, name, descriptor, signature, exceptions);
//            }
//        };
//        cr.accept(cv,ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);
//        byte[] bytes = cw.toByteArray();
//        File file = new File(
//                "/Users/jackie/Desktop/WorkPlace/Terraria/app/src/main/java/com/jackie/terraria/MyMain.class");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(bytes);
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //Tree Api

//        byte[] bytesArray = getBytes();
//        ClassReader cr = new ClassReader(bytesArray);
//        ClassNode cn = new ClassNode();
//        cr.accept(cn,ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);
//
//        cn.methods.add(new MethodNode(ACC_PUBLIC,"jackie3","(ILjava/lang/String;)V",null,null));
//        cn.fields.remove(new FieldNode(ACC_PUBLIC,"jackie3","Ljava/lang/String;",null,null));
//        //无效？？？
////        cn.fields.remove(new FieldNode(ACC_PUBLIC,"b","I",null,null));
//
//        ClassWriter cw = new ClassWriter(0);
//        cn.accept(cw);
//
//        byte[] bytes = cw.toByteArray();
//        File file = new File(
//                "/Users/jackie/Desktop/WorkPlace/Terraria/app/src/main/java/com/jackie/terraria/MyMain2.class");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(bytes);
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//

        //====================================修改方法内容====================
//        byte[] bytes = getBytes();
//        ClassReader cr = new ClassReader(bytes);
//        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
//        ClassVisitor cv = new ClassVisitor(ASM7,classWriter) {
//            @Override
//            public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
//                    final String signature,
//                    final String[] exceptions) {
//                if ("foo".equals(name)){
//                    return null;
//                }
//                return super.visitMethod(access, name, descriptor, signature, exceptions);
//            }
//
//            @Override
//            public void visitEnd() {
//                super.visitEnd();
//                MethodVisitor mv = cv.visitMethod(ACC_PUBLIC,"foo","(I)I",null,null);
//                mv.visitCode();
//                mv.visitVarInsn(ILOAD,1);
//                mv.visitIntInsn(BIPUSH,100);
//                mv.visitInsn(IADD);
//                mv.visitInsn(IRETURN);
//                //触发计算
//                mv.visitMaxs(0,0);
//
//                mv.visitEnd();
//
//            }
//        };
//        cr.accept(cv,0);
//        byte[] b = classWriter.toByteArray();
//        writeToByteFile(b);

        //=========================================AdviceAdapter使用 方法头尾加上打印=============================

//        byte[] bytes = getBytes();
//        ClassReader cr = new ClassReader(bytes);
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
//        ClassVisitor cv = new ClassVisitor(ASM7,cw) {
//            @Override
//            public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
//                    final String signature,
//                    final String[] exceptions) {
//                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
//                if (!"foo".equals(name)) return mv;
//
//                return new AdviceAdapter(ASM7,mv,access,name,descriptor) {
//                    @Override
//                    protected void onMethodEnter() {
//                        super.onMethodEnter();
//                        mv.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
//                        mv.visitLdcInsn("enter"+ name);
//                        mv.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/String;)V",false);
//                    }
//
//                    @Override
//                    protected void onMethodExit(final int opcode) {
//                        super.onMethodExit(opcode);
//                        mv.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
//                        if (opcode == Opcodes.ATHROW){
//                            mv.visitLdcInsn("err exit"+ name);
//                        } else {
//                            mv.visitLdcInsn("normal exit"+ name);
//                        }
//                        mv.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/String;)V",false);
//                    }
//                };
//
//
//            }
//        };
//        cr.accept(cv,0);
//        byte[] b = cw.toByteArray();
//        writeToByteFile(b);


        //=========================================AdviceAdapter使用 方法加上 try-catch =============================

//        byte[] bytes = getBytes();
//        ClassReader cr = new ClassReader(bytes);
//        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
//        ClassVisitor cv = new ClassVisitor(ASM7,cw) {
//            Label startLabel = new Label();
//            @Override
//            public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
//                    final String signature,
//                    final String[] exceptions) {
//                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
//                if (!"foo".equals(name)) return mv;
//
//                return new AdviceAdapter(ASM7,mv,access,name,descriptor) {
//                    @Override
//                    protected void onMethodEnter() {
//                        super.onMethodEnter();
//                        mv.visitLabel(startLabel);
//
//                        mv.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
//                        mv.visitLdcInsn("enter"+ name);
//                        mv.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/String;)V",false);
//                    }
//
//                    @Override
//                    public void visitMaxs(final int maxStack, final int maxLocals) {
//                        //生成异常表
//                        Label endLabel = new Label();
//                        mv.visitTryCatchBlock(startLabel,endLabel,endLabel, null);
//                        mv.visitLabel(endLabel);
//
//                        //生成异常处理代码块
//                        typeFinallyBlock(ATHROW);
//                        mv.visitInsn(ATHROW);
//                        super.visitMaxs(maxStack, maxLocals);
//                    }
//
//                    @Override
//                    protected void onMethodExit(final int opcode) {
//                        super.onMethodExit(opcode);
//                        if (opcode != ATHROW) typeFinallyBlock(opcode);
//                    }
//
//                    private void typeFinallyBlock(int opcode){
//                        mv.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
//                        if (opcode == Opcodes.ATHROW){
//                            mv.visitLdcInsn("err exit"+ name);
//                        } else {
//                            mv.visitLdcInsn("normal exit"+ name);
//                        }
//                        mv.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/String;)V",false);
//
//                    }
//                };
//
//
//            }
//        };
//        cr.accept(cv,0);
//        byte[] b = cw.toByteArray();
//        writeToByteFile(b);
//
//
//






    }

    private static void writeToByteFile(byte[] bytes){
        File file = new File(
                "/Users/jackie/Desktop/WorkPlace/Terraria/app/src/main/java/com/jackie/terraria/MyMain.class");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private static byte[] getBytes(){
        File file = new File("/Users/jackie/Desktop/WorkPlace/Terraria/app/src/main/java/com/jackie/terraria/MyMain.class");
        System.out.println(file.getAbsolutePath());
        byte[] bytesArray = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytesArray;
    }

//    public int foo(int a){
//        return a;
//    }

//    public void foo(){
//        System.out.println("hello foo");
//    }

    public void foo(){
        try {
            int a = 1 / 0;
        }catch (Exception e){
            ExceptionUtils.handleException(e);
        }
    }

}
