## [ Hadoop MapReduce ]

- MapReduce 역사

  - 구글에서 대용량 데이터 처리를 분산 병렬 컴퓨팅에서 처리하기 위한 목적으로 제작하여 2004년 발표한 소프트웨어 프레임워크다. 이 프레임워크는 페타바이트
    이상의 대용량 데이터를 신뢰도가 낮은 컴퓨터로 구성된 클러스터 환경에서 병렬 처리를 지원하기 위해서 개발되었다.

- MapReduce 구성 : Hadoop 클러스터의 데이터를 처리하기 위한 시스템으로 총 2개(Map, Reduce)의 단계로 구성된다.

  - Map
    - 각 Map task는 전체 데이터 셋에 대해서 별개의
      부분에 대한 작업을 수행하게 되는데, 기본적으로 하나의 HDFS
      block을 대상으로 수행하게 된다.
    - 모든 Map 태스크가 종료되면, MapReduce 시스템은 중간(intermediate) 데이터를 Reduce 단계를 수행할 노드로 분산하여 전송한다
  - Shuffle or Sort : 
  - Reduce
    - Distributed File System에서 수행되는 MapReduce 작업이 끝나면 HDFS에 파일이 써진다.
    - MapReduce 작업이 시작할 때는 HDFS로 부터 파일을 가져오는
      작업이 수행된다.

- MapReduce 정리

  - 정의 : 데이터를 개별로 가공 및 필터링하거나, 어떤 키값에 기반하여 데이터를 분류하거나, 분류한 데이터로 통계치를 계산하는 등, 수많은 데이터 처리에서 사용되고 있는 기법들을 일반화 하고 있다. 
    map() 함수와 reduce() 함수는 한 번에 처리할 수 있는 데이터와 데이터 전달 방법 등이 다르다
  - map() 함수 : 처리 대상 데이터 전체를 하나씩, 하나씩 처리한다. 처리대상 데이터간에 의존관계가 없고 독립적으로 실행 가능하며 처리나 순서를 고려하지 않아도 되는 처리에 적합하다.(전처리 즉, 변환작업) 
    EX) **map : (K1, V1) -> list(K2, V2)**
  - reduce() 함수 : 키와 연관된 복수의 데이터가 전달된다. 또한 reduce() 함수에 전달되는 데이터는 키값으로 정렬되어 있다. 그룹화된
    복수의 데이터를 필요로 하는 처리 또는 순서를 고려해야 하는 처리에 적합하다.(그룹별 합계 즉 ,집계작업)
    EX) **reduce : (K2, list(V2)) -> list(K3, V3)**
  - MapReduce는 윈도우에서는 실행할 수가 없음 -> 리눅스 환경에서만 사용 가능

- MapReduce 설정 및 수행

  ```
  <Map>
  input : 원본데이터
  output : 키/값
  
  <Reduce>
  input : 맵에서 추출한 키/[값, .....]
  output : 그룹화및 연산수행하여 최종 결과 : 키/값
  ```

  ```xml
  - mapred-site.xml에 property 추가(mapred-site.xml.template 복사해서 만들고 추가)
  <configuration>
     <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
     </property>   
  </configuration>
  
  - yarn-site.xml에 property추가
  <configuration>
  <!-- Site specific YARN configuration properties -->
      <property>
            <name>yarn.nodemanager.aux-services</name>
            <value>mapreduce_shuffle</value>
      </property>
      <property>
            <name>yarn.resourcemanager.hostname</name>
            <value>master</value>
      </property>
      <property>
            <name>yarn.resourcemanager.webapp.address</name>
            <value>${yarn.resourcemanager.hostname}:8088</value>
      </property>
      <property>
            <name>yarn.nodemanager.resource.memory-mb</name>
            <value>4096</value>
      </property>
      <property>
            <name>yarn.scheduler.minimum-allocation-mb</name>
            <value>2048</value>
      </property>
  </configuration>
  ```

  ```bash
  - master의 mapreduce설정 파일들 slave에 모두 복사
  # scp [복사할 파일] root@[호스트네임 즉, slave명]:/root/hadoop-2.7.7/etc/hadoop
  
  - yarn 실행
  # start-yarn.sh
  
  - yarn으로 jar파일 안의 내용을 읽어서 작업 처리
  ex) 
  1. jar풀어 wordcount명령 실행하여 /output/test1에 저장
  # yarn jar hadoop-mapreduce-examples-2.7.7.jar wordcount /edudata/fruit.txt /output/test2
  2. test2파일 읽음
  # hdfs dfs -cat /output/test2/part-r-00000
  
  - 파이어폭스로 접속하여 yarn 상태 확인
  url = http://master:8088/cluster
  ```

  

- Eclipse에서 MapReduce를 수행하는 자바 소스

  ```java
  - WordCountMapper Class 소스
    public class WordCountMapper extends
           Mapper<LongWritable, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();   
    public void map(LongWritable key, Text value, Context context)
     				 throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }
  }
  
  - WordCountReduce Class 소스
  public class WordCountReducer extends
            Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable result = new IntWritable();
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
      			       throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
    }
  }
  
  - WordCount Class Main 소스
  public class WordCount {
    public static void main(String[] args) throws Exception {
      Configuration conf = new Configuration();
      conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
     
      Job job = Job.getInstance(conf);
  
      job.setJarByClass(WordCount.class);
      job.setMapperClass(WordCountMapper.class);
      job.setReducerClass(WordCountReducer.class);
  
      job.setInputFormatClass(TextInputFormat.class);
      job.setOutputFormatClass(TextOutputFormat.class);
  
      job.setOutputKeyClass(Text.class);
      job.setOutputValueClass(IntWritable.class);
  
      FileInputFormat.addInputPath(job, new Path("/edudata/fruit.txt"));
      FileOutputFormat.setOutputPath(job, new Path("/output/result"));
  
      job.waitForCompletion(true);
    }
  }
  ```