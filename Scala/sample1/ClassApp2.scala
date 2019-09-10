package edu.scala.exam

class Person2(name:String, age:Int) {
  println("Person2 object create : " + name + " - " + age)
}

object ClassApp2 extends App {
  val p = new Person2("duke", 23)
  print(p)  
}