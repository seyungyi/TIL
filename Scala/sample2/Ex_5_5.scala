package edu.scala.exam2

object Ex_5_5 {
  def main(args: Array[String]): Unit = {
    val thisYear = 2016

    // 아직 매개변수가 존재하지 않지만, 
    // _ 와일드카드로 어느 String 값이든 들어올 수 있다고 선언합니다.
    val fixedValueFunction = go(thisYear)_

    // go()가 아니라 fixedValueFunction 형태로 호출
    fixedValueFunction("test1")
    fixedValueFunction("test2")
    fixedValueFunction("test3")
    }

  def go(thisYear: Int)(string: String) = {
    println(string + ": " + thisYear)
  }
}
