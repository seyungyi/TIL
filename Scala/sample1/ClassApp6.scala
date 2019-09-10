package edu.scala.exam

case class Person6(name:String="또치", age:Int=10) {
  println(s"Person6 - ${name} : ${age} 생성")
  def greeting() = println(s"${name}님은 ${age}세입니다.");
  def greeting(dong:String) = println(s"${name}님은 ${age}세이고 ${dong}에서 살고 있습니다.");
}


object ClassApp6 extends App {
  var p = Person6()
  p.greeting()
  p.greeting("쌍문동") 
  p.greeting
  println(p.toString)
  println(p.hashCode)
  var p1 = Person6("또치", 10)
  print(p == p1)
  var p2 = Person6("또치", 20)
  print(p == p2)
}