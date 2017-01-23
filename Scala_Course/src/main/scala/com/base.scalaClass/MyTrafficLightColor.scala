package com.base.scalaClass


/**
  * 枚举类
  */
object MyTrafficLightColor extends Enumeration {
  type MyTrafficLightColor = Value  //添加类型别名
  val Red = Value("aaa")  //定义一个枚举值
  val Green = Value   //也可以这么定义
  val Yellow = Value(5) //自定一个枚举值的id,默认情况下是
}


object Enum2 {
  def main(args: Array[String]): Unit = {
    val action = doWhat(MyTrafficLightColor.Green)
    println(action)

    println(MyTrafficLightColor.Red)
    //遍历枚举类中所有值
    for (s <- MyTrafficLightColor.values) println(s.id + ":" + s)
  }

  import MyTrafficLightColor._

  //定义逻辑
  def doWhat(color : MyTrafficLightColor) = {
    color match {
      case Red => "STOP"
      case Green => "GO"
      case Yellow => "READ"
    }
  }
}