# ASM 常用插件开发(Commonly used ASM plugin)


## ASM Plugin (A powerful bytecode plugin)

### 1. method-execute-time(统计方法执行时间,可以指定阈值) (English: calculate method execute-time(you can specify a threshold))

使用：build.gradle(app)下导入以下 Extention
``` 
    method_execute_time{
        time = "10"
    }
```

``` maven { url 'https://jitpack.io' }  ```

``` classpath 'com.github.ljzyljc.Terraria:method-excute-time:1.0.2' ```



### 2. encode-string (给字符串加密) (English: encode some specific class' String)

使用：build.gradle(app)下导入以下 Extention
``` 
encryptPackage {
    encryptPackages = "com/jackie/terraria/Foo2"
}
```

``` maven { url 'https://jitpack.io' }  ```

``` classpath 'com.github.ljzyljc.Terraria:encode-string:1.0.2' ```


### 3. try-catch-plugin (给方法添加 try-catch) (English: add try catch to some specific method)

使用：build.gradle(app)下导入以下 Extention
``` 
tryCatch {
    hookPoint = [
            "com.jackie.terraria.Foo": [
                    "i"
            ]
    ]
    exceptionHandler = ["com.jackie.terraria.ExceptionUtils": "handleException"]
    returnHandler = ["com.jackie.terraria.ExceptionUtils":"handleReturn"]
}
```

``` maven { url 'https://jitpack.io' }  ```

``` classpath 'com.github.ljzyljc.Terraria:try-catch-plugin:1.0.2' ```




## Quick Start



## License

Apache 2.0

//自定义plugin 找不到的问题：

1.src/main/groovy或java下面的 XXXPlugin类一定要记得导包，
同时也要看是否导入正确的java或groovy包下面（如果反了可能会导致一直找不到)
2.resources 下面的文件名要准确

//Extension 中的值要设置成 public

1.HunterTransform 的问题，如果没有设置this.bytecodeWeaver的话，   this.bytecodeWeaver.setClassLoader(urlClassLoader);就有异常
Caused by: java.lang.NullPointerException
at com.quinn.hunter.transform.HunterTransform.transform(HunterTransform.java:98)