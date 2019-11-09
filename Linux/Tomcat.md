# [ Tomcat ]

## Tomcat Environment Build Method

### 1. Tomcat 설치

```bash
$ sudo apt-get install tomcat9
or
# 홈페이지 url경로를 통해 직접 다운(이 방법을 추천함!! -> 문서 하단에 서비스 등록 방법 기재)
# 홈페이지에서 설치파일 우클릭 설치경로 복사 - 터미널 wget 명령어로 설치 - tar zxvf 파일이름 - 설치완료 
$ $ wget http://apache.tt.co.kr/tomcat/tomcat-9/v9.0.27/bin/apache-tomcat-9.0.27.tar.gz

# /usr/local or /opt로 이동
$ cd /usr/local
$ cd /opt

# tomcat 폴더 생성후 압축 풀기
$ mkdir tomcat
$ mv apache-tomcat-9.0.27.tar.gz
$ tar -xvzf apache-tomcat-9.0.27.tar.gz

# 알집설치시 환경변수 설정(톰캣 위치에 따라 경로 수정해야하는 것 명심하기)
$ nano /etc/profile에서 가장 밑줄에 아래문장 추가
export CATALINA_HOME=/opt/tomcat/apache-tomcat-[톰켓 버전]
export CLASSPATH=.:$CATALINA_HOME/lib/jsp-api.jar:$CATALINA_HOME/lib/servlet-api.jar
PATH=$PATH:$CATALINA_HOME/bin
:wq (저장)

$ source /etc/profie -> 명령어로 설정파일 적용

# 포트번호 변경
$ nano /usr/local/apache-tomcoat-[version]/conf/server.xml
...
<Connector port="8080" 부분을 변경(oracle도 8080으로 겹치기에 필수) ..... >
...
```

### 2. Tomcat 제거

```bash
$ sudo apt-get remove tomcat9
```

### 3. Tomcat 상태 확인

```bash
$ ps -ef | grep tomcat

$ netstat -nlp (기본 활성 3개)
```

### 4. Tomcat 버전 확인

```bash
$ sudo /usr/share/tomcat9/bin/version.sh
```

### 5. Tomcat 시작

```bash
$ sudo service tomcat start

# 톰캣 bin폴더에서 ./startup.sh 실행
$ cd /usr/local/apache-tomcat-톰캣버전/bin
$ sudo sh startup.sh   (관리자 권한으로 필수)
or
$ ./startup.sh

# 주소에 http://ip주소 or http://localhost:포트번호/폴더/파일이름.확장자
```

### 6. Tomcat 정지

```bash
$ sudo service tomcat stop
or
# 또는 톰캣 bin폴더에서 ./shutdown.sh 직접 실행
$ ./shutdown.sh
```

### 7. Tomcat 재시작

```bash
$ sudo service tomcat restart
```



## Tomcat Service 등록

- 조건 : Java 설치, 톰캣 다운로드 필수

- Create a Tomcat directory

  ``` bash
  $ mkdir /opt/tomcat
  $ mv apache-tomcat-9.0.8/ /opt/tomcat
  ```

- Create a Tomcat user

  ```bash
  $ sudo groupadd tomcat
  $ useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
  or
  $ sudo useradd -M -s /bin/nologin -g tomcat -d /usr/local/tomcat tomcat
  ```

- Update permissions to Tomcat

  ```bash
  $ chgrp -R tomcat /opt/tomcat
  $ cd /opt/tomcat/apache-tomcat-9.0.8
  $ chmod -R g+r conf
  $ chmod g+x conf
  $ chown -R tomcat webapps/ work/ temp/ logs/
  ```

- Create a Systemd Service File

  ```bash
  $ sudo vi /etc/systemd/system/tomcat.service
  ```

  ```
  [Unit] 
  Description=Apache Tomcat
  After=syslog.target network.target
  
  [Service] 
  Type=forking
  
  Environment=JAVA_HOME=/usr/local/java
  Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'
  
  Environment=CATALINA_PID=/opt/tomcat/apache-tomcat-9.0.27/temp/tomcat.pid
  Environment=CATALINA_HOME=/opt/tomcat/apache-tomcat-9.0.27
  Environment=CATALINA_BASE=/opt/tomcat/apache-tomcat-9.0.27
  Environment='CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC'
  
  WorkingDirectory=/opt/tomcat/apache-tomcat-9.0.27
  ExecStart=/opt/tomcat/apache-tomcat-9.0.27/bin/startup.sh
  ExecStop=/opt/tomcat/apache-tomcat-9.0.27/bin/shutdown.sh
  
  User=tomcat
  Group=tomcat
  
  UMask=0007
  RestartSec=10
  Restart=always
  
  [Install] 
  WantedBy=multi-user.target
  ```

- Reload the Sytsemd File

  ```bash
  $ systemctl daemon-reload
  ```

- Restart Tomcat 

  ```bash
  $ systemctl start tomcat
  ```

- Management Tomcat Service

  ```bash
  # 톰캣 서비스 시작
  $ systemctl start tomcat
  # 톰캣 서비스 중지
  $ systemctl stop tomcat
  # 톰캣 서비스 다시시작
  $ systemctl restart tomcat
  # 톰캣 상태 확인
  $ systemctl status tomcat
  ```

- Auto start at boot settings Tomcat Service

  ```bash
  # 부팅시 톰캣 자동시작
  $ sudo systemctl start tomcat
  # 부팅시 톰캣 자동시작 해재
  $ sudo systemctl disable tomcat
  ```

###  Tomcat 설치경로

```
/usr/share/tomcat9  →  executable & libraries
/var/lib/tomcat9  →  conf & webapps
/usr/local
/opt
```

### Tomcat 기본 웹 폴더 장소

```bash
# 설치한 톰캣 경로 기준으로 시작
# /apache-tomcat-버전/
$ cd webapps/ROOT
```

### Reference Site

> https://www.liquidweb.com/kb/how-to-install-apache-tomcat-9-on-ubuntu-18-04/
>
> https://phoenixnap.com/kb/how-to-install-tomcat-ubuntu
>
> https://all-record.tistory.com/1827