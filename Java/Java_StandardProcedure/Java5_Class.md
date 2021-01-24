# [ Java Basic Grammer_5 ]

nextInt(), nextDouble(), next() ....  ---> 원하는 타입값만을 읽어들임

nextLine() ---> 입력값이 무조건 String으로 읽어들임

​                 ---> 숫자 입력시 다시 숫자로 변환하는 작업 필요

​                        변환방법 : int 변수명 = Integer.parseInt(String);

# Class 정의와 객체 생성

### 객제지향언어

- 역사 : 최초는 군사를 위한 가상체험 시도를 위한 연구 중 객체에 대한 개념이론이 시행됨
- 특징 : 재사용성이 높음. 관리가 쉬워짐. 신뢰성이 높음

### 클래스

- 정의 : 객체를 정의해 놓은 것
- 종류 : 멤버변수, 생성자메서드, 일반메서드
- 사용용도 : 객체를 생성하는데 사용됨
- 사용방법
  - 클래스명.멤버 <--- 사용하려는 멤버가 static 인 경우

### 객체

- 실제로 존재하는 것. 사물 또는 개념
- 사용용도 : 객체의 속성과 기능에 따라 달라짐.

### 객체와 인스턴스

- 객체와 인스턴스는 결론적으로는 같은 개념이다
  - 단, 객체는 단일로는 "a는 객체이다" 라는 것으로 사용되고

- 인스턴스는 "a는 a클래스의 인스턴스이다" 라는 식으로 사용된다.
  - 인스턴스화 : 클래스로부터 인스턴스를 생성하는 것

### 객체의 구성요소

- 객체 = 속성과 기능의 집합이다. 속성과 기능을 객체의 멤버(구성요소)라고 한다.

- 속성 : 변수로 정의

- 기능 : 메서드로 정의 (동작)

### 생성자 메서드

- 클래스를 객체 생성할 떄 호출되는 메서드
- 호출식
  - new 생성자메서드호출식  ---> new Student()  or  new Member()
- 특징
  1. 메서드명이 클래스명과 동일해야 한다.
  2. 매개변수는 자유롭게, 오버로딩 가능
  3. 리턴값의 타입은 반드시 생략한다.(void(x)) == 리턴값이 없다
  4. 생성자 메서드를 만들지 않고 생성자 메서드를 생략가능

- 생성자 메서드가 존재하지 않는 클래스의 경우에는 컴파일러가 자동으로 생성자를 한 개 만든다 --> 디폴트 생성자라 한다.(매개변수 없다)

- javap = 어떤 소스로부터 컴파일 되어는지에 대한 정보를 보여줌

### 생성자

- 인스턴스가 생성될 때마다  호출되는 '인스턴스 초기화 메서드'

- 인스턴스 변수의 초기화 또는 인스턴스 생성시 수행할 작업에 사용

- 몇 가지 조건을 제외하고는 메서드와 동일

- 모든 클래스에는 최소 하나의 생성자가 존재 ---> 클래스에 생성자가 없다면 그건 디폴트로 생략되있는 것

- this() : 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용
  - 다른 생성자 호출은 생성자의 첫 문장에서만 가능

- this : 인스턴스 자신을 가리키는 참조변수
  - 인스턴스의 주소가 저장되어 있다(모든 인스턴스는 메서드에 지역변수로 숨겨진 채로 존재)

### 클래스 정의와 객체 생성 정리

- 클래스 : 객체를 생성하기 위한 프로그램 구조
  - 자바는 클래스 단위의 프로그래밍

- 객체 : 클래스를 메모리에 할당하여 사용 가능한 상태로 만든 것

- 객체변수(참조형 변수)에 저장하여, 연산자로 객체의 멤버들을 사용한다(private 형 멤버는 제외)

- 클래스 객체 생성시에는 어떤 생성자를 호출할 것인가?

- 생성자 메서드 정의 방법
  - 클래스명과 이름이 같아야 한다.
  - 리턴 타입을 생략한다.
  - 필요에 따라서 this() 메서드를 사용할  수 있다.
  - 여러 개로 오버로딩 할 수 있다.

- this, this() : this는 변수, this()는 메서드

### API : Appication Programming Interface

- 자주 사용되는 프로그램을 미리 만들어서 제공하는 것.
- 클래스로 제공된다.
- File 클래스 : 주어진 파일명의 파일이 존재하는 체크하는 메서드

### 프로그램 아규먼트 전달하기

- Run Configuration 실행시켜서 Argument항목에서 값 전달

### 메서드와 변수

1. 선언위치에 따른 변수 종류

- 멤버변수 - 클래스영역

  (1) 클래스변수 : 클래스가 메모리에 올라갈때 생성

  (2) 인스턴스 변수 : 인스턴스 생성시 생성( 클래스 영역은 클래스 선언 밑에)

- 메서드 영역

  (1) 지역변수 : 변수 선언문 수행시 생성(하나의 메서드 영역 안에)

2. 클래스 변수와 인스턴스 변수

- 인스턴스 변수 : 인스턴스가 생성될 때마다 생성되므로 인스턴스마다 각기 다른 값을 유지 가능(클래스 밑에 작성)

- 클래스 변수 : 모든 인스턴스가 하나의 저장공간을 공유하기에 항상 공통된 값 가짐 --> 고유의 값을 갖는 경우를 만들기 위해서는 static으로 만들면 안된다

- static 선언은 정적메서드 이기 때문에 불변의 값이라고 생각한다.

- static형 멤버는 참조형변수나, 클래스이름으로 접근 가능하지만 클래스이름으로 접근하는 것이 좋다.

3. 메서드 오버로딩

- 정의 : 기존의 메서드에 이름이 같지만 변수의 개수와 타입이 다른 메서드를 생성하는 것을 말한다.

### 상속

- 정의 : 기존의 클래스를 재사용해서 새로운 클래스를 작성하는 것

- 두 클래스를 조상과 자손으로 관계를 맺어주는 것

- 자손은 조상의 모든 멤버를 상속 받는다.(생성자, 초기화블럭 제외)

- 자손의 멤버개수는 조상보다 적을 수 없다(같거나 많다)

- 공통부분은 조상부분에서 관리하고, 개별부분은 자손부분에서 관리한다 --> 조상의 변경은 자손에 영향이 있지만, 자손의 변경은 조상에 영향 없다.

- 사용법 : class 자손 extends 조상 { .... }

### 포함

- 한 클래스의 멤버변수로 다른 클래스를 선언하는 것

- 작은 단위의 클래스를 먼저 만들고, 이 둘을 조합해서 하나의 커다란 클래스를 만든다.

### 상속과 포함의 사용

- is ~a (상속관계) : ~은 ~이다

- has ~a(포함관계) : ~은 ~을 가지고 있다.

### toString

- Object가 가지고 있는 메소드이기때문에 모든 클래스가 상속받는다.

- 기본 참조변수를 출력할시(print문) toString을 생략해도 자동으로 toString 결과값으로 처리된다.

### 메서드 오버라이딩

- 정의 : 조상클래스로부터 상속받는 메서드의 내용을 상속받는 클래스에 맞게 변경하는 것

### 접근 제어자

- public(공용)
- protected(같은 패키지 내에서만)
- (default)
- private(누구도 접근 불가)

### super() 메서드

- 없으면 자동으로 생성되어준다. 

- 가장 첫번째 행에 적어야 에러가 발생 안한다.

- 부모의 클래스를 사용한다.

- 단, 아규먼트를 안받는 경우에만 호출 가능(부모클래스에 아규먼트가 있으면 안됨)

- 자손을 부모에 맞추어야함