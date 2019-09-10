package edu.scala.exam

class Person3_1(name:String, age:Int) {
  println(s"Person3_1 - ${name} : ${age} 생성")
}
class Person3_2(var name:String, var age:Int) {
  println(s"Person3_2 - ${name} : ${age} 생성")
}
class Person3_3(val name:String, val age:Int) {
  println(s"Person3_3 - ${name} : ${age} 생성")
}

object ClassApp3 extends App {
  var p1 = new Person3_1("duke", 23)
  println(p1) 
  //println(p1.name)
  val p2 = new Person3_2("dooly", 1000)
  println(p2) 
  println("getter call - " + p2.name)    
  val p3 = new Person3_3("gildong", 45)
  println(p3) 
  println("getter call - " + p3.name)
  println("-------------------------------");
  p2.name = "dounat"
  println("getter call - " + p2.name)
  //p3.name = "ddochi"
}