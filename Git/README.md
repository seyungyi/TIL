# [ Git ]

## < Git이란 >

- **분산 버전 관리 시스템**(VCS : Version Control System) 이다.

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

### Git 로그목록

```bash
- git bas 상에서 log를 그래프 형식으로
$ git log --graph --oneline
- 리눅스 명령어로 로그를 트리구조로 텍스트파일로 저장
$ tree /f > 파일명.txt
```

### 새로운 저장소 초기화하기

```bash
- Git 폴더 생성
$ mkdir /path/newDir

- Git 폴더 이동
$ cd /path/newDir

- 현재 폴더를 Git Repository로 생성 및 초기화
$ git init
```

### 저장소 복제

```bash
- Github Repository의 URL경로의 저장소를 복제
$ git clone <저장소 url>
1. 로컬에 원격 저장소를 받고싶은 경우 사용한다.
2. 이후에는 push - pull 명령어를 통해 업데이트하면 됨
```

### 설정 정보 등록(필수)

```bash
- 전역 사용자명/이메일 구성하기
$ git config --global user.name “Your name”
$ git config --global user.email “Your email address”

- 저장소별 사용자명/이메일 구성하기 (해당 저장소 디렉터리로 이동후)
$ git config user.name “Your name”
$ git config user.email “Your email address”
- 전역 설정 정보 조회 ( 설정 정보 위치 Path : ~/.gitconfig)
$ git --config --global --list 
```

### 원격 저장소 등록(필수)

```bash
- 원격 저장소 등록하기
$ git remote add <원격 저장소> <저장소 url>

- 원격 저장소 삭제하기
$ git remote remove origin
$ git remote rm origin

- Git 폴더와 Github 원격저장소랑 연결
$ git remote add origin 본인깃헙주소 : git 폴더와 github원격저장소랑 연결

- 등록된 원격 저장소 리스트 확인
$ git remote -v : 저장소 확인

- 중간 저장소에 있는 파일을 Github 원격저장소에 업로드
$ git push -u master
 
 - 중간 저장소에 있는 파일을 Github 저장소의 master branch에 저장(=업로드)
$ git push origin master

- 중간 저장소에 있는 파일을 Github 저장소의 master branch에 강제로 올리기
$ git push origin master --force

- 업로드 되는 모든 파일을 현재 push하는 기준으로 모두 업로드(추천하지 않음)
$ git push origin +master

- 원격저장소의 내용을 가져와 로컬저장소의 내용과 자동으로 병합(여러 pc사용시 필수 과정)
$ git pull origin master

- 원격저장소의 내용을 확인만 하고 로컬저장소의 내용과 병합하지는 않음
$ git fetch origin master
(로컬 저장소와 원격 저장소의 변경 내용이 다를 때 이를 비교/대조. git merge 명령어와 함께 최신 데이터를 반영하거나 충돌 문제를 해결) 
```

## Git 되돌리기

1. commit 메시지 수정(스테이징에 올라온 커밋)

   ```bash
   $ git commit --amend
   ```

   - git bash에서 vim이 실행됨
   - 편집모드(`i`) 상태에서 수정후 esc+`:wq`
   - `push` , 즉, 원격저장소에 올린 이후에는 진행하면 충돌이 무조건 발생함
   - 커밋을 다시 하게 되면 해시값이 변경되기 때문!

2. Staging area(INDEX)에서 취소하기

   ```bash
   $ git reset HEAD programmers/
   $ git status
   On branch master
   Changes to be committed:
     (use "git restore --staged <file>..." to unstage)
           modified:   "폴더명/소스파일.py"
   
   Untracked files:
     (use "git add <file>..." to include in what will be committed)
           폴더명/
   ```

3. git 이력에서 특정 파일 삭제 커밋

   ```bash
   $ git rm --cached 파일명
   ```

   - 한번도 커밋된 이력이 없을 때에는 staging area에서 취소와 동일함
   - 다만, 커밋에 포함된 적 있는 경우에는 삭제 커밋이 됨. (실제 파일은 삭제되지 않음!)

4. 특정 파일 포함해서 다시 커밋

   ```bash
   $ git add a.py
   $ git commit -m 'a, b 추가'
   $ git add b.py
   $ git commit --amend
   ```

   - commit 메시지를 수정하기전에 staging area에 변경을 해주면, 해당 파일까지 포함하여 다시 커밋을 진행함

5. 현재 작업 내역 커밋 시점으로 되돌리기

   예를 들어, 특정 파일을 삭제하였거나 혹은 코드 수정과정에서 오류가 많이 발생하여 직전 커밋 시점 상태로 돌아고 싶을 때 사용이 가능함

   ```bash
   $ git checkout -- 파일명
   ```

## 충돌 해결하기(Merge conflict)

> 기본적으로 push - pull 하는 과정에서 동일한 파일의 다른 이력이 기록될 경우 충돌이 발생한다!
>
> 다른 파일이 수정되는 경우 fast-fowarding을 통해 자동으로 merge가 되기도 함!
>
> 이러한 오류를 발생시키지 않으려면, 항상 작업 하기전에 `pull` 을 확인하고, 작업 및 커밋을 한 이후에 `push` 를 하는 것을 습관화 하자!

1. Local A에서 a.txt 작성 후 커밋

2. Local A에서 원격저장소(Origin)로 push

3. Local B에서 pull하지 않은 상태에서 a.txt 동일한 라인 작성 후 커밋

4. Local B에서 원격저장소(Origin)로 push -> push 되지 않음!

5. 해결(원격저장소 변경사항 Local B에서 반영)

   ```bash
   $ git pull origin master
   ```

6. 충돌 발생(동일 파일 수정시)

   - 어떤 파일에서 충돌되었는지 확인하는 명령어

   ```bash
   $ git log --online --left-right --p
   ```

   - Git 에서 직접 충돌 파일에 기록을 남겨줌.

     ```bash
     <<<<<<< HEAD
     집 수정 내용
     =======
     멀캠 수정 내용
     >>>>>>> 12dfas12sadf124fdsa
     ```

     - `HEAD` : 현재 작업하고 있는 곳(Local B)
     - `해쉬값`: pull 을 통해 받아온 변경사항(origin)
     - 해당 하는 위치를 찾아서 직접 수정을 진행함!

7. merge conflict 해결 commit 남기기

   ```bash
   $ git status
   $ git add .
   $ git commit -m 'Merge conflict 해결'
   ```

8. 원격저장소로 `push`

   ```bash
   $ git push origin master
   ```

## Branch 활용하기

`git init` 을 하였을 때 `(master)` 는 사실 master 브랜치에 있다라는 사실을 보여주고 있는 것이다.

1. branch 생성

   ```basha
   (master) $ git branch {branch이름}
   (master) $ git branch
   *master
   {branch이름}
   ```

2. branch 이동

   ```bash
   $ git checkout {branch이름}
   ```

   - 위 두 명령어를 동시에 실행하려면 아래와 같이 한다.

     ```bash
     $ git checkout -b {branch이름}
     ```

3. branch 삭제

   ```bash
   $ git branch -d {브랜치이름}
   ```

4. branch 병합

   ```bash
   (master) $ git merge feature/main
   ```

   `master` 브랜치에 `feature/main` 을 병합한다.

   항상 병합을 하고 싶은 대상의 브랜치로 옮겨서 진행해야 한다.

## Git merge

### 1. Fast-fowarding

브랜치를 나눈 이후에 master 브랜치에 커밋이 발생하지 않았고, 단순히 커밋만 옮기면 되는 경우. merge 커밋이 발생하지는 않음.

### 2. Auto Merge

브랜치를 나눈 이후에 master 브랜치에 커밋이 발생하였으나, 동일한 파일이 수정되지 않아서 자동으로 병합이 되는 경우. merge 커밋이 발생함.

```bash
$ git log --graph --oneline
*   85cd33b (test) Merge branch 'feature/main'
|\
| * 42df5bb Complete main feature
* | 90cf6e6 README
|/
* 98aa976 Init css/js
```

### 3. Merge conflict 발생

브랜치를 나눈 이후에 master 브랜치에 커밋이 발생하였고, 동일한 파일이 각자 다른 브랜치에서 수정된 경우 자동으로 merge가 되지 않는다. 따라서 merge conflict가 발생하고, 직접 수정 후 커밋을 해야한다.

```bash
$ git merge feature/main
Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
Automatic merge failed; fix conflicts and then commit the result.
```

Git은 충돌이 발생한 파일에 아래와 같이 표기를 해준다. 해당 부분을 찾아서 수동으로 해결 해야한다. 충돌 위치를 파악하기 위해서 `git status` 를 통해 확인하자!

```bash
<<<<<<< HEAD
Master 수정
=======
Branch 수정
>>>>>>> feature/footer
$ git add .
$ git commit
```

커밋을 하게 되면, merge 커밋이 발생한다.

```bash
$ git log --graph --oneline
*   4ef20fb (HEAD -> master) Merge branch 'feature/footer'
|\
| * 9701912 (feature/footer) Complete footer
* | c932f24 README
|/
*   85cd33b (test) Merge branch 'feature/main'
```

## Git stash

현재 변경 사항을 담아 둘 수 있는 임시 공간이 존재한다.

1. 현재 변경사항 담기

   ```bash
   $ git stash
   $ git stash list
   ```

2. 임시 저장사항 불러오기

   ```bash
   $ git stash pop
   ```

   위의 명령어는 `apply` + `drop` 과 동일하다.

## < Git Bash 사용 명령어 >

```bash
(위의 과정에서 필수적으로 사용한 명령어들은 제외시킴)

- git에서 사용 가능한 명령어 리스트를 보여줌
$ git

- 새로운 디렉토리를 생성하여 git 저장소 생성
$ git init directory path

-저장소별 설정 정보 조회
$ git config --list

- all user 시스템 정보 (path : /etc/gitconfig)
$ git config --system

- 로컬저장소 정보 (path : ~/.git/config)
$ git config --local

- git 파일 현재 상태
$ git status

- 파일들 한번에 추가
$ git add . or git add --all

- git에 올릴 파일을 중간 저장소 리스트에 올림(tracked로 변경)
$ git add 파일이름

- 생략(단, 폴더이름뒤에 / 안붙이면 빈폴더만 저장될 수 있음) -> 폴더도 통째로 저장
$ git add ./폴더이름/

- git의 중간 저장소 리스트에 있는 파일들을 중간 저장소에 저장
$ git commit -m "코멘트"

- git 중간 저장소 리스트 파일들을 중간 저장소에 저장하는데 comment를 에디터로 작성
$ git commit

- git 활동 기록(커밋 히스토리를 시간순으로 정렬하여 보여줌)
$ git log 

- git 활동 로그 한 줄로 간단히 요약
$ git log --oneline

- 커밋에 대한 추가, 삭제 모든 이력 보여줌
$ git reflog

- add된 변경사항들을 reset(=되돌린다)
$ git reset [--soft | --mixed | --hard]

- 변경사항들을 add하기전에 확인하는 커맨드(변경사항 확인)
$ git diff [버전 id]..[버전 id2] : 입력한 두 버전 간의 차이점을 비교한다.
$ git diff : git add하기 전과 add한 후의 파일 내용을 비교한다.

- git 로컬저장소 삭제
$ rm -rf ./.git

- git 파일 및 폴더 삭제
$ git rm 파일 및 폴더명

- git 커밋 이력에서 특정 파일 삭제 커멧
$ git rm --cached 파일명

- git 파일 밋 폴더 강제 삭제
$ git rm -rf 파일 및 폴더명

- git 저장소에 있는 파일 삭제
$ git rm -r --cached {파일 및 폴더명}
```

### < Github 참고 주소 >

```
TIL 예시	https://github.com/edutak/algorithms
git md 정리 내용	https://gist.github.com/edutak/0b3ec40bdecbc9bad074e8df1e5a7998
git 입문편	https://backlog.com/git-tutorial/kr/intro/intro1_1.html
잘 정리된 예시	
기술 면접 가이드	https://github.com/JaeYeopHan/Interview_Question_for_Beginner
논산	https://github.com/krta2/awesome-nonsan
자율 출퇴근	https://github.com/milooy/remote-or-flexible-work-company-in-korea
	
커밋 메시지	
본문/명령문	https://meetup.toast.com/posts/106
커밋 낱말 사전	https://blog.ull.im/engineering/2019/03/10/logs-on-git.html
	
git 시각화	http://git-school.github.io/visualizing-git/
git cheatsheet	ttp://ndpsoftware.com/git-cheatsheet.html
chatbot 코드	https://github.com/edutak/openapi-a

https://core.telegram.org/bots/api	
```