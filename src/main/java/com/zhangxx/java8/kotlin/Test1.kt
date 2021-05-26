package com.zhangxx.java8.kotlin

fun main() {


    println(Test1().run { sayHell("kotlin") })

}


class Test1 {

    fun sayHell(name: String): String {
        return "Hello World ${name}"
    }


}