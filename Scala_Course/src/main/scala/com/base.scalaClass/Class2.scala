package com.base.scalaClass


import scala.util.control.Breaks._

/**
  * Created by geeag on 17/1/16.
  * 主要内容是if、for、懒值、异常等基本知识
  */
object Class2 {

  //scala里的if/else表达式有值
  def test(): Unit = {
    val v1 = if (10 < 1) "a" else 100
    println(v1)
  }

  //scala里的循环,scala里面没有java的for(初始化变量;检查变量是否满足条件;更新变量)的语句,
  // 如果要使用循环,可以使用while活着这样的for语句
  def test1(): Unit = {
    //for循环
    var n = 5
    for (i <- 1 to n) {
      println(i);
    }
    println("--------------------")

    val s = "Hello"
    var sum = 0
    for (i <- 0 until s.length) {
      sum += s(i)
      println(sum)
    }
    println("--------------------")

    for (c <- "Hello") println(c)
  }

  def test2(): Unit = {
    var n = 10
    //while循环
    while (n < 10) {
      n = n + 1
      println(n)
    }
    println("--------------------")
  }

  /**
    * 跳出循环,可以直接使用return,或者使用Breaks里的break来处理
    */
  def breaker() {
    var sum = 0
    breakable {
      for (i <- 0 to 10) {
        sum += i
        if (sum < 5) {
          println(sum)
        } else {
          println("break")
          break
          //return
        }
      }
      println("--------------")
    }
  }

  /** advanceFor()
    * fro高级形式
    */
  def advanceFor(): Unit = {
    //直接定义二次循环
    for (i <- 0 to 3; j <- 1 to 2) {
      val sum = i + j
      println(i + "+" + j + "=" + sum)
    }
    println("------------------------")

    //带有守卫的if表达式的循环,只有当表达式为true采执行此次循环
    for (i <- 0 to 3; j <- 1 to 2 if i == j) {
      val sum = i + j
      println(i + "+" + j + "=" + sum)
    }
    println("------------------------")

    //可以使用更复杂的形式来定一个for循环
    for (i <- 1 to 3; f = 4 - i; j <- f to 3) {
      var sum = i + j
      println(i + "+" + j + "=" + sum)

    }
    println("------------------------")

    //使用yield可以是让循环生成一个集合
    val arr = for (i <- 0 to 10) yield i
    println(arr.length)
    for (i <- arr) {
      println(i)
    }
    arr.foreach(a => println(a))
    println("*************************")
  }

  /**
    * 函数,函数就是带有返回值的方法,如果一个方法不带有返回值,那在scala中被称为过程
    */

  //这里定了一个不带返回类型的函数,输入参数是Int型,返回值不带有return,建议习惯这种编码发誓,只把return用作于循环退出
  def fan(n: Int) = {
    var r = 1
    for (i <- r to n) {
      r = r * i
    }
    r
  }

  //也可以指定函数的返回类型,这里指定了返回类型是Int
  def fan1(n: Int): Int = {
    var r = 1
    for (i <- r to n) {
      r = r * i
    }
    r
  }

  //定义一个参数可变长的方法
  def sum(args: Int*) = {
    var sum = 0
    for (arg <- args) {
      sum += arg
    }
    sum
  }

  //可变长传参的另一种实现
  def sum1(args: Int*): Int = {
    if (args.length == 0) 0
    else args.head + sum1(args.tail: _*)
  }

  /*
   *  懒值
   *  当val被声明成lazy时,他的初始化将被延迟,直到我们首次对他取值
   */
  def lazyFan(): Unit ={
    lazy val txt = scala.io.Source.fromFile("/Users/geeag/Downloads/text").mkString
    println(txt)
  }


  def main(args: Array[String]): Unit = {
    //    test()
    //    test1()
    //    breaker()
        advanceFor()
//    val a = fan1(3)
//    println(a)
//    val b = sum(1, 2, 3, 4)
//    println(b)
//    val c = sum1(1 to 4: _*)
//    println(c)
//    lazyFan()
    for(i <- 0 to 10 reverse){
      println(i)
    }
  }

}
