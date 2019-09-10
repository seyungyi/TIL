package edu.scala.exam2

object Ex_5_8 {
  def main(args: Array[String]): Unit = {
    printlnStrings("string1", "string2", "string3");
  }

  def printlnStrings(args: String*) = {
    for (arg <- args) {
      println(arg);
    }
  }
}
