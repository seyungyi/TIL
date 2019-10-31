# Linux

## 1. Linux 개요

- CentOS 리눅스는 RedHat의 비상용화(무료)된 리눅스이다.

- **가상머신(VM)**

  가상으로 존재하는 컴퓨터 즉 가짜 컴퓨터를 말한다.

- **가상머신 소프트웨어**

  가상머신을 생성하는 소프트웨어를 말한다.

- pc에 이미 설치되어있는 운영체제를 **호스트 OS**, 가상머신에 설치할 그외 운영체제를 **게스트 OS**라 한다.

- 멀티부팅과는 개념이 다르다.

  cf) 멀티부팅은 어떤 시스템으로 부팅했느냐에 따라 하나의 운영체제를 사용하는 것이다.

- **VMware**

  가상머신을 만들어주는 프로그램이다.

## 2. VMware Player 설치방법

1. License accept 체크

2. Enhanced Keyboard Driver 체크

3. Check for product updates on startup,

   Help impove VMware Workstation 12 Player **체크해제**

4. Desktop, Start Menu Programs folder 체크

5. Finish - Restart

6. C:\Program Files (x86)\VMware\VMware Player 에 vmnetcfg.exe프로그램 옮겨넣기

7. 명령프롬프트 - ipconfig (교재 p.66 네트워크 정보 파악과 변경 참고)

8. vmnetcfg.exe 더블클릭 - NAT 호스트OS의 네트워크 환경을 빌려서 사용한다.

9. 192.168.111.0에서 세번째 자리를 **111**로 바꿔준다.

10. 명령프롬프트 - ipconfig - VMnet8에서 192.168.111.1로 바뀌었는지 확인 (외부에서는 이 ip로 사용한다.)

## 3. CentOS 리눅스

리눅스 - 안드로이드, 임베디드 프로그램, 라즈베리파이 모두 기본바탕은 리눅스이다.

유닉스는 1970년도 벨 연구소에서 나왔다. 유닉스라는 운영체제를 개발하기 위해 C 언어가 나왔다. 리눅스는 GNU프로젝트를 바탕으로 리누스 토르발스가 만들었다.

- 리눅스 배포판 구성

  하드웨어+**커널**(엄격한 의미의 리눅스)+셸(명령어 처리기)+응용프로그램으로 구성된다.

## 4. CentOS 설치

1. VMware Workstation 12 Player 클릭 - 첫 번째 것에 이메일 입력, Finish
2. C:\CentOS\linuxM - 로컬디스크 C아래에 폴더생성
3. create a new virtual machine
4. I will install the operating system later 선택 후 next
5. Linux - CentOS 64-bit 선택
6. linuxM 이름 설정 - C:\CentOS\linuxM 경로 설정
7. maximum disk size 20.0 - store virtual disk as a single file
8. finish
9. edit virtual machine settings 클릭 - cd/dvd (ide) - use iso image file(CentOS-7.0-1406-x86_64-DVD.iso) 설정
10. usb controller, sound card, printer remove - Ok
11. play virtual machine 클릭
12. remind me later, Ok
13. 한국어 선택 - 계속 진행
14. 소프트웨어 선택 - 개발 및 창조를 위한 워크스테이션 - 완료
15. 네트워크 및 호스트 이름 클릭 - Ethernet 끔을 켬으로 바꿈
16. 호스트이름 : linuxserver로 변경 - 완료
17. 설치대상 - 20GB 선택 - 파티션을 설정합니다 - 완료 - 표준 파티션 선택 - +버튼 - 마운트 지점 : swap 선택(메모리 부족할 때 사용하는 공간) - 원하는 용량 : 2G - 마운트 지점 : /
18. 변경사항을 적용
19. 설치시작
20. Root 암호 : password - 완료버튼 2번
21. 사용자 생성 - 이름,암호 : centos - 완료버튼 2번
22. 재부팅 - 약관동의 - 완료 - 설정완료
23. kdump 활성화 해제 - 앞으로 - 예 - 확인
24. 목록에 없습니까 - 사용자이름 : root - 암호 : password - 한국어 - 밑에 있는 한국어(-버튼) - 영어(미국)(+버튼) - 다음 - 다음 (p. 교재 102까지) - start using centos linux
25. 컴퓨터 끄고 cd/dvd 기본으로, memory 4GB로 바꾸기
26. oracleXE와 oracleListener 중지하면 더 빨라짐
27. 고정 IP 수정 (p.117쪽 참고)

- [JDK 1.8 설치](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

  1. tools 폴더에 jsk압출파일을 붙여놓고 터미널을 통해 'tar xvfz 파일이름' 명령어를 입력해 압축을 풀어준다.

  tar : 묶어놓기만 한 것이다. / tar.gz : 묶어놓고 압축도 한 것이다.

  **/etc** : 시스템 정보와 관련된 파일들이 들어있다.

  **/usr** : JDK와 같은 개발 툴을 보관하는 디렉토리이다.

  **/tmp** : 여러 목적의 임시 폴더와 파일들이 생성되는 디렉토리이다.

  **/dev** : 리눅스에서 관리되는 장치들에 대한 파일을 보관하는 디렉토리이다.

  1. mv jdk1.8.0_131 /usr 명령어를 통해 JDK파일을 이동한다.
  2. gedit **/etc/profile** : **전역적 환경 설정 파일**이다.
  3. export JAVA_HOME=/usr/jdk1.8.0_131 export PATH=$JAVA_HOME/bin:$PATH 입력한다. (blank를 주면 안된다!)
  4. source /etc/profile 명령어를 입력해 강제적으로 profile을 다시 실행시킨다.

- javaexample 생성

  1. vi FirstApp.java 명령어 입력
  2. 파일 입력
  3. javac FirstApp.java 명령어 입력
  4. java FirstApp 명령어 입력(클래스 이름만 입력해야한다. .뒤에는 package 확장자로 인식한다.)
  5. vi SecondApp.java 명령어 입력
  6. 파일 입력(package화)
  7. **javac -d . SecondApp.java** : . 자리에 다른 디렉토리를 줘도 된다. (띄어쓰기 주의!!) , 컴파일해준다.
  8. ls test
  9. java test.SecondApp : package가 되어있는 파일은 앞에 package명을 붙여주어야 한다.
  10. 2yy 명령어(커서가 있는 행부터 2행을 복사한다.) - p 명령어(커서가 있는 행 다음에 붙여넣는다.)
  11. class B로 수정
  12. r 명령어(커서가 있는 문자를 replace해준다.)
  13. cw 명령어(커서가 있는 단어를 지운다.) - esc누르고 커서가 있는 곳에서 .을 누르면 마지막 명령어를 다시 수행한다.

- eclipse 설치

  1. 파이어폭스 - 환경설정 - root - tools
  2. [[www.eclipse.org](http://www.eclipse.org/)] - Eclipse 2018-12 - Linux 64bit
  3. cd ../tools 또는 cd /root/tools
  4. tar xvfz e + tab키
  5. mv eclipse .. 또는 mv eclipse /root
  6. cd eclipse - ./ eclipse
  7. Firstapp 파일 생성 및 컴파일

------

## 사용자 관리와 파일 속성

| Windows 운영체제   | Linux 운영체제     |
| ------------------ | ------------------ |
| 단일 사용자 시스템 | 다중 사용자 시스템 |

- **ps** - process status (현재 수행중인 프로그램)
- PID : process id / kill -9 PID : 프로세스를 강제로 죽인다.
- **ps -ef** : pts/0 어느 터미널인지 알 수 있다.
- **ps -ef|more** : 페이지 단위로 보여준다.
- **ps -ef|grep eclipse** : eclipse 단어가 들어가있는 내용을 보여준다.

- tty : 가상콘솔이다.
- sleep 50 : 50초 동안 정지한다. 슈퍼 유저만 가능하다.
- ps -ef|grep sleep, kill -9 pid

파일 허가권

- 생성되는 모든 파일과 디렉토리는 사용자 허가모드가 정해져 있다.

- 사용자 허가모드 : 읽기(r), 쓰기(w), 실행(x)

- 사용자 종류 : 소유자(owner), 그룹(group), 그외 사용자(other)

  ```
  - rw- r-- r--
  - : 일반 텍스트 파일
  rw- : 읽기, 쓰기(소유자)
  r-- : 읽기 (그룹, 그외 사용자)
  ```

- **su centos** : 임시 유저이다. 일반 유저의 경우 $이 붙는다.

  / ctrl + D : 임시 유저에서 나간다.

- 사용자 허가모드 변경

  - **chmod 허가모드스펙 대상파일명** :

    ​	rwxrwxrwx ( 3개씩 쪼개 8진수로 표현)

    ​	110100100 (지정 : 1, 미지정 : 0) (644) -> rw-r--r--

     110110100 (664) -> rw-rw-r--

    ​	110110110 (666) -> rw-rw-rw-

    ​	111111111 (777) -> rwxrwxrwx

  - 추가하고 싶으면 + 빼고 싶으면 -

  - a+rwx

  - g+rw

  - d+rwx

  - o+r

------

## vi (visual editor)

1. 2가지 모드가 존재한다.

   **입력모드** : 입력되는 문자를 **입력 데이터로 인식**한다.

   **명령모드** : 입력되는 문자를 **편집 명령어로 인식**한다.

   - **x : 현재 커서 위치의 문자 1개를 삭제**한다. / 3x
   - **dd** : 현재 커서 위치의 1행을 삭제한다. / 5dd / (dd-p : 잘라내기-붙이기)
   - **yy** : 현재 커서 위치의 1행을 복사한다. / 4yy / (yy-p : 복사-붙이기)
   - **p** : 아래행에 붙인다.
   - **dw** : 현재 커서 위치의 단어를 삭제한다.
   - **u** : undo
   - **.** : redo (마지막 명령을 반복한다.)
   - **:set nu, :숫자** : 출력할 때 행넘버를 만든다. 실제 파일내용으로 들어가지는 않는다. (마지막행으로 : shift+g)
   - **/찾을단어** : 단어를 찾아준다.
   - **n** : forward 방향으로 다음 단어를 찾는다.
   - **N** : 역방향으로 이전 단어를 찾는다.
   - **:s/old단어/new단어** : old단어를 찾아서 new단어로 바꾼다.
   - 그 밖에 : gg(문단 첫번째 문자), G(문단 끝 문자), Home,^(현재 행 첫번째 문자), End,$(현재 행 끝 문자)

2. 편집 명령어가 알파벳 문자이다.

3. **초기에는 명령모드이다!!!** 명령모드 -> 입력모드로 변환하려면

   **a(현재 위치에서 다음 컬럼), i(현재 위치), o(아래 빈 행이 열린다.)** 문자를 입력해야한다.

4. 입력모드 -> 명령모드로 변환하려면 **ESC 키**를 누른다.

5. 저장 - **:w.** / 종료 - **:q.**(수정된 부분이 있으면 종료가 안됨.) / 강제종료 - **:q!** / 저장+종료 - **:wq, shiftkey + zz**

------

## 리눅스 명령어

- tab 키로 자동완성기능을 제공한다.

- 추가옵션을 줄 때는 한 칸 띄고 줘야한다.

- ifconfig : window의 ipconfig와 같다.

- **pwd** : print working directory의 약어이다. 현재 위치한 디렉토리를 출력한다.

- **ls** : 현재 디렉토리의 파일 리스트를 보여준다. **ls -a**(hidden파일), **ls -l**, **ls -al**, **ls 디렉토리정보**, **ll**

- **cd** : change directory의 약어이다.

  cd 절대패스 : 최상위 디렉토리로부터 지정한다. ex) cd /tmp, cd /etc/sysconfig

  cd 상대패스 : 현재 디렉토리로부터 지정한다. ex) cd ../../tmp

  cd + Enter : 홈 디렉토리로 이동한다. (로그인을 했을 떄 최초로 존재하게 되는 디렉토리를 **홈 디렉토리**라고 한다. 계정마다 홈디렉토리는 다르다.)

  ./ : 현재 디렉토리에서 시작한다.

  ../ : 상위 디렉토리로 올라가라는 의미이다.

- **cd etc** : **현재 디렉토리 밑의 etc**로 이동한다.

- **cd /etc** : **최상위 디렉토리(root) 밑의 etc**로 이동한다.

- cp : 파일복사

  - cp old파일명 new파일명 : old 파일내용에 new 파일내용을 복사한다.

  - cp old파일 디렉토리 : 파일을 디렉토리 자리에 복사한다.

    ex) cp FirstApp.java ThirdApp.java

    ​	cp FirstApp.java /tmp : tmp 폴더 안에 FirstApp.java로 복사된다.

     cp FirstApp.java /tmp/New.java :

    ​	cp tools /tmp : tmp 폴더 안에 tools 폴더만 생성된다.

    ​	cp **-r** tools /tmp : tools라는 폴더 안 파일까지 tmp 폴더로 복사한다. (-r : recursive)

- mv : 파일이동, 파일명 변경

  - mv 파일명 디렉토리 : 주어진 디렉토리로 이동한다.
  - mv 파일명 디렉토리/new파일명
  - **mv old파일명 new파일명** : 파일명을 변경한다. (old파일은 없어진다.)

- mkdir&rmdir

  - **mkdir** : make directory의 약어이다. 새로운 디렉토리를 생성한다.
  - rmdir : 디렉토리가 비어있어야 삭제해준다. 파일 안에 서브 폴더가 들어있으면 에러가 난다.
  - rm : 파일을 삭제한다. 파일을 정말 삭제할건지 물어본다.
  - rm -r 디렉토리: 디렉토리까지 삭제한다. (남이 만든 파일은 삭제할 수 없다.)
  - **rm -f 파일명**: 파일을 삭제할 건지 묻지 않고 삭제한다.
  - rm -rf : 현재 디렉토리와 하위 서브 디렉토리까지 모두 삭제한다. (조심히 사용해야함!)

- tar : 아카이브(컬렉션) 생성, 풀기, 리스트보기

  - tar cvf 아카이브파일명 파일리스트... : 아카이브파일로 묶는다. cvf(create)

  - tar xvf 아카이브파일명 : 아카이브파일을 푼다.

  - tar tvf 아카이브파일명 : 아카이브파일 내용을 확인한다.

  - ex) tar cvf myApp.tar *.class : .class로 끝나는 파일 모두를 tar로 묶는 것이다.

    ​	tar cvf tools.tar tools : tools폴더를 tar로 묶는 것이다.

     gzip myApp.tar : myApp.tar.gz로 압축한다.

     gzip -d myApp.tar.gz : myApp.tar로 풀어준다.

     (= tar xvf**z** 파일이름 : zip 압축을 풀고 아카이브 파일도 푼다.)

- 파일 내용 체크

  : cat(여러 개의 파일을 연결해서 보여줌), head(앞 행), tail(끝 행), more(페이지 단위로 보여줌)

- 파일의 내용을 출력하거나 편집기로 오픈하지 않고도 체크

  : **grep** 찾으려는단어 파일명 / ex) grep unico *.txt (unico가 들어가있는 행을 출력함)

- 파일 시스템(디렉토리와 일반파일로 구성)에서 어떤 명칭의 파일이 어디있는지 체크 :

  find 폴더명 -name 파일명

  find / -name test.java (전체 파일 시스템에서 찾는다.)

  find /tmp -name test.java

  find tools -name test.java

  find dir1/dir2 -name test.java

- **>, >>, |**

  ex) cat Test.java > Output.java : 출력방향을 Output.java로 한다.

  ​	ls -al > list.txt : ls -al 수행결과를 redirection하여 파일에 저장한다.

  ​	cd

   ls -al > /tmp/list.txt

   cd tools

   ls -al **>** /tmp/list.txt (마지막에 수행된 결과만 저장된다.)(overriding)

  ​	ls -al **>>** /tmp/list.txt (마지막에 수행된 결과를 추가로 저장한다.)(append)

​	ls -al | more : ls -al의 결과를 다음 명령의 입력데이터로 준다. (| : 명령이다.)

​	ls -al | wc -l : ls -al의 결과를 wc 명령어한테 준다. (wc : 텍스트 라인 수를 출력한다.)

​	명령1 | 명령2 | 명령3 : 명령1의 결과를 받아 명령2를 수행하고 그 결과로 명령3을 수행한다.

- hostname : 현재 설치한 서버이름을 출력한다. (hostnamectl set-hostname 서버이름 으로 변경가능)
- **systemctl restart network** : 네트워크를 재시작한다.
- clear : 스크립트를 정리해준다.
- touch 파일명 : 크기가 0인 새 파일을 생성한다.
- cat 파일명 : 파일내용 출력 및 추가한다.
- java -version : centos의 내장된 자바의 버전을 알 수 있다. (OpenJDK 사용)
- man 명령어 : enter(한 행씩), spacebar(한 페이지씩)
- systemctl stop firewalld : 방화벽을 해제한다. 다시 부팅하면 방화벽이 다시 기동된다.
- systemctl disable firewalld : 다시 부팅해도 방화벽이 해제되어있다.
- ps** - process status (현재 수행중인 프로그램)
- kill -9 PID : 프로세스를 강제로 죽인다.
- **ps -ef** : pts/0 어느 터미널인지 알 수 있다.
- **ps -ef|more** : 페이지 단위로 보여준다.
- **ps -ef|grep eclipse** : eclipse 단어가 들어가있는 내용을 보여준다.
- history, 자동완성 : stack이 사용되었다.
- **링크** (교재 p.202 참고)
  - **ln** a.txt b.txt vs. cp a.txt b.txt
  - ln a.txt b.txt : **하드링크**이다. 실제 데이터소스는 하나이다. 따라서 a를 수정하면 b도 수정된다. cp는 a를 수정하는 것이 b와 같지 않다.
  - **ln -s** a.txt b.txt : **심볼릭 링크**이다. b.txt가 가리키는 것은 a.txt파일이다. 따라서 a.txt가 삭제되면 b.txt도 삭제된다.(바로가기와 비슷)
- 파일 압축과 묶기
  - bzip2 : 확장명 bz2로 압축하거나 풀어준다.
  - gzip : : 확장명 gz로 압축하거나 풀어준다.