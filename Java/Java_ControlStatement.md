# [ Java Basic Grammer_2 ]

## 제어문

- 조건제어문 : if, switch
- 반복제어문 : for, while, do while
- 분기제어문 : break, continue, (goto)자바지원안함

### 조건 제어문 - (if, else, else if)

```java
v1 == 100
v2 == true
v3 == 'A'
v4 == "duke" --> v4.equals("duke")
```

### 중접 if문( if문 안에 if문 사용)

```java
if( 조건식 ) {
    if( 조건식 ) {
    	실행문;
    } else {
    	실행문;
    }
}
```

### switch문

- switch문의 식의 결과는 정수 또는 문자열
- case 문의 값은 정수 상수만 가능, 중복 불가

```java
switch( 식 ) {
    case 값 :
    // 식의 결과가 값과 같을 경우 실행할 문장
    break;
    ...
    default :
    // 식의 결과가 값 이외의 경우 실행할 문장
    break;
}
```

 ### 자바의 반복문

- for : 반복할 횟수를 미리 알고 있을 때, 배열의 데이터 값을 다룰 때
- while : 어떤 조건이 만족되는 동안 반복
- for(;;) --> 무한루프

### Math 함수의 범위 공식

- Max 값 - Min 값 + 1 --> 예로 난수의 범위 값 지정시 사용

### 한글문자의 코드값

- 영문의 경우 ASCII 코드로 꾸준히 사용되어왔음.

- 초기 : 정해진 하늘 코드가 없었다.

  ```
  1989년 : KSC5601 --> 완성형한글코드
     EUC-KR
     MS949(CP949)
    가 - 0xB0A1
  1990년대 : 유니코드
  UTF-16 ---> 2바이트  ==> 자바에서 사용, 대부분의 언어에서도 사용
     A - \u0041
    가 - \uAC00
  UTF-8 ---> 1~4바이트
     A - \uEAB080
  ```

### 자바의 식별자(명칭) 규칙 : 클래스명, 메서드명, 변수명, 라벨명

- 영문대소문자와 숫자, _, $

- 숫자로시작 불가

- 길이제한은 없다고 본다(65535자)

- 자바의 예약어(키워드)는 사용 불가

  ```java
  (종류)
  ​ class, extends, implements, import
  
  ​ public, protected, private
  
  ​ static, final, abstract
  
  ​ instanceof
  
  ​ if, switch, while, for, do, break, continue, default
  
  ​ byte, short, int, long, float, double, boolean 
  ```

### 출력

- System.out.println(), System.out.print()

  - 출력할 데이터를 한 개만 전달 가능(아규먼트를 한 개만)

  ```java
  System.out.println("결과값="+result);
  System.out.println("결과값=", result);
  ```
  - 전달할 수 있는 데이터의 타입에 제한이 거의 없다.

---

Java 5(JDK1.5) 기준

---

- System.out.printf();

  - System.out.printf("….....")

  - System.out.printf("…......", …......)

  - System.out.printf("일반문자포맷문자")

  - 포맷문자 : %정해진문자

    ```
    %d, %o, %x --- 진수크기(2진, 8진, 16진)
    
    %s --- 문자열
    
    %c --- 문자
    
    %f --- %.3f
    ```