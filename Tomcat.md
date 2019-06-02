# [ Tomcat ]

## 톰캣 관련 명령어

### 1. Tomcat 설치

```
sudo apt-get install tomcat8

홈페이지에서 설치파일 우클릭 설치경로 복사 - 터미널 wget 명령어로 설치 - tar zxvf 파일이름 - 설치완료 (/usr/local로 이동)

알집설치시 환경설정

#nano /etc/profile에서 가장 밑줄에 아래문장 추가

export CATALINA_HOME=/usr/local/apache-tomcat-[톰켓 버전]

export CLASSPATH=.:$CATALINA_HOME/lib/jsp-api.jar:$CATALINA_HOME/lib/servlet-api.jar

PATH=$PATH:$CATALINA_HOME/bin	(저장)

#source /etc/profie 명령어로 설정파일 적용

- 포트번호 변경

#nano /usr/local/apache-tomcoat-[version]/conf/server.xml

<Connector port="8080" 부분을 변경(oracle도 8080으로 겹치기에 필수) ..... >
```

### 2. Tomcat 제거

```
sudo apt-get remove tomcat8
```

### 3. Tomcat 상태 확인

```
ps -ef | grep tomcat

netstat -nlp (기본 활성 3개)
```

### 4. Tomcat 버전 확인

```
sudo /usr/share/tomcat8/bin/version.sh
```

### 5. Tomcat 시작

```
sudo service tomcat8 start

톰캣 bin폴더에서 ./startup.sh 실행

#cd /usr/local/apache-tomcat-톰캣버전/bin

#sudo sh startup.sh   (관리자 권한으로 필수)

주소에 http://ip주소 or http://localhost:포트번호/폴더/파일이름.확장자
```

### 6. Tomcat 정지

```
sudo service tomcat8 stop

톰캣 bin폴더에서 ./shutdown.sh 실행
```

### 7. Tomcat 재시작

```
sudo service tomcat8 restart
```

###  Tomcat 설치경로

```
/usr/share/tomcat8  →  executable & libraries

/var/lib/tomcat8  →  conf & webapps

tomcat 알집 해제 폴더
```

출처: https://all-record.tistory.com/182