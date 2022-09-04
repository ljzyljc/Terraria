# Terraria


## ASM Plugin (A powerful bytecode plugin)



## Quick Start



## License

Apache 2.0

//plugin 找不到的问题：

1.src/main/groovy或java下面的 XXXPlugin类一定要记得导包，
同时也要看是否导入正确的java或groovy包下面（如果反了可能会导致一直找不到)
2.resources 下面的文件名要准确

//Extension 中的值要设置成 public

1.HunterTransform 的问题，如果没有设置this.bytecodeWeaver的话，   this.bytecodeWeaver.setClassLoader(urlClassLoader);就有异常
Caused by: java.lang.NullPointerException
at com.quinn.hunter.transform.HunterTransform.transform(HunterTransform.java:98)