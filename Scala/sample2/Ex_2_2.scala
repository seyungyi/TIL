package edu.scala.exam2

object Ex_2_2 {
  def main(args: Array[String]): Unit = {
    var a: Int = 5
    var b = a
    a = 10
    println(a)
    println(b)
    println(a.getClass.getSimpleName)
    println(b.getClass().getSimpleName())
  }

}
