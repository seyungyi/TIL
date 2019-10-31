# [ Java Basic Grammer_1 ]

## 개발 환경

1. JDK 1.8(Java Development Kit)

   ```
   http://java.sun.com
   https://www.oracle.com/technetwork/java/index.html
   ```

2. Eclipse(IDE) - Java Developer, Enterprise

   ```
   http://www.eclipse.org/
   ```

3. 환경변수 설정 및 확인

   ```
   - 환경변수 설정
   1. [내 PC 속성] - [고급 시스템 설정] - [환경 변수] 창 접속
   2. [새로 만들기] - 변수 이름 : JAVA_HOME, 변수 값 : Java 설치한 JDK1.8 폴더 경로
   3. [Path 편집] - 가장 뒤에 추가 - [%JAVA_HOME%\bin;]
   
   - cmd 콘솔창 오픈
   java -version
   javac
   echo %JAVA_HOME%
   echo %PATH%
   ```

## 일반적인 구문

- 자바프로그램의 구조 - 클래스, main()
- 데이터 타입, 변수
- 연산자
- 제어문(조건, 반복, 분기)
  - if, switch, for, while, do while, break, continue
- 배열(1차원, 2차원)
- OOP1 : 클래스 정의와 객체 생성
- OOP2 : 상속, 다형성, 추상클래스와 인터페이스
- 예외처리

### 자바의 데이터 타입

- 넘버타입

  - 정수(byte(1), short(2), int(4), long(8))
  - 실수(float(4), double(8))
    - <long형과 float를 비교하면 실제 float형이 더 넓은 범위>

- 문자타입 : char(2) : UTF-16 유니코드방식

- 논리타입 : boolean(1 or ?)

  ---

- 문자열타입 : String

  ---

- 참조형(객체형) : String

  ---

- 데이터 타입별 범위(자바의 정석 page 29 참고) 

- 자바에서 다루게 되는 데이터의 종류(page 30)

  - 리터럴 : 프로그램 코드에 사용된 데이터 값

    ```
     100, 3.14, true, false, 10L, 'A', ' ', "", "가나다"
    ```

  - 변수

    - 데이터 값을 저장하는 메모리상의 방
    - 사용하기 전에 만들어서 사용해야 한다 - 변수 선언
    - 형태 = 타입명 변수명;
    - 변수명은 소문자로 시작하는 것이 관례

  - 상수

    - 변수, 값을 초기화 하면 더 이상 값을 변경할 수 없다.
    - 형태 = final 타입명 변수명;
    - 변수명은 모두 대문자(PI, MAX_NUMBER … )

- 대입 연산자, 할당 연산자( = )

| l-value | r-value                                                   |
| ------- | --------------------------------------------------------- |
| 변수    | 변수, 리터럴, 상수, 연산식, 리턴값이 있는 메서드의 호출식 |
| 큰 값   | 작은 값 --> 자동형변환                                    |
| 작은 값 | 큰 값(x) --> 강제형변환연                                 |

- 값의 크기 순서(값이 길이가 아닌 저장되는 범위가 기준이 됨)

  - double > float > long > int > short >byte

  - double > float > long > int > char

  - boolean : 절대 다른 타입 변환 불가

- 산술이항연산(+, -, /, *, %) : int 타입보다 작은 타입은 int로 변환

- 형변환 예시

  - char + int -> int + int -> int

  - char + char -> int + int -> int

  - int + int -> int

  - long + int -> long + long -> long

  - float + double -> double + double -> double

  - long + float -> float + float -> float

  - boolean -> 예외

  ```
  - 10(10진수), 010(8진수), 0x10(16진수), 0b10(2진수)
  Ex) "결과값="+10+20 ---> 결과값=1020
  "결과값="+(10+20) ---> 결과값=30
  ```

### 자바의 연산자

- 항(피연산자)의 개수 : 단항연산자, 이항연산자, 삼항연산자기능 : 강제형변환, 산술, 비교, 논리, 조건, 대입, 복합대입, 증감

- 종류 (우선순위별)

  ```
  - . (우선순위 제일 높음)
  
  ++, --, +, -, ~. !, (타입)
  
  사칙연산자1 : *, /, %
  
  사칙(부호)연산자2 : +, -
  
  쉬프트연산자 : >>, >>>, <<
  
  비교연산자 : >, >=, <=, ==, !=, instanceof
  
  논리연산자 : &, |, ^
  
  복합논리연산자1 : &&
  
  복합논리연산자2 : ||
  
  조건연산자 : 항1?항2:항3
  
  복합대입연산자 : =, +=, -=, *=, /=, &=
  
  = (우선순위 제일 낮음)
  ```

 

- 증감 연산자 : `++` : 단항연산자로서 주어진 항의 값을 1 증가
- 감소 연산자 : `--` : 단항연산자로서 주어진 항의 값을 1 감소
  - 대부분의 단항 연산자들은 연산자가 앞에오고 피연산자가 뒤에 온다
  - 위치
    - ++num : 전위형 - 먼저 증가시키고 다른 연산을 수행하라
    - num++ : 후위형 - 다른 연산을 먼저하고 나중에 증가시켜라 

### Argument와 Parameter

- Argument : 값을 전달하는 인자(전달인자)
- Parameter : 값을 받을 수 있는 방(매개변수)
