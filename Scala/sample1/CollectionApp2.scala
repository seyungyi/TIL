package edu.scala.exam

object CollectionApp2 extends App {
  val r1 = -5 to 5
  println(r1(0))
  println(r1(4))
  println(r1.length)
  println(r1)
  val r2 = 10 to 15
  println(r2(0))
  println(r2(4))
  println(r2.length)
  println(r2)
  val v = r1 ++ r2
  println(v)
  println(v.length)
  val r3 = 'A' to 'Z'
  println(r3)
  val r4 = -5 until 5
  println(r4.length)
  println(r4)
}