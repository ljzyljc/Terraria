package com.plugin.trycatch;

import static com.plugin.trycatch.StringCheckUtils.B_TYPE;
import static com.plugin.trycatch.StringCheckUtils.C_TYPE;
import static com.plugin.trycatch.StringCheckUtils.D_TYPE;
import static com.plugin.trycatch.StringCheckUtils.F_TYPE;
import static com.plugin.trycatch.StringCheckUtils.I_TYPE;
import static com.plugin.trycatch.StringCheckUtils.S_TYPE;
import static com.plugin.trycatch.StringCheckUtils.LONG_TYPE;
import static com.plugin.trycatch.StringCheckUtils.BOOLEAN_TYPE;
import static com.plugin.trycatch.StringCheckUtils.LONG_TYPE;
import static groovyjarjarasm.asm.Opcodes.ASM7;

import groovyjarjarasm.asm.Opcodes;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;


public class TryCatchClassAdapter extends ClassVisitor {
    private String mClassName;
    private List<String> mMethodName;
    private String mMethodDescriptor;

    public TryCatchClassAdapter(ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }

    @Override
    public void visit(final int version, final int access, final String name, final String signature,
            final String superName, final String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        mClassName = name.replace("/",".");
        mMethodName = Config.getInstance().mTryCatchExtension.hookPoint.get(mClassName);
        System.out.println("~~~~~~~~~~className: name"+name);

    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
            final String signature,
            final String[] exceptions) {
        System.out.println("~~~~~~~~~mMethodName: descriptor"+descriptor);
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (mMethodName.contains(name)){
            mMethodDescriptor = descriptor;
            return new MyClassAdviceAdapter(ASM7,mv,access,name,descriptor);
        } else {
            return mv;
        }

    }

    //no return value
    private class MyClassAdviceAdapter extends AdviceAdapter {


        Label l1;
        Label l2;
        private String mExceptionHandleClass;
        private String mExceptionHandleMethod;
        private String mReturnHandleClass;
        private String mReturnHandleMethod;
        protected MyClassAdviceAdapter(final int api, final MethodVisitor methodVisitor, final int access,
                final String name, final String descriptor) {
            super(api, methodVisitor, access, name, descriptor);

            Map<String,String> exceptionMap = Config.getInstance().mTryCatchExtension.exceptionHandler;
            if (exceptionMap != null){
                exceptionMap.entrySet().forEach(entry -> {
                    mExceptionHandleClass = entry.getKey().replace(".","/");
                    mExceptionHandleMethod = entry.getValue();
                });
            }
            Map<String,String> returnMap = Config.getInstance().mTryCatchExtension.returnHandler;
            if (returnMap != null){
                returnMap.entrySet().forEach(entry -> {
                    mReturnHandleClass = entry.getKey().replace(".","/");
                    mReturnHandleMethod = entry.getValue();
                });
            }
        }


        @Override
        protected void onMethodEnter() {
            super.onMethodEnter();
            Label l0 = new Label();
            l1 = new Label();
            l2 = new Label();
            mv.visitTryCatchBlock(l0,l1,l2,"java/lang/Exception");
        }

        @Override
        protected void onMethodExit(final int opcode) {
            super.onMethodExit(opcode);
            System.out.println();
            if (mReturnHandleClass != null && mReturnHandleMethod != null) {
                mv.visitLabel(l1);
                //需要返回值，基础类型和对象
                if (mMethodDescriptor.equals(I_TYPE)) {
                    mv.visitInsn(IRETURN);
                } else if (mMethodDescriptor.equals(B_TYPE)) {
                    mv.visitInsn(IRETURN);
                } else if (mMethodDescriptor.equals(S_TYPE)) {
                    mv.visitInsn(IRETURN);
                } else if (mMethodDescriptor.equals(D_TYPE)) {
                    mv.visitInsn(DRETURN);
                } else if (mMethodDescriptor.equals(F_TYPE)) {
                    mv.visitInsn(FRETURN);
                } else if (mMethodDescriptor.equals(LONG_TYPE)) {
                    mv.visitInsn(LRETURN);
                } else if (mMethodDescriptor.equals(BOOLEAN_TYPE)) {
                    mv.visitInsn(IRETURN);
                } else if (mMethodDescriptor.equals(C_TYPE)) {
                    mv.visitInsn(IRETURN);
                } else {
                    mv.visitInsn(ARETURN);
                }
                mv.visitLabel(l2);
                mv.visitVarInsn(ASTORE,2);
                if (mExceptionHandleClass != null && mExceptionHandleMethod != null) {
                    mv.visitVarInsn(ALOAD, 2);
                    mv.visitMethodInsn(INVOKESTATIC, mExceptionHandleClass, mExceptionHandleMethod,
                            "(Ljava/lang/Throwable;)V", false);
                }
                mv.visitMethodInsn(INVOKESTATIC, mReturnHandleClass, mReturnHandleMethod,
                        "()I", false);
                mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf","(I)Ljava/lang/Integer;",
                         false);

            } else {

                mv.visitLabel(l1);
                Label l3 = new Label();
                mv.visitJumpInsn(GOTO, l3);
                mv.visitLabel(l2);
                mv.visitVarInsn(ASTORE, 1);
                if (mExceptionHandleClass != null && mExceptionHandleMethod != null) {
                    mv.visitVarInsn(ALOAD, 1);
                    mv.visitMethodInsn(INVOKESTATIC, mExceptionHandleClass, mExceptionHandleMethod,
                            "(Ljava/lang/Throwable;)V", false);
                }
                mv.visitLabel(l3);
            }
        }
    }
}
