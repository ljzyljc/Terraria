package com.plugin.method_excute_time;

import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/9/4
 */
public class MethodExecuteTransform extends HunterTransform {

    public MethodExecuteTransform(final Project project) {
        super(project);
        this.bytecodeWeaver = new MethodWeaver();
    }
}
