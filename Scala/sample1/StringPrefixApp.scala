package edu.scala.exam 

object StringPrefixApp extends App {
  val name = "duke"
  println("Hello! ${name}")
  println(s"Hello! ${name}")
  println("${1 + 1}")
  println(s"${1 + 1}")
  val height : Double = 160.576
  val name1 = "dooly"
  println(f"$name1%s is $height%2.2f meters tall")
  val str = "AAA\nBBB"
  println(str)
  val rawStr = raw"AAA\nBBB"
  println(rawStr)
  println("---------------------------")
  println(name+height+name1+str)
  println(name,height,name1,str)
  
}