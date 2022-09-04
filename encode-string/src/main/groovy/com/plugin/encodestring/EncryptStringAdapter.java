package com.plugin.encodestring;

import java.util.ArrayList;
import java.util.List;
import org.gradle.internal.impldep.com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Type;
import org.gradle.internal.impldep.com.google.api.client.util.Base64;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.FieldNode;

import static groovyjarjarasm.asm.Opcodes.ASM7;
import static groovyjarjarasm.asm.Opcodes.INVOKESTATIC;
import static groovyjarjarasm.asm.Opcodes.PUTSTATIC;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/20
 */
public class EncryptStringAdapter extends ClassVisitor {


    private String owner;
    private List<FieldNode> staticFinalFieldNodeList = new ArrayList<>();
    public EncryptStringAdapter(final ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }

    @Override
    public void visit(final int version, final int access, final String name, final String signature,
            final String superName, final String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        owner = name;
    }

    @Override
    public FieldVisitor visitField(final int access, final String name, final String descriptor,
            final String signature, final Object value) {
        System.out.println("====encrypt========="+access);
        if (value != null && value instanceof String
                && descriptor.equals("Ljava/lang/String;")
                && 0 != (Opcodes.ACC_STATIC & access)
                && 0 != (Opcodes.ACC_FINAL & access)
        ){
            System.out.println("====encrypt==========="+descriptor);
            staticFinalFieldNodeList.add(new FieldNode(access,name,descriptor,signature,value));
            return super.visitField(access, name, descriptor, signature, null);
        }

        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
            final String signature,
            final String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        System.out.println("====encrypt=========================="+owner);
        mv = new EncryptStringMethodVisitor(mv,name,owner,staticFinalFieldNodeList);
        return mv;
    }


    class EncryptStringMethodVisitor extends MethodVisitor {

        private String className = "com/encrypt/lib/Base64Util";

        private String encryptMethodName = "decode";

        private String owner;

        private String methodName;

        private List<FieldNode> staticFinalFieldNodeList;

        public EncryptStringMethodVisitor(final MethodVisitor methodVisitor,String methodName,String owner,List<FieldNode> staticFinalFieldNodeList) {
            super(ASM7, methodVisitor);
            this.methodName = methodName;
            this.owner = owner;
            this.staticFinalFieldNodeList = staticFinalFieldNodeList;
        }

        @Override
        public void visitLdcInsn(final Object value) {
            if (value instanceof String) {
//                String encode = Base64.encodeBase64String(((String) value).getBytes());
                mv.visitLdcInsn("newCode");
                mv.visitMethodInsn(INVOKESTATIC, className, encryptMethodName,
                        "(Ljava/lang/String;)Ljava/lang/String;", false);
                return;
            }

            super.visitLdcInsn(value);

        }

        @Override
        public void visitInsn(final int opcode) {
            super.visitInsn(opcode);
            if (opcode == Opcodes.RETURN && methodName.equals("<clinit>")){

                for (FieldNode fieldNode:staticFinalFieldNodeList) {
                    mv.visitLdcInsn("newCode");
                    System.out.println("===encrypt=====visitInsn1==="+className + "   "+ encryptMethodName);
                    System.out.println("===encrypt=====visitInsn2==="+owner + "   "+ fieldNode.name);
                    mv.visitMethodInsn(INVOKESTATIC,className,encryptMethodName,"(Ljava/lang/String;)Ljava/lang/String;",false);
                    mv.visitFieldInsn(Opcodes.PUTSTATIC, owner, fieldNode.name, "Ljava/lang/String;");
                }
            }
            super.visitInsn(opcode);

        }
    }
}
