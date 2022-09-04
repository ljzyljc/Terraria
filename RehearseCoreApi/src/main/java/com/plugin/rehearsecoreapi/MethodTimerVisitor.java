package com.plugin.rehearsecoreapi;


import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.LocalVariablesSorter;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/9/4
 */
public class MethodTimerVisitor extends ClassVisitor {

    public MethodTimerVisitor(final int api, final ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
            final String signature,
            final String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (mv != null && !"<init>".equals(name) && !"<clinit>".equals(name)){
            boolean isAbs = (access & ACC_ABSTRACT) != 0;
            boolean isNativeMethod = (access & ACC_NATIVE) != 0;
            if (!isAbs && !isNativeMethod){
                mv = new MethodTimerAdapter(api,access,name,descriptor,mv);
            }
        }
        return mv;
    }

    private static class MethodTimerAdapter extends LocalVariablesSorter implements Opcodes {
        private final String methodName;
        private final String methodDesc;
        private int slotIndex = 0;

        public MethodTimerAdapter(final int api, final int access, String name,final String descriptor,
                final MethodVisitor methodVisitor) {
            super(api, access, descriptor, methodVisitor);
            this.methodName = name;
            this.methodDesc = descriptor;
        }

        @Override
        public void visitCode() {

            slotIndex = newLocal(Type.LONG_TYPE);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(LSTORE, slotIndex);

            super.visitCode();
        }

        @Override
        public void visitInsn(final int opcode) {

            if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {

                mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
                mv.visitVarInsn(LLOAD, slotIndex);
                mv.visitInsn(LSUB);
                mv.visitVarInsn(LSTORE, slotIndex);
                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
                mv.visitInsn(DUP);
                mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
                mv.visitLdcInsn(methodName + methodDesc);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append",
                        "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                mv.visitVarInsn(LLOAD, slotIndex);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append",
                        "(J)Ljava/lang/StringBuilder;", false);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString",
                        "()Ljava/lang/String;", false);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V",
                        false);
            }
            super.visitInsn(opcode);
        }
    }


}
