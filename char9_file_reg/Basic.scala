package com.book.scalaImpatient.char9_file_reg

/**
  * Created by wenchao on 2017/8/7.
  */
//文件操作：
//Source.fromFile(...).getLines.toArray 输出文件的所有行
//Source.fromFile(...).mkString         以字符串形式输出文件内容
//java的PrintWrite来写入文本



import scala.io.Source




object  Basic extends  App{
  val source=Source.fromFile("myfile.txt","utf-8")
  //第一个参数是字符串或者是java.io.File
  //字符编码
  val lineIterator=source.getLines //mkSting将整个文件读成一个字符串 toArray或者toBuffer将这些行放入数组或者缓冲中
  for(i <- lineIterator) process(i)
  def process(i:String): Unit ={
    println(i)
  }
  //直接读取字符 for(c <- source) 处理c
  //tokens = source.mkString.split("\\s+") 以空格隔开的词法单元
  //val numbers=tokens.map(_.toDouble)

  //其他读取方式
  //var source=Source.fromURL("http://www.horstamnn.com","UTF-8")  //URL
  //var source=Source.fromString("hello world")                    //字符串
  //var source=Source.stdin                                       //标准输入

}




//case  访问目录
import java.io.File
class AccessDir{

  def subdirs(dir:File):Iterator[File]={
    var child=dir.listFiles.filter(_.isDirectory)
    child.toIterator ++ child.toIterator.flatMap(subdirs _)
  }
}
object ListFile extends App{
  val files=new AccessDir()
  for (f <- files.subdirs(new File("D:\\BOOK\\scala"))) println(f)

}



object StreamFile extends  App{
  var words=Source.fromFile("D:\\BOOK\\scala\\word.txt").getLines().toStream
  println(words)
  println(words(5))  //0-5
  println(words)
  println(words(3))

}
