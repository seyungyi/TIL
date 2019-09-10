package edu.scala.exam2

object Ex_8_3 {
  def main(args: Array[String]): Unit = {
    val o = List(1, 2, 3, 4)
    val n = o.foldLeft(0)((i, j) => i + j)
    println(n)
    
    val l1 = List(3, 6, 9)
    println(l1.foldLeft(0) { (x : Int, y : Int) => println("x:"+ x + ",y:"+ y); x + y })

    val l2 = List(3, 6, 9)
    println(l2.foldRight(0) { (x : Int, y : Int) => println("x:"+ x + ",y:"+ y); x + y })

  }
}