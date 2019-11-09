# [ Java Install Method ]

## Direct Down and Install Method

```bash
## [Oracle 홈페이지 접속 로그인, 라이센스 동의 후 자바 tar.gz 다운로드]
# [wget 설치시 라이센스 동의 문제로 다운로드 실패할 경우]
# 1. GUI 환경 : 접속 후 다운로드 | 2. 윈도우 다운 후 FTP 전송
$ wget [URL]

$ sudo mv jdk1.8.xxx.tar.gz /usr/local/java

$ cd /usr/local/java/

$ tar -xvzf jdk.1.8.xxx.tar.gz

$ sudo vi /etc/profile
...
export JAVA_HOME=/usr/local/java/jdk1.8.xxx
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib
(:wq)

$ source /etc/profile

$ java -version

$ javac
```

## Installer Packages Method

```bash
$ tar zxvf jdk-8u144-linux-x64.tar.gz

$ sudo mkdir /usr/lib/jvm

$ sudo mv jdk1.8.0_144 /usr/lib/jvm

$ sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.8.0_144/bin/java 1

$ sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk1.8.0_144/bin/javac 1

$ sudo update-alternatives --install /usr/bin/javaws javaws /usr/lib/jvm/jdk1.8.0_144/bin/javaws 1

$ sudo update-alternatives --config java

$ sudo update-alternatives --config javac

$ sudo update-alternatives --config javaws
```