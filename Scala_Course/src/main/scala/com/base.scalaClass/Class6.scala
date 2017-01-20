package com.base.scalaClass

/**
  * 对象
  * 学习:单列、伴生对象、特质、apply方法、枚举等
  */
class Class6 private() {
  //将构造方法设定为私有

  def apply() {
    println("Class apply()")
  }

  var name: String = _;

  def account: Unit = {
    println("class ApplyTest account")
  }

  def this(name: String) {
    this()
    this.name = name
  }
}

/**
  * 建立Class6的伴生对象,伴生对象和类之间何以相互访问私有特性,它们必须在同一个源文件中
  * 伴生对象就类似一个静态类,里面所有东西都是单例
  */
object Class6 {

  var person: String = _

  //通过在半生对象里定义apply方法,可以实现单例,这样每次返回的都是同一个Class6对象
  def apply() = {
    println("object apply")
    if (person == null)
      person = "aaa"
    else {
      person = "bbb"
    }
    Class6 //返回一个伴生对象
  }

  def pnt(): Unit = {
    println("pnt")
  }
}

/**
  * 当直接使用类名的话,就是直接调用伴生对象,
  */
object Main extends App {
  //  var a = new Class6("a")
  //  var b = Class6.apply()   //直接调用伴生对象object
  //  var c = Class6.apply() //直接调用伴生对象object
  //  println(b == c)
  //  println(Class6.apply().person)
  //  println(Class6.apply().person)
  val a = new Class6("")
  a() //调用类的apply
  Class6() //调用伴生对象的apply
}