package com.book.scalaImpatient.char11_Operator

/**
  * Created by wenchao on 2017/8/7.
  */
//apply & update 方法
//scala 允许你用如下函数的调用语法f(arg1,arg2,...)扩展到可以应用函数之外的值，如果f不是函数或者方法
//等等同于调用f.apply(arg1,arg2,...)
//但是如果出现在左侧，表达式f(arg1,arg2,...)=value
//对应如下调用f.update(arg1,arg2,...,value)，应用于数组或者映射
//例如：val scores=HashMap(String,Int)
//scores("Bob")=100  =调用scores.update("Bob",100)
//val bobscore=scores("Bob")  =调用scores.apply("Bob")


/*apply方法同样被经常用于伴生对象中，用来构造对象而不用显示使用new
class Fraction(n:Int,d:Int) {...}
object Fraction{
  def apply(n:Int,d:Int)=new Fraction(n,d)

}
这样，我们就可以使用Fraction(2,3)来构造一个分数而不是用 new Fraction(2,3)*/

//************提取器unapply 伴生对象apply的反向操作
//apply 接受构造参数然后将他们变成对象
//unapply 接受一个对象，然后从中提取值--通常这些值就是当初用来构造该对象的值


object Name{
  def unapply(input:String) :Option[(String,String)] ={
    val pos=input.indexOf(" ")
    if (pos == -1) None else Some((input.substring(0,pos),input.substring(pos+1)))
  }
}
object ApplyTest extends  App{
  val author:String="fu wenchao"
  val Name(first,last) = author
  println(first)           //fu
  println(last)            //wenchao
}



object Student {
  def unapply(str: String): Option[(String, String, String)] = {
    val parts = str.split(",")
    if (parts.length == 3) Some(parts(0), parts(1), parts(2)) else None
  }
}
object StudentTest extends  App{
  val students="fuwenchao,zhouwei,fuqinqin"
  val Student(a,b,c)=students
  }




//************ 样例类 自动具备 apply unapply
case class Currency(value:Double,unit:String)
//Currency(12.2,"EUR")   //将调用Currency.apply
//case Currency(amount,"USD") => println("$"+amount)   将调用Currency.unapply






//unapplySeq方法 提取任意长度的值的序列 返回Option[seq[A]] A是要被提取的值的类型
object Name2{
  def unapplySeq(input:String):Option[Seq[String]]={
    if(input.trim=="") None else Some(input.trim.split("\\s+"))
  }
}
/*这样就可以提取任意数量的变量了
author match {
  case Name2(first,last) =>   ...
  case Name2(first,middle,last) =>   ...
  case Name2(a,b,c,d) =>   ...
}
如：
object Names {
  def unapplySeq(str: String): Option[Seq[String]] = {
    if (str.contains(",")) Some(str.split(","))
    else None
  }
}
val namesString = "xiao ming,xiao hong,tom"
namesString match {
  case Names(first, second, third) => {
    println("the string contains three people's names")
    println(s"$first $second $third")
  }
  case _ => println("nothing matched")
}




  */
