package com.plugin.palladium

import org.gradle.api.Plugin
import org.gradle.api.Project

class Palladium implements Plugin<Project>{

    @Override
    void apply(final Project project) {
        project.task("palladium"){
            println("hello: palladium~~~~~~~--------~~~~~~~~~")
        }
    }
}