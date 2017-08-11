package com.book.scalaImpatient.char2_control_function
import scala.io._
/**
  * Created by wenchao on 2017/8/6.
  */
/*
class Lazy {
//val被声明为lazy时，他的初始化将被推迟，知道我们首次对他取值，例如
  lazy val words= scala.io.Source.fromFile("/usr/a.txt").mkString()
  //如果程序从不访问words，那么文件也不会被打开

  //可以将懒值当作介于def和val的中间状态
  val words1=scala.io.Source.fromFile("/usr/a.txt").mkString()     //words被定义时即被取值
  lazy val words2 =scala.io.Source.fromFile("/usr/a.txt").mkString() //在words被首次使用时取值
  def words3=scala.io.Source.fromFile("/usr/a.txt").mkString()       //在每一次words被使用时取值
}
*/
