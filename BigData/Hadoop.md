# [ Hadoop ]

### < 정의 >

- HDFS(저장) + MapReduce(파일처리) -> upgrade시킨 것이 Spark
  - cluster
    - 여러 대의 컴퓨터들이 연결되어 하나의 시스템처럼 동작하는 컴퓨터들의 집합을 말함
  - HDFS(하둡분산파일시스템)
    - **NameNode와 여러 개의 DataNode로 연결**된다. 명령어 또는 직접 프로그램을 만들어서(java) 사용한다. 파일을 block단위(128M 또는 128G)로 쪼개서 같은 rack에 2개 다른 rack에 1개를 저장한다.
    - DataNode는 주기적으로 **하트비트**를 NameNode에 보내 살아있음을 알린다. **SecondaryNameNode**는 meta 데이터를 주기적으로 갱신해준다. NameNode가 실행되지 않는 것을 염려해 active NameNode, standby NameNode로 나눠 준비할 수도 있다.

### < 설치 전 준비사항 >

- 가상머신 - 리눅스(centos) 설치
  - 경로는 centos 폴더 안에 가상머신 폴더 새로 생성
  - Single vmdk 선택
  - HDD 40G, Memory 2G, (USB, Sound, Printer) 삭제
  - 언어 - 한국어, 키보드 - 영어(미국) 추가
  - 소프트웨어 선택 - 개발 및 창조를 위한 워크스테이션 선택 - 완료
  - 네트워크 설정 동작시키기 - 호스트이름 master로 변경
  - 파티션 직접 설정 - swap (용량의 10~15%), / (전체 설정)
  - root 비번, 계정 추가할 경우에는 설정추가
  - 설치 후 재부팅
- 설치한 가상리눅스 복제
  - centos 폴더 복사 붙여넣기
  - 폴더명 변경
  - 폴더 안에 확장자 .vmx 파일 텍스트파일로 열기
  - Display 속성 찾아서 속성값을 폴더명과 일치시켜 변경하기
  - vmware player 실행시켜 edit에서 [network] - [advanced] - mac주소 [generate]하여 mac주소 변경
- 복제한 맥 번호
  - m2 = 00:50:56:2C:97:EF
  - m3 = 00:50:56:39:04:5B
  - m4 = 00:50:56:34:82:DB

## < Hadoop HDFS 명령어 >

- Hadoop Document URL : [Document 이동](**https://hadoop.apache.org/docs/r2.7.7/hadoop-project-dist/hadoop-common/FileSystemShell.html**)

  ```bash
  # hdfs dfs -ls /[디렉토리명 또는 파일명]
  지정된 디렉토리의 파일리스트 또는 지정된 파일의 정보를 보여준다.
  
  # hdfs dfs -lsr /[디렉토리명]
  지정된 디렉토리의 파일리스트 및 서브디렉토리들의 파일 리스트도 보여준다.
  
  # hdfs dfs -mkdir /디렉토리명
  지정된 디렉토리를 생성한다.
  
  # hdfs dfs -cat /[디렉토리/]파일
  지정된 파일의 내용을 화면에 출력한다.
  
  # hdfs dfs -put 사용자계정로컬파일 HDFS디렉터리[/파일]
  지정된 사용자계정 로컬 파일시스템의 파일을 HDFS 상 디렉터리의 파일로 복사한다.
  
  # hdfs dfs -get HDFS디렉터리의파일  사용자계정로컬 디렉터리[/파일]
  지정된 HDFS상의 파일을 사용자계정 로컬 파일시스템의 디렉터리나 파일로 복사한다.
  
  # hdfs dfs -rm /[디렉토리]/파일
  지정된 파일을 삭제한다.
  
  # hdfs dfs -rmr /디렉토리
  지정된 디렉터리를 삭제. 비어 있지않은 디렉터리도 삭제하며 서브 디렉토리도 삭제한다.
  
  # hdfs dfs -tail /[디렉토리]/파일
  지정된 파일의 마지막 1kb 내용을 화면에 출력한다.
  
  # hdfs dfs –chmod 사용자허가모드 /[디렉토리명 또는 파일명]
  지정된 디렉토리 또는 파일의 사용자 허가 모드를 변경한다.
  
  # hdfs dfs -mv /[디렉토리]/old파일 /[디렉토리]/new파일
  지정된 디렉토리의 파일을 다른 이름으로 변경하거나 다른 폴더로 이동한다.
  ```

### < 하둡 완전 분산모드 설치 과정 >

- 각 가상머신별 설정 변경

  ```bash
  - /etc/sysconfig/network-eno..... 를 vi에디터로 mac주소와 ip주소를 변경(고정)
  상단에 MAC주소 변경 필수
  master : 192.168.111.120
  slave1 : 192.168.111.130
  slave2 : 192.168.111.140
  slave3 : 192.168.111.150
  
  - hostnamectl set-hostname [변경할 hostname명] 으로 변경(각 가상머신별로 다르게)
  # hostnamectl set-hostname slave1
  # hostnamectl set-hostname slave2
  # hostnamectl set-hostname slave3
  
  - /etc/hosts 를 vi에디터로 열어 가장 아래에 가상머신별로 ip주소와 hostname을 등록한다(모든 가상머신에)
  ```

- SSH Key생성을 통해 다른 시스템과 공유

  ```bash
  - 비밀번호 없이 로그인이 가능하도록 하는 것으로 다음 명령을 master 시스템에서 수행시켜서 공개키를 만든다.
  (참고 : 시큐어 셸(Secure Shell, SSH)은 네트워크 상의 다른 컴퓨터에 로그인하거나 원격 시스템에서 명령을 실행하고 다른 시스템으로 파일을 복사할 수 있도록 해 주는 응용 프로그램 또는 그 프로토콜을 가리킨다.)
  [hadoop@master ~]$ ssh-keygen -t rsa    
  	Generating public/private rsa key pair.
  	Enter file in which to save the key (/root/.ssh/id_rsa): 그냥엔터
  	Created directory '/root/.ssh'.
  	Enter passphrase (empty for no passphrase) : 그냥엔터
  	Enter same passphrase again: 그냥엔터
  	
  - 공개키를 생성한 다음에는 다음 명령을 수행시켜서 공개키를 나머지 리눅스 시스템과 공유한다.
  	[root@master ~]$ ssh-copy-id  –i  /root/.ssh/id_rsa.pub  root@slave1
  	[root@master ~]$ ssh-copy-id  –i  /root/.ssh/id_rsa.pub  root@slave2
  	[root@master ~]$ ssh-copy-id  –i  /root/.ssh/id_rsa.pub  root@slave3
  	[root@master ~]$ ssh-copy-id  –i  /root/.ssh/id_rsa.pub  root@master
  
  - 각 가상머신으로 접속하여 로그인 암호를 요구할시 설정이 잘못된것
  [root@master ~]$ ssh root@slave1
  Last login: 날짜
  [root@master ~]$ logout
  Connection to slave1 closed
  ---> 이런식으로 등록한 모든 slave(slave 1, 2, 3), master를 확인한다
  ```

- 홈디렉토리의 .bashrc 파일에 다음 내용을 추가한다.

  ```bash
  export HADOOP_HOME=/root/hadoop-2.7.7
  export PATH=$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$PATH
  ```

- Hadoop의 설정파일 디렉토리로 옮겨간다

  ```bash
  cd $HADOOP_HOME/etc/hadoop
  ```

- Hadoop 폴더안에 설정파일에 다음 내용들을 추가한다

  ```bash
  - hadoop-env.sh 파일 끝에 다음 내용을 추가한다.
  export JAVA_HOME=/usr/local/java
  export HADOOP_HOME=/root/hadoop-2.7.7
  export HADOOP_HEAPSIZE=500
  
  - mapred-env.sh 파일 끝에 다음 내용을 추가한다.
  export JAVA_HOME=/usr/local/java
  export HADOOP_JOB_HISTORYSERVER_HEAPSIZE=500
  export HADOOP_HOME=/root/hadoop-2.7.7
  
  - yarn-env.sh 파일 끝에 다음 내용을 추가한다.
  export JAVA_HOME=/usr/local/java
  export YARN_HEAPSIZE=500
  export HADOOP_HOME=/root/hadoop-2.7.7
  
  (편리한 방식)
  scp mapred-env.sh@slave1:/root/hadoop-2.7.7/etc/hadoop
  현재 mapred-env.sh를 slave1의 폴더경로에 복사해라라는 명령
  ```

- 다음 내용들도 추가

  ```xml
  - core-site.xml 에 다음 내용을 편집한다.
  <configuration>
     <property>
        <name>fs.defaultFS</name>
        <value>hdfs://master:9000/</value>
     </property>   
  </configuration>
  
  - hdfs-site.xml 에 다음 내용을 편집한다.
  <configuration>
     <property>
        <name>dfs.replication</name>
        <value>3</value>
     </property>
     <property>
        <name>dfs.name.dir</name>
        <value>/root/hadoop-2.7.7/hdfs/name</value>
     </property>
     <property>
        <name>dfs.data.dir</name>
        <value>/root/hadoop-2.7.7/hdfs/data</value>
     </property>
     <property>
        <name>dfs.support.append</name>
        <value>true</value>
     </property>
     <property>
        <name>dfs.namenode.secondary.http-address</name>
        <value>slave1:50090</value>
     </property>
     <property>
        <name>dfs.namenode.secondary.https-address</name>
        <value>slave1:50091</value>
     </property> 
  </configuration>
  
  - mapred-site.xml 에 다음 내용을 편집한다.
  <configuration>
     <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
     </property>
     <property>
        <name>yarn.resourcemanager.hostname</name>
        <value>master</value>
     </property>
  </configuration>
  
  
  - yarn-site.xml 에 다음 내용을 편집한다. 
  <configuration>
  <!-- Site specific YARN configuration properties -->
     <property>
        <name>yarn.nodemanager.aux-services</name>
        <value>mapreduce_shuffle</value>
     </property>
  </configuration>
  
  - slaves 파일을 다음 내용으로 편집한다.
  Localhost를 지우고 slave1, slave2, slave3를 추가한다(반드시 행단위로 작성)
  slave1
  slave2
  slave3
  ```

- 하둡 시스템을 포맷한다(반드시 master에서만 수행해야한다)

  ```bash
  hdfs namenode -format
  ```

- Hadoop의 HDFS를 기동시킨다

  ```
  start-dfs.sh
  ```

- Hadoop의 HDFS 설치 완료여부를 확인한다

  ```
  - 데몬이 제대로 수행되었는지 확인한다. – jps 사용( JVM Process Status )
  # jps
  master : NameNode
  slave1, slave2, slave3 : DataNode
  slave1 : SecondaryNameNode
  ```
  
-  웹 페이지에서 저장된 블록 채크

  ```
  http://master:50070/
  ```

- Hadoop의 HDFS 데몬 종료

  ```
  stop-dfs.sh
  ```

- 하둡 DHFS 영역에 폴더를 구축한다.

  ```bash
  강사시스템에서 파일 세개를 가져가서 리눅스의 sampledata 디렉토리에 넣고 압축파일은 압축을 푼다.
     ( 압축해제 명령 : bzip2 -kd 2008.csv.bz2 )
  # hdfs dfs -ls /
  # hdfs dfs -mkdir /edudata
  # hdfs dfs -chmod 777 /edudata
  # hafs dfs -put /root/sampledata/파일명   /edudata
  # hdfs dfs -ls /edudata
  ```

- eclipse 설치

  ```
  1.tools폴더에 eclipse 설치
  2.mv eclipse .. (root로 옮기기)
  3.cd eclipse
  4.eclipse 실행(./eclipse)
  ```

- maven 변환

  ```xml
  1.java project 생성
  2.[configure] - [convert maven project]
  3.pom.xml에 dependency 추가
  <dependency>
  	<groupId>org.apache.hadoop</groupId>
  	<artifactId>hadoop-common</artifactId>
  	<version>2.7.7</version>
  </dependency>
  <dependency>
  	<groupId>org.apache.hadoop</groupId>
  	<artifactId>hadoop-client</artifactId>
  	<version>2.7.7</version>
  </dependency>
  ```

- Java와 Hadoop 연동

  ```xml
  - hadoop File I/O Dependency
  <dependency>
     <groupId>org.apache.hadoop</groupId>
     <artifactId>hadoop-common</artifactId>
     <version>2.7.7</version>
  </dependency>
  	
  <dependency>
     <groupId>org.apache.hadoop</groupId>
     <artifactId>hadoop-client</artifactId>
     <version>2.7.7</version>
  </dependency>
  <dependency>
     <groupId>org.apache.hadoop</groupId>
     <artifactId>hadoop-mapreduce-client-core</artifactId>
     <version>2.7.7</version>
  </dependency>
  
  <dependency>
     <groupId>org.apache.hadoop</groupId>
     <artifactId>hadoop-annotations</artifactId>
     <version>2.7.7</version>
  </dependency> 
  	
  <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.6</version>
  </dependency>
   
  <dependency>
     <groupId>org.springframework.data</groupId>
     <artifactId>spring-data-hadoop</artifactId>
     <version>2.5.0.RELEASE</version>
  </dependency>
  	
  		
  <!-- https://mvnrepository.com/artifact/jdk.tools/jdk.tools -->
  <dependency>
  	<groupId>jdk.tools</groupId>
  	<artifactId>jdk.tools</artifactId>
  	<version>1.8</version>
  	<scope>system</scope>
  	<systemPath>C:/Program Files/Java/jdk1.8.0_211/lib/tools.jar</systemPath>
  </dependency>
  ```

- Hadoop HDFS 프로그램 구현

  ```java
  // 파일 복사
    Configuration config = new Configuration();
    FileSystem hdfs = FileSystem.get(config);
    Path srcPath = new Path(srcFile);
    Path dstPath = new Path(dstFile);
    hdfs.copyFromLocalFile(srcPath, dstPath);
  
    // 파일 생성
    Configuration config = new Configuration();
    FileSystem hdfs = FileSystem.get(config);
    Path path = new Path(fileName);
    FSDataOutputStream outputStream = hdfs.create(path);
    outputStream.write(buff, 0, buff.length);
  
    // 파일명 변경
    Configuration config = new Configuration();
    FileSystem hdfs = FileSystem.get(config);
    Path fromPath = new Path(fromFileName);
    Path toPath = new Path(toFileName);
    boolean isRenamed = hdfs.rename(fromPath, toPath);
    // 파일 삭제
    Configuration config = new Configuration();
    FileSystem hdfs = FileSystem.get(config);
    Path path = new Path(fileName);
    boolean isDeleted = hdfs.delete(path, false);
  
    // 재귀적으로 파일 삭제
    Configuration config = new Configuration();
    FileSystem hdfs = FileSystem.get(config);
    Path path = new Path(fileName);
    boolean isDeleted = hdfs.delete(path, true);
  
    // 리스트 출력
    Configuration config = new Configuration();
    FileSystem fs = FileSystem.get(URI.create(uri), config);
      
    Path[] paths = new Path[args.length];
       for (int i = 0; i < paths.length; i++) {
          paths[i] = new Path(args[i]);
    }
      
    FileStatus[] status = fs.listStatus(paths);
    Path[] listedPaths = FileUtil.stat2Paths(status);
    for (Path p : listedPaths) {
       System.out.println(p);
    }
  ```

- **[ HADOOP HDFS** **주요 API 정리  URL]**

  ```html
  <http://hadoop.apache.org/docs/r2.7.7/api/index.html?org/apache/hadoop/fs/package-summary.html>
  ```

  ```java
  org.ahache.hadoop.conf.Configuration
  void addResource(String name)      	설정 리소스를 추가한다.
  void set(String name, String value)      	key와 value 값을 설정한다.
  
  org.apache.hadoop.fs.Path
  FileSystem getFileSystem(Configuration conf)      
  NameNode에 의해 관리되는 FileSystem 객체를 리턴한다.
  
  org.apache.hadoop.fs.FileSystem
  FSDataInputStream open(Path f)       
  지정된 Path 객체에 대한 FSDatatInputStream 객체를 리턴한다.
  FSDataOutputStream create(Path f)      
  지정된 Path 객체에 대한 FSDataOutputStream 객체를 리턴한다.
  FSDataOutputStream create(Path f, boolean overwrite) 
  지정된 Path 객체에 대한 FSDataOutputStream 객체를 리턴한다.
  FSDataOutputStream append(Path f)     
  지정된 Path 객체에 대한 FSDataOutputStream 객체를 리턴한다.
      
  boolean delete(Path f, boolean recusive)      
  경로에 해당되는 파일을 삭제한다.
  boolean exists(Path f)      
  경로가 존재하는지 여부를 반환한다.
  static FileSystem get(Configuration conf)      
  주어진 Configuration에 대한 FileSystem 객체를 리턴한다.
  FileStatus getFileStatus(Path f)      
  FileStatus 객체를 반환한다.
  boolean isDirectory(Path f)      
  경로가 디렉토리인지의 여부를 리턴한다.
  boolean isFile(Path f)      
  경로가 파일인지의 여부를 리턴한다.
      
  static FileSystem newInstance(Configuration conf)  
  주어진 Configuration에 대한 FileSystem 객체를 리턴한다.
  FSDataInputStream open(Path f)      
  주어진 경로에 대한 FSDataInputStream 객체를 오픈한다.
  
  org.apache.hadoop.fs.FileStatus
  int getBlockSize()       
  파일의 블록사이즈를 반환한다.
  long getLangth()       
  파일의 길이(바이트 단위)를 리턴한다.
  ```