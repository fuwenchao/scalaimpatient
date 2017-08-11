package com.book.scalaImpatient.char2_control_function

/**
  * Created by wenchao on 2017/8/5.
  */
object  If extends App{
  val x=10
  val s= if (x>0) 1 else -1
  println(s)
  val s1= if (x>0) 1    // val s1= if (x>0) 1 else ()
  val s2= if (x>0) 1 else ()
  println(s1)
  println(s2)
  //if else 换了行的话，需要使用花括号
  //{} 块表达式，最后一个表达式的只就是块返回的值
}
