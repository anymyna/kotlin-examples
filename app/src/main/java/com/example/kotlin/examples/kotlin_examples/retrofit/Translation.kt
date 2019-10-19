package com.example.kotlin.examples.kotlin_examples.retrofit

/**
 * Created by Carson_Ho on 17/3/20.
 */

class Translation {

    private val status: Int = 0

    private val content: Content? = null

    private class Content {
        val from: String? = null
        val to: String? = null
        val vendor: String? = null
        val out: String? = null
        val errNo: Int = 0
    }


    //定义 输出返回数据 的方法
    fun show() {
        println(status)
        println(content?.from)
        println(content?.to)
        println(content?.vendor)
        println(content?.out)
        println(content?.errNo)
    }


    override fun toString(): String {
        return super.toString() + "  status =  " + status + " ;content.from = " + content!!.from + " ; content.to = " + content.to + " ; content.vendor ; " + content.vendor + " ; content.out " + content.out + ";content.errNo  " + content.errNo
    }
}
