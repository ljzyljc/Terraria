package com.jackie.terraria.kotlin

/**
 * Description:
 * @author feifei5292190@gmail.com
 * @date 2022/8/7
 */
fun test(){
    println("Top class")
}


public class Hello {
    fun foo(){
        println("foo")
    }
}

object MySingleton{

}

class MyExtendTool{

}

fun MyExtendTool.name(){
    println("extend name")
}


interface MyInterface{
    fun testAge(){
        println("90")
    }
    fun ss(){}
}

class Thanos: MyInterface{

}

class Equivalence(){
    fun age(){
        for (i in 0..200){
            println(i)
        }
    }
}