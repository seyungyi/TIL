# [ Hadoop Yarn(Yet Another Resource Negotiator) ]

- Hadoop 컴포넌트 구성 ( HDFS 클러스터 + YARN 클러스터 )
  - HDFS(Hadoop Distributed File System) = 분산 파일 시스템
  - YARN(Yet Another Resource Negotiator) = 분산 컴퓨팅 환경을 제공

### < Yarn 클러스터 구성 >

- Resource Manager
  - Master 호스트에서 뜨는 데몬으로서 client 와 통신하는 역할을 한다. 
  - 클러스터에 있는 Worker 호스트들의 Resource 를 트래킹하여 Job 실행에 필요한 Node Manager 들을 컨트롤 하는 역할을 한다.
- Node Manager
  - Worker 호스트에 존재하는 데몬 으로서 실제로 job 을 처리하고 결과를 전달해주는 역할을 한다.
  - 사용자가 요청한 프로그램을 실행하는 Container를 fork 시키고 Container를 모니터링 Container 장애 상황 또는 Container가 요청한 리소스보다 많이 사용하고 있는지 감시한다.
- Container
  - YARN에서 쓰는 용어로서 리소스를 점유하는 하나의 단위이다. 
  - job 의 요청이 여러 개의 Map/Reduce Task 로 분리되어 Node Manager 에게 할당되면 Node Manager는 그 요청을 처리하기 위해 하나의 Container 를 실행하게 된다.
  - Container 는 우측에서 보는거와 같이 CPU, RAM 등의 리소스를 점유하여 task 를 처리하게 된다.

## < MapReduce 작업이 요청되어 처리되는 프로세스 >

- YARN 클러스터에 job 을 요청한 경우(= 클러스터에서 Process 를 Running 하는 ) 어떠한 방식으로 실행이 되는지 소개

1. Client 가 Application을 실행하고 클러스터의 Resource Manager에게 이를 알려 준다.
2. Resource Manager는 Worker 노드중에 하나를 골라 Container 를 생성한다. 그리고 그 Container 가 바로 Application Master 가 된다. 
3. Application Master는 task 를 실행할 컨테이너를 RM 에게 요청하게 된다. 
4. Application Master는 유휴한 자원을 소유한 노드의 Node Manager 를 통해 task 를 실행할 Container 를 생성하게 되고 task 를 실행하는 Container 는 task 의 상태( status) 를 Application Master 에게 알려준다.
5. 모든 task가 종료되면 AM도 종료되고 클러스터에 할당된 컨테이너의 자원도 모두 de-allocated 된다. 
6. Application client 도 종료된다.

## < 정리 >

- YARN 은 Application 의 job 을 분산 환경에서 병렬 처리할 수 있도록 도와주는 클러스터링 서비스이다.
- Resource Manager, Application Master, Node Manager 가 YARN 에서의 주요 컴포넌트이고 하나의 잡을 처리하기 위해 여러 개의 Task 를 나누고, 이를 처리하기 위한 Container 라는 개념이 존재한다.

## < Yarn 에서 MapReduce 동작 방법 >

- Hint
  - YARN의 실제 동작 방식을 이해하기 위해서는 MapReduce가 YARN클러스터에서 어떻게 동작하는지를 이해하는
    것이 가장 좋은 방법이다. 
  - MapReduce가 최초로 YARN을 사용하는 시스템이었으며, 같은 Hadoop 프로젝트내에 엮여있기 때문에 YARN을 가장 잘 사용하는 시스템이라고 할 수 있다. 

- YARN 클러스터에서 MapReduce 프로그램이 동작하는 과정

  ```bash
  1. YARN  클러스터를 기동
  # start-yarn.sh
  
  2. Mapper, Reducer, Driver(메인) 클래스를 작성
  
  3. YARN 환경에서는 Job 별로 클러스터를 구성
  
  4. 요청된 MapReduce 를 위한 클러스터를 구성하기 위해서는 1 개의 Application Master가 필요하며 이를 위해 YARN의 ResourceManager에게 리소스를 요청
  
  5. YARN의 ResourceManager는 요청받은 ApplicationMaster를 자신이 관리하는 클러스터(여러개의 NodeManager) 중 하나의 서버를 선택하여 ApplicationMaster를 실행하고 이 서버를 클라이언트에게 알려준다. ApplicationMaster는 요청받은 Job의 종류에 따라서 다르며 MapReduce에 사용되는 ApplicationMaster는 MRAppMaster (org.apache.hadoop.mapreduce.v2.app) 이다.
  
  6. 클라이언트는 ResourceManager로 부터 받은 ApplicationMaster 서버에 MapReduce 작업 요청을 한다.
  
  7. MRAppMaster는 작업 요청을 받으면 사용자가 실행한 MapReduce 작업에 필요한 리소스를 다시 ResourceManager에게 요청한다.
  
  8. ResourceManager는 요청받은 리소스에 대해 NodeManager를 지정하고 Container를 실행한 후 Container 목록을 MRAppMaster에 준다.
  
  9. NodeManager에 의해 실행된 MapReduce Task를 위한 Container는 MRAppMaster와 통신을 하며 주어진 Map Task와 Reduce Task를 실행한다.
  
  핵심 = 이 과정에서 MRAppMaster 객체의 재활용, Task를 위해 실행된 Container객체의 재활용 등은 MapReduce와 YARN의 버전업에 따라 처리 방식이 조금씩 다르다.
  ```

  