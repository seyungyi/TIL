

package edu.scala.exam

object CompareOperApp extends App {
  println(1 == 1)
  println('a' == 'a')
  println(1 == 'a')
  println('a' == 'A')
  val s1 = "abc"
  val s2 = "abc"
  println(s1 == s2)
  case class Person(p1:String, p2:String)
  val obj1 = Person("a", "b")
  val obj2 = Person("a", "b")
  val obj3 = Person("A", "b")
  println(obj1 == obj2)
  println(obj1 == obj3)    
}