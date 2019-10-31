# [ Java Basic Grammer_13 ]

## 프로세스와 쓰레드(Process & Thread)

- 수행 방법
  - 프로그램 ----(실행)-----> 프로세스
- 정의
  - 프로그램 : 실행 가능한 파일(HDD)
  - 프로세스 : 실행 중인 프로그램(메모리), 자원(Resource)과 쓰레드로 구성
  - 쓰레드
    - 프로세스 내에서 실제 작업을 수행
    - 모든 프로세스는 하나 이상의 쓰레드를 가지고 있음
    - 비유
      - 프로세스 : 쓰레드 = 공장 : 일꾼
      - 싱글 쓰레드 프로세스 = 자원 + 쓰레드
      - 멀티 쓰레드 프로세스 = 자원 + 쓰레드 + 자원 + 쓰레드 + ..... + 쓰레드

- 비교(멀티 프로세스 VS 멀티 쓰레드)
  - 하나의 새로운 프로세스를 생성하는 것보다 하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 듬
  - 비유
    - 2 프로세스 1쓰레드 VS 1 프로세스 2쓰레드
- 멀티쓰레드 장단점
  - 장점
    - 자원을 보다 효율적으로 사용할 수 있다
    - 사용자에 대한 응답성이 향상된다
    - 작업이 분리되어 코드가 간결해진다
  - 단점
    - 동기화에 주의해야 한다
    - 교착상태가 발생하지 않도록 주의해야 한다
    - 각 쓰레드가 효율적으로 고르게 실행될 수 있게 해야 한다
  - 결론
    - 여러 면으로 좋은 점이 많지만, 프로그래밍시 고려해야할 사항이 많다!!

### 구현과 실행

- Thread 클래스를 상속

  ```java
  class MyThread extends Thread {
  	public void run() {		// Thread 클래스의 run()을 오버라이딩
  		/* 작업 내용 */
  	}
  }
  ```

- Runnable 인터페이스를 구현

  ```java
  public interface Runnable {
      public abstract void run();
  }
  
  class MyThread implements Runnalbe {
  	public void run() {		// Runnable 인터페이스의 추상메서드 run()을 구현
  		/* 작업 내용 */ 
  	}
  }
  ```

- 실행 예

  ```java
  ThreadEx1_1 t1 = new ThreadEx1_1();
  
  Runnable r = new ThreadEx1_2();
  Thread t2 = new Thread(r);		// 생성자 Thread(Runnable target)
  // Thread t2 = new Thread(new ThreadEx1_2());
  ```

- start() & run() 메서드

  ```java
  class ThreadTest {
  	public static void main(String[] args) {
  		MyThread t1 = new MyThread();
  		t1.start();
  	}
  }
  
  class MyThread extends Thread {
  	public void run() {
  		// ........
  	}
  }
  ```

- 쓰레드의 우선순위

  - 작업의 중요도에 따라 쓰레드의 우선순위를 다르게 하여 특정 쓰레드가 더 많은 작업시간을 갖도록 할 수 있다