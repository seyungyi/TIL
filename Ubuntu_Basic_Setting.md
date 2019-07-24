# [ Ubuntu Basic Setting ]

### 윈도우와 시간 맞추기(듀얼부팅일 경우)

```
$ timedatectl set-local-rtc 1
$ sudo vi /etc/default/rcS
가장 밑에 줄에 추가
UTC=no
```

### GRUB 부팅 순서 바꾸기 or 출력 안되는 문제

```
GRUB 부팅 순서 바꾸기 or 출력안되는 문제
(부팅순서)
$ sudo gedit /boot/grub/grub.cfg
윈도우 부팅 메뉴를 리눅스 부팅 메뉴 위로 옮겨준다
### BEGIN /etc/grub.d/30_os-prober ###
menuentry 'Windows Boot Manager' ~~~ 라고 적혀있는 부분이 윈도우 부팅 메뉴라인
(추가 세팅, 관리 원할경우 Ultimate Guide:Getting Started With Ubuntu 링크를 확인)
(출력문제시)
# sudo vi /etc/defalt/grub
GRUB_TIMEOUT 값을 2 로 변경
# sudo update-grub
```

### root 사용자로 자동 로그인(root로 원할시)

```
먼저 설정-사용자계정에서 자동로그인 기능을 활성화!
$ sudo gdeit /etc/lightdm/lightdm.conf
[Seat:*]
autologin-user=root
입력 후 저장
$ sudo gedit /root/.profile
가장 아래 줄
# mesg n || true
재시작
```

### 자동 업데이트 금지

```
설정-소프트웨어업데이트-체크 모두 해제-[업데이트 창]-아래 설정 변경
(초기 버전만 업데이트)
$ cd /etc/apt
$ mv sourcese.list sources.list_org
# vi sources.list
deb http://ftp:daumkakao.com/ubuntu/ xenial main
deb http://kr.archive.ubuntu.com/ubuntu/ xenial main 

deb http://ftp:daumkakao.com/ubuntu/ xenial universe
deb http://kr.archive.ubuntu.com/ubuntu/ xenial universe

deb http://ftp:daumkakao.com/ubuntu/ xenial multiverse
deb http://kr.archive.ubuntu.com/ubuntu/ xenial multiverse

deb http://ftp:daumkakao.com/ubuntu/ xenial restricted
deb http://kr.archive.ubuntu.com/ubuntu/ xenial restricted
# apt-get update
```

### 고정 IP 설정하기

```
유선연결 편집 - [방식] 수동 - add - 네트워크 값 입력 - 저장
재접속
# ifconfig 아이피 확인
(네트워크 경고메시지&오류 보고서 감추기)
# sudo gedit /usr/lib/avahi/avahi-daemon-check-dns.sh
AVAHI_DAEMON_DETECT_LOCAL=1 값을 주석처리(#)
AVAHI_DAEMON_DETECT_LOCAL=0 으로 새로 기입
저장
# gedit /etc/default/avahi-daemon
AVAHI_DAEMON_DETECT_LOCAL=1 값을 0으로 변경
(오류보고서)
# sudo vi /etc/default/apport
enabled = 0
```

### 화면 보호기 끄기

```
설정 - 화면밝기&잠금 - 설정 끄기
```

### 방화벽 활성화

```
# ufw enable
단 방화벽 관련 소프트웨어 좋은 것이 있으니 찾아보기
```

### X윈도우 텍스트모드로 부팅 설정

```
# ls -l /lib/systemd/system/default.target
# ln -sf /lib/systemd/system/multi-user.target /lib/systemd/system/default.target
# ls -l /lib/systemd/system/default.target
# reboot
```

### 그래픽 모드로 부팅 설정

```
# ls -l /lib/systemd/system/default.target
# ln -sf /lib/systemd/system/graphical.target /lib/systemd/system/default.target
```

### 재부팅시 네트워크 비활성 문제

```
# sudo systemctl restart NetworkManager.service
or
# suo vim /etc/rc.local
(입력)
#!/bin/bash
su root -C "systemctl restart NetworkManger.service"
exit 0
(저장)
```

### 한글 입력기 fcitx -> nimf 로 변경(한국 개발자가 만듬으로 한글문제 해결이 잘 된 것)

```
# sudo add-apt-repository ppa:hodong/nimf
# sudo apt update
# sudo apt install nimf
(PDF View 인 Evince 실행 지연 문제시)
# sudo vi /etc/apparmord/usr.bin.evince
# include<abstractions/ibus>
# include<abstractions/nimf>
```

### Ubuntu Tweak(테마, 폰트변경 및 GUI 설정 쉽게 변경하는 툴)

```
# sudo apt install unity-tweak-tool
```

### Cairo-Dock

```
# sudo apt install cairo-dock
```

### DropBox(리눅스는 드롭박스 클라우드가 최적화가 가장 잘 됨)

```
# sudo apt install nautilus-dropbox
```

### GIMP(이미지 편집)

```
# sudo apt install gimp
```

### Beleach Bit(불필요한 파일들 자동 삭제하는 프로그램)

```
# sudo apt install bleachbit
```

### SysPeek(cpu 점유율 확인)

```
# sudo add-apt-repository ppa:nilarimogard/webupd8
# sudo apt update
# sudo apt install syspeek
```

### SMPlayer

```
# sudo add-apt-repository ppa:rvm/smplayer
# sudo apt update
# sudo apt install smplayer
```

### Dock 설치

```
# sudo add-apt-repository ppa:ricotz/docky
# sodu apt-get update && sudo apt-get install plank
#plank --preferences 
```

### Side Bar Switch

```
# gsettings set com.canonical.Unity.Launcher launcher-position Bottom
# gsettings set com.canonical.Unity.Launcher launcher-position Left
```

### 노트북 덮개 닫았을 시 자동 절전모드 해제

```
# sudo vi /etc/systemd/logind.conf
HandleLidSwitch 부분 주석 해제 후 변경(원래 suspend)
HandlieLidSwitch=ignore
# systemctl restart systemd-logind.service
# service systemd-logind restart
적용 후 재부팅 or loing서비스 재시작
< 그래픽 환경(GUI)인 경우 [설정] - [Power] - [lid is closed] 해제 >
```

## 디스크 마운트

```
하드디스크의 UUID 알아보기
# ll /dev/disk/by-uuid

하드디스크 추가
# sudo gedit /etc/fstab
맨 마지막줄에 내용 추가
UUID=UUID입력	마운트위치	파일시스템종류	옵션	덤프	패스
(<file system>	<mount point>	<type>	<options>	<dump>	<pass>)
file system : UUID 입력
mount point : 마운트 위치 지정. 사전에 마운트할 위치의 디렉터리 생성해야함
type : 파일 시스템 종류
options : 별다른 값 없다면 default
dump : 동일
pass : 동일 
```

## 네트워크 공유폴더 마운트

```
최근의 우분투에서는 우분투에서 윈도우 공유폴더의 접근이 간단해짐
1.CIFS 설치를 통해 공유가능
# sudo apt-get install cifs-utils
2.공유폴더를 마운트할 폴더 생성
# sudo mkdir shareFolder
3.마운트 디스크 설정 변경
# sudo gedit /etc/fstab
4.마운트 시킬 공유폴더의 ip/폴더명 계정명 등의 옵션 지정
ip주소/공유폴더명	마운트폴더위치	cifs	username=계정,password=암호	0	0
5.마운트 설정이 된 폴더들을 자동으로 전부 마운트
# sudo mount -a
6.마운트 폴더에서 확인
# cd shareFolder
# ls -l
```



