package com.book.scalaImpatient.char13_Collection

/**
  * Created by wenchao on 2017/8/7.
  */
//scala集合继承层级 Iterable-->(Seq,Set,Map)--->(IndexedSeq,SortedSet,SortedMap)
//每个scala集合特质或者类都有一个apply方法的伴生对象，
//Set(1,3,2)  Array(12,23,4,4)
//可变集合与不可变集合  scala有限采用不可变集合
//*** numbers是一个不可变集，numbers+=9 就是一个包含numbers和9的新集合，如果9已经在集合中，则你得到一个指向老集的引用

/*//不可变序列
Seq  -->IndexedSeq -->(Vector,Range)
     -->(List,Stream,Stack,Queue)
//可变序列
     -->IndexedSeq --> ArrayBuffer
     -->(Stack,Queue,Priotity Queue ,LinkedList,Double  LinkedList)
*/




object ListTest  extends App{
  //List 空表Nil 元素head 列表tail
  val digits=List(1,3,4)
  println(digits)    //List(1, 3, 4)
  println(digits.head)  //1
  println(digits.tail)  //List(3, 4)
  //digits.head 元素1

  println(9::digits.tail)  //List(9, 3, 4)


  val names=List("peter","wenchao","fu")
  names.map(_.toUpperCase).foreach(println)

  val upname= for(n <- names) yield  n.toUpperCase()
  upname.foreach(println)

}



//可变列表
object LinkedList extends App{
  //将所有负值改为0
  val lst =scala.collection.mutable.LinkedList(1,-2,7,-9)
  var cur =lst
  while (cur != Nil){
    if (cur.elem<0) cur.elem=0
    cur=cur.next
  }
}


object SetTest extends  App {
  //Set 不重复元素的集合
  Set(0, 2, 3, 1) + 1 //尝试将已有元素加入没有效果
  //Set中元素顺序根据hashCode值进行组织，你可以快得多的方式找到元素，比列表或者数组中要快得多
  //digtals contains 0
  //Set(1,2) subsetOf digitals
  //并集 union | ++
  //交集 intersect  &
  //差集 diff &~ --
}

//各种集合操作符，详见P173
//常用方法，详见P175



//化简，折叠，扫描
//List(1,7,2,9).reduceLeft(_ - _)  =1-7-2-9
//List(1,7,2,9).reduceRight(_ + _)  =1-(7-(2-9))=1-7+2-9
//List(1,7,2,9).foldLeft(0)(_ - _) =0-1-7-2-9   = (0 /: List(1,7,2,9))(_ - _)         foldRight
//sum



//计算词频率
object FreqCalc extends  App{
  val freq =scala.collection.mutable.Map[Char,Int]()
  for(c <- "fufuwenwenchh") freq(c)=freq.getOrElse(c,0)+1
  println(freq)                 //Map(n -> 2, e -> 2, w -> 2, h -> 2, c -> 1, u -> 2, f -> 2)

  //使用折叠的思考方式  这是一个不可变映射，每一步都计算出一个新映射
  var newMap=(Map[Char,Int]() /: "thisisisi"){
    (m,c)=> m+(c -> (m.getOrElse(c,0)+1))
  }
  println(newMap)

}


//like斐波那契数列
object LikeFibonacci extends  App{
  (1 to 10).scanLeft(1)(_ + _).foreach(println)
}




object Test {
  def main(args: Array[String]) {
    val colors1 = Map("red" -> "#FF0000XXXX",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF",
      "yellow" -> "#FFFF00",
      "red" -> "#FF00CXXC")

    //  ++ 作为运算符
    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )

    //  ++ 作为方法
    colors = colors1.++(colors2)
    println( "colors1.++(colors2)) : " + colors )

    var colorsu=colors1 + ("red" -> "xxxxxxxxxxxxxxxx")

    println( "colors2 : " + colorsu )
  }
}


//流
//懒视图
//线程安全的集合
class SaveCollection {
  //线程安全的集合
  val scores = new scala.collection.mutable.HashMap[String,Int] with
                      scala.collection.mutable.SynchronizedMap[String,Int]
  //并行集合
/*  scala提供的用于操纵大型集合任务的解决方案非常诱人，这些任务通常可以很自然的并行操作
  举例来说，要计算所有元素之和，多个线程合一并发计算不同区域的和，到最后，这些结果被汇总
  到一起。要对这些并发任务排程是很困难的，但是在scala中不需要担心这个。
  如果是一个大型集合coll.par.sum  或者coll.par.count(_ % 2 ==0)
  或者并行化遍历 for(i <- (0 until 1000).par) print(i+ " ")
  par方法返回的并行集合类型或者自ParSet,ParSeq,ParMap特质的类型，所有这些特质都是ParIterable的子类型。
  但是并不是Iterable的子类型，因此你不能将并行集合传递给预期Iterable,Seq,Set,Map的方法*/
}