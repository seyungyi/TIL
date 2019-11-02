# [ AWS Ubuntu Settings ]

## Table of Contents

- [Index](#index)
- [Create EC2 Instance in AWS](#create_ec2_instance_in_aws)
- [Basic](#basic)
- [Firewall](#firewall)
- [SSH](#ssh)
- [FTP](#ftp)
- [Java](#java)
- [Tomcat](#tomcat)
- [Database](#database)
- [R](#r)
- [RStudio](#rstudio)

# Index

- Amazon Web Serve EC2 프리티어 인스턴스를 기준으로 기본적인 Web 배포 환경을 구성하는 방법 정리하였음

## Create EC2 Instance in AWS

- EC2 Free tier 생성하기
- Default로 1~5단계 통과
- 네트워크 보안은 개인 IP설정하는 것을 권장함
- Key Pair 다운로드 및 Instance 생성
- 접속
  - PuttyGen 사용, 다운받은 .pem 파일을 Key파일 생성 후 putty 접속 방법
  - git bash에서 .pem을 이용한 ssh 접속 방법

> 아래의 모든 command 명령 수행은 root 권한을 가지고 실행하기에 sudo 생략
>
> apt-get update | apt-get upgrade 수행

## Basic

- 외부에서 AWS 내부로 접속하려고 하는 포트 번호를 설정 - [인바운드 편집]

- root 패스워드 수정

  ```bash
  $ sudo passwd root
  ```

- 신규 유저 추가

  ```bash
  $ adduser [user명]
  $ sudo passwd [user명]
  ```

- 계정에 root권한 부여

  ```bash
  $ vi /ettc/sudouser
  root ALL=(ALL:ALL)	ALL 
  [유저명] ALL=(ALL:ALL)	ALL 추가
  ```

- 같은 key pair로 로그인 가능하게 하기

  ```bash
  # ubuntu의 .ssh 디렉토리를 newuser 계정으로 복사
  $ sudo cp /home/ubuntu/.ssh/ /home/newuser/.ssh/
  or
  $ sudo cp -r /home/ubuntu/.ssh/ /home/hwkim/.ssh/
  # 복사한 key-pair 소유자를 [유저명]으로 변경
  $ sudo chown -R newuser:newuser /home/newuser/.ssh
  ```
  
- 호스트명 수정

  ```bash
  $ sudo vi /etc/hosts
  [IP주소] [호스트네임]
  ```

- 시간 설정하기

  ```bash
  $ date
  [Default] UTC 타임존
  # 타임존 목록 확인(서울)
  $ timedatectl list-timezones | grep Seoul
  # 변경[KST 타임존]
  $ timedatectl set-timezone Asia/Seoul
  $ timedatectl
  ```
  
- 설치 파일 및 FTP 전송 파일 관리를 위한 폴더

  ```bash
  $ mkdir tools
  ```

## Firewall

- 방화벽 켜기/끄기

  ```bash
  $ ufw enable
  $ ufw disable
  ```
  
- 방화벽 개방 및 차단

  ```bash
  $ ufw allow [포트번호 or 서비스명]/[프로토콜]
  $ ufw deny [포트번호 or 서비스명]/[프로토콜]
  ```
  
- 방화벽 규칙 제거

  ```bash
  ufw delete (allow/deny) [포트]/[프로토콜]
  ```

- 방화벽 특정 IP 막기

  ```bash
  $ ufw deny from [아이피주소]
  ```

- 방화벽 상태 보기

  ```bash
  $ ufw status
  ```

## SSH

- SSH 서버 패키지 확인

  ```bash
  $ rpm -qa | grep openssh-server
  openssh-server-7.4p1-16.el7.x86_64
  ```

- SSH 설치

  ```bash
  $ sudo apt-get install openssh-server
  ```

- SSH Config

  ```bash
  $ vi /etc/ssh/sshd_config
  ## 아래 주석을 해제
  PermitRootLogin prohibit_password=YES
  ```

- SSH 서비스 재시작

  ```bash
  $ service ssh restart
  ```

## FTP

- vsftpd 설치 패키지 존재여부 확인

  ```bash
  $ apt search vsftpd 
  ```

- vsftpd Package 방식 설치

  ```bash
  $ apt-get install vsftpd
  ```

- vsftpd 실행 상태보기 및 네트워크 포트 보기

  ```bash
  $ service vsftpd status
  $ netstat -natp | grep [ftp or LISTEN or port]
  ## vsftpd 는 TCP 21번 포트로 LISTEN 상태 확인
  ```
  
- FTP 접근 설정 파일 수정

  ```bash
  $ vi /etc/vsftpd.conf
  listen=YES
  listen_ipv6=NO
  anonymous_enable=NO
  port_enable=NO
  pasv_enable=YES
  local_enable=YES
  write_enable=YES
  use_localtime=YES
  xferlog_enable=YES
  chroot_local_user=YES
  allow_writeable_chroot=YES
  secure_chroot_dir=/var/run/vsftpd/empty
  pam_service_name=vsftpd
  ## ftpd_banner : 최초연결시 표시되는 환영메세지입니다. 하지만 대부분의 FTP클라이언트에서 무시하는 값입니다.
  ftpd_banner=Welcome to My FTP Server!
  ## ssh_enambe:인증서가 올바르지 않지만 안전하게 보안 통신합니다. 만약 당신의 소프트웨어가 보안연결을 지원하지 않는다면 NO로 바꿔주세요
  ssl_enable=YES
  rsa_cert_file=/etc/ssl/certs/ssl-cert-snakeoil.pem
  rsa_private_key_file=/etc/ssl/private/ssl-cert-snakeoil.key
  ## listen_port : FTP 접속 포트입니다. TCP 21 번을 사용합니다.
  listen_port=21
  ## pasv_min_port, pasv_max_port : FTP PASV 통신모드에서 사용할 포트입니다. 이 예제에서는 TCP 60020 ~ 60030 포트를 사용하게 설정했습니다.
  ## 즉 방화벽에서 TCP 21, TCP 60020~60030 번을 허용 설정해주어야 합니다.
  pasv_min_port=60020
  pasv_max_port=60030
  #utf8_filesystem=YES
  local_umask=022
  ```
  
- 로그인 및 파일전송 로그 기록 저장 경로

  ```bash
  $ cat /var/log/vsftd.log
  ```

- FTP 로그인 거부 설정

  ```bash
  ## 파일에 쓰여진 사용자는 FTP 로그인이 거부됨
  $ vi /etc/ftpusers
  ```

- 서비스 재시작

  ```bash
  $ service vsfptd restart
  ```

- IPTABLES 방화벽에서 FTP 설정 관련 코드 예시

  - 특정 IP에 대해서 접속 허용

    ```bash
    $ -A INPUT -s [ip번호]/[포트] -p tcp -m state --state NEW -m tcp --dport 21 -j ACCEPT
    $ -A INPUT -s [ip번호]/[포트] -p tcp -m state --state NEW -m tcp --dport 60020:60030 -j ACCEPT
    ```

  - IP 제한 없이 접속 허용

    ```bash
    $ -A INPUT -p tcp -m state --state NEW -m tcp --dport 21 -j ACCEPT
    $ -A INPUT -p tcp -m state --state NEW -m tcp --dport 60020:60030 -j ACCEPT
    ```

## Java

- OpenJDK 설치 방식

  ```bash
  $ sudo apt-get install oracle-java8-installer
  or
  $ sudo apt-get install openjdk-8-jdk
  $ sudo apt-get install openjdk-8-jre
  ```

  - 환경변수 자동 설정

    ```bash
    $ sudo apt-get install oracle-java8-set-default
    # 환경변수 확인
    $ sudo su - root -c 'printenv'
    ```

  - 환경변수 수동 설정

    1. javac 경로 확인

       ```bash
       $ readlink -f /usr/bin/javac
       ```

    2. profile 수정

       ```bash
       $ vi /etc/profile
       export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
       ```

    3. JAVA_HOME 확인

       ```bash
       $ echo $JAVA_HOME
       $ $JAVA_HOME/bin/javac -version
       ```

- 직접 다운 방식

  - wget 사용시 라이센스 동의문제로 FTP 전송 이용

    > https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

  - 압축 해제, 폴더 이동 후 심볼릭 링크 설정

    ```bash
    $ tar -xvzf jdk-1.8.xxx.tar.gz
    $ mv jdk-1.8.xxx/ /usr/local/
    $ cd /usr/local
    # 심볼릭 링크 설정
    $ ln -s jdk-1.8.xxx/ java
    ```
    
- Java 환경변수 설정
  
  ```bash
    # 환경변수 설정 파일
    $ vi /etc/profile
    ## 제일 아래 행에 추가 -> [Shift] + g
    export JAVA_HOME=/usr/local/java
    export PATH=$JAVA_HOME/bin:$PATH
    export CLASSPATH=$JAVA_HOME/lib
    # 환경변수 적용
    $ source /etc/profile
    $ java -version
    $ javac -version
    ```
  
- 여러 개의 버전이 설치되어있을 경우

  - 설치된 자바 목록에서 Defalut Java 선택 가능

    ```bash
    $ sudo update-alternatives --config java
    ```

## Tomcat

- Package Installer 설치 방식

  ```bash
  # 1. Tomcat 설치
  sudo apt-get install tomcat9
  # 2. Tomcat 제거
  sudo apt-get remove tomcat9
  # 3. Tomcat 상태 확인
  ps -ef | grep tomcat
  # 4. Tomcat 버전 확인
  sudo /usr/share/tomcat9/bin/version.sh
  # 5. Tomcat 시작
  sudo service tomcat9 start
  # 6. Tomcat 정지
  sudo service tomcat9 stop
  # 7. Tomcat 재시작
  sudo service tomcat9 restart
  ```
  
- 수동 설치 방식

  - Tomcat 홈페이지에서 tar.gz 설치파일 링크 주소 복사

    > http://tomcat.apache.org/

  - 링크주소 파일 내려받기

    ```bash
    $ wget [Tomcat Url]
    ```

  - 압축 해제, 폴더 이동 후 심볼릭 링크 설정

    ```bash
    $ tar -xvzf apache-tomcat-
    $ mv apache-tomcat-/ /usr/local
    $ cd /usr/local
    ## 심볼릭 링크 설정
    $ ln -s apache-tomcat-/ tomcat
    ```
    
- Tomcat 기동과 종료
  
  ```bash
    $ cd /usr/local/tomcat/bin
    # 톰캣 기동
    $ ./startup.sh
    # 톰캣 정지
    $ ./shutdown.sh
    ```
    
  - Tomcat Service 등록
  
  1. Tomcat User 등록
  
     ```bash
       $ sudo groupadd tomcat
     $ sudo useradd -M -s /bin/nologin -g tomcat -d /usr/local/tomcat tomcat
       ```
  
    2. 권한 조정
  
     ```bash
       $ chgrp -R tomcat /usr/local/tomcat
     $ chmod -R g+r conf
       $ chmod g+x conf
       $ chown -R tomcat webapps/ work/ temp/ logs/
       ```
  
    3. systemd 설정파일 등록
  
     ```bash
       $ sudo vi /etc/systemd/system/tomcat.service
     ```
  
       ```
       # Systemd unit file for tomcat
     [Unit]
       Description=Apache Tomcat Web Application Container
       After=syslog.target network.target
       
       [Service]
       Type=forking
       
       Environment="JAVA_HOME=/usr/local/java"
       Environment="CATALINA_PID=/usr/local/tomcat/temp/tomcat.pid"
       Environment="CATALINA_HOME=/usr/local/tomcat"
       Environment="CATALINA_BASE=/usr/local/tomcat"
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
  
  - systemd 재시작 및 관리
  
  ``` bash
    $ systemctl daemon-reload
  $ systemctl enable tomcat
    $ systemctl start tomcat
    $ systemctl stop tomcat
    $ systemctl restart tomcat
    ```

## Database

- Select database tool is MariaDB

- Apt Configuration

  ```bash
  $ sudo apt-get install software-properties-common
  $ sudo apt-key adv --recv-keys --keyserver hkp://keyserver.ubuntu.com:80 0xF1656F24C74CD1D8
  $ sudo vim /etc/apt/sources.list.d/mariadb.list
  # MariaDB 10.3 Repository
  deb [arch=amd64,arm64,ppc64el] http://sfo1.mirrors.digitalocean.com/mariadb/repo/10.3/ubuntu bionic main
  deb-src http://sfo1.mirrors.digitalocean.com/mariadb/repo/10.3/ubuntu bionic main
  ```
  
- MariaDB-server install

  ```bash
  $ sudo apt-get update
  $ sudo apt-get install mariadb-server
  ```

- MariaDB 상태 확인

  ```bash
  $ sudo systemctl status mariadb
  ```

- MariaDB root password 설정(최초 설치시 비밀번호 없음)

  ```bash
  ## 최초 설치시 패스워드는 없음
  $ mysql -u root -p
  Enter password: [Enter로 그냥 통과]
  
  ...
  MariaDB [(none)]>
  
  ## 사용자 확인
  MariaDB [(none)]> use mysql;
  MariaDB [(mysql)]> SELECT HOST, USER, PASSWORD, SUPER_PRIV FROM USER;
  ```

  ```mysql
  MariaDB [(none)]> use mysql;
  MariaDB [(none)]> INSERT INTO user passwored=password('변경비밀번호') WHERE user='root'
  ```

- Database 생성

  ```mysql
  MariaDB [(none)]> create database [database명];
  MariaDB [(none)]> show dateabases;
  ```

- 사용자 계정 추가 및 데이터베이스 접속 권한 설정(내부, 외부)

  ```mysql
  # 사용자 계정 생성
  MariaDB [(mysql)]> CREATE USER '아이디'@'%' IDENTIFIED BY '비밀번호';
  # 사용자 권한 주기
  ## '%'는 모든 외부 접속 허용
  MariaDB [(mysql)]> GRANT ALL PRIVILEGES ON [데이터베이스].* TO '아이디'@'%';
  # 새로고침
  MariaDB [(mysql)]> FLUSH PRIVILEGES;
  ```

- 사용자 계정 삭제

  ```mysql
  MariaDB [(mysql)]> DROP USER [사용자]@[서버];
  ```

- 방화벽 포트 허용

  ```bash
  $ ufw allow 3306
  or
  $ ufw allow mariaDB
  ```

- Manage MariaDB Service

  ```bash
  $ sudo systemctl stop mariadb.service      # To Stop MariaDB service 
  $ sudo systemctl start mariadb.service     # To Start MariaDB service 
  $ sudo systemctl status mariadb.service    # To Check MariaDB service status 
  $ sudo systemctl restart mariadb.service   # To Stop then Start MariaDB service 
  ```

## R

- GPG key 등록

  ```bash
  $ sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys E298A3A825C0D65DFD57CBB651716619E084DAB9
  ```
  
- R Project Ubuntu list 등록

  ```bash
  $ sudo add-apt-repository 'deb https://cloud.r-project.org/bin/linux/ubuntu disco-cran35/'
  or
  $ sudo add-apt-repository 'deb https://cloud.r-project.org/bin/linux/ubuntu cosmic-cran35/'
  or
  $ sudo add-apt-repository 'deb https://cloud.r-project.org/bin/linux/ubuntu bionic-cran35/'
  or
  $ sudo add-apt-repository 'deb https://cloud.r-project.org/bin/linux/ubuntu xenial-cran35/'
  or
  $ sudo add-apt-repository 'deb https://cloud.r-project.org/bin/linux/ubuntu trusty-cran35/'
  ```
  
- apt package 방식으로 설치

  ```bash
  $ apt-get update
  $ apt-get install -y r-base
  ```
  
- R 실행

  ```bash
  $ sudo -i R
  ```

## RStudio-Server

-  Intall rstudio-server

  ```bash
  $ sudo apt-get install gdebi-core
  $ wget https://download2.rstudio.org/server/bionic/amd64/rstudio-server-1.2.5001-amd64.deb
  $ sudo gdebi rstudio-server-1.2.5001-amd64.deb
  ```

- RStudio status 확인

  ```bash
  $ rstudio-server status
  ```

- RStudio service manage

  ```bash
  $ rstudio-server start
  $ rstudio-server stop
  $ rstudio-server restart
  ```

- Rstudio-server 웹브라우저 접속

  > https://[aws접속IP:8787]









