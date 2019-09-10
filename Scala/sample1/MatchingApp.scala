package edu.scala.exam

object MatchingApp extends App {
  def matching(x:Int) : String = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
    }
  println(matching(1))
  println(matching(2))
  println(matching(4))
  
}