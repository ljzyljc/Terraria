package com.plugin.trycatch;


import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

public class TryCatchTransform extends HunterTransform {

    public TryCatchTransform(final Project project) {
        super(project);
        this.bytecodeWeaver = new TryCatchWeaver();
    }
}
