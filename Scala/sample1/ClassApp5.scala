package edu.scala.exam

class Person5(name:String="또치", age:Int=10) {
  println(s"Person5 - ${name} : ${age} 생성")
  def greeting() = println(s"${name}님은 ${age}세입니다.");
  def greeting(dong:String) = println(s"${name}님은 ${age}세이고 ${dong}에서 살고 있습니다.");
}


object ClassApp5 extends App {
  var p = new Person5()
  p.greeting()
  p.greeting("쌍문동") 
  p.greeting
}