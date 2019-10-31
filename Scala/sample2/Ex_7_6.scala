package edu.scala.exam2

object Ex_7_6 {
  def main(args: Array[String]): Unit = {
    val map = Map(
      "number1" -> "aa",
      "number2" -> "bb",
      "number3" -> 3,
      5 -> "cc" )
    
    println(map.isEmpty)
    println("whole map : " + map)
    println("keys : " + map.keys)
    println("values : " + map.values)
     
    println(map("number1"))
    println(map.get("number1"))
  }
}