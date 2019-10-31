package edu.scala.exam
//import scala.collection.mutable.MutableList

object CollectionFunctionApp extends App {
  // map()
  val nums = List(1,2,3,4,5)//1 to 10
  var result1 = nums.map(_ + 1)
  println(nums)
  println(result1)
  
  val strs = List("duke", "tuxi", "dooly")
  var result2 = strs.map(_.toUpperCase)
  println(strs)
  println(result2)
  
  val su = 1 to 10
  println(su.reduce(_ + _))
  println(su.reduceLeft(_ + _))
  println(su.reduceRight(_ + _))
  
  println(su.reduce(_ - _))
  println(su.reduceLeft(_ - _))
  println(su.reduceRight(_ - _))
  
  println(su.fold(10)(_ + _))
  
    
     
}