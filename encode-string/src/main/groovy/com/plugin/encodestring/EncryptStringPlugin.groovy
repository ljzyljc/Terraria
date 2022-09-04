package com.plugin.encodestring

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class EncryptStringPlugin implements Plugin<Project>{

    @Override
    void apply(final Project project) {
        EncryptStringExtension extension = project.getExtensions().create("encryptPackage",EncryptStringExtension.class)
        Config.instance.mEncryptStringExtension = extension
        AppExtension appExtension = project.getProperties().get("android")
        appExtension.registerTransform(new EncryptStringTransForm(project),Collections.EMPTY_LIST)
        System.out.println("===1===========")
        System.out.println("===1=="+Config.instance.mEncryptStringExtension.encryptPackages.toString())
//        System.out.println("====="+Config.instance.mEncryptStringExtension.toString())
        project.task("te3st"){
            System.out.println("=====~=========")
        }
    }
}