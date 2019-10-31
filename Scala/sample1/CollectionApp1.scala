package edu.scala.exam 

object CollectionApp1 extends App {
  val ary1 = Array(10,20,30,40,50)
  println(ary1)
  println(ary1(0))
  println(ary1(4))
  println(ary1.length)
  ary1(4) = 500
    
  for(su <- ary1)
    print(su + " ")
  println()
  val ary2 = Array(1, true, false, 'A', "ABC", 3.14)
  for(su <- ary2)
    print(su + " ")
  println()
  println(ary2.length)
  val ary3 = ary1 ++ ary2
  for(su <- ary3)
    print(su + " ")
  println()
  println(ary3.length)    
}