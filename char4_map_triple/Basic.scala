package com.book.scalaImpatient.char4_map_triple

/**
  * Created by wenchao on 2017/8/6.
  */
object  Basic extends App{
  //不可变
  var map1=Map("name"->"fuwenchao","age"->"18","birthday"->"19900717")  //Map[String,String]
  //可变
  var map2= scala.collection.mutable.Map("name"->"fuwenchao","age"->"18","birthday"->"19900717")
  //另一种方式
  var map3= scala.collection.mutable.Map(("name","fuwenchao"))

  //get value
  var name=map1("name")

  //是否 存在
  var xx=if( map1.contains("bob") ) map1("bob") else 0
  //快捷写法
  var yy=map1.getOrElse("bob",0)

  //update
  map2("name")="shuaige"

  //add
  map2 += ("fav"->"baseketball")
  //del
  map2 -= "age"

  println(map2)           //Map(birthday -> 19900717, fav -> baseketball, name -> shuaige)


  //*********迭代
  // for((k,v) <- 映射) 处理 k v
  for (v <- map2.values) println(v)
  //翻转
  //for ((k,v) <- 映射） yield (v,k)
//************************************************
  //元祖 忽略

  //*************拉链操作 zip
  var symbols=Array("<<","-",">")
  var counts=Array(2,20,2)
  var pairs=symbols.zip(counts)
  println(pairs.toString)   //[Lscala.Tuple2;@3379bd14
  println(pairs.mkString(" ** "))  //(<,2) ** (-,20) ** (>,2)

  for((s,n) <- pairs) print(s*n)    //<<-------------------->>


}
