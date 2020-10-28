# [ Spring - Excetion ]

## @ExceptionHandler

- @Controller, @RestController가 적용된 Bean 내에서 발생하는 예외를 잡아서 하나의 메서드에서 처리해주는 기능을 하는 annotation

  ```java
  @RestController 
  public class MyRestController { 
      ... 
      ... 
      @ExceptionHandler(NullPointerException.class) 
      public Object nullex(Exception e) { 
          System.err.println(e.getClass()); return "myService"; 
      } 
  }
  ```

- 인자로 캐치하고 싶은 예외클래스를 annotation 매개변수로 등록하여 사용하면 됨

- 다중 등록 가능

  - ex) @ExceptionHandler({ Exception1.class, Exception2.class })

- 주의사항

  - Controller, RestController에서만 적용가능(Service 등은 안됨)
  - 해당 타입과 전혀 다른 리턴 타입을 사용해도 됨(= 리턴은 자유)
  - annotation을 등록한 Controller에만 적용됨



## @ControllerAdvice

- 모든 @Controller에서 발생할 수 있는 예외를 잡아 처리해주는 annotation

  ```java
  @RestControllerAdvice 
  public class MyAdvice { 
      @ExceptionHandler(CustomException.class) 
      public String custom() { 
          return "hello custom"; 
      } 
  }
  ```

- 별도의 속성값 없이 사용하면 전역에 있는 컨트롤러를 담당하게 됨

- RestControllerAdvice와 ControllerAdvice는 각각의 RestController, Controller에서 발생한 예외만 캐치함

- 전역의 예외를 패키지 단위로 제한 가능

  ```java
  @RestControllerAdvice("com.example.demo.login.controller")
  ```



## 실무 사용시

- 예외 발생시 정의하는 에러 인터페이스의 포맷이 일정해야함

- 두 종류의 모듈에서 각각 발생했을 때 리턴하는 타입을 @ControllerAdvice로 통합 처리하려하면 리턴 타입이 다르기에 통합해서 처리할 수 없는 문제가 발생

- 에러 처리의 좋은 경우는 HTTP 상태코드, ErrorResponse 등이 좋다

  - 에러 인터페이스와 포맷이 모두 같고 클라이언트 측에서도 이해하기 좋은 에러가 날라오기 때문임

  - @ExceptionHandler와 함께 아래과 같은 HTTP 상태코드를 리턴하기도 함

    ```java
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    ```

- 조건문에 따라 throw new XXXXException(); 명령으로 호출하면 에러 처리가 간단히 끝나 유지보수에 편리함

- 에러 관리 예제

```java
public enum LoginErrorCode { 
    OperationNotAuthorized(6000,"Operation not authorized"), 
    DuplicateIdFound(6001,"Duplicate Id"), 
    //... 
    UnrecognizedRole(6010,"Unrecognized Role"); 
    private int code; 
    private String description; 
    private LoginErrorCode(int code, String description) { 
        this.code = code; 
        this.description = description; 
    } 
    public int getCode() { 
        return code; 
    } 
    public String getDescription() { 
        return description; 
    } 
}
```