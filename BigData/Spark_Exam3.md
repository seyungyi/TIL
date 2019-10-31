# [ Spark Programming Exercise ]

## Spark와 SQL을 위한 설정

1. HIVE 폴더의 `hive-site.xml` 파일 복사

2. [Spark-x.x.x] - [conf] 폴더에 복사

3. hive-site.xml 파일 수정

   ```xml
   75행 <value>/root/apache-hive/hivetmp</value> 
   80행 <value>/root/apache-hive/${hive.session.id}_resources</value> 
   1685행 <value>/root/apache-hive/hivetmp</value> 
   3976행 <value>/root/apache-hive/hivetmp/operation_logs</value> 
   
   <!-- <name>hive.server2.enable.doAs</name> --> 
   4359행 <value>false</value>
   ```

4. . HADOOP의 HDFS에 HIVE에서 사용될 디렉토리들을 생성하고 사용자 허가모드를 777 로 만든다

   ```bash
   $ hdfs dfs mkdir /tmp/hive
   $ hdfs dfs chmod 777 /tmp/hive
   $ hdfs dfs mkdir p /user/hive/warehouse
   $ hdfs dfs chmod 777 /user/hive/warehouse
   ```

## DataFrame을 이용하여 데이터처리 기술하기

### RDD와 DataFrame의 상호변환

- RDD로부터 DataFrame 생성하기

  ```scala
  scala> case class Dessert(menuId: String, name: String, price: Int, kcal: Int)
  scala> val dessertRDD = sc.textFile("File:///root/sampledata/dessert-menu.csv")
  scala> val dessertDF = dessertRDD.map { record => 
       | val splitRecord = record.split(",")
       | val menuId = splitRecord(0)
       | val name = splitRecord(1)
       | val price = splitRecord(2).toInt
       | val kcal = splitRecord(3).toInt
       | Dessert(menuId, name, price, kcal)
       | }.toDF
  
  scala> dessertDF.printSchema
  root
   |-- menuId: string (nullable = true)
   |-- name: string (nullable = true)
   |-- price: integer (nullable = false)
   |-- kcal: integer (nullable = false)
  ```

- DataFrame으로부터 RDD 생성하기

  ```scala
  scala> val rowRDD = dessertDF.rdd
  rowRDD: org.apache.spark.rdd.RDD[org.apache.spark.sql.Row] = MapPartitionsRDD[16] at rdd at <console>:25
  
  scala> val nameAndPriceRDD = rowRDD.map { row =>
       | val name = row.getString(1)
       | val price = row.getInt(2)
       | (name, price)
       | }
  nameAndPriceRDD: org.apache.spark.rdd.RDD[(String, Int)] = MapPartitionsRDD[17] at map at <console>:25
  
  scala> nameAndPriceRDD.collect.foreach(println)
  (초콜릿 파르페,4900)                                                            
  (푸딩 파르페,5300)
  (딸기 파르페,5200)
  (판나코타,4200)
  (치즈 무스,5800)
  (아포가토,3000)
  (티라미스,6000)
  (녹차 파르페,4500)
  (바닐라 젤라또,3600)
  (카라멜 팬케익,3900)
  (크림 안미츠,5000)
  (고구마 파르페,6500)
  (녹차 빙수,3800)
  (초코 크레이프,3700)
  (바나나 크레이프,3300)
  (커스터드 푸딩,2000)
  (초코 토르테,3300)
  (치즈 수플레,2200)
  (호박 타르트,3400)
  (캬라멜 롤,3700)
  (치즈 케익,4000)
  (애플 파이,4400)
  (몽블랑,4700)
  ```

- DataFrame에 쿼리 발행하기

  ```scala
  scala> dessertDF.registerTempTable("dessert_table")
  scala> val numOver300KcalDF = sqlContext.sql(
  		"SELECT count(*) AS num_of_over_300Kcal FROM dessert_table WHERE kcal >= 260")
  scala> numOver300KcalDF.show
  
  - 스파크 SQL 내장 함수의 사용 예
  scala> sqlContext.sql("SELECT atan2(1,3) AS 'ATAN2(1,3)'").show
  
  - 하이브 내장 함수의 사용 예
  scala> sqlContext.sql("SELECT pi() AS PI, e() AS E").show
  ```

- DataFrame API로 DataFrame 다루기

  - 컬럼과 식 선택

    ```scala
    scala> val nameAndPriceDF = dessertDF.select(dessertDF("name"), dessertDF("price"))
    scala> nameAndPriceDF.printSchema
    
    scala> val selectAllDF = dessertDF.select("*")
    scala> selectAllDF.printSchema
    
    scala> nameAndPriceDF.show
    scala> selectAllDF.show(3)
    
    scala> val nameAndDollarDF = nameAndPriceDF.select($"name", $"price" / lit(1000.0))
    scala> nameAndDollarDF.printSchema
    
    scala> val nameAndDollarDF = nameAndPriceDF.select(
        $"name", ($"price" / lit(1000.0) as "dollar price"))
    scala> nameAndDollarDF.printSchema
    ```

  - 필터링

    ```scala
    scala> val over5200WonDF = dessertDF.where($"price" >= 5200)
    scala> over5200WonDF.show
    
    scala> val over5200WonNameDF = dessertDF.where($"price" >= 5200).select($"name")
    scala> over5200WonNameDF.show
    ```

  - 정렬

    ```scala
    scala> val sortedDessertDF = dessertDF.orderBy($"price".asc, $"kcal".desc)
    scala> sortedDessertDF.show
    ```

  - 집약처리

    ```scala
    scala> val avgKcalDF = dessertDF.agg(avg($"kcal") as "avg_of_kcal")
    scala> avgKcalDF.show
    
    scala> import org.apache.spark.sql.types.DataTypes._
    sacla> val numPerPriceRangeDF = dessertDF.groupBy(
    		(($"price" / 1000) cast IntegerType) * 1000
    		as "price_range").agg(count($"price")).orderBy($"price_range")
    scala> numPerPriceRangeDF.show
    ```