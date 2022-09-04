package com.plugin.rehearsecoreapi.hello;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/9/1
 */
public class TestAdviceAdapter extends AdviceAdapter {


    protected TestAdviceAdapter(final int api, final MethodVisitor methodVisitor, final int access, final String name,
            final String descriptor) {
        super(api, methodVisitor, access, name, descriptor);
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
    }

    @Override
    protected void onMethodExit(final int opcode) {
        super.onMethodExit(opcode);
//        int a = newLocal()
    }
}
