package edu.scala.exam2

object Ex_3_9 {
  def main(args: Array[String]): Unit = {
    for (i <- (1 to 10) if (i % 2 == 0)) { 
      println(i)
    }
  }
}
