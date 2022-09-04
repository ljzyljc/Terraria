package com.plugin.rehearsecoreapi;

import java.io.IOException;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2022/8/23
 */
public class ASMPrint { //既可以打印 Core Api 的内容，也可以打印 类的内容
    public static void main(String[] args) throws IOException {
        // (1) 设置参数
        String className = "com.plugin.rehearsecoreapi.MyClass";
        int parsingOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;
        boolean asmCode = true;

        // (2) 打印结果
//        Printer printer = asmCode ? new ASMifier() : new Textifier();
//        PrintWriter printWriter = new PrintWriter(System.out, true);
//        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(null, printer, printWriter);
//        new ClassReader(className).accept(traceClassVisitor, parsingOptions);

        //在Java ASM 9.1或9.2及之后版本当中，使用-nodebug选项
        String[] array = new String[] {
                "-nodebug",
                "com.plugin.rehearsecoreapi.MyClass"
        };
        ASMifier.main(array);


    }
}
