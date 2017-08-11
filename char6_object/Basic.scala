package com.book.scalaImpatient.char6_object

/**
  * Created by wenchao on 2017/8/6.
  */
//单例
//scala中没有静态方法或者静态对象，object来达到目的
//对象本质上可以拥有类的所有特性，可以扩展其他类或者特质，但是没有构造器参数
//伴生对象 java类中可以同时拥有实例方法和静态方法，scala中通过伴生对象达到同样的目的
//类和它的伴生对象可以相互访问私有特性，他们必须存在于同一个源文件中

//对象继承 一个类或者多个特质
class Basic {

}


//apply方法 ：Object(a,b,c,d)时，实际调用的是对象的apply方法，返回的是伴生类的对象
//如Array对象定义了apply方法，我们可以这样创建数组 Array("fuwenchao","is","handsome")
//上面的例子也可以用构造器呀，因为省去了new


//*************************App特质
//style ont
object Hello{
  def main(args:Array[String]): Unit ={
    println("hello world")
  }
}


object hello2 extends  App{
  if (args.length>0) println("hello"+args(0)) else
  println("hello world")
}