package edu.scala.exam

object FunctionApp2  {
  def add1(x:Int, y:Int):Int = return x + y
    
  def add2(x:Int, y:Int) = x + y + 1000
    
  def add2(x:Int):Int = x * 1000
    
  def add3(x:Int, y:Int=1000):Unit = {
    println("Inner " + x + y)
    println("Inner " + (x + y))
    }
  def main(args: Array[String]) :Unit = {
   println(add1(10,20))
   println(add2(10,20))
   println(add2(10))
   add3(10,20)
   add3(10)
    }    
}