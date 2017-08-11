package com.book.scalaImpatient.char14_case_class

/**
  * Created by wenchao on 2017/8/8.
  */

//match 是更好的 switch
//守卫
//可以对表达式的类型进行匹配，优先选择匹配模式而不是
//可以匹配数组，元组，样例类
//样例类是编译器会为之自动产出模式匹配所需要的方法的类
//用Option来存放可能存在也可能不存在的值---这比null更安全


//如果case关键字后面跟着一个变量名，那么匹配的表达式会被赋值给那个变量
//如果变量与常量表达式冲突，将常量包在反引号中
class char14_Case_Class {
  //类型模式
  //当你在匹配类型的时候，必须给定变量名，否则回那对象本身对比
  //匹配发生在运行期间，java虚拟机中泛型的类型信息会被檫掉，因此，你不能用类型来匹配特定的Map类型
  //case m:Map[String:Int] => //don't do this but like case m:Map[_,_] =>
  //但是对于数组而言元素的类型信息是完好的，你可以匹配到Array[Int]
  val obj:Any  = 0
  obj match {
    case x:Int => x                //匹配到的值被绑定到
    case x:String => x //绑定到s
    case _ => 0
  }
  var arr =Array[Int](0,1,2)
  //数组，列表，元组匹配
  arr match{
    case Array(0) => "0"
    case Array(x,y) => x +" "+y      //匹配任何带有两个元素的数组，并绑定到x,y
    case Array(0,_*) => "0...."      //匹配任何以0开始的数组
    case _ => "something else "
  }

  //var Array（first,second,_*） =arr 将arr数组的第一个和第二个元素分别赋值给first,second
  var lst=List(1,2,3)
  lst match {
    case 0 :: Nil =>  "0"
    case x :: y :: Nil => x + " "+ y
    case 0 :: tail =>"0..."
    case _ => "something else"

  }
  var pair=(1,0)
  pair match{
    case (0,_)=> "0..."
    case (y,0) =>y + "0"
    case _ => "neither is 0"
  }


  //提取器
  //带有从对象中提取值的unapply unapplySeq方法的对象
  //正则表达式是另一个适合提取器的场景
  var partten="([0-9]+) ([a-z]+)".r
  "99 wenchao" match{
    case partten(num,item) => item
  }


}




//for case

import scala.collection.JavaConversions.propertiesAsScalaMap
object forcase extends App{
  for((k,v) <- System.getProperties())
    println(k+"----+++--->>>> "+v)
}
object forcase2 extends App{
  for((k,"") <- System.getProperties())  //for((k,v) <- System.getProperties() if v =="")
    println(k+"----+++--->>>> ")
}







//样例类
abstract  class amount
case class Doller(value:Double) extends  amount
case class Currency(v:Double,unit:String) extends  amount
//针对单例的样例类
case object xx extends  amount
object CaseClass extends  App {
  var amt = Currency(222.33, "EUR")

  val mm=amt match{
    case Currency(_,u) => "o noes i get u "+u
    //case Doller(v) => "$"+v 不注释会被报错
    case _ => ""
  }
  println(mm)
  //用法


}


object CaseClass2 extends  App{
  def caseTest(classX:Any) : String = {
    classX match{
      case Currency(_,u) => "o noes i get u "+u  //有一个中置写法
      case Doller(v) => "$"+v
      case _ => "xx "
    }

  }
  val d=Doller(10.5)
  val o1:String=caseTest(d)
  println(o1)
  val c=Currency(10,"MY")
  val o2=caseTest(c)
  println(o2)

}