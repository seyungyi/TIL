package edu.scala.exam

object CollectionApp3 extends App {
  val list1 = List(10,20,20,40)
  println(list1)
  println(list1.length)
  println(list1(0))
  //list1(6) = 100
  println(list1(3))
  val list2 = (1 to 10).toList
  val list3 = Array(100,200,300).toList
  println(list2)
  println(list3) 
  
  val set1 = Set(10,20,20,40)
  println(set1)
  println(set1.size)
  println(set1(0))
  println(set1(40))
  
  val tuple1 = ("java", "duke")
  println(tuple1._1)
  println(tuple1._2)
  
  val map1 = Map(1 -> 2)
  val map2 = Map("foo" -> "bar")
 
  println(map1)
  println(map2)
  println(map1.get(1))
  println(map1.get(10))
  println(map1.getOrElse(1, 99))
  println(map1.getOrElse(10, 99))
  println(map2.get("foo"))
  println(map2.get("FOO"))
  println(map2.getOrElse("foo", "duke"))
  println(map2.getOrElse("FOO", "duke"))
  
  val map3 = Map(1 -> "dooly", 2 -> "ddochi", 3 -> "dounat", 1 -> "gildong")
  println(map3)
}