# [ Linux Command ]

### 시스템 종료

```
# halt -p (18.04 버전때 이 명령 이후 부팅이 안됬으니 그냥 시스템 전원으로 종료가 정신이 편함)
# poweroff
# shutdown -h now
# init 0
```

### 재부팅

```
# shutdown -r now
# reboot
# init 6
```

### 로그아웃

```
# logout;
# exit;
```

### 가상콘솔

```
컨트롤 + f1~f6, f7은 x윈도우 화면이다
```

### .init 숫자 명령

```
0 : 종료모드, 1 : 복구모드, 3 : 다중 복구모드, 5 : 그래픽 다중사용자모드, 6 : 재시작
```

### dos와 history 명령어

```
dos : 이전에 사용한 명령어를 상하 화살표를 이용해 재사용하는 기능
history : 사용한 명령어 목록
# history -c : 히스토리 삭제
```

### 리눅스에서 cpu 클럭 보기

```
# dmidecode -t processor
```

### 파일 검색

```
# whereis 파일명 : 파일 검색
```

### 파일 실행

```
# ./파일명 : 파일 실행
```

### rpm파일 

```
alien 미설치시
# sudp apt-get install alien
변환
# alien [패키지이름.rpm]
ex) # sudo alien -k --script 파일명.rpm
```

### deb 파일

```
설치
# dpkg -i [패키지이름.deb]
제거
# dpkg -r [패키지이름.deb]
```

### 압축풀기 관련

```
# tar [[-]function][options] filenames
# tar [[-]function][options] -C directory-name

function : 수행할 작업을 지시하는 단일 명령
option : 처리할 기능
filenames : 풀거나 묶을 파일 리스트(목록)

tar(Type Archiver)
function
c : 묶음
x : 파일 추출(풀기)
d : 파일과 비교
r : 파일의 마지막 부분에 파일 추가
t : 내용 나열
u : 새로운 파일로 업데이트

option
f : 읽거나 기록할 파일을 정의
v : 묶거나 풀고 있는 파일을 보기
z : gzip으로 압축하여 백업

압축하기
# tar cvf file_name.tar *.c
# gzip file_name.tar

압출풀기
# tar xvzf file_name.tar
```

### 디렉토리 명령어

```
# pwd : 현재 작업하고 있는 디렉토리의 완전경로
# cd : 디렉토리 변경
# mkdir : 디렉토리 생성
# rmdir : 디렉토리 삭제(강제 삭제시 -r 추가)
```

### Stack 저장소

```
# pushd : 현재경로나 원하는 경로를 저장하면 순서대로 저장(후입선출구조)
# dirs : Stack의 저장된 경로 확인
# popd : 저장된 역순으로 경로를 점프하면서 바꿀수 있음
# popd + 숫자 : 위쪽으로부터 숫자 경로를 빼고 그 자리를 자동으로 채움
```

### 크론탭

```

```



### 기본 명령어들 모음

```
alias(명령어 간소화하기) 
apropos(관련된 명령어 찾기) 
arch(컴퓨터 종류 알기) 
arp(같은 서브넷의 IP 보여주기) 
at(작업 시간 정하기) 
atd(계획성 있는 작업 실행하기) 
awk(특정 패턴 문자 처리하기) 
a2p(펄 파일로 바꾸기) 
badblocks(배드 블럭 검사하기) 
bc(계산기) 
biff(메일 수신 소리로 확인하기) 
bg(후면작업; 배경화면 설정) 
bind(키나 함수 순서 결합하기) 
break(루프 빠져나가기) 
cal(달력보기) 
builtin(내부 명령어 알아보기) 
case(조건 처리하기) 
cat(화면상에서 파일 보기) 
cd(디렉토리 변경하기) 
cfdisk(디스크 설정하기) 
chattr(파일 속성 변경하기) 
chfn(사용자 정보 변경하기) 
chgrp(파일, 디렉토리가 속했던 그룹 바꾸기) 
chmod(파일 권한 바꾸기) 
chown(파일 주인 바꾸기) 
chsh(지정된 셸 바꾸기) 
cksum(CRC값을 점검한다) 
clear(화면 청소하기) 
clock(CMOS 시각을 조정하기) 
cmp(파일 비교하기) 
colcrt(문자 변환 필터) 
colrm(열 삭제하기) 
column(가로 정렬하기) 
comm(파일 비교 출력하기) 
command(명령어 알아보기) 
continue(루프 계속돌기) 
cp(파일 복사하기) 
cpio(복사본 만들기) 
crontab(cron을 관리한다) 
csplit(파일에 서식, 규칙 정하기) 
cut(필요한 필드만 출력하기) 
date(날짜 보기) 
dd(블럭장치 읽고 쓰기) 
debugfs(ext2 파일 시스템 디버깅하기) 
declare(변수 선언하기) 
df(파일 시스템의 사용량 보기) 
dirs(디렉토리 목록 표시하기) 
dmesg(부팅 메시지 보기) 

(X윈도우 환경에서 printk 메세지를 기본으로 못보는데 dmesg를 통해서 확인할수 있다)
dnsdomainname(DNS 이름 출력) 
domainname(NIS 이름 출력&설정) 
du(디렉토리와 파일의 용량 파악하기) 
dumpe2fs(파일 시스템 정보 보기) 
echo(표준 출력하기) 
eject(장치 해제하기) 
elm(메일 관련) 
enable(내부 명령어 지정) 
env(환경변수 출력하기) 
eval(인수 읽기) 
exec(셸 명령어 실행하기) 
exit(종료하기) 
expand(탭을 공백으로 변환하기) 
export(변수 지정하기) 
e2fsck(파일 시스템 복구하기) 
fc(지정된 편집기 받기) 
fdformat(플로피 디스크 포맷하기) 
fdisk(파티션 나누기) 
fg(지정된 작업을 전면 프로세스로 시작하기) 
file(파일 종류 보기) 
find(파일 찾기) 
finger(사용자 정보 알기) 
fold(정형화하기) 
fmt(정형화하기) 
for(반복 실행하기) 
free(메모리 사용량 알아보기) 
fsck(파일 시스템 검사하기) 
fstab(파일 시스템에 대한 고정적인 정보 저장하기) 
ftp(파일 전송 프로그램) 
fuser(프로세스 ID 출력) 
getkeycodes(매핑 테이블 출력하기) 
grep(특정 문자(열) 검색하기) 
gzexe(실행 파일 압축하기) 
gzip(압축하기) 
halt(시스템 종료하기) 
hash(기억해 두기; index 역할) 
head(파일의 앞부분 출력하기) 
help(도움말 보여주기) 
host(호스트 정보 보기) 
history(사용 명령어 목록보기) 
hostname(서버 이름 알기) 
id(계정 정보 알기) 
if(조건문 실행하기) 
ifconfig(랜카드에 주소 할당하기) 
imolamod(모듈 설치하기) 
inetd(인터넷 서비스의 최상위 데몬) 
init(실행 단계 정하기) 
ispell(철자법 검사하기) 
jobs(수행중인 프로세스 알기) 
kbd_mode(키보드 모드 출력하기) 
kill(프로세스 죽이기)  강제종료 (kill -9  PID)
klogd(커널 로그 데몬) 
ldd(공유 라이브러리의 의존성 알기) 
less(페이지 단위로 출력하기) 
let(정규식 표현하기) 
lilo(부팅하기) 
ln(링크하기) 
locate(패턴에 맞는 파일 찾기) 
login(로그인하기) 
logger(시스템 로그 기록하기) 
logname(사용자 로그인명 보여주기) 
logout(로그인 셸 종료하기) 
look(특정 단어 검색하기) 
losetup(중복 장치 확인하기) 
lpd(프린트 데몬) 
lpq(현재 프린트 작업 상태 출력하기) 
lpr(출력하기) 
lprm(대기열에 있는 문서 삭제하기) 
ls(디렉토리 내용보기) 
lsattr(파일 시스템의 속성 보여주기) 
lsdev(하드웨어 장치 출력하기) 
lsmod(모듈 정보 출력하기) lnsmod(묘둘 올리기) rmmod (모듈 내리기)
mail(메일 관련) 
make(컴파일하기) 
man(매뉴얼 보기) 
mattrib 
mbadblocks 
mcd 
mcopy 
mdel 
mdeltree 
mdir 
mesg(메시지를 받을 수 있는지 확인하기) 
mformat 
minfo 
mkdir (디렉토리 만들기) 
mke2fs(파일 시스템 생성하기) 
mkfs(파일 시스템 만들기) 
mknod(특수 파일 만들기) 
mkswap(스왑 영역 지정하기) 
mlabel 
mmd 

mount 
mmount 
mmove 
mpartition 
mount(장치 연결하기) 
more(화면 단위로 출력하기)  ls -al | more
mrd 
mren 
mtoolstest 
mtype 
mutt(메일 관련) 
mv(파일 옮기기) 
mzip 
netstat(현재 네트웍 상황 보기) 
nice(프로세스 우선 순위 변경하기) 
od(8진수로 파일 보기) 
passwd(암호 입력하기) 
pidof(실행중인 프로그램의 프로세스 ID 찾기) 
pine(메일 관련) 
ping(네트웍 확인하기) 
popd(pushd 취소) 
ps(프로세스 상태 알기) ps -aux
pstree(프로세스 상관관계 알기) 
pwd(절대경로 보여주기) 
quota(디스크 한계량 알기) 
rarp(rarp 테이블 관리하기) 
rcp(원격 호스트에 파일 복사하기) 
rdev(루트, 스왑장치, 램 크기, 비디오 모드를 조사하고 설정하기) 
rdate(네트웍으로 시간 설정하기) 
reboot(재부팅하기) 
readonly(읽기 전용으로 표시하기) 
renice(프로세스 우선 순위 바꾸기) 
reset(터미널 초기화하기) 
restore(다시 저장하기) 
rlogin(바로 접속하기) 
rm(파일 지우기) 
rmdir (디렉토리 지우기) rm -rf
route(라우팅 테이블 추가/삭제하기) 
rpm(프로그램 추가/삭제) 
rpm2cpio(rpm을 cpio로 변환하기) 
rsh(원격으로 명령어 실행하기) 
rup(호스트 상태 출력하기) 
rusers(호스트에 로그인한 사용자 출력하기) 
rwall(호스트 사용자에게 메시지 뿌리기) 
script(기록하기) 
set(변수값 설정하기) 
setup(시스템 관련 설정하기) 
showmount(호스트의 마운트 정보 보여주기) 
shutdown(전원 끄기) 
sleep(잠시 쉬기) 
source(스크립트 번역하기) 
split(파일 나누기) 
ssh(암호화된 원격 로그인하기) 
stty(터미널라인 설정 보여주기) 
su(계정 바꾸기) 
suspend(셸 중단하기) 
swapoff (스왑 해제하기) 
swapon(스왑 활성화하기) 
sync(버퍼 재설정하기) 
syslogd(로그인 과정 설정하기) 
tac(거꾸로 보기) 
tail(문서 끝부분 출력하기) 
talk(이야기하기) 
tar(파일 묶기) 
tcpdchk(tcp wrapper 설정하기) 
tcpmatch(네트웍 요청에 대해 예측하기) 
tee(표준 입력으로부터 표준 출력 만들기) 
telnet(원격접속하기) 
test(테스트하기) 
times(셸에서의 사용자와 시스템 시간 출력하기) 
top(cpu 프로세스 상황 보여주기) 
tr(문자열 바꿔주기) 
true(종료 코드 리턴하기) 
type(유형 보기) 
ul(밑줄 처리해서 보여주기) 
ulimit(제한하기) 
umask(매스크 모드 설정하기) 
umount(장치 해제하기) 
unalias(별명 제거하기) 
uname(시스템 정보 보기) 
unexpand(공백 문자를 탭으로 변환하기) 
uniq(중복된 문장 찾기) 
useradd(사용자 계정 만들기) 
userdel(계정 삭제하기) 
usermod(사용자 계정정보 수정하기) 
unset(설정 변수 해제) 
uptime(시스템 부하 평균 보여주기) 
users(로그인된 사용자 보여주기) 
w(시스템에 접속한 사용자 상황 알아보기) 
wait(프로세스 기다리기) 
wall(모든 사용자에게 메시지 보내기) 
wc(문자, 단어, 라인수 세기) 
whatis(명령어의 간단한 설명보기) 
while(루프 명령어) 
who(사용자 알기) 
write(콘솔 상에서 간단한 메시지 보내기) 
xcopy(반복적으로 복사하기) 
XFree86 
ypchfn(NIS에서 사용하는 chfn 명령어) 
ypchsh(NIS에서 사용하는 chsh 명령어) 
yppasswd(NIS에서 사용하는 passwd 명령어) 
zcat(압축 파일 보기) 
zcmp(압축 파일 비교하기) 
zforce(강제로 gz 만들기) 
zgrep(압축 상태에서 grep 실행하기) 
zmore(압축 상태에서 more 실행하기) 
znew(.Z 파일을 .gz로 다시 압축하기)

출처 : http://yahweh0.blog.me 
```

