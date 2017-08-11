package com.book.scalaImpatient.char8_inherit

/**
  * Created by wenchao on 2017/8/7.
  */
//重写方法必须用 override，重写抽象方法是，不用
//extends
//final声明的类不能被扩展，final修饰的方法或字段不能被重写

class Person{
  override def toString ="in Person "
}

class Basic extends Person {
  override def toString=super.toString+"in Baisc"   //super 调用父类方法
}

object Basic extends App{
  val b=new Basic()
  print(b.toString)
}


//构造器
//重写限制
//def只能重写另一个def
//val只能重写另一个val或者是不带参数的def
//var只能重写另一个抽象的var





//***************构造顺序和提前定义
class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature{
  override  val range: Int = 2
}
object Ant extends  App {
  val c = new Ant
  println(c.range) //结果为2
  println(c.env.length) //结果为0
}
//为什么 c.env.length为0，,见一下解释
//1:Ant构造器在做它自己的构造之前，调用Creature的构造器
//2:Creature的构造器将他的range字段设为10
//3:Creature为了初始化env数组，调用range()取值器
//4:该方法被重写以输出（还未初始化的）Ant类的range字段值
//5:range方法返回0。（这是对象被分配空间时所有整型字段的初始值）
//6:env被设为长度为0的数组
//7:Ant构造器继续执行，将其range字段设为2

//虽然range字段 看上去可能是2 或者10，但是env长度是0， 这里的教训是你在构造器内不应该依赖val值





//安全但是不高效的解决方式
class Creature2 {
  lazy val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant2 extends Creature2{
  override lazy val range: Int = 2
}
object Ant2 extends  App {
  val c = new Ant2
  println(c.range) //结果为2
  println(c.env.length) //结果为2
}



//在子类中使用提前定义语法
class Creature3 {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant3 extends {            //使用提前定义  with Creature
  override val range: Int = 2
}with Creature3
object Ant3 extends App {
  val c = new Ant3
  println(c.range)       //2
  println(c.env.length) //结果返回2
}