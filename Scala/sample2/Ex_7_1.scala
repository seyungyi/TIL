package edu.scala.exam2

object Ex_7_1 {
  def main(args: Array[String]): Unit = {
    val arrayA = Array(1, 2, 3, 4, 5)
    for(x <- arrayA) 
      println(x)

    val arrayB = Array("a", "b", "c", "d")
    for(x <- arrayB) 
      println(x)
    val arrayC = Array("a", "b", 100, "c", "d")
    for(x <- arrayC) 
      println(x)
  }
}