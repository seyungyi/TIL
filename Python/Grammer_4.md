# [ Python Basic Grammer_4 ]

## < 프로그래밍 꽃! 클래스와 모듈, 예외 처리 >

## 1. 프로그래밍 핵심, 클래스

- 클래스 개념

  - 클래스 : 똑같은 무엇인가를 계속해서 만들어낼 수 있는 설계 도면 같은 것

  - 인스턴스 : 클래스에 의해서 만들어진 피조물(=객체)

  - 객체와 인스턴스 차이 : 특정 객체가 어떤 클래스의 객체인지를 관계 위주로 설명할 때 사용됨(navi = Cat() --> navi는 객체, navi는 Cat의 인스턴스)

    ```python
    >>> class Simple:
    >>>     pass
    >>> a = Simple()
    ==> 1개의 클래스는 무수히 많은 인스턴스를 만들어 낼 수 있다
    ```

- 이야기 형식의 클래스 기초

  ```python
  1. 클래스 변수
  >> class Service:
      secret = "영구는 배꼽이 두 개다."
  >>> pey = Service()
  >>> pey.secret  --> '.'은 도트 연산자라 부른다
  "영구는 배꼽이 두 개다."
  
  2. 클래스 함수
  >>> class Service:
      secret = "영구는 배꼽이 두 개다."
      def sum(self, a, b):
          result = a + b
          print("%s + %s = %s입니다." % (a, b, result))
  >>> pey = Service()
  >>> pey.sum(1,1)
  1 + 1 = 2입니다.
  
  3. self 간단히 살펴보기
  - def(sum(self, a, b)) 에서 self는 클래스 함수의 첫 번째 인수로 받아야 하는 파이썬만의 특징이다. 단, self를 생략하면 호출 시 이용했던 인스턴스로 바뀌게 됨
  - self의 필요성
  : 필요성은 파이썬 언어의 개발 원리로 깊이 들어가야하기에, 단순히 클래스 내 함수의 첫 번째 인수는 무조건 self로 사용해야 인스턴스의 함수로 사용할 수 있다고만 알기
  - FourCal.setdata(a, 4, 2) 와 같이 '클래스명.메서드' 형태로 호출시 객체 a를 반드시 입력 인수로 꼭 넣어주어야 함
      
  4. __init__ 이란?
  : "인스턴스를 만들 때 항상 실행된다"는 의미, 즉 아이디를 부여받을 때 항상 실행된다는 말과 같음
  >>> pey = Service("홍길동")
  ```

- 클래스 자세히 알기

  - 클래스 : 인스턴스를 만들어내는 공장

  - 클래스의 구조

    ```python
    class 클래스 이름[(상속 클래스명)]:
        <클래스 변수 1>
        ...
        <클래스 변수 N>
        def 클래스 함수1(self[, 인수1, 인수2, ...]):
            <수행할 문장 1>
            <수행할 문장 2> ....
            
    - class = 클래스를 만들때 사용되는 예약어, 그 뒤에 클래스 이름 입력
    - 상속 클래스가 있을시 () 아넹 상속할 클래스명 입력 필수
    ```

- 사칙연산 클래스 만들기

  ```python
  1. 클래스를 어떻게 만들지 구상
  FourCal(사칙 연산 클래스):
      1. setdata 메소드 : 사칙 연산을 위한 두 숫자를 입력받기
      2. div 메서드 : 나누기 기능
      3. sub 메서드 : 빼기 기능
      4. sum 메서드 : 더하기 기능
      5. mul 메서드 : 곱하기 기능
       
  2. 클래스 구조 만들기
  >>> class FourCal:
      pass
  >>> a = FourCal()
  >>> type(a)
  <class '__main__.FourCal'> -> 객체 a의 타입은 FourCal 클래스이다
  
  3. 객체애 숫자 지정할 수 있게 만들기
  >>> class FourCal:
      def setdata(self, first, second):
          self.first = first
          self.second = second
  
  4. 더하기, 빼기, 곱하기, 나누기 기능 만들기
  >>> class FourCal:
      def setdata(self, first, second):
          self.first = first
          self.second = second
      def sum(self):
          result = self.first + self.second
          return result
     	def sub(self):
          result = self.first - self.second
          return result
      def mul(self):
          result = self.first * self.second
          return result
      def div(self):
          result = self.first / self.second
          return result
  ```

- '박씨네 집' 클래스 만들기 : 앞 순서는 사칙연산과 동일

  ```python
  >>> class HousePark:
      lastname = "박"
      def setname(self, name):
          self.fullname = self.lastname + name
      def travel(self, where):
          print("%s, %s여행을 가다." % (self.fullname, where))
  ```

- 초깃값 설정하기

  ```python
  >>> class HousePark:
      lastname = "박"
      def __init__(self, name):
          self.fullname = self.lastname + name
      def travel(self, where):
          print("%s, %s여행을 가다." % (self.fullname, where))
  >>> pey = HousePark("응용")
  >>> pey.travel("태국")
  ==> 초깃값 설정없는 상태의 소스에서는 클래스를 만들고 바로 travel함수 실행하려할 시 속성값 에러가 발생한다 ==> setname 함수를 통해 초깃값이 필수적이다
  ```

- 클래스의 상속

  - 상속 : '물려받다'라는 뜻으로, 어떤 클래스를 만들 때 다른 클래스의 기능을 물려받을 수 있게 만드는 것

  - 구조 : **class 상속받을 클래스명(상속할 클래스명)**

    ```python
    >>> class HouseKim(HousePark):
        lastname = "김"
    >>> juliet = HouseKim("줄리엣")
    >>> juliet.travel("독도")
    김줄리엣, 독도여행을 가다
    ```

  - 메서드 오버라이딩 : 메서드 이름을 동일하게 다시 구현하는 것. 즉, 상속받을 대상인 클래스의 메서드와 이름은 같지만 행동이 다르게 할 때 사용

    ```python
    >>> class HouseKim(HousePark):
        lastname = "김"
        def travel(self, where, day):
            print("%s, %s여행 %d일 가네." % (self.fullname, where,day))
    ```

- 연산자 오버로딩 : 연산자(+,-,*,/,,,)를 객체끼리 사용할 수 있게 하는 기법

  ```python
  # house.py
  >>> class HousePark:
      lastname = "박"
      def __init__(self, name):
          self.fullname = self.lastname + name
      def travel(self, where):
          print("%s, %s여행을 가다." % (self.fullname, where))
      def love(self, other):
          print("%s, %s 사랑에 빠졌네" % (self.fullname, other.fullname))
      def __add__(self, other):
          print("%s, %s 결혼했네" % (self.fullname, other.fullname))
  >>> class HouseKim(HousePark):
      lastname = "김"
      def travel(self, where, day):
          print("%s, %s여행 %d일 가네." % (self.fullname, where, day))
  >>> pay = HousePark("응용")
  >>> juliet = HouseKim("줄리엣")
  >>> pey.love(juliet)
  박응용 ,김줄리엣 사랑에 빠졌네
  >>> pey + juliet
  박응용 ,김줄리엣 결혼했네
  ```

- '박씨네 집' 클래스 완성하기

  ```python
  # house.py
  >>> class HousePark:
      lastname = "박"
      def __init__(self, name):
          self.fullname = self.lastname + name
      def travel(self, where):
          print("%s, %s여행을 가다." % (self.fullname, where))
      def love(self, other):
          print("%s, %s 사랑에 빠졌네" % (self.fullname, other.fullname))
      def __add__(self, other):
          print("%s, %s 결혼했네" % (self.fullname, other.fullname))
      def __fight__(self, other):
          print("%s, %s 싸우네" % (self.fullname, other.fullname))
      def __sub__(self, other):
          print("%s, %s 이혼했네" % (self.fullname, other.fullname))
          
  >>> class HouseKim(HousePark):
      lastname = "김"
      def travel(self, where, day):
          print("%s, %s여행 %d일 가네." % (self.fullname, where, day))
  >>> pay = HousePark("응용")
  >>> juliet = HouseKim("줄리엣")
  >>> pey.travel("부산")
  박응용, 부산여행을 가다
  >>> juliet.travel("부산", 3)
  김줄리엣, 부산여행 3일을 가네.
  >>> pey.love(juliet)
  박응용 ,김줄리엣 사랑에 빠졌네
  >>> pey + juliet
  박응용 ,김줄리엣 결혼했네
  >>> pey.fight(juliet)
  박응용, 김줄리엣 싸우네
  >>> pey - juliet
  박응용, 김줄리엣 이혼했네
  ```

## 2. 모듈

- 정의

  - 함수나 변수 또는 클래스 들을 모아 놓은 파일을 말함
  - 다른 파이썬 프로그램에서 불러와 사용할 수 있게끔 만들어진 파이썬 파일이기도 함
  - 만들어 놓은 모듈을 사용하기도 하고, 직접 만들어 사용할 수도 있다

- 모듈 만들고 불러 보기 ( import 모듈이름 )

  ```python
  - 모듈 만들기
  # mod1.py
  >>> def sum(a,b):
     	 return a+b
  ==> 그동안 에디터로 만들어 왔던 파일 모두가 모듈이다!!
  
  - 모듈 불러오기
  >>> import mod1
  >>> print(moa1.sum(3,4))
  7
  
  - 모듈 함수를 사용하는 다른 방법
  ==> from 모듈이름 import 모듈함수
  >>> from mod1 import sum
  >>> sum(3, 4)
  7
  >>> from mod1 import sum, 다른 함수 ==> mod1의 여러 함수 불러오기
  >>> from mod1 import * ===> mod1 모듈의 모든 함수를 불러온다는 의미
  ```

- if `__name__` == "`__main__`":의 의미

  - 모듈 안에 print문 등이 있을 경우 자동으로 무조건 실행될 경우를 방지함

  ```python
  # mod1.py
  >>> def sum(a,b):
     	 return a+b
      def safe_sum(a,b):
          if type(a) != type(b):
              print("더할 수 있는 것이 아닙니다.")
              return
         	else:
              result = sum(a,b)
          return result
  # 추가한 부분
  	print(safe_sum('a',1))
  	print(safe_sum(1,4))
  	print(sum(10, 10.4))
  
  - 실행시
  >>> import mod1
  더할 수 있는 것이 아닙니다.
  None
  5
  20.4
  
  - 추가부분 수정
  >>> def sum(a,b):
     	 return a+b
      def safe_sum(a,b):
          if type(a) != type(b):
              print("더할 수 있는 것이 아닙니다.")
              return
         	else:
              result = sum(a,b)
          return result
      
  	if __name__ == "__main__":
          print(safe_sum('a',1))
          print(safe_sum(1,4))
          print(sum(10, 10.4))
          
  ==> C:\Python>python mod1.py처럼 직접 파일을 실행시켰을 경우에만 해당 print문을 실행한다.
      
  >>> import mod1
  >>>
  ```

- 클래스나 변수 등을 포함한 모듈

  ```python
  # mod2.py
  PI = 3.141592
  class Math:
      def solv(self, r): -> 반지름 계산
          return PI * (r ** 2)
     	def sum(a,b):
          return a+b
      if __name__ == "__main__":  --> 파일을 직접 실행했을때 수행
          print(PI)
          a = Math()
          print(a.solv(2))
          print(sum(PI, 4.4))
          
  - 모듈에 포함된 변수, 클래스, 함수 사용
  >>> print(mod2.PI)
  3.141592
  >>> a = mod2.Math()
  >>> print(a.solv(2))
  12.566368
  >>> print(mod2.sum(mod2.PI, 4.4))
  7.541592
  ```

- 새 파일 안에서 이전에 만든 모듈 불러오기 : 파이썬 파일 안에 만들어 놓은 모듈 불러와 사용하기

  ```python
  # modtest.py
  import mod2
  result = mod2.sum(3,4)
  print(result)
  
  - 사용하려는 모듈은 동일한 디렉터리에 존재해야함
  - 모듈 불러오는 다른 방법
  # mo2.py르 C:\Python\Mymodules라는 디렉터리에 저장
  1. sys.path.append(모듈을 저장한 디렉터리) 사용하기
  >>> import sys
  sys는 파이썬 설치시 설치되는 라이브러리 모듈
  >>> sys.path
  설치된 경로 디렉터리 결과를 보여줌.....
  >>> sys.path.append("C:/Python/Mymodules")
  >>> sys.path
  모듈이 저장된 디렉터리가 추가되있음...
  >>> import mod2
  >>> print(mod2.sum(3,4))
  7
  2. PYTHONPATH 환경 변수 사용하기
  C:\Users\home>set PYTHONPATH=C:\Python\Mymodules
  >>> import mod2
  >>> print(mod2.sum(3,4))
  7
  ```

## 3. 패키지

- 정의 : 도트(.)를 이용해 파이썬 모듈을 계층적(디렉터리 구조)으로 관리할 수 있게 해준다

- 예) 모듈명이 A,B인 경우 A는 패키지명이 되고 B는 A 패키지의 B모듈이 됨

  ```python
  game/
  	__init__.py
      sound/
      	__init__.py
          echo.py
          wav.py
      graphic/
      	__init__.py
          screen.py
          render.py
      play/
      	__init__.py
          run.py
          test.py
  ```

- 패키지 만들기

  - 패키지 기본 구성 요소 준비

    1. C:/Pythono 안에 game 및 기타 서브 디렉터리 생성 후 .py 만들기

       ```
       C:/Python/game/__init__.py
       C:/Python/game/sound/__init__.py
       C:/Python/game/sound/echo.py
       C:/Python/game/graphic/__init__.py
       C:/Python/game/graphic/render.py
       ```

    2. 각 디렉터리에 `__init__`.py 파일 만들기만 한다

    3. echo.py 만들기

       ```python
       # echo.py
       def echo_test():
           print("echo")
       ```

    4. render.py 만들기

       ```python
       # render.py
       eef render_test():
           print("render")
       ```

    5. game 패키지 참조할 수 있게 set 명령어로 PYTHONPATH 환경 변수에 모듈 디렉터리 추가

       ```python
       C:\> set PYTHONPATH=C:/Python
       C:\> python
       >>>
       ```

  - 패키지 안의 함수 실행

    - import 예제들은 하나의 예제를 실행후 다름 예제 실행 시에는 반드시 인터프리터를 종료하고 다시 실행해야함

    1. echo 모듈 import 하여 실행

       ```python
       >>> import game.sound.echo
       >>> game.sound.echo.echo_test()
       echo
       ```

    2. echo 모듈이 있는 디렉터리까지를 from ... import 하여 실행

       ```python
       >>> from game.sound import echo
       >>> echo.echo_test()
       echo
       ```

    3. echo 모듈의 echo_test 함수를 직접 import 하여 실행

       ```python
       >>> from game.sound.echo import echo_test
       >>> echo_test()
       echo
       ```

    4. 다음의 경우들은 사용 불가

       ```python
       - case 1
       >>> import game
       >>> game.sound.echo.echo_test()
       Traceback (most recent call last):
           File "<stdin>", line 1, in <module>
       AttributeError: 'module' object has no attribute 'sound'
       ==> import game 수행은 game 디렉터리 모듈 또는 game 디렉터리 __init__.py에 정의된 것만 참조 가능
       
       - case 2
       >>> import game.sound.echo.echo_test
       Traceback (most recent call last):
           File "<stdin>", line 1, in <module>
       ImportError: No module named echo_test
       ==> 도트 연산자(.)를 사용하여 import a.b.c처럼 import할 때는 가장 항목인 c는 반드시 모듈 또는 패키지 여야 한다
       ```

- `__init__.py`의 용도 : 해당 디렉터리가 패키지의 일부임을 알려주는 역할

  ```python
  >>> import game.sound.echo
  Traceback (most recent call last):
      File "<stdin>" ,line 1, in <module>
  ImportError: No module named sound.echo
  ==> sound 디렉터리에 __init__.py 파일이 없어서 임포트 오류가 발생
  ```

- `__all__`의 용도 : 패키지 디렉터리에서 * 기호를 이용하여 import 할 경우 이곳에 정의된 모듈만 import 된다는 의미

  ```python
  >>> from game.sound import *
  >>> echo.echo_test()
  Traceback (most recent call last):
      File "<stdin>" ,line 1, in <module>
  NameError: name 'echo' is no defined
      
  - 해결 방법
  = 특정 디렉터리의 모듈을 * 이용하여 import할 때에는 해당 디렉터리의 __init__.py파일에 __all__이라는 변수를 설정하고 import할 수 있는 모듈을 정의해야함
  C:/Python/game/sound/__init__.py
  __all__ = ['echo']
  
  >>> from game.sound import *
  >>> echo.echo_test()
  echo
  ```

- relative 패키지

  - relative한 접근자로 다른 디렐터리의 모듈을 사용하게 해줌

    ```python
    - case 1 : 전체 경로를 이용하여 import
    # render.py
    from game.sound.echo import echo_test
    def render_test():
        print("render")
        echo_test()   
    >>> from game.graphic.render import render_test
    >>> render_test()
    render
    echo
    
    - case 2 : 현재 디렉터리 경로를 기준으로 import (.. 은 부모 디렉터리를 의미)
    # render.py
    from ..sound.echo import echo_test
    def render_test():
        print("render")
        echo_test()
    ```

  - relative한 접근자는 render.py와 같이 모듈 안에서만 사용해야 함

  - 파이썬 인터프리터에서 relative한 접근자 사용시 'SystemError: cannot perform relative import'와 같은 오류 발생

## 4. 예외 처리

- 오류가 발생하는 시기 : 오류는 종류가 다양하기에 발생하는 시기도 천차만별

  ```python
  - case 1 : 디렉터리 안에 없는 파일을 열려고 시도했을때 발생하는 오류
  >>> f = open("나없는파일", 'r')
  Traceback (most recent call last):
      File "<stdin>", line 1, in <module>
  FileNotFoundError: [Error 2] No such file or directory: '나없는파일'
          
  - case 2 : 0으로 다른 숫자를 나눌 때 발생하는 오류
  >>> 4 / 0
  Traceback (most recent call last):
      File "<stdin>", line 1, in <module>
  ZeroDivisionError: division by zero
  
  - case 3 : 리스트 내에서 얻을 수 없는 값을 호출하려할때 발생하는 오류
  >>> a = [1, 2, 3]
  >>> a[4]
  Traceback (most recent call last):
      File "<stdin>", line 1, in <module>
  IndexError: list index out of range
  ```

- 오류 예외 처리 기법 : 유연한 프로그래밍을 위한 오류 처리

  - try, except문 : try 블록 수행중 오류 발생시 except 블록 수행

    ```python
    try:
        ...
    except [발생 오류[as 오류 메시지 변수]]:
        ...
    ==> []기호는 괄호 안의 내용을 생략할 수 있다는 관례적인 표기법
    ```

    1. try, except만 쓰는 방법 : 위와 동일

    2. 발생 오류만 포함한 except문 : 미리 정해 놓은 오류 일음과 일치할 때만 except 블록 수행

       ```python
       try:
           ...
       except 발생 오류:
           ...
       ```

    3. 발생 오류와 오류 메시지 변수까지 포함한 except문 : 두번째 경우에서 오류 메시지의 내용까지 알고 싶을때 사용

       ```python
       try:
           ...
       except 발생 오류 as 오류 메시지 변수:
           ...
       
       ex)
       try:
           4/0
       except ZeroDivisionError as e:
           print(e)
       결과값: division by zero
       ```

  - try .. else : 예외가 발생하지 않은 경우 else절 실행. else절은 except절 바로 다음에 위치해야함

    ```python
    try:
        f = open('foo.txt', 'r')
    except FileNotFoundError as e:
        print(str(e))
    else:
        data = f.read()
        f.close()
    => 만약 foo.txt라는 파일이 없다면 except절이 수행되고 foo.txt파일이 있다면 else절이 수행됨
    ```

  - try .. finally

    - try문 수행 도중 예외 발생 여부 상관없이 항상 수행됨

    - 보통 finally절은 사용한 리소스를 close해야 할 경우 많이 사용

      ```python
      f = open('foo.txt', 'w')
      try:
          # 무언가를 수행한다
      finally:
          f.close()
      => foo.txt라는 파일을 쓰기모드로 연 후 try문 수행된 후 예외 발생 여부 상관없이 finally절에서 f.close()로 열린 파일을 닫을수 있음
      ```

- 오류 회피하기 : 프로그래밍시 특정 오류 발생시 그냥 통과시켜야할 경우 사용

  ```python
  try:
      f = open("나없는파일", 'r')
  except FileNotFoundError:
      pass
  ```

- 오류 일부러 발생시키기 : 회피와 반대로 일부러 발생시킬 때 사용(raise)

  ```python
  class Bird:
      def fly(self):
          raise NotImplementedError
          
  class Eagle(Bird):
      pass
  >>> eagle = Eagle()
  >>> eagle.fly()
  Traceback(most recent call last):
      File "...", line 33, in <module>
      	eagle.fly()
      File "...", line 26, in fly
      	raise NotImplementedError
  NotImplementedError
  
  - 예외 발생되지 않게 하려면 Eagle 클래스에 fly함수를 반드시 구현
  class Eagle(Bird):
      def fly(self):
          print("very fast")
  >>> eagle = Eagle()
  >>> eagle.fly()
  very fast
  ```