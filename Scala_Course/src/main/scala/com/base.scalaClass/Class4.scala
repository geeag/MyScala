package com.base.scalaClass

import java.util

import scala.collection.JavaConversions.mapAsScalaMap

/**
  * 元组,也类似java中的Map
  */
object Class4 {

  //构建一个不可变的Map的两种方式,就是在定义完成之后无法改变其内容
  val scores1 = Map("a" -> 1, "b" -> 2, "c" -> 3)
  val scores2 = Map(("a", 1), ("b", 2), ("c", 3))
  //构建一个可变的Map
  var scores3 = scala.collection.mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
  //建立一个空的可变Map
  var scores4 = new scala.collection.mutable.HashMap[String, Int]()

  //获取Map中的值
  def getMapValue(): Unit = {
    //    val value = scores2("gg") //scala中当Map中不包含所要的key时会报错,所以需要使用getOrElse来取代这样的取值法
    val value2 = scores2.getOrElse("gg", 0)
    //    val value3 = scores2.get("a")
    println(value2)
  }

  //修改Map
  def setMapValue(): Unit = {
    scores3("a") = 0 //修改key为a的值
    scores3 += ("d" -> 4, "e" -> 5) //在Map中添加多个值
    scores3 -= ("b", "a") //从Map中删除
    //遍历Map的key
    val set = scores3.keySet
    for (i <- set)
      println(i + ":" + scores3(i))

    //遍历一个Map的value
    val values = scores3.values
    for (i <- values) {
      println(i)
    }
    println("-------------------------------")

    //反转一个Map的key和value
    val reverseMap = for ((k, v) <- scores3) yield (v, k)
    val k = reverseMap.keySet
    for (i <- k)
      println(i + ":" + reverseMap.getOrElse(i, "NUll"))
    println("-------------------------------")

    val newScores1 = scores1 + ("a" -> 11)
    println(newScores1("a"))

    scores3 = scores3 - "a"
    println(scores3.getOrElse("aa", 0))
  }

  //排序
  def sortMap(): Unit = {
    var scores = scala.collection.immutable.SortedMap(("a", 1), ("d", 4), ("b", 2), ("c", 3))
    for (i <- scores.keySet)
      println(i + ":" + scores(i))
    println("-------------------------------")

    //按照插入的顺序来遍历Map
    var scores1 = scala.collection.mutable.LinkedHashMap(("a", 1), ("d", 4), ("b", 2), ("c", 3))
    for (i <- scores1.keySet)
      println(i + ":" + scores1(i))
  }

  //使用java的Api来实现Map排序
  def callJavaApi(): Unit = {
    var scores: scala.collection.mutable.Map[String, Int] = new util.TreeMap[String, Int]
    scores += ("d" -> 4, "e" -> 5, "b" -> 2, "a" -> 1)
    for (i <- scores.keySet)
      println(i + ":" + scores(i))
  }

  //元组,一个元组可以包含多个不通类型数据,类似于一个对象
  def tuple(): Unit = {
    val tuple = ("AAA", 1, 3.14)
    var second = tuple._1 //获取第二个元素
//    println(second)

    var (a, b, _) = tuple
    println(tuple._3)
  }

  //拉链操作
  def zip(): Unit ={
    val symbol = Array("<","-",">")
    val counts = Array(2,10,2)
    val pairs = symbol.zip(counts)
    for((i,j) <- pairs)
      println(i + ":" + j)
    println("------------------------")

    //toMap将对偶转换成映射
    val newMap = pairs.toMap
    for(i <- newMap.keys)
      println(i + ":" + newMap(i))
  }

  def main(args: Array[String]): Unit = {
    //    getMapValue()
    //    setMapValue()
    //    sortMap()
    //    callJavaApi()
//    tuple()
    zip()
  }
}
