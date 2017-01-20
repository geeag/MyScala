package com.base.scalaClass

/**
  * scala实现类,getter、setter方法的使用,构造器和辅助构造器
  */
object Class5 {



  def main(args: Array[String]): Unit = {
    val obj = new ExampleClass()
    obj.age_=(5)
    println(obj.getName)
    val obj2 = new ExampleClass()
    obj2.age_=(10)

    //建议:修改属性值时使用(),而不修改该属性时去掉()
    println(obj.current())
    println(obj.current)
    println("-----------------------")


    obj.testPersionClass
    var p = obj.newPerson
    println(p.name)
  }
}
