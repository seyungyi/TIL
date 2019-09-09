# [ Java Encoding Solution  ]

## BOM(Byte Order Mark)

- BOM이란 문서 맨 앞에 보이지 않는 특정 바이트를 넣은 다음 이것을 해석해서 정확히 어떤 인코딩 방식이 사용되었는지 알아내는 방법
- UTF-8의 경우 `EFBBBF`가 들어있음
- UTF-8에는 BOM이 없는 것이 보통이다. 단, 메모장과 같은 일부 윈도우즈 프로그램에서 UTF-8 저장시 BOM을 추가하고 있다. 이것이 문제를 발생하게 되는 것임
- [사이트 참조](https://brownbears.tistory.com/124)

## UTF Encoding

- UTF-16 ---- 자바가 지원 코드셋 - 한글영문모두 2바이트

  ```
  MS949(EUC-kR, KSC5601, CP949) --- Windows7
              한글 2바이트, 영문 1바이트
              UTF-16(2)     UTF-8(1~4)
              A - 0x41 ---------------------->\u0041
              가 - 0xB0A1 ------------------>\u00B0
                   0xB0A1 ------------------>\uAC00
  ```

- 외부에서 읽어들일때 어떤 코드셋이냐에 따라 UTF-8 등의 형식으로 읽어들인다.

### URL 프로그래밍 - IO 프로그래밍 응용

- URL 문자열(웹 사이트의 주소 문자열)

  ```
  http://서버의도메인명[:포트번호]/패스/파일
  ```

- URL이라는 클래스가 제공되어(java.net) 객체 생성시 지정된 URL문자열에 해당되는 사이트의 소스를 받아올 수 있다.

  > 웹 크롤링의 시작   => CSV(Coma Service V...)

## 객체 직렬화

```java
ObjectOutputStream - writeObject()

ObjectInputStream - readObject()
```