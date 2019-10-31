package edu.scala.exam2

object Ex_5_6 {
  def main(args: Array[String]): Unit = {
    val g = f
    println(f(1))
    println(g(1))
  }

  def f = (i: Int) => i + 1
}
