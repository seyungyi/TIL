## Typora : 일반 텍스트형식을 마크다운형식으로 편집해주는 에디터(.md)

```
# 제목 : 헤더기능

\## 소제목 : 헤더보다는 작은 사이즈

**글자** : 글자를 굵게

*글자* : 글자 기울이기

1. 항목 + Enter : 다음 행에 자동으로 2.추가 (글머리 기호)

> : 인용문 설정

---+(Enter) : 절취선 긋기(스페이스바 없음)

^1 : 주석 달기

~~글자~~ : 취소선

\- 입력후 스페이스 : 자동 목록 표시

` `  : 감싸면 자동 기능 생략

\* 갯수 * : *로 감싸면 강조

 \``` : 프로그래밍 언어 입력 칸

[타이틀](링크) 엔터 : 링크주소 타이틀과 연결

![이름](이미지주소) : 이름으로 이미지 주소의 이미지 복사
```

## Git 설치 과정( 특강 )

```
저장은 c드라이브 - 사용자 - 사용자폴더

git은 리눅스명령어 커맨드와 유사

TIL폴더 만들기 -> 오늘날짜 폴더 만들기 -> 날짜에 파일 옮기기 -> TIL폴더에서 git status -> error가 뜸 -> git add . : git에 폴더내용 전부를 업로드

-> git config --global user.email "wjion8428@gmail.com" -> git config --global user.name "Goyesung" ->  git commit -m "first"

-> git status -> git log -> git remote add origin <https://github.com/wjion8428/TIL.git> ->  git push -u origin master

git에서는 add, commit, push 명령어가 주됨(typora 파일 업로드시)

<https://learngitbranching.js.org/>
```

## Git 파일 관리 영역

```
파일 수정(Working Directory)-> Modified -> Stage -> Commited(Staging area) -> 파일 수정(local repository)
```

![img](https://www.evernote.com/shard/s355/res/d2b79a8d-fe36-4a03-8df3-fa5618fe1276)

## < Git Bash 명령어 >

```
git init : 현재 폴더를 git 로컬저장소로 지정

git init directory path : 새로운 디렉토리를 생성하여 git 저장소 생성

git --config --global --list : 전역 설정 정보 조회 (path : ~/.gitconfig)

git config --list : 저장소별 설정 정보 조회

git config --system : all user 시스템 정보 (path : /etc/gitconfig)

git config --local : 로컬저장소 정보 (path : ~/.git/config)

git status : git 파일 현재 상태

git add . or git add --all : 파일들 한번에 추가

git add 파일이름 : git에 올릴 파일을 중간 저장소 리스트에 올림(tracked로 변경)

git add ./폴더이름/ : 생략(단, 폴더이름뒤에 / 안붙이면 빈폴더만 저장될 수 있음) -> 폴더도 통째로 저장

git commit -m "코멘트" : git의 중간 저장소 리스트에 있는 파일들을 중간 저장소에 저장

git log : git 활동 기록

git reset [--soft | --mixed | --hard] : add된 변경사항들을 reset(=되돌린다)

git diff : 변경사항들을 add하기전에 확인하는 커맨드

 rm -rf ./.git : git 로컬저장소 삭제

git rm 파일 및 폴더명

git rm -rf 파일 및 폴더명

git rm -r --cached {파일 및 폴더명}
```

### 설정 정보

```
전역 사용자명/이메일 구성하기
# git config - -global user.name “Your name”
# git config - -global user.email “Your email address”

저장소별 사용자명/이메일 구성하기 (해당 저장소 디렉터리로 이동후)
# git config user.name “Your name”
# git config user.email “Your email address”
```

### 원격 저장소 등록

```
# git remote add <원격 저장소> <저장소 url>
# git remote add origin 본인깃헙주소 : git 폴더와 github원격저장소랑 연결

git remote -v : 저장소 확인

git push -u master : 중간 저장소에 있는 파일을 github원격저장소에 업로드

git push origin master

git push origin master --force

git push origin +master : 강제로 파일 올리기(좋은 방법은 아님)

git pull origin master : 원격저장소의 내용을 가져와 로컬저장소의 내용과 자동으로 병합

git fetch origin master : 원격저장소의 내용을 확인만 하고 로컬저장소의 내용과 병합하지는 않음

(로컬 저장소와 원격 저장소의 변경 내용이 다를 때 이를 비교/대조. git merge 명령어와 함께 최신 데이터를 반영하거나 충돌 문제를 해결) 
```

### 새로운 저장소 초기화하기

```
# mkdir /path/newDir
# cd /path/newDir
# git init
```

### 저장소 복제

```
# git clone <저장소 url>
```



