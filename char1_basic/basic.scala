package com.book.scalaImpatient.char1_basic

/**
  * Created by wenchao on 2017/8/5.
  */
object basic extends  App{
  //不带参数的方法通常不使用（）
  val x=1.toString
  val y=1.toString()
  println(x==y)                    //true
  val z=1
  println(x==z)                     //false
  println(x.isInstanceOf[String])  //true
  println(x.isInstanceOf[Int])      //false
  println(1.to(10))                 //Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(1 to 10)                  //同上

 /* . 点之后不给出提示，但是返回lo ,并集
 不给提示是因为Hello为java.lang.String类型，被隐式转换为StringOps类型，
 然后调用StringOps类型的intersect方法
 RichInt      -->Int
 RichDouble   -->Double
 RichChar     -->Char
 Rich提供了基本类型所不具备的一些方法，比如上面的to方法
 */
  println("Hello".intersect("world"))



/*  算法和操作符重载,这些操作符实际上是方法，比如
  a+b = a.+(b)
  任何符号都可以用来定义方法，比如 /% 求对偶，结果是商和余数
  但是没有++ --操作符，一般使用 +=1 -=1
  ---------
  函数调用
  如：
  min(1,2)
  sqrt(2)
  import scala.math._ 引入，scala前缀可以不写
  --------------
  scala没有静态方法，半生对象替代，里面的方法就是静态方法一样*/

}
