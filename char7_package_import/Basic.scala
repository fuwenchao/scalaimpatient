package com.book.scalaImpatient.char7_package_import


/**
  * Created by wenchao on 2017/8/7.
  */
//管理大型程序中的名称
//包可以像内部类那样嵌套
//可以在同一个文件中为多个包贡献
//作用域：可以访问上层作用域中的名称
//包可以包含类，对象，特质，但是不能包含函数和变量的定义，但是可以放在包对象中，每个包都可以有一个包对象
//可见性
package com.horstmann.impatient.people
class Person{
  val name="fuwenchao"
  private[people] def desc="a person with name "+name

  //你可以将可见度延伸到上层包
  //private[impatient] def desc="a person with name "+name
}
//引入：任何地方都可以声明引入，并不仅限于文件顶部
//import引入的效果一直延伸到包含该语句的块末尾
//通过将引入放置在需要引入的地方，你可以大幅减少可能的名称冲突
//集中映入方式
import java.awt.{Color,Font}              //引入几个成员
import java.util.{HashMap => JavaHashMap} //重命名

import java.util.{HashMap => _,_}            //隐藏java的HashMap
import scala.collection.mutable._           //现在HashMap就无二义的指向scala的HashMap，因为java的HashMap被隐藏起来了




//隐式引入：每个scala代码都隐式引入如下代码
//import java.lang._
//import scala._
//import predef._
//不像所有其他的引入，这个引入被允许可以覆盖之前的引入，比如：
//scala.StringBuilder会覆盖java.lang.StringBuilder 而不是与之冲突

//由于scala包被引入了，那些以scala开头的包的前缀可以忽略，比如
import collection.mutable.HashMap





class Basic {

}
