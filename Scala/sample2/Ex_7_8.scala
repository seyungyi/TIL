package edu.scala.exam2

object Ex_7_8 {
  def main(args: Array[String]): Unit = {
    var basket: Set[String] = Set()
    basket += "딸기"
    basket += "포도"
    basket += "포도"
    basket += "사과"
    basket += "포도"
    basket += "바나나"
    println(basket) 
    basket -= "바나나"
    println(basket) 
    basket += "망고"
    println(basket) 
  }
}