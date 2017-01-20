package com.base.scalaClass

object TrafficLightColor extends Enumeration {
  type TrafficLightColor = Value
  val Red = Value(0, "Stop")
  val Yellow = Value(10)
  val Green = Value("Go")
}


object Margin extends Enumeration {
  type Margin = Value
  val TOP, BOTTOM, LEFT, RIGHT = Value
}

import com.base.scalaClass.TrafficLightColor._
import com.base.scalaClass.Margin._

object Driver extends App {
  println(BOTTOM, BOTTOM.id)

  def doWhat(color: TrafficLightColor) = {
    if (color == Red) "stop"
    else if (color == Yellow) "hurry up" else "go"
  }

  //使用match匹配
  def doWhat2(color: TrafficLightColor) = color match {
    case Red    => "stop"
    case Yellow => "hurry up"
    case _      => "go"
  }

  // load Red
  val red = TrafficLightColor(0) // Calls Enumeration.apply
  println(red, red.id)
  println(doWhat(red))
  println(doWhat2(TrafficLightColor.Yellow))

  //打印出所有枚举
  Margin.values.foreach { v => println(v,v.id)}
}