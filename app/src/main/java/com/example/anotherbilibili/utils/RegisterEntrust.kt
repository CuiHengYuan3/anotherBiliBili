package com.example.anotherbilibili.utils


/**
 * 利用委托来实现注册的两种形式
 *
 *
 * */

//注册需要实现接口
interface RegisterEntrust {

    //物理z
    fun register(para1: String,para2: String)

}