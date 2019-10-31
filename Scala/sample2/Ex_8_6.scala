package edu.scala.exam2

object Ex_8_6 {
  def main(args: Array[String]): Unit = {
    val o = List(1, 2, 3, 4)

    val n = o.find(i => i >= 4)
    val nn = o.find(i => i == 9)

    println(n)
    println(nn)
  }
}