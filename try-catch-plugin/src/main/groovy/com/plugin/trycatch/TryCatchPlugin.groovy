package com.plugin.trycatch

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class TryCatchPlugin implements Plugin<Project>{

    @Override
    void apply(final Project project) {
        TryCatchExtension extension = project.getExtensions().create("tryCatch",TryCatchExtension.class)
        Config.instance.mTryCatchExtension = extension
        AppExtension appExtension = project.getProperties().get("android")
        appExtension.registerTransform(new TryCatchTransform(project),Collections.EMPTY_LIST)
        System.out.println(appExtension.toString())
    }
}