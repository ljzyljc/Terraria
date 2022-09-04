package com.plugin.method_excute_time

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project;


class MethodExecuteCollectPlugin implements Plugin<Project>{

    @Override
    void apply(final Project project) {
        System.out.println("========MethodExecuteCollectPlugin=======")
        MethodExecuteExtension extension = project.getExtensions().create("method_execute_time",MethodExecuteExtension.class)
        Config.instance.mMethodExecuteExtension = extension

        AppExtension appExtension = project.getProperties().get("android")
        appExtension.registerTransform(new MethodExecuteTransform(project))
    }
}