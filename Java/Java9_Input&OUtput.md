# [ Java Basic Grammer_9 ]

### Java의 Input&Output 프로그래밍

- 입력과 출력 프로그래밍

- 프로그램 실행에 필요한 데이터를 읽는다.(입력)

- 프로그램 실행의 결과를 내보낸다.(출력)

- 입력 ; 표준, 파일, 네트워크

- 출력 : 표준, 파일, 네트워크

- 입출력 대상에 관계없이 스트림이라는 논리적인 구조를 사용한다.
  - 즉, 스트림 객체를 사용한다.

---

(1) 입력용과 출력용으로 나눠어져 있다.

(2) 바이트 스트림과 문자 스트림으로 나눠져 있다.

- 주요 API(java.io)

  - File : 파일점검, 파일 생성, 파일 삭제, 파일 이름변경 등.....

  - FileReadler, FileWriter
  - BufferedReader, BufferedWriter
  - PrintWriter
  - FileInputStream, FileOutputStream
  - DataInputStream, DataOutputStream
  - InputStreamReader, OutputStreamWriter
    - 바이트스트림 객체를 문자스트림 객체로 변환하는 브릿지객체

### FileWriter객체

- FileWriter 객체 생성시에 path경로 이후에 true값을 주면 실행시 계속 오버라이딩 되는 것이다.

- 윈도우 메모장 등에서는 개행문자시 \n만 줘도 정상 개행처리가 되지만, 유닉스 등에서는 \r\n 모두 실시해야한다.
  - File객체는 개행을 하려면 필수적으로 \r\n 을 추가해야한다

- printf의 개행문자로 \n보다 %n이 더 운영체제에 맞춰서 실행해준다.

- close 기능을 finally에 구현하고자 하면 또다시 예외가 발생할 수 있기에 최초 구현시에

- try(변수선언과 객체생성) { } catch(....) { }   구문으로 해당 범위 밖이 된다면 자동으로 close기능이 구현되기에 수동으로 close기능을 구현할 필요가 없어진다.(단, 변수가 try내의 범위기에 범위 밖에서는 사용 불가),

- 수행코드를 여러개 적고자 한다면, 한개의 코드끝에 ;(세미콜론) 을 통해 구분 지어준다.