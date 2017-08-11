package com.book.scalaImpatient.char5_class

/**
  * Created by wenchao on 2017/8/6.
  */
//scala源文件可以包含多个类，所有这些类都具有共有可见性
//调用无参方法，可以不加上（）
//getter 和 setter 方法：java风格中，一般不用公有字段，因为这样的话任何人都可以修改该字段

//scala对每个字段都提供了这两个方法 ，字段是公有的，这两个方法都是公有的，反之都是私有的
//scala中 get = age set= age_=，但是可以重新定义，如下的Person类
//val修饰的字段就是有get方法
//使用 @BeanProperty 会自动在生成两个get set方法,比如getAge() setAge()
class PersonT {
  private var age=10
  def ageover=age
  def ageover_=(newvalue:Int): Unit ={
    if (newvalue>age) age=newvalue
  }

}
//主构造器和辅助构造器
//主 跟在类名后面；辅助 this
//辅助要先调用之前的辅助或者主开始
class Person(val name:String,val age:Int){  //主 可以不带val 或者 var
  println("name:"+name+"；"+"age:"+age)
}
object Person extends App{
  var p =new Person("fuwenchao",18)       //name:fuwenchao；age:18
}


//************************
//嵌套类
//你可以在类中定义类，方法中定义方法