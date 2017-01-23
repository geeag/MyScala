package com.base.scalaClass

/**
  * 方法重写、字段重写
  * 与java类似使用extends继承,可以在类中定义出超类没有的字段和方法,或者重写超类的方法
  */
class Class8 (name:String, age:Int)extends SuperClass(name,age){
  //超类构造器
  override val salay: Int = 20000 //重写salay字段

  override def info()={   //重写info方法
    println("姓名 :" +getName +  " 年龄:" + getAge)
  }
}

object Class8{
  def main(args: Array[String]): Unit = {
    val sunClass = new Class8("Merry", 20)

    sunClass.info()
    println(sunClass.salay)
    sunClass.setAge_=(1)
    sunClass.setName_=("aaa")

    sunClass.info()
    if(null.isInstanceOf[SuperClass]) //判断是否是SuperClass类,null去判断返回false,如果类不匹配则报错
      println(true)
//    sunClass.info()
  }
}

