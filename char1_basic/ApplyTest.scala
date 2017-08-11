package com.book.scalaImpatient.char1_basic

/**
  * Created by wenchao on 2017/8/5.
  */
object ApplyTest  extends  App{
  println("hello"(2))        // l
  println("hello"(20))       //报错
/*  上面的实现原理实际是调用了一个名为Apply的方法
  StringOps 定义 def Apply(n:Int):Char
  "hell0"(2)实际是 "hello".Apply(4)*/
}



