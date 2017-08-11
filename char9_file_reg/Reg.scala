package com.book.scalaImpatient.char9_file_reg

/**
  * Created by wenchao on 2017/8/7.
  */

//String r方法构造regex对象

object Reg extends App{
  val numPattern="[0-9]+".r
  for (i <- numPattern.findAllIn("99 fu,98zhou")) println(i)  //.toArray
  //首个匹配
  val m1=numPattern.findFirstIn("99 sss,98 xxxxx,333")  // some(99).getOrElse(0)
  println(m1)
  //替换
  println(numPattern.replaceFirstIn("99 fu,98zhou","xxx"))   //xxx fu,98zhou
  println(numPattern.replaceAllIn("99 fu,98zhou","xxx"))     //xxx fu,xxxzhou

  //分组
  val numitemPattern="([0-9]+) ([a-z]+)".r
  for(numitemPattern(num,item) <- numitemPattern.findAllIn("28 fuwenchao ,30 zhou")) {
    print(num)
    println(item)
  }


}