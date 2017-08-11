package com.book.scalaImpatient.char12_highfunction

/**
  * Created by wenchao on 2017/8/7.
  */
//可以像其他数据类型一样被传递和操作
import math._


object Basic extends App{
  val num=3.14
  val fun = ceil _   //fun设置为ceil函数 ，ceil后面的_ 意味着你确实指的是这个函数，为不是碰巧忘记了给他参数
                     // 从技术上讲，_将ceil方法转成了函数，在scala中，你无法直接操作方法，而只能直接操作函数


/*  你能对函数做什么呢？两件事
  一：调用它
  二：传递它，存放在变量中，或者作为参数传递给另一个函数
  如：*/
  println(fun(num))    //4.0  fun是一个包含函数的变量，而不是一个固定的函数
  //将fun传递给另一个函数
  Array(3.14,2.33,10).map(fun)


  //匿名函数 如(x:Double) => 3*x,存放在变量中
  val fun2= (x:Double) => 3*x  //= def fun2(x:Double)=3*x
  for(i <- Array(3.14,2.33,10).map((x:Double) => 3*x)) println(i)
  println("------传递函数-----")
  for(i <- Array(3.14,2.33,10).map(fun2)) println(i)


  //函数作为参数的函数（高阶函数）   (参数类型)=>结果类型
  def funAsFun(f:(Double)=>Double)=f(0.25)
  funAsFun(ceil _)
  funAsFun(sqrt _)

  //高阶函数也可以产出另一个函数
  def mulBy(factor:Double)=(x:Double)=>factor*x
  val useMul=mulBy(5)
  useMul(20)
  //一些有用的高阶函数
  (1 to 10).map(_*0.1)
  (1 to 9).map("*"*_).foreach(println _)
  (1 to 9).filter(_ % 2==0)   //偶数


  //闭包
  //柯里化指的是原来接受两个参数的函数变成新的接受一个参数的函数的过程
  def Before(x:Int,y:Int)=x*y
  def After(x:Int)=(y:Int)=>x*y
  println(After(2)(4))

  //抽象控制 我们可以将一系列语句组成不带参数也没有返回值的函数

  //return表达式 scala中你不需要return语句来返回函数值，函数的返回值就是函数体的值


}
