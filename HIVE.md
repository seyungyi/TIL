# [ HIVE ]

## < HIVE 정의 >

- Apache Hive 데이터웨어 하우스 소프트웨어는 SQL을 사용하여 분산 스토리지(HDFS)에 있는 대규모 데이터 세트의
  읽기, 쓰기 및 관리를 용이하게 한다. 
- 스토리지에 있는 데이터에 스키마를 정의하고 스키마 기반의 SQL을 사용해서 데이터의 처리가 가능하다.
- Hive에 연결하기 위한 명령과 JDBC 드라이버가 제공된다.

## < HIVE 특징 >

- Apache Hive는 MapReduce 기반의 High-Level Abstraction
  - HiveQL은 SQL-like 언어를 사용
  - Hadoop 클러스터에서 MapReduce 잡을 생성함
  - Facebook에서 데이터 웨어하우스를 위해 개발되었음
- Hive는 Client Machine에서 동작
  - HiveQL 질의문을 MapReduce job 으로 변환
  - jobs 을 클러스터에 등록
- Hive는 데이터 포맷과 위치를 가지고 있는 metasotre 를 가지고 있음
  - 질의문 자체는 파일시스템(HDFS)에 저장되어 있는 데이터에게 질의 함

## < HIVE 설치와 환경설정 >

1. tools 디렉토리로 옮겨가서 다음 명령을 수행하고 HIVE 프로그램을 내려 받는다.

   ```bash
   # wget  http://apache.tt.co.kr/hive/hive-2.3.5/apache-hive-2.3.5-bin.tar.gz
   ```

2. 압축을 해제한 다음에 apache-hive-2.3.5 폴더를 홈 디렉토리로 이동한 후 apache-hive로 폴더명을 변경한다

3. 홈디렉토리의 .bashrc 제일 하단에 다음 내용을 추가한다

   ```bash
   export HIVE_HOME=/root/apache-hive
   export PATH=$HIVE_HOME/bin:$PATH
   ```

4. .bashrc를 source 명령어를 수행한다

5. HIVE 의 conf 디렉토리로 이동한다. (cd  $HIVE_HOME/conf) 

   ```bash
   hive-env.sh.template 을 hive-env.sh 으로 복사한다.
   hive-default.xml.template  을 hive-site.xml 로 복사한다
   ```

6. hive-env.sh 에 하둡의 홈디렉토리를 추가한다

   ```bash
   HADOOP_HOME=/root/hadoop-2.7.7
   ```

7. hive-site.xml 파일을 오픈하여 다음 내용대로 수정한다.

   ```xml
   ** vi에디터에서 :set number 수행하면 행번호 출력 **
   ** vi에디터에서 :행번호 를 수행하면 해당 행으로 이동 **
   75행     <value>/root/apache-hive/hivetmp</value>
   80행     <value>/root/apache-hive/${hive.session.id}_resources</value>
   1685행   <value>/root/apache-hive/hivetmp</value>
   3976행   <value>/root/apache-hive/hivetmp/operation_logs</value>
   <!-- <name>hive.server2.enable.doAs</name> -->
   <!-- remote에서의 접근권한 설정 -->
   4359행	<value>false</value>
   ```

8. HADOOP 의 HDFS 에 HIVE 에서 사용될 디렉토리들을 생성하고 사용자 허가모드를  777 로 만든다.

   ```bash
   # hdfs dfs  -mkdir  /tmp/hive
   # hdfs dfs  -chmod  777  /tmp/hive
   # hdfs dfs  -mkdir  -p /user/hive/warehouse
   # hdfs dfs  -chmod  777  /user/hive/warehouse
   ```

9. root 계정의 홈디렉토리에서 다음 명령을 수행해서 derby 데이터베이스를 포맷한다.

   ```bash
   # schematool -initSchema -dbType derby
   ```

10. HIVE 서버를 기동시킨다. - 항상 root 계정의 홈디렉토리에서 수행시킨다.

    ```bash
    # hiveserver2
    ```

11. HIVE 클라이언트를 기동시킨다.

    ```bash
    [root@master ~]# beeline
    Beeline version 1.2.1.spark2 by Apache Hive
    beeline> !connect jdbc:hive2://192.168.111.120:10000/default
    Connecting to jdbc:hive2://192.168.111.120:10000/default
    Enter username for jdbc:hive2://192.168.111.120:10000/default: root
    Enter password for jdbc:hive2://192.168.111.120:10000/default: ********
    19/08/03 08:38:28 INFO jdbc.Utils: Supplied authorities: 192.168.111.120:10000
    19/08/03 08:38:28 INFO jdbc.Utils: Resolved authority: 192.168.111.120:10000
    19/08/03 08:38:29 INFO jdbc.HiveConnection: Will try to open client transport with
    JDBC Uri: jdbc:hive2://192.168.111.120:10000/default
    Connected to: Apache Hive (version 2.3.5)
    Driver: Hive JDBC (version 1.2.1.spark2)
    Transaction isolation: TRANSACTION_REPEATABLE_READ 
    0: jdbc:hive2://192.168.111.120:10000/default>
    다음 명령을 수행하여 현재 만들어져 있는 데이터베이스를 채크한다.
    0: jdbc:hive2://localhost:10000/default> show databases;
    학습용 데이터베이스를 생성한다.
    0: jdbc:hive2://localhost:10000/default> create database mydb;
    0: jdbc:hive2://localhost:10000/default> show databases;
    0: jdbc:hive2://localhost:10000/default> !quit     <---------  beeline 종료 명령어
    ```
    
12. mydb라는 데이터베이스로 하이브에 접속한다.

    ```bash
    $ beeline 
    beeline> !connect  jdbc:hive2://192.169.111.120:10000/mydb
    Enter username for jdbc:hive2://localhost:10000/default: root
    Enter password for jdbc:hive2://localhost:10000/default: ********
    (참고 : beeline -u  jdbc:hive2://192.168.111.120:10000/DB명  -n  계정  -p 암호)
    ```

13. 테이블 생성과 데이터 저장(모든 명령은 한 줄에 쭉 이어서 작성)

    ​    HIVE 로 접근하기 위한 HDFS 파일의 스펙에 따라 테이블 생성

    ```mysql
    create table clicklog(clickdate string, pid string) 
    row format delimited fields terminated by ' ' lines terminated by '\n' stored as textfile; 
    
    생성된 테이블에 로컬 파일 시스템의 데이터 파일 로드
    load data local inpath '/root/sampledata/product_click.log'  into table clicklog;
    
    --> 위의 명령은 로컬 파일 시스템의 파일을 HIVE 테이블의 데이터 파일로 저장하는 것이다. 
    하둡 파일 시스템의        	/user/hive/warehouse/mydb.db/clicklog/product_click.log 의 내용을 확인한다.
    --> 새 터미널로 내용을 확인할 시 source .bashrc를 반드시 수행해야한다.(변경된 설정내용은 logout 또는 reboot시 적용되기에 다른 터미널에서 source한 것은 해당 터미널에서만 적용됨.)
    
    다음 SQL 명령들도 수행시켜본다. 
    	select clickdate from clicklog;           		
    	select pid from clicklog;
    	select * from clicklog;     			
    	select * from clicklog order by pid;
    	describe database mydb;			
    	describe clicklog;
    	select pid, count(pid) from clicklog group by pid;
     	select pid, count(pid) from clicklog group by pid limit 5;
    select pid,count(pid)clickcount from clicklog group by pid order by clickcount;
    ```

14. 파티션 기능을 활용한 테이블 활용

    ```mysql
    - 테이블을 생성(파티션 포맷 설정) : 추가 공부 필요함
    create table subway (line string, time string, ride int, takeoff int) 
    partitioned by (linep string) 
    row  format  delimited fields terminated by  ','  lines terminated by  '\n' stored  as  textfile ;
    
    - Linux 환경에 존재하는 파일을 Hive로 불러오면서 table에 파티션별로 저장할 수 있음
    load data local inpath '/root/sampledata/subway_line_1.csv'  
    into table subway partition (linep = 'line_1');
    
    load data local inpath '/root/sampledata/subway_line_2.csv' 
    into table subway partition (linep = 'line_2');
    
    load data local inpath '/root/sampledata/subway_line_3.csv' 
    into table subway partition (linep = 'line_3');
    
    load data local inpath '/root/sampledata/subway_line_4.csv' 
    into table subway partition (linep = 'line_4');
    
    select * from subway;
    select * from subway where linep='line_3';
    ```

    ```bash
    - HIVE에 불러오기가 정상적으로 되었는지 확인
    hadoop fs -ls /user/hive/warehouse/mydb.db/subway/
    
    - HIVE에 불러오기 한 파일을 파티션 부분을 출력
    hadoop fs -cat /user/hive/warehouse/mydb.db/subway/linep=line_1/subway_line_1.csv
    ```

    ```xml
    [ HIVE 클라이언트 구현시 pom.xml 에 넣어야 하는 내용 ]
    	<dependency>
    		<groupId>org.apache.hive</groupId>
    		<artifactId>hive-jdbc</artifactId>
    		<version>2.3.5</version>
    	</dependency>
    
    [ spring-context.xml 에 넣어야 하는 내용 ]
       <bean id="hiveDriver" class="org.apache.hive.jdbc.HiveDriver"/>
       <bean id="hiveDataSource" 
           		class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
      	<constructor-arg name="driver" ref="hiveDriver"/>
      	<constructor-arg name="url" value="jdbc:hive2://192.168.111.120:10000/mydb"/>
      	<constructor-arg name="username" value="root"/>
      	<constructor-arg name="password" value="password"/>
       </bean>
    ```

- 소스

  ```java
  Class.forName("org.apache.hive.jdbc.HiveDriver");
  Connection conn = DriverManager.getConnection
  				("jdbc:hive2://192.168.111.120:10000/mydb", "root", "password");		
  Statement stmt = conn.createStatement();
  String sql = "show tables";
  System.out.println("-------------------------------");
  System.out.println("Running: " + sql);
  ResultSet rs = stmt.executeQuery(sql);
  while(rs.next()) {
  	System.out.println(rs.getString(1));
  }
  rs = stmt.executeQuery("select * from clicklog");
  while (rs.next()) {
  	System.out.println(rs.getString(1) + "\t" + rs.getString(2));
  }
  rs.close();
  stmt.close();
  conn.close();
  ```