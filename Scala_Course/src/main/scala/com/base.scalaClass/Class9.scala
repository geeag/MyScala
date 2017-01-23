package com.base.scalaClass

import scala.io.Source
import scala.sys.process._  //可以调用外部命令
/**
  * 处理文本以及正则表达式
  */
class Class9 {
  //读取本地文件,然后一行一行输出,字符集为UTF-8
  def readFile() ={
    val source = Source.fromFile("/Users/geeag/Downloads/优先匹配.txt","UTF-8")
    val lineIterator = source.getLines()
    for(l <- lineIterator){
      val info = l.split("\t")
      for(i <- info)
        println(i)
      println("-----------------")
    }

    source.close()  //关闭流
  }

}

object Class9 extends App{
//  val test = new Class9()
//  test.readFile()

  /**
    * 使用#>将ls -l的结果保存到/Users/geeag/Downloads/v.txt
    * 使用#>>就是在文件结尾追加
    */

// "ls -l" #>> new java.io.File("/Users/geeag/Downloads/v.txt") !;
  val line = "ls /Users/geeag" !!;  //用!!代表结果以字符串形式返回
  println(line)
}
