# [ Java Basic Grammer_8 ]

### Java의 API

- java.lang 패키지는 내장 패키지로서 import 문 선언이 필요하지 않다.

- java.lang : 프로그래밍 하면서 기본적으로 사용되는 클래스와 인터페이스(내장클래스)

- java.util : 다양하고 유용한 기능을 제공하는 클래스와 인터페이스

- java.net : 통신 프로그램을 개발할 때 필요로 하는 기능을 제공하는 클래스와 인터페이스

### 타입 확인

```
v1 == v2 -----> false

1234  2345

이 경우에는 객체주소를 참조하는 것이기 때문에 false라는 값이 나오는 것이다.

문자를 비교하기 위해서는 equlas 메소드를 오버라이딩하여 equlas로 비교를 해야한다

(조건에는 null인지 아닌지, instanceof로 해당 타입인지 Object타입으로 매개변수를 받아 실시해야한다)
```

### String API

- String - 읽는 용도, immutable(불변한)

- StringBuffer(StringBuilder) - 편집 용도

```java
String s = new String("abc");

s.toUpperCase() -> 대문자변환

s.toLowerCase() -> 소문자변환
```

### Collection API : 자료구조 API

데이터들의 집합을 좀더 편하고 효과적으로 다룰 수 있게 지원

리스트 : 데이터의 저장 순서를 유지한다

맵(Map) : 키(Key), 값(Value) 로 이루어져있다.

셋(Set) : 키 값을 저장한다

### Iterator

- 인터페이스로서 반복문과 동일한 기능을 수행



(일반)타입종료 : byte, short, int, long, float, double, char, boolean

(객체)java.lang : Byte, Short, Integer, Long, Float, Double, Character, Boolean



### Wrapper클래스

- 기본형 데이터를 객체로 만들고자할때(박싱), 기본형에 맞는 각 Wrapper클래스가 존재한다.

* Boxing 과 UnBoxing 이 자바 1.5버전부터 지원이 된다.
  * 자동으로 기본 -> 객체, 객체 -> 기본으로의 변환이 이루어짐

### ArrayList 와 LinkedList는 기능이 거의 같음

- 배열처럼 공간을 미리 할당하는 것이 아니라 값을 하나씩 추가하여 List를 생성하는 방식이다.

### HashSet

- 데이터를 저장하는 집합 API
- 랜덤 숫자 저장은 중복발생이 생기지 않는다.

### Collections 클래스

- Collection 객체.... 내용 추가예정