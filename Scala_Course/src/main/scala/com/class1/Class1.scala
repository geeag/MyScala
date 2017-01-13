package com.class1

import scala.runtime.{RichDouble, RichInt}
import scala.math._

/**
  * scala变量定义
  * scala也拥有7中基本数据类型:Byte、Char、String、int、Short、Long、Flot、Double
  */
object Class1 {
  //定义一个可变量,变量类型从第一次赋值的内容推断出来
  var variable1 = "";
  var variable2 = 1000;
  //定义一个不可变量,类似于java的final,语句之间可以不通过;来分割,当然为了程序可读性,也可以添加;
  val variable3 = "final"
  //通过指定数据类型来声明一个变量
  var variable4 : String = "I am String";
  var variable5 : String = "I am String";

  //RichInt、RichDouble、RichChar等变量提供了int、double、char等数据类型所不具备的简便方法
  var reachInt : RichInt = 1;
  var reachDouble : RichDouble = 1.0;

  //我们也可以使用这样的方法,这是将1转换成RichInt后再调用to方法,scala方法很灵活,下面的方法其效果是一样的
  var arr = 1.to(10);
  var arr2 = 1 to 10;

  //函数表达式,只要引入包直接使用不需要再从某个包去调用它们
  var mySqrt = sqrt(4); //开根号
  var myPow = pow(4,2); //开方
  var myMin = min(3,Pi);  //最小值



  //main方法
  def main(args:Array[String]):Unit ={
    println(123)
    println(1.to(10));
    println(sqrt(2))
    println(myMin)
    println(myPow)
  }
}
