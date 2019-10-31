package edu.scala.exam2

object Ex_5_4 {
  def main(args: Array[String]): Unit = {
    dropship(people(5))
  }

  def people(n: Int) = {
    println("탑승수속을 시작합니다")
    n
  }

  def dropship(n: => Int) = {
    println("드랍십 준비합니다")
    println(n + "명 탑승했습니다.")
  }
} 
