package com.base.scalaClass

/**
  * 一个实体类,带有getter和setter方法,还有一个构造方法
  */
class SuperClass() {

  private var name: String = _
  private var age: Int = _
  val salay: Int = 100000

  def getName = name

  def setName_=(newValue: String) = {
    name = newValue
  }

  def getAge = age

  def setAge_=(newValue: Int) = {
    age = newValue
  }

  def this(_name: String, _age: Int) {
    this()
    setName_=(_name)
    setAge_=(_age)
  }

  def info() = {
    println(name + ":" + age)
  }
}
