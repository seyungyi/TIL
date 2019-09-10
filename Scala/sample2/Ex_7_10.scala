package edu.scala.exam2

object Ex_7_10 {
  def main(args: Array[String]): Unit = {
    val list = List("a", "b", "c")
    val i = list.iterator 
    while(i.hasNext)
      println(i.next)
  }
}