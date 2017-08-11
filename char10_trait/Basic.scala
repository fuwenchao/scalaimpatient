package com.book.scalaImpatient.char10_trait

/**
  * Created by wenchao on 2017/8/7.
  */
//scala提供特质而非接口，可以同时拥有抽象方法和具体方法，类可以实现多个特质
trait Logger{
  def log(msg:String)
}
trait ConLogger{
  def log(msg:String){println(msg)}
}
class ConsoleLogger extends Logger{          //多个特质用with 如 extends Logger with A with B
  def log(msg:String): Unit ={         //不需要写override
    println(msg)
  }
}



trait LoggerTest{
  def log(msg:String){}

}
trait ConsoleLoggerTest extends LoggerTest{
  override def log(msg: String): Unit = {println(msg)}
}

class SavingAccount extends LoggerTest{
  val account=10
  if (account<0) log("account is error") else log("account is correct")
}
object SavingAccount extends App{
  //混入
  //val sa=new SavingAccount with ConsoleLoggerTest  //account is correct
  val sa=new SavingAccount                          //什么也不做
}