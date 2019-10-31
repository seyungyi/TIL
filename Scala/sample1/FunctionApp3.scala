package edu.scala.exam

object FunctionApp3 {
  def sum1(num:Int*) = {
    print(num)
    println("\n---------------------")
    }
  def sum2(num:Int*) = {
    for(su <- num)
      print(su + " ")
      println("\n---------------------")
    }
  def sum3(num:Int*) = {
    println(num.reduce(_+_)) // 묵시적 파라미터
    println("\n---------------------")
    }
  def main(args: Array[String]):Unit = {
   sum1(10)
   sum1(10,20)
   sum1(10,20,30)
   sum1(10,20,30,40)
   println("\n====================")
   sum2(10)
   sum2(10,20)
   sum2(10,20,30)
   sum2(10,20,30,40)
   println("\n====================")
   sum3(10)
   sum3(10,20)
   sum3(10,20,30)
   sum3(10,20,30,40)
    }    
}