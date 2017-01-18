package com.base

import scala.collection.mutable.ArrayBuffer


/**
  * 数组、变长数组、遍历、数组转换、常用算法、多维数组、与java相互操作
  */
object Class3 {
  //---------------定长数组---------------------
  //定义一个定长数组,所有元素初始化为0
  val nums = new Array[Int](10)
  //定义一个定长数组,所有元素初始化为null
  val a = new Array[String](10)
  //提供初始值的情况下就可以不用new
  val b = Array[String]("a", "b", "c", "d", "e", "f", "g")

  //修改数组中的值
  def setArr(): Unit = {
    b(0) = "c"
  }


  //---------------变长数组---------------------
  val c = ArrayBuffer[Int]()

  def setArrBuf(): Unit = {
    c += 1 //在c的尾端添加1
    c += (2, 3, 4) //在c的尾端添加多个元素
    c ++= Array(5, 7, 8) //使用++=追加任何集合
    c.trimEnd(3) //使用trimEnd移除最后3个元素
    c.insert(2, 0) //在第二个位置插入0,也可以插入多个
    c.insert(2, 9, 9, 9)
    c.remove(2) //移除第二个元素
    c.remove(1, 2) //从第一个元素开始,移除2个元素
  }

  //---------------定长数组与变长数组之间的转换---------------------
  def transformArr(): Unit = {
    val a = Array[Int](0, 1, 2, 3, 4, 5)
    val b = a.toBuffer //将定长转为不定长
    val c = b.toArray //将不定长转为定长

  }

  //遍历数组
  def foreach(): Unit = {
    for (i <- 0 until b.length) //遍历数组
      println(b(i))
    println("----------------------------")
    for (i <- b) //另一种遍历数组
      println(i)
    println("----------------------------")

    for (i <- 0 until(b.length, 2)) //每两个两个元素一跳
      println(b(i))
    println("----------------------------")
    for (i <- (0 until b.length).reverse) //倒序遍历
      println(b(i))
    println("----------------------------")

    val a = for (i <- b if i.equals("b") || i.equals("c")) yield i //遍历中的守卫,并将遍历结果赋值给另一个变量
    for (i <- a)
      println(i)

    println("----------------------------")
  }

  /**
    * scala常用算法
    */
  def commFan(): Unit = {
//    val sum = Array(1, 2, 3, 4).sum //求数组的和
//    println(sum)

    //让数组排序,_<_从小到大, _>_从大到小
    val arr = ArrayBuffer[Int](9, 34, 8, 1, 4, 10)
    val storeArr = arr.sortWith(_ < _)
    for (i <- storeArr)
      println(i)
    println("----------------------------")

    //比toString更强大的方法,可以按照自己的
    val mkString = arr.mkString("")
    println(mkString)
  }

  //建立二维数组
  def twoDimensionArr(): Unit ={
    val mm = Array.ofDim[Int](3,4) //定义一个三行四列的二维数组
    mm(0) = Array[Int](2,3,4,5)
    mm(1) = Array[Int](6,7,8,9)
    for(i <- mm)
      for(j <- i)
        println(j)
  }

  def random(): Unit ={
    while(true){
      val r = (new util.Random()).nextInt(2)  //生成0到1的随机整数
      println(r)
    }
  }

  def main(args: Array[String]): Unit = {
//    foreach()
//    commFan()
//    twoDimensionArr()
    random()
  }
}
