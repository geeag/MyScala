package com.base.scalaClass

import scala.beans.BeanProperty

/**
  *
  */
class ExampleClass() {

  //私有字段,只有被类本身所调用,无法被其它类调用,但是可以通过ExampleClass类来调用,可以通过不是同一个对象的ExampleClass类来调用
  private var value = 0

  //通过[this]来定义一个对象,就是限定了,该对象只能配对象本身来调用,这样一来就无法通过isLess的方式来使用该字段
  private[this] var pValue = 1

  //使用javaBean规范定义的字段,通过这样的方式既可以支持scala风格的getter、setter也支持java风格的getter()、setter()
  @BeanProperty var name: String = _

  //scala风格的getter方法
  def age = value

  //scala风格的setter方法
  def age_=(newValue: Int) {
    value = newValue
  }

  /**
    * 辅助构造器:辅助构造器都是名称都为this,每一个辅助构造器都必须以一个,对先前已经定义其它辅助构造器或者主构造器的调用开始,
    * 如果一个类没有定义主构造器,那自动拥有一个无参主构造器
    */
  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }


  def isLess(other: ExampleClass) = value < other.value

  def increment(): Unit = {
    //方法默认是共有方法
    value += 1
  }


  def current() = value

  def testPersionClass(): Unit ={
    val person = new Person("jack", 20)
    println(person.prt)
  }

  def newPerson = new Person("jack", 20)

  /**
    * 这里是定义主构造函数的方法,这里的参数类型完全可以引用以上所提到任意三种数据类型
    * 通过这种构造方法所定义的参数都是私有的,除非定义了公有的getter、setter方法
    * 也可以让主构造器变成私有的只要用这样的方式:class Person private(var name : String, private val age : Int),
    * 这么一来那只能使用辅助构造器来调用Person对象了
    */
  class Person(var name : String, private val age : Int){
    def prt = name + ":" + age
  }
}
