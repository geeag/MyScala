package com.base.scalaClass

/**
  * 抽象类
  *
  */
abstract class AbstractCalss{

  var name:String   //定义一个抽象字段

  def id: Int //定义一个抽象方法,抽象方法不需要添加abstract关键字,只要省去方法体就可以
}


//实现类
class Test extends AbstractCalss{
  override var name: String = "AAA"   //使用override关键字实现抽象字段

  override def id: Int = {  //使用override关键字实现抽象方法
      100000
  }
}

//测试类
object Test extends App{
  val test = new Test()
  println(test.id + ":" + test.name)
}