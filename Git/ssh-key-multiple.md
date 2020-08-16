# [ Git ssh-key 를 이용한 다중 계정 등록 ]

- SSH-KEY란?
  - 동일한 로컬 환경에서 다른 계정으로 Commit Log를 남기려고 할 때 사용가능한 인증수단



## < 다중 계정 등록 방법 >

### 1. 키 생성

- 기본 환경은 window의 경우 git bash를 설치, os x의 경우 terminal을 이용

- 기본 경로

  > ~/.ssh/

- 키 생성하기

```bash
# userA와 userB의 github 계정에 대한 ssh-key 생성 명령어
# 이 때 사용하는 email 계정은 로그인시 사용하는 계정ㄷ과 동일
$ ssh-keygen -t rsa -C "userA@personal_email.com" -f "id_rsa_userA"
$ ssh-keygen -t rsa -C "userB@personal_email.com" -f "id_rsa_userB"

# 생성한 키 등록
$ ssh-add id_rsa_userA
$ ssh-add id-rsa_userB
```

- 키 적용하기

```bash
# 위 과정을 진행시 결과물로 .pub 확장자의 파일들이 생성됨
# 만들어진 rsa 파일(.pub)들을 terminal에서 적용
# .ssh 폴더 내에 config 파일이 없다면 생성하여 작성
$ vi ~/.ssh/config
# Personal account-userA 이건 주석이라 아무 내용이나 적어도 상관없습니다. 
Host github.com-userA
	HostName github.com
	User git
	IdentityFile ~/.ssh/id_rsa_userA
# Personal account-userB
Host github.com-userB
	HostName github.com
	User git
	IdentityFile ~/.ssh/id_rsa_userB
	
# 위 내용의 Host 정보를 추가하여 github repository에서 clone을 실시함
```

- 프로젝트 폴더에서 사용할 계정 정보를 각 프로젝트의 설정 정보에 추가

  - 설정 이유 : 각 프로젝트 폴더에서 어떤 User email을 사용할지 로컬환경에 알려주기 위함

  > .gitconfig : git repository에 등록되어있는 설정파일

```bash
$ vi ~/.gitconfig
[user]
	email = userA@personal_email.com 
```

- 등록 확인 : Host 정보를 확인

```bash
$ ssh -T github.com-userA
# Hi USERA! You've successfully authenticated, but GitHub does not provide shell access.
$ ssh -T github.com-userB
# Hi USERB! You've successfully authenticated, but GitHub does   not provide shell access.
```



### 2. SSH KEY 사이트에 적용하기

- 생성한 rsa 파일(.pub)의 내용을 복사

```bash
# 형식 : 아래와 같으며 ssh-rsa부터 email 주소까지 모두 복사
ssh-rsa asdfvv4vsvw23 .... 생략 ...== userA@my_email.com
```

- Github 계정의 [ Settings ] - [ SSH and GPC keys ] 접속
- [ New SSH key ] 클릭하여 생성한 key를 등록
- [ Title ]에는 등록 정보에 대한 내용(개인이 구분할 수 있게만 입력. 아무 내용 상관 X)
- [ Key ] 항목에 만들어진 `ssh-key` 정보를 복사하여 입력
- Github에 key 등록이 완료되었다면 개인 로컬환경에도 적용

```bash
$ ssh-add ~/.ssh/id_rsa_userA
```

- GitHub, local 환경 모두 적용 완료시 Clone 작업 진행하기



### 3. Remote Repository Clone

- 기존에 사용하던 [ Clone with HTTPS ]  방식 대신 [ Clone with SSH ] 방식으로 Clone(Termial or Download ZIP)
- 앞에서 등록한 ~/.ssh/config에 등록한 정보를 이용해 Clone 하기

```bash
# ~/.ssh/config 정보 중 Host의 userA 정보가 중요함!
Host github.com-userA
```

- Clone 형태

  > git@github.com-userA:userA/repository-name.git

- Repository가 있는 상태에서 Remote url을 적용하려는 경우

  > git remote set-url origin git@github.com-userA:userA/repository-name.git



출처:

- https://medium.com/the-andela-way/a-practical-guide-to-managing-multiple-github-accounts-8e7970c8fd46