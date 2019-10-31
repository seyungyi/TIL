package edu.scala.exam2

object Ex_8_7 {
  def main(args: Array[String]): Unit = {
    val o = List(1, 2, 3, 4, 5, 6, 0)

    val n = o.drop(4)
    val nn = o.dropWhile(i => i < 3)

    println(n)
    println(nn)
  }
}