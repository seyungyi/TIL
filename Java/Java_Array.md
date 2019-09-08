# [ Java Basic Grammer_3 ]

## 배열

- 1차원 배열 : 동일한 타입의 데이터들을 집합으로 다룰 수 있게 지원하는 데이터 구조

- 1차원 배열을 만드는 방법 : 처리할 데이터의 개수, 데이터의 타입

- 다량의 데이터를 다루는데 있어서 효율적

  ```java
  new 타입[크기]  or  타입[] 변수명;  or  타입 변수명[];  //참조형(주소값 참조)
  new String[24], new int[10], new char[26]
  ```

- 배열을 사용하는 방법

  - 배열을 생성한 다음에는 배열타입의 변수에 담아서 사용한다.

  - 타입명[] 변수명;  // 타입명 변수명[];

    ```java
    String[] str;    int[] nums;    char munja[];    double d[];
    
    - 4바이트, 배열의 참조값(주소값)
    int[] nums = new int[10];
    nums[0], nums[1], nums[2] …........ nums[9]
    temp = nums[5];
    System.out.println(nums[3]);
    ```

- 2차원 배열

  - 테이블 구조로 데이터들을 다룰 수 있게 지원하는 데이터 구조
  - 동일 크기를 갖는 1차원 배열이 여러 개 있는 구조
  - 생성 방법 : `new 타입[행의크기][열의크기]`={ {1, 2, 3, 4,}, {11, 22, 33, 44} }

  - 사용 방법 : 2차원 배열 변수에 담아서 사용한다.

    ```
    타입 변수명[][];   or   타입[] 변수명[];  or 타입[][] 변수명;
    ```

  ---

  JAVA 5(JDK 1.5)

  ---

- enhanced for(향상된 for문)

  ```
  for(타입 변수명 : 배열) {
  	실행문;
  	System.out.printf()
  } 
  ```

- Scanner : 입력받는 역할 API

  ```java
  Scanner 변수명 = new Scanner();
  ```

  - scan.next()  :  단어(워드), String 으로 읽어옴, 개행문자없이 단어만 읽어감
  - scan.nextLine() : 입력버퍼에 남아있는 개행문자를 청소하는 기능
  - scan.readLine() : 입력데이터를 한 행씩 읽음
  - scan.nextInt() : int
  - scan.nextDouble() : double

- label

  - break문의 label을 달아주면 break를 원하는 label설정구문을 종료시킬 수 있다.

    ```java
    label명 : for(int i=0; i<n; i++) {
    	for(int j=0; j<n; j++) {
    		break label;
    	}
    }
    --> 바깥의 label이 붙어있는 for문이 break되어 반복문 종료
    ```

### 시간 계산

- x * 3600 + y * 60 + z == time;
- 초를 시분초로 변환
  - 시간 : 3600 / TotalSecond
  - 분 : (3600 % 시간) / 60
  - 초 : (3600 % 시간) % 60
