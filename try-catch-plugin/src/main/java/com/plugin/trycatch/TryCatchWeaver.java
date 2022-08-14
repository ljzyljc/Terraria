package com.plugin.trycatch;


import com.quinn.hunter.transform.asm.BaseWeaver;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class TryCatchWeaver extends BaseWeaver {

    @Override
    public boolean isWeavableClass(final String fullQualifiedClassName) {
        if (Config.getInstance().mTryCatchExtension == null
                || Config.getInstance().mTryCatchExtension.hookPoint == null){
            return false;
        }
//        System.out.println("================="+ fullQualifiedClassName);
//        System.out.println("================="+ Config.getInstance().mTryCatchExtension.hookPoint.toString());
        boolean flag = Config.getInstance().mTryCatchExtension.hookPoint.containsKey(
                fullQualifiedClassName.replace(".class", ""));
        System.out.println("=================="+flag+ "    " + fullQualifiedClassName);
        return flag;
    }

    @Override
    protected ClassVisitor wrapClassWriter(final ClassWriter classWriter) {
        return new TryCatchClassAdapter(classWriter);
    }
}
