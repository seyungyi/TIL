# [ Jenkins ]

## Jenkins란?

- 소프트웨어 개발 과정에서 지속적으로 통합 서비스를 제공해주는 툴을 말한다.
- 지속적인 통합 서비스란 CI(Continous Integration)라 부른다.
- 2004년 여름 썬 마이크로시스템즈에서 허드슨 프로젝트로 개발되었으며, 2005년 2월에 java.net에 처음 출시가 되었다.
- 기존 방식(CI 툴의 등장 이전)
  - 일정 시간마다 빌드를 실행하는 방식
  - 개발자가 당일 작성한 코드들의 커밋이 끝난 심야 시간대에 빌드 과정이 타이머에 의해 집중적으로 진행이 되었다.
    - 이러한 빌드 과정을 nightly-build 라 부름
- 현재 방식(Jenkins와 같은 CI 툴 등장 이후)
  - 정기적인 빌드 뿐만 아니라 Git과 같은 버전관리시스템과 연동하여 소스의 커밋을 감지하면 자동적으로 자동화 테스트가 포함된 빌드가 작동되도록 설정할 수 있게 발전되었다.

## Jenkins의 이점

- 프로젝트 표준 컴파일 환경에서의 컴파일 오류 검출
- 자동화 테스트 수행
- 정적 코드 분석에 의한 코딩 규약 준수여부 체크
- 프로파일링 툴을 이용한 소스 변경에 따른 성능 변화 감시
- 결합 테스트 환경에 대한 배포작업
- 500여가지가 넘는 플러그인으로 간단한 설치 기능 제공
- 파이썬과 같은 스크립트를 이용해 손쉽게 자신에게 필요한 기능 추가 가능



## Jenkins 사용법

- 사용방법은 2가지 방법 중 하나를 선택하여 진행할 수 있다.

### Docker를 이용한 Jenkins 설치

- 실습에서 진행한 방법. Docker를 사용함으로 로컬 PC환경을 깔끔하게 유지하면서 사용법을 읽힐 수 있다.
- 사전에 Docker는 설치되어있다 가정하고 진행

1. Pull jenkins/jenkins:lts

   - jenkins 최신 버전의 경우보다 LTS 버전이 안정성이 좋지 않을까라는 생각으로 해당 버전을 선택 

   ```bash
   $ docker pull jenkins/jenkins:lts
   ```

2. Docker Jenkins Run

   - `-d` : 백그라운드 실행 옵션
   - `-p` : 포트 설정 -> 호스트 서버 9090 포트로 접근시 젠킨스 컨테이너 내부 8080 포트와 매핑
   - `-v` : 호스트와 볼륨을 공유. 빌드 결과물들을 호스트에서 공유 가능함
     - 콜론 기준 왼쪽 : 내 호스트 서버의 루트 경로로 잡음
     - 콜론 기준 오른쪽 : 컨테이너 내부 젠킨스 폴더 경로
     - **주의할 점** : 경로의 시작은 / 경로로 시작해야된다.
   - `--name` : 컨테이너 이름 설정
   - `jenkins/jenkins:lt` : pull 받은 image명과 버전. 버전을 적지 않으면 latest 버전으로 자동 pull or 실행

   ```bash
   $ docker run -d -p 9090:8080 -v /Desktop/jenkins:/var/jenkins_home --name jenkins -u root jenkins/jenkins:lt
   ```

3. Jenkins 접속하기

   - localhost:9090

4. 초기 접속시 Administrator password 입력 필수

   - 도커로 접속시 컨테이너 로그를 확인하여 비밀번호를 확인 가능

     ````bash
     $ docker container ls
     # CONTAINER ID 확인
     $ docker logs [CONTAINER ID]
     # 중간에 password 정보 확인
     ````

   - 일반 설치일 경우

     - /var/jenkins_home/secrets/initialAdminPassword 관리자 권한으로 열면 비밀번호 확인 가능

5. Install Plugin

   - 젠킨스 설치화면에 나오는 [ Install suggested plugins ] 으로 설치 진행

6. 설치 완료



### Jenkins 활용하기

1. SSH 연결을 통한 다른 서버 배포 프로세스

   1. 버전관리시스템에서 소스 코드 PULL

   2. 배포 서버에서 빌드 및 테스트 진행
   3. 실행 가능한 jar 파일 생성
   4. jar file 개발/운영 서버에 배포
   5. script 실행 : Application 동작



