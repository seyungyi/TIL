package edu.scala.exam

object FunctionApp4 {
  def exec(fun:(Int, Int) => Int, x:Int, y:Int) = fun(x, y)

  def main(args: Array[String]):Unit = {
   var result = exec((x:Int, y:Int) => x+y, 2, 3)
   print(result)
   println("\n====================")
   result = exec((x, y) => x+y, 20, 30)
   print(result)
   println("\n====================")
   result = exec((x, y) => x*y, 2, 3)
   print(result)
   println("\n====================")
   result = exec(_*_, 20, 30)
   print(result)
   println("\n====================")
   
    }    
}