package edu.scala.exam

object VarAndValApp extends App {
  var variable = 100
  val value = 100
  println(f"variable = $variable%d")
  println(f"value = $value%d")
  variable += 100
  //value += 200
  println(f"new variable = $variable%d")
  println(f"value = $value%d")
}