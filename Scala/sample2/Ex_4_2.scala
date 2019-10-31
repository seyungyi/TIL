package edu.scala.exam2

object Ex_4_2 {
  def main(args: Array[String]): Unit = {
    val apple = new Fruit("사과")
    println(apple.name)
    apple.name="배"
    println(apple.name)
  }
}
class Fruit(input: String) {
  var name = input
}
