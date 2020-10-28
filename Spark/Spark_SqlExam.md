# Spark SQL Example

```SPARQL
case class Product(pid: String, cnt: Int)

val productRDD = sc.textFile("/edudata/product_click.log")

val splitRDD = productRDD.flatMap(record => record.split(" ")

val filterRDD = splitRDD.filter(_.matches("p[a-z0-9]*"))

val productMap = proWordRDD.map((_, 1))

val productReduce = productMap.reduceByKey(_ + _)

val sortProduct = productReduce.sortBy(x => -x._2)

val productDF = sortProduct.map { record => 
     | val pid = record._1
     | val cnt = record._2
     | Product(pid, cnt) }.toDF

productDF.show
```



```SPARQL
case class Product(pid: String, cnt: Int)

val productRDD = sc.textFile("/edudata/product_click.log")

val productDF = productRDD.map{record=>
   | val splitRecord = record.split(" ")
   | val pid = splitRecord(1)
   | Product(pid, 0)
   | }.toDF

val pidAndCntDF = productDF.groupBy($"pid").agg(count($"pid") as "cnt").orderBy($"cnt".desc)

pidAndCntDF.show
```



```SPARQL
val rowRDD = pidAndCntDF.rdd

val pidAndCntRDD = rowRDD.map{row=>
     | val pid = row.get(0)
     | val cnt = row.get(1)
     | (pid, cnt)}

pidAndCntRDD.collect.foreach(println)
```

