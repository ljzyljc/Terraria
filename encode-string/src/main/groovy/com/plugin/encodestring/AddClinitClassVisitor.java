package com.plugin.encodestring;

import static groovyjarjarasm.asm.Opcodes.ACC_STATIC;
import static groovyjarjarasm.asm.Opcodes.ASM7;
import static groovyjarjarasm.asm.Opcodes.RETURN;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/20
 */
public class AddClinitClassVisitor extends ClassVisitor {

    public AddClinitClassVisitor(final ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }
    private Boolean hasClinit = false;

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
            final String signature,
            final String[] exceptions) {
        if (name.equals("<clinit>")){
            hasClinit = true;
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        System.out.println("==========="+hasClinit);
        if (!hasClinit){
            MethodVisitor mv = super.visitMethod(ACC_STATIC,"<clinit>","V()",null,null);
            mv.visitCode();
            mv.visitInsn(RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

    }
}
