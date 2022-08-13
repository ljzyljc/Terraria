package com.jackie.terraria.kotlin

/**
 * Description:
 * @author feifei5292190@gmail.com
 * @date 2022/8/8
 */
class InfixTest {

    infix fun test(d: String){
        println("jackie:${d}")
    }

    fun test2(){
        test("4")
    }
}