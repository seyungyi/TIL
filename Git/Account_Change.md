# [ Git 다른 계정으로 변경 - Key Chain or 자격증명 제거 ]

## 개요

- 사용자가 사용하는 Git의 계정이 2개 이상일 경우, bash terminal에서 계정을 변경한 후 Commit 명령 수행 이후 Github에 Push or Pull 하는 과정에서 발생하는 `Access Denied`가 발생하여 `Reject` 되는 경우에 사용할 수 있는 방법이다.



## 계정 변경 과정

### 1. Git 계정 변경

- Git bash에서 사용하려는 Git `username`과 `email` 정보로 변경한다.

  ```bash
  # git config 정보 확인(전체)
  $ git config --list
  
  # git 정보 전역 설정
  $ git config --global user.name '사용자이름'
  $ git config --global user.email '로그인 이메일'
  
  # git 정보 local 설정 : 해당 프로젝트에만 해당하는 계정 설정
  $ git config --local user.name '사용자이름'
  $ git config --local user.email '로그인 이메일'
  ```

### 2. Key Chain 등록 정보 제거 및 변경

- Windows
  - [ 제어판 ] - [ 사용자 계정 ] - [ Windows 자격증명 ] - [ github ] 삭제 or 변경하려는 계정으로 수정
- Mac
  - [ Key Chain Access App ] - [ github ] 암호 정보 클릭 - [ 계정 ]과 [ 암호 ]를 변경하려는 계정으로 수정