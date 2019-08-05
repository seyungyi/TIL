## Typora : 일반 텍스트형식을 마크다운형식으로 편집해주는 에디터(.md)

```
# 제목 : 헤더기능

## 소제목 : 헤더보다는 작은 사이즈

**글자** : 글자를 굵게

*글자* : 글자 기울이기

1. 항목 + Enter : 다음 행에 자동으로 2.추가 (글머리 기호)

> : 인용문 설정

---+(Enter) : 절취선 긋기(스페이스바 없음)

^1 : 주석 달기

~~글자~~ : 취소선

- 입력후 스페이스 : 자동 목록 표시

` `  : 감싸면 자동 기능 생략

* 갯수 * : *로 감싸면 강조

 ``` : 프로그래밍 언어 입력 칸

[타이틀](링크) 엔터 : 링크주소 타이틀과 연결

![이름](이미지주소) : 이름으로 이미지 주소의 이미지 복사

(+) \ 를 붙이면 마크다운이 적용되지 않습니다.
```

# [ Git ]

## < Git이란 >

- **버전 관리 시스템**(VCS : Version Control System) 이다.

- 기능

  1. Git을 이용하면 하나의 파일이름으로 버전 관리 할 수 있다.

     예를 들어 발표자료_최종본.pptx, 발표자료_진짜_최종본.pptx, 발표자료__정말_최종본.pptx 이라는 파일이있을 때, 버전관리를 발표자료_최종본.pptx 하나로 할 수 있다.

  2. 다른사람과 협업할 수 있다.

- 구조

  - git 구조도 이미지
  - **Working Directory** : 현재 작업하고 있는 디렉토리를 말한다.
  - **Stage Area** : 커밋이 되기위해 대기하는 파일이 저장된다.
  - Repository : 저장소이다.
    - Local Repository : 자신의 PC에 존재하는 저장소를 말한다.
    - Remote Repository : Github와 같은 원격 저장소를 말한다.

- 버전

  - 작업이 있으면 작업에서 완결된 상태가 있는 것을 말한다.

## Git 파일 관리 영역 구조

```
파일 수정(Working Directory)-> Modified -> Stage -> Commited(Staging area) -> 파일 수정(local repository)
```

### 새로운 저장소 초기화하기

```
- Git 폴더 생성
# mkdir /path/newDir

- Git 폴더 이동
# cd /path/newDir

- 현재 폴더를 Git Repository로 생성 및 초기화
# git init
```

### 저장소 복제

```
- Github Repository의 URL경로의 저장소를 복제
# git clone <저장소 url>
```

### 설정 정보 등록(필수)

```
- 전역 사용자명/이메일 구성하기
# git config --global user.name “Your name”
# git config --global user.email “Your email address”

- 저장소별 사용자명/이메일 구성하기 (해당 저장소 디렉터리로 이동후)
# git config user.name “Your name”
# git config user.email “Your email address”
- 전역 설정 정보 조회 ( 설정 정보 위치 Path : ~/.gitconfig)
# git --config --global --list 
```

### 원격 저장소 등록(필수)

```
- 원격 저장소 등록하기
# git remote add <원격 저장소> <저장소 url>

- Git 폴더와 Github 원격저장소랑 연결
# git remote add origin 본인깃헙주소 : git 폴더와 github원격저장소랑 연결

- 등록된 원격 저장소 리스트 확인
# git remote -v : 저장소 확인

- 중간 저장소에 있는 파일을 Github 원격저장소에 업로드
# git push -u master
 
 - 중간 저장소에 있는 파일을 Github 저장소의 master branch에 저장(=업로드)
# git push origin master

- 중간 저장소에 있는 파일을 Github 저장소의 master branch에 강제로 올리기
# git push origin master --force

- 업로드 되는 모든 파일을 현재 push하는 기준으로 모두 업로드(추천하지 않음)
# git push origin +master

- 원격저장소의 내용을 가져와 로컬저장소의 내용과 자동으로 병합(여러 pc사용시 필수 과정)
# git pull origin master

- 원격저장소의 내용을 확인만 하고 로컬저장소의 내용과 병합하지는 않음
# git fetch origin master
(로컬 저장소와 원격 저장소의 변경 내용이 다를 때 이를 비교/대조. git merge 명령어와 함께 최신 데이터를 반영하거나 충돌 문제를 해결) 
```

## < Git Bash 사용 명령어 >

```
(위의 과정에서 필수적으로 사용한 명령어들은 제외시킴)

- git에서 사용 가능한 명령어 리스트를 보여줌
# git

- 새로운 디렉토리를 생성하여 git 저장소 생성
# git init directory path

-저장소별 설정 정보 조회
# git config --list

- all user 시스템 정보 (path : /etc/gitconfig)
# git config --system

- 로컬저장소 정보 (path : ~/.git/config)
# git config --local

- git 파일 현재 상태
# git status

- 파일들 한번에 추가
# git add . or git add --all

- git에 올릴 파일을 중간 저장소 리스트에 올림(tracked로 변경)
# git add 파일이름

- 생략(단, 폴더이름뒤에 / 안붙이면 빈폴더만 저장될 수 있음) -> 폴더도 통째로 저장
# git add ./폴더이름/

- git의 중간 저장소 리스트에 있는 파일들을 중간 저장소에 저장
# git commit -m "코멘트"

- git 중간 저장소 리스트 파일들을 중간 저장소에 저장하는데 comment를 에디터로 작성
# git commit

- git 활동 기록(커밋 히스토리를 시간순으로 정렬하여 보여줌)
# git log 

- add된 변경사항들을 reset(=되돌린다)
# git reset [--soft | --mixed | --hard]

- 변경사항들을 add하기전에 확인하는 커맨드(변경사항 확인)
# git diff [버전 id]..[버전 id2] : 입력한 두 버전 간의 차이점을 비교한다.
# git diff : git add하기 전과 add한 후의 파일 내용을 비교한다.

- git 로컬저장소 삭제
# rm -rf ./.git

- git 파일 및 폴더 삭제
# git rm 파일 및 폴더명

- git 파일 밋 폴더 강제 삭제
# git rm -rf 파일 및 폴더명

- git 저장소에 있는 파일 삭제
# git rm -r --cached {파일 및 폴더명}
```

