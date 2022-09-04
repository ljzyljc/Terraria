package com.plugin.method_excute_time;

import static org.objectweb.asm.Opcodes.ASM9;

import com.quinn.hunter.transform.asm.BaseWeaver;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/9/4
 */
public class MethodWeaver extends BaseWeaver {


    private String fullQualifiedClassName;
    @Override
    public boolean isWeavableClass(final String fullQualifiedClassName) {
        this.fullQualifiedClassName = fullQualifiedClassName.replace(".class", "");
//        if (fullQualifiedClassName.replace(".class", "").contains("com.jackie.terraria")){
//            System.out.println("=========="+fullQualifiedClassName);
//            return true;
//        }
        return super.isWeavableClass(fullQualifiedClassName);
    }

    @Override
    protected ClassVisitor wrapClassWriter(final ClassWriter classWriter) {
        return new MethodTimerVisitor(ASM9,classWriter,fullQualifiedClassName);
    }
}
