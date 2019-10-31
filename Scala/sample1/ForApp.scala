package edu.scala.exam

object ForApp extends App {
  for(num <- 0 to 3)
    print(num + " ")
  println("\n------------")
  for(num <- 0 until 3)
    print(num + " ")
  println("\n------------")
  val ary = Array("A", "B", "C")
  for(munja <- ary)
    print(munja + " ")
  println("\n------------")
  for(i <- 0 until ary.length)
    println(i, ary(i))
  println("\n------------")
  for((v, i) <- ary.zipWithIndex)
    println(i, v)    
  println("\n------------")
  val map = Map("k1"->"v1", "k2"->"v2", "k3"->"v3")
  for((k, v) <- map)
    println(k,v)
  println("\n------------")
  for(num <- 1 to 10; if num%2 != 0)
    println(num)
  println("\n------------")
  ary.foreach(println)
    
    
      
}