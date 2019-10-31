package edu.scala.exam

class Person4_1(name:String="ddochi", age:Int=10) {
  println(s"Person4_1 - ${name} : ${age} 생성")
}
class Person4_2(var name:String="ddochi", var age:Int=10) {
  println(s"Person4_2 - ${name} : ${age} 생성")
}
class Person4_3(val name:String="ddochi", val age:Int=10) {
  println(s"Person4_3 - ${name} : ${age} 생성")
}

object ClassApp4 extends App {
  var p1 = new Person4_1()
  println(p1) 
  val p2 = new Person4_2()
  println(p2) 
  println("getter call - " + p2.name)    
  val p3 = new Person4_3()
  println(p3) 
  println("getter call - " + p3.name)
  println("-------------------------------");
  p2.name = "dounat"
  println("getter call - " + p2.name)
}