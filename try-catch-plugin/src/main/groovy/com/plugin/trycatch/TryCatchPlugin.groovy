package com.plugin.trycatch

import org.gradle.api.Plugin
import org.gradle.api.Project

class TryCatchPlugin implements Plugin<Project>{

    @Override
    void apply(final Project project) {
        project.task("trycatch"){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+project.parent.name)
        }

    }
}