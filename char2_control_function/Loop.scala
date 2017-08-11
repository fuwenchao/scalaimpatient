package com.book.scalaImpatient.char2_control_function

/**
  * Created by wenchao on 2017/8/5.
  */
object Loop extends  App{
/*  while (n>0){
    r=r*n
    n=n-1
  }*/


/*  val s="fuwenchao"
  var sum=0
  for (n <- 1 until  s.length){
    println(s(n))
    sum += s(n)
    println(sum)
  }
  for (i <- s){
    println(i)
  }*/

  //高级for
  for(i <- 1 to 3;j <- 1 to 3) print((10*i+j)+"  ")  //11  12  13  21  22  23  31  32  33
  println
  for(i <- 1 to 3;j <- 1 to 3 if i != j) print((10*i+j)+"  ") //12  13  21  23  31  32
  println
  for(i <- 1 to 3;from=4-i;j <- from to 3)  print((10*i+j)+"  ")  //13  22  23  31  32  33
  println
  //每次迭代生成集合中的一个值
  for(i <- 1 to 3;from=4-i;j <- from to 3)  yield (10*i+j)+"  "
}
