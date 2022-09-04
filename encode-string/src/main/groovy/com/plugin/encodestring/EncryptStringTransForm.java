package com.plugin.encodestring;


import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

public class EncryptStringTransForm extends HunterTransform {

    public EncryptStringTransForm(final Project project) {
        super(project);
        this.bytecodeWeaver = new EncryptStringWeaver();
        System.out.println("===1==========="+Config.getInstance().mEncryptStringExtension.encryptPackages);
    }

}
