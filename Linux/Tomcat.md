# [ Tomcat ]

## 톰캣 관련 명령어

### 1. Tomcat 설치

```
sudo apt-get install tomcat9

홈페이지에서 설치파일 우클릭 설치경로 복사 - 터미널 wget 명령어로 설치 - tar zxvf 파일이름 - 설치완료 (/usr/local or /opt로 이동)

*알집설치시 환경변수 설정*

#nano /etc/profile에서 가장 밑줄에 아래문장 추가

export CATALINA_HOME=/usr/local/apache-tomcat-[톰켓 버전]

export CLASSPATH=.:$CATALINA_HOME/lib/jsp-api.jar:$CATALINA_HOME/lib/servlet-api.jar

PATH=$PATH:$CATALINA_HOME/bin	(저장)

#source /etc/profie 명령어로 설정파일 적용

- 포트번호 변경

#nano /usr/local/apache-tomcoat-[version]/conf/server.xml

<Connector port="8080" 부분을 변경(oracle도 8080으로 겹치기에 필수) ..... >

or
- 홈페이지 url경로를 통해 직접 다운
wget http://apache.tt.co.kr/tomcat/tomcat-9/v9.0.27/bin/apache-tomcat-9.0.27.tar.gz
```

### 2. Tomcat 제거

```
sudo apt-get remove tomcat9
```

### 3. Tomcat 상태 확인

```
ps -ef | grep tomcat

netstat -nlp (기본 활성 3개)
```

### 4. Tomcat 버전 확인

```
sudo /usr/share/tomcat9/bin/version.sh
```

### 5. Tomcat 시작

```
sudo service tomcat9 start

톰캣 bin폴더에서 ./startup.sh 실행

#cd /usr/local/apache-tomcat-톰캣버전/bin

#sudo sh startup.sh   (관리자 권한으로 필수)

주소에 http://ip주소 or http://localhost:포트번호/폴더/파일이름.확장자
```

### 6. Tomcat 정지

```
sudo service tomcat9 stop

톰캣 bin폴더에서 ./shutdown.sh 실행
```

### 7. Tomcat 재시작

```
sudo service tomcat9 restart
```

### 8. Tomcat Service 등록

- 톰캣 유저 등록

```bash
$ sudo groupadd tomcat
$ sudo useradd -M -s /bin/nologin -g tomcat -d /usr/local/tomcat tomcat
```

- 권한 조정

```bash
$ cd /usr/local/tomcat
$ sudo chmod -R g+r conf
$ sudo chmod g+x conf
$ sudo chown -R tomcat webapps/ work/ temp/ logs/
```

- 설정 파일 등록

```bash
$ sudo vi /etc/systemd/system/tomcat.service
```

```bash
# Systemd unit file for tomcat
[Unit]
Description=Apache Tomcat Web Application Container
After=syslog.target network.target

[Service]
Type=forking

Environment="JAVA_HOME=/usr/java/jdk-10.0.1/"  <-- 자바 경로
Environment="CATALINA_PID=/usr/local/tomcat/temp/tomcat.pid"
Environment="CATALINA_HOME=/usr/local/tomcat"  <-- 톰캣 경로
Environment="CATALINA_BASE=/usr/local/tomcat"  <-- 톰캣 경로
Environment="CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC"
Environment="JAVA_OPTS=-Djava.security.egd=file:///dev/urandom"

ExecStart=/usr/local/tomcat/bin/startup.sh
ExecStop=/usr/local/tomcat/bin/shutdown.sh

User=tomcat
Group=tomcat
UMask=0007
RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target
```

### 9. Tomcat Service 기동

```bash
$ sudo systemctl daemon-reload
$ sudo systemctl enable tomcat
$ sudo systemctl start tomcat
```

### 10. Tomcat Service 중지

```bash
$ sudo systemctl stop tomcat
```

###  Tomcat 설치경로

```
/usr/share/tomcat9  →  executable & libraries
/var/lib/tomcat9  →  conf & webapps
/usr/local
/opt
```

출처: https://all-record.tistory.com/1827

### Tomcat 웹 폴더 장소

```
설치한 톰캣 경로 기준으로 시작
/apache-tomcat-버전/
# cd webapps/ROOT
```

