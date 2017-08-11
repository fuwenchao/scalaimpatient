package com.book.scalaImpatient.char3_AboutArray

/**
  * Created by wenchao on 2017/8/6.
  */
//定长用Array，变长用ArrayBuffer
//提供初始值不用new，()来访问元素
//用for(arr<-arrs if) ... yield... 将原数组转换为新数组


object  ArrayBasic extends  App{
  val nums=new Array[Int](10)           //10个整数数组，初始化为0
  val string=new Array[String](10)      //10个字符串数组，初始化为null
  val s=Array("hell0","world")        //长度为2的Array[String],类型是推断出来的
  s(0)="GoodBye"                        //使用（）而不是[]来访问数组

  import scala.collection.mutable.ArrayBuffer
  var b =new ArrayBuffer[Int]()
  b += 1                  //ArrayBuffer(1) +=增加元素
  b ++= Array(10,20,30)  //++=操作符增加任何集合
  b.trimEnd(2)            //移除后五个元素
  //其他方法
  //insert(p,x)    任意位置插入
  //remove          任意位置删除

  //遍历数组
  for(n <- 0 until b.length){
    println(n+"  "+b(n))
  }
  var result = for (i <- 0 until b.length) yield 2*b(i)
  println(result)                                           //Vector(0, 2)
  println(result.toArray)                                   //[I@50ae997b

  var result2=for (i <- 0 until b.length if i%2 ==0) yield 2*b(i)
  print(result2)                                             //Vector(0)


  var result3=b.filter(_%2==0).map(2*_)                //ArrayBuffer(20)
  println(result3)

  var result4=b.filter{_%2==0}.map{2*_}                //ArrayBuffer(20)
  print("result4:")
  println(result4)

  //常用方法 sum max quickSort sorted mkString
  println(b.mkString(" and "))
  println(b.toString)


  //***********************多维数组
  val matrix=Array.ofDim[Double](3,4)  //3行4列
  //不规则数组
  val trigle=new Array[Array[Int]](10)
/*  for(i <- 0 until trigle.length) trigle(i)=new trigle[Int](i+1)*/
}
