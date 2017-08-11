package com.book.scalaImpatient.char2_control_function

/**
  * Created by wenchao on 2017/8/5.
  */
class Function {
    //define 只要函数不是递归的，可以不给出函数的返回值
  def abs(x:Int) = if (x>0) x else -x
  //函数多个代码块最后一个为函数的返回值
  def fac(n:Int)={
    var r=1
    for (1 <- 1 to n) r = r+1
    r
  }
  //递归
  def fac2(n:Int):Int ={
    if (n <=0 ) 1 else n * fac2(n-1)
  }
  //默认参数
  def deco(str:String,left:String="[",right:String="]")=
    left+str+right
  //变长参数  val s=sum(1,3,4,54,3,2,12)
  //传入seq，如果你已经有了一个值的序列，则不能直接将他传入
  //var s=sum(1 to 10)  错误
  // var s=sum(1 to 10:_*) 将1 to 10 当作参数序列处理
  def sum(args:Int*)={
    var result=0
    for(arg <- args) result+=arg
    result
  }
  def recursiveSum(args:Int*):Int={
    if(args.length==0) 0
    else args.head+recursiveSum(args.tail:_*)
  }
}



class Procedure{
  //函数体包含在花括号之内但是没有= 号  ，那么返回类型就是Unit，过程不返回值，调用它仅仅为了 他的副作用，比如打印
  //= def x(x:Int):Unit={}
  def box(s:String){
    var border="-"*s.length+"--\n"
    println(border+"|"+s+"|\n"+border)

  }
}