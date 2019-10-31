# [ Spark Programming Exercise ]

## eclipse로 데이터 처리하기

```bash
- 이클립스 패키지의 scala 소스를 export - jar파일로 저장
path 경로는 /root/spark-2.4.3/myspark
$ jar tvf wc111.jar
$ spark-submit --master local --class com.example.chapter5.WordCount --name WordCount wc111.jar file:///root/sampledata/simple-words.txt
$ hdfs dfs -ls /edudata
$ hdfs dfs -put /root/sample/simple-words.txt /edudata/
$ hdfs dfs -put /root/sampledata/simple-words.txt /edudata/
$ spark-submit --master local --class com.example.chapter5.WordCount --name WordCount wc111.jar /edudata/simple-words.txt

```

## 데이터 순서를 바꾸어 처리하기

### RDD 요소 정렬하기(sorted)

```scala
val textRDD = sc.textFile("File:///root/spark-2.4.3/READEME.md")
val wordCandidateRDD = textRDD.flatMap(_.split("[ ,.]"))
val wordRDD = wordCandidateRDD.filter(_.matches("""\p{Alnum}+"""))
val wordAndOnePairRDD = wordRDD.map((_, 1))
val wordAndCountRDD = wordAndOnePairRDD.reduceByKey(_ + _)

val couintAndWordRDD = wordAndCountRDD.map { wordAndCount => 
	(wordAndCount._2, wordAndCount._1)
}

val sortedCWRDD = countAndWordRDD.sortByKey(false)
val sortedWCRDD = sortedCWRDD.map { countAndWord => 
	(countAndWOrd._2, countAndWOrd._1)
}
val sortedWCArray = sortedWCRDD.collect
sortedWCArray.foreach(println)
(the,21)
(Spark,15)
(to,14)
(for,12)
...

- 각 튜플에 접근하려고 이용하는 ._1과 ._2 표기법이 읽기 불편할 경우 아래와 같이 표기 가능
-> 매핑 대상과 결과가 인덱스가 아니라 이름을 부여할 수 있기에 직관적으로 이해하기 좋음
val sortedWCRDD = sortedWCRDD = sortedCWRDD.map {
    case (count, word) => 
    	(word, count)
}
```



### RDD 선두로부터 요소 꺼내기

- take 메서드 : 매개변수에 지정되니 수만큼의 요소를 RDD의 선두로부터 끄집어내, 드라이버 프로그램에 배열로 돌려주는 액션 메서드

```scala
val top3WordArray = sortedWCRDD.take(3)
top3WordArray.foreach(println)
(the,21)
(Spark,15)
(to,14)
```