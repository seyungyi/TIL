# [ Selenium&Rserve_ Deployments ]

# Rserve 서버

- ## Download Rserve

  ```R
  > install.packages("Rserve")
  > quit()
  ```

- ## Start Rserve

  ```bash
  $ R CMD Rserve --RS-encoding utf8
  or
  $ R CMD Rserve --RS-port 6311
  ```

- ## Kill Rserve

  ```bash
  $ netstat -tnlp | grep 6311
  $ kill -9 PID번호
  ```

## RSelenium 서버

- ## Prerequisites(전제조건)

  1. 서버 업데이트

  2. XVFB(X virtual framebuffer) 설치

     - XVFB : UNIX 유사 운영 체제(예: Linux)를 위한 메모리 내 디스플레이 서버
     - 디스플레이 없이 X11 디스플레이 서버 프로토콜을 구현함
     - CI 서비스 같은 CLI 애플리케이션에 유용함

     ```bash
     $ sudo apt-get update
     $ sudo apt-get install -y uznip xvfb libxi6 libgconf-2-4
     ```

  3. Java 8 설치

     ```bash
     $ sudo apt-get install default-jdk
     or
     홈페이지에서 tar.gz 다운후 압축 해제하여 경로 설정
     ```

- ## Install Google Chrome(최신 크롬패키지 설치)

  - Google 크롬 헤드리스 기능 : 자동화를 위한 멀티파이프 도어를 열게 함

  ```bash
  $ sudo curl -sS -o - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add
  $ sudo echo "deb [arch=amd64]  http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
  $ sudo apt-get -y update
  $ sudo apt-get -y install google-chrome-stable
  ```

- ## Install ChromeDriver

  1. 크롬드라이버 설치

     - 크롬을 위한 WebDriver의 유선 프로토콜을 구현하는 독립형 서버
     - WebDriver는 여러 브라우저에서 웹 앱의 자동 테스트를 위한 오픈 소스 툴

     ```bash
     $ wget https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip
     $ unzip chromedriver_linux64.zip
     ```

  2. 명령을 실행하여 시스템에서 ChromeDriver를 구성

     ```bash
     $ sudo mv chromedriver /usr/bin/chromedriver
     $ sudo chown root:root /usr/bin/chromedriver
     $ sudo chmod +x /usr/bin/chromedriver
     ```

- ## Download Required Jar Files

  1. 원격 Selenium WebDrivers를 실행하려면 Selenium Server가 필요함

  2. Selenium 독립 실행형 서버 jar 파일을 다운로드 또는 홈페이지에서 다운

     ```bash
     $ wget https://selenium-release.storage.googleapis.com/3.13/selenium-server-standalone-3.13.0.jar
     or
     $ wget http://www.java2s.com/Code/JarDownload/testng/testng-6.8.7.jar.zip
     unzip testng-6.8.7.jar.zip
     ```

- ## Start Chrome via Selenium Server

  1. **Run Chrome via Selenium Server** - 1

     ```bash
     $ java -jar selenium-server-standalone-3.13.0.jar -port number
     ```

  2. **Run Chrome via Selenium Server** - 2

     ```bash
     $ xvfb-run java -Dwebdriver.chrome.driver=/usr/bin/chromedriver -jar selenium-server-standalone.jar
     or
     디버그 모드에서 서버 실행(헤드리스 크롬드라이버 실행)
     $ chromedriver --url-base=/wd/hub
     ```

## PhantomJS

- Headless Browser로서 GUI 그래픽 환경이 없어도 백그라운드에서 웹 브라우저의 동적 실행을 가능하게 한다



