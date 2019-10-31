# [ Spark Programming Exercise ]

## 메서드 종류와 정의

- parallelize() : 스칼라컬렉션 객체를 이용해서 RDD 객체를 생성
- count() : RDD의 요소 개수를 리턴
- first() : RDD 객체의 첫 번째 요소를 리턴
- collect() : RDD 객체의 모든 요소를 배열로 리턴
- map() : 입력 RDD의 모든 요소에 f를 적용한 결과를 저장한 RDD를 반환
- flatMap() : 입력 RDD의 모든 요소에 f를 적용하고 모든 요소들을 하나로 묶어서 반환
- filter() : 입력 RDD의 모든 요소에 f를 수행하고 참을 리턴하는 결과만 저장한 RDD를 반환
- reduce() : 지정된 f를 수행시켜 입력 RDD의 개수를 축소시켜서 생성된 RDD를 반환
- reduceByKey() : 키값을 기준으로 f를 수행하고 RDD를 반환
- groupBy() : 입력 RDD의 모든 요소에 f를 적용한 결과로 그루핑된 RDD를 반환



## 예제 1

```scala
val x = sc.parallelize(List("spark", "rdd", "example", "sample", "example"))
x.count
x.first
val y = x.map(x => (x,1))
y.collect
y.collect.foreach(println)
val y = x.map((_, 1))
y.collect
y.collect.foreach(println)
val y = x.map(x => (x, x.length))
y.collect
y.collect.foreach(println)
```

## 예제 2

```scala
val x = sc.parallelize(List("spark rdd example", "sample example"))
val y = x.map(x => (x.split(" ")))
y.collect
y.collect.foreach(println)
val y = x.flatMap(x => x.split(" "))
y.collect
y.collect.foreach(println)
val y = x.flatMap(_.split(" "))
y.collect
y.collect.foreach(println)
```

## 예제 3

```scala
val x = sc.parallelize(1 to 10)
val y = x.filter(e => e%2 == 0)
y.collect
y.collect.foreach(println)
val y = x.filter(_ % 2 == 0)
y.collect
y.collect.foreach(println)
```

## 예제 4

```scala
val x = sc.parallelize(1 to 10, 2)
val y = x.reduce((result, n) => (result+n))
val y = x.reduce(_ + _)
val y = x.reduce(- * _)
```

## 예제 5

```scala
val x = sc.prarallelize(Array(("a", 1), ("b", 1), ("a", 1), ("a", 1), ("b", 1), ("b", 1), ("b", 1), ("b", 1)))
val y = x.reduceByKey((result, n) => (result + n))
y.collect
y.collect.foreach(println)
val y = x.reduceByKey(_ + _)
y.collect
y.collect.foreach(println)
def sumFunc(result:Int, n:int) = result + n
val y = x.reduceByKey(sumFunc)
y.collect
y.collect.foreach(println)
```

## 예제 6

```scala
val x = sc.prarallelize(Array("Joseph", 1), ("Jimmy", 1), ("Tina", 1), ("Thomas", 1), ("James", 1), ("Cory", 1), ("Christine", 1), ("Jackeline", 1), ("Juan", 1), 3)
val y = x.groupBy(word => word.charAt(0))
y.collect
y.collect.foreach(println)
val y = x.groupBy(_.charAt(0))
y.collect
y.collect.foreach(println)
val y = x.groupBy(_.length)
y.collect
y.collect.foreach(println)
```