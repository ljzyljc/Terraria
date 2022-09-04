package com.plugin.encodestring;


import com.quinn.hunter.transform.asm.BaseWeaver;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class EncryptStringWeaver extends BaseWeaver {

    @Override
    public boolean isWeavableClass(final String fullQualifiedClassName) {
        if (Config.getInstance().mEncryptStringExtension == null) {
            return false;
        }
        String packageName = fullQualifiedClassName.replace(".class", "");
        if (packageName.contains(Config.getInstance().mEncryptStringExtension.encryptPackages.replace("/","."))){
            System.out.println("===encrypt====="+Config.getInstance().mEncryptStringExtension.encryptPackages + "      "+ fullQualifiedClassName);
            return true;
        }
        return false;

    }

    @Override
    protected ClassVisitor wrapClassWriter(final ClassWriter classWriter) {
        return new AddClinitClassVisitor(classWriter);
    }
}
