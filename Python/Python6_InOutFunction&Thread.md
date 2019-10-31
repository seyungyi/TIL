# [ Python Basic Grammer_6 ]

## < 파이썬 내장함수 및 외장 함수, 스레드>

## 1. 내장 함수

- abs : 어떤 숫자를 입력으로 받을 때, 그 숫자의 절대값을 돌려주는 함수

  ```python
  >>> abs(3)
  3
  >>> abs(-3)
  3
  ```

- all : **반복 가능한 자료형** x를 입력 인수로 받으며, 이 x가 모두 참이면 True, 거짓이 하나라도 있으면 False를 리턴

  - 반복 가능한 자료형 : for문으로 그 값을 출력할 수 있는 것(리스트, 튜플, 문자열, 딕셔너리, 집합 등)

  ```python
  >>> all([1,2,3])
  True
  >>> all([1,2,3,0])
  False
  ```

- any : x중 하나라도 참이 있을 경우 True, x가 모두 거짓일 경우에만 False 리턴. all(x)의 반대

  ```python
  >>> any([1,2,3,0])
  True
  >>> any([0, ""])
  False
  ```

- chr : 아스키(ASCII) 코드값을 입력으로 받아 코드에 해당하는 문자열 출력

  ```python
  >>> chr(97)
  'a'
  >>> chr(48)
  '0'
  ```

- dir : 객체가 자체적으로 가지고 있는 변수나 함수를 보여주는 함수

  ```python
  >>> dir([1, 2, 3])
  ['append', 'count', 'extend', 'index', 'insert', 'pop', ...]
  >>> dir({'1':'a'})
  ['clear', 'copy', 'get', 'has_key', 'items', 'keys', ...]
  ```

- divmod : divmod(a,b)는 2개의 숫자를 입력받아 a를 b로 나눈 몫과 나머지를 튜플 형태로 리턴하는 함수

  ```python
  >>> divmod(7,3)
  (2,1)
  >>> divmod(1.3, 0.2)
  (6.0, 0.0999999999999999978)
  ```

- enumerate : '열거하다'라는 뜻. 순서가 있는 자료형(리스트, 튜플, 문자열)을 입력받아 인덱스 값을 포함하는 enumerate 객체를 리턴

  ```python
  >>> for i, name in enumerate(['body', 'foo', 'bar']):
      print(i, name)
      ...
  0 body
  1 foo
  2 bar
  ```

- eval : eval(expression). 실행 가능한 문자열(1+2, 'hi'+'a'같은 것)을 입력받아 문자열을 실행한 결과값을 리턴받는 함수

  - 보통 eval은 입력받은 문자열로 파이썬 함수나 클래스를 동적으로 실행하고 싶은 경우에 사용함

  ```python
  >>> eval('1+2')
  3
  >>> eval("'hi' + 'a'")
  'hia'
  >>> eval('divmod(4,3)')
  (1,1)
  ```

- filter : 첫 번째 인수로 함수 이름, 두 번째 인수로 함수에 차례로 들어갈 반복 가능한 자료형을 받는다. 두 번째 인수의 요소들이 첫 번째 인수인 함수에 입력됬을때 리턴값이 참인 것만 묶어서 돌려준다

  ```python
  # positive.py
  def positive(numberList):
      result = []
      for num in numberList:
          if num > 0:
              result.append(num)
      return result
  print(positive([1, -3 ,2, 0, -5, 6]))
  결과값 : [1, 2, 6]
      
  - filter 적용시
  # filter1.py
  def positive(x):
      return x > 0
  print(list(filter(positive, [1, -3, 2, 0, -5, 6])))
  결과값 : [1, 2, 6]
  - lambda 적용시
  >>> print(list(filter(lambda x: x>0, [1,-3,2,0,-5,6])))
  ```

- hex : 정수값을 입력받아 16진수로 변환하여 리턴

  ```python
  >>> hex(234)
  '0xea'
  >>> hex(3)
  '0x3'
  ```

- id : 객체를 입력받아 객체의 고유 주소값(레퍼런스)을 리턴

  ```python
  >>> a = 3
  >>> id(3)
  135072304
  >>> id(a)
  135072304
  >>> b = a
  >>> id(b)
  135072304
  >>> id(4)
  135072292
  ```

- input : 사용자 입력을 받는 함수

  ```python
  >>> a = input()
  hi
  >>> a
  'hi'
  >>> b = input("Enter: ") --> Enter: 라는 프롬프트를 띄우고 사용자 입력을 받음
  ```

- int : 문자열 형태의 숫자나 소수점이 있는 숫자 등을 정수 형태로 리턴하는 함수

  ```python
  >>> int('3')
  3
  >>> int(3.4)
  3
  -- int(x, radix) : radix진수로 표현된 문자열 x를 10진수로 변환하여 리턴
  >>> int('11', 2)
  3
  >>> int('1A', 16)
  26
  ```

- isinstance : 첫 번째 인수로 인스턴스, 두 번째 인수로 클래스 이름을 받는다. 받은 인스턴스가 그 클래스의 인스턴스인지를 판단해 참이면 True, 거짓이면 False를 리턴

  ```python
  >>> class Person: pass
  >>> a = Person()
  >>> isintance(a, Person)
  True
  >>> b = 3
  >>> isintance(b, Person)
  False
  ```

- lambda : 함수를 생성할 때 사용하는 예약어로, def와 동일한 역할. 보통 함수를 한 줄로 간결하게 만들 때 사용함

  - 구조 : lambda 인수1, 인수2, ... -> 인수를 이용한 표현

  ```python
  >>> myList = [lambda a, b:a+b, lambda a,b:a*b]
  >>> myList
  [at 0x811eb2c>, at 0x811eb64>]
  >>> myList[0](3,4)
  7
  >>> myList[1](3,4)
  12
  ```

- len : 입력값의 길이(요소의 전체 개수)를 리턴하는 함수

  ```python
  >>> len("python")
  6
  >>> len((1, 'a'))
  2
  ```

- list : 반복 가능한 자료형을 입력받아 리스트로 만들어 리턴하는 함수

  ```python
  >>> list("python")
  ['p', 'y', 't', 'h', 'o', 'n']
  >>> list((1,2,3))
  [1,2,3]
  ```

- map : map(f, iterable)은 함수(f)와 반복 가능한 자료형을 입력으로 받는다. 입력 받은 자료형의 각 요소가 함수 f에 의해 수행된 결과를 묶어서 리턴

  ```python
  - 기존 방식
  # two_time.py
  def two_time(numberList):
      result = []
      for number in numberList:
          result.append(number*2)
      return result
  result = two_time([1,2,3,4])
  print(result)
  결과값 : [2,4,6,8]
      
  - map 함수 적용
  >>> def two_time(x): return x*2
  ...
  >>> list(map(two_time, [1, 2, 3, 4]))
  [2, 4, 6, 8]
  >>> list(map(lambda a: a*2, [1, 2, 3, 4]))
  [2, 4, 6, 8]
  
  # map_test.py
  def plus_one(x):
      return x+1
  print(list(map(plus_one, [1, 2, 3, 4, 5])))
  결과값 : [2, 3, 4, 5, 6]
  ```

- max : 인수로 반복 가능한 자료형을 입력받아 최대값을 리턴

  ```python
  >>> max([1, 2, 3])
  3
  >>> max("python")
  'y'
  ```

- min : 인수로 반복 가능한 자료형을 입력받아 최소값을 리턴

  ```python
  >>> min([1, 2, 3])
  1
  >>> min("python")
  'h'
  ```

- oct : 정수 형태의 숫자를 8진수 문자열로 바꾸어 리턴하는 함수

  ```python
  >>> oct(34)
  '0o42'
  >>> oct(12345)
  '0o30071'
  ```

- open : open(filename, [mode]). 파일이름과 읽기 방법을 입력받아 파일 객체를 리턴

  | 모드 | 설명                      |
  | ---- | ------------------------- |
  | w    | 쓰기 모드로 파일 열기     |
  | r    | 읽기 모드로 팡리 열기     |
  | a    | 추가 모드로 파일 열기     |
  | b    | 바이너리 모드로 파일 열기 |

  

  ```python
  >>>f = open("binary_file", "rb")
  >>> fread = open("read_mode.txt", 'r')
  >>> fread2 = open("read_mode.txt")
  >>> fappend = open("append_mode.txt", 'a')
  ```

- ord : 문자의 아스키 코드값을 리턴

  ```python
  >>> ord('a')
  97
  >>> ord('0')
  48
  ```

- pow : pow(x,y)는 x의 y 제곱한 결과를 리턴

  ```python
  >>> pow(2,4)
  16
  >>> pow(3,3)
  27
  ```

- range

  - 구조 : range([start], stop [, step])
  - for문과 함께 자주 사용되는 함수
  - 입력받은 숫자에 해당하는 범위의 값을 반복 가능한 객체로 만들어 리턴

  ```python
  1. 인수가 1개일 경우
  >>> list(range(5))
  [0, 1, 2, 3, 4]
  
  2. 인수가 2개일 경우
  >>> list(range(5, 10))
  [5, 6, 7, 8, 9, 10]
  
  3. 인수가 3개일 경우
  >>> list(range(1, 10, 2))
  [1, 3, 5, 7, 9]
  >>> list(range(0, -10, -1))
  [0, -1, -2, -3, -4, -5, -6, -7, -8, -9]
  ```

- sorted : 입력값을 정렬한 후 그 결과를 리스트로 리턴하는 함수

  ```python
  >>> sorted([3, 1, 2])
  [1, 2, 3]
  >>> sorted(['a', 'c', 'b'])
  ['a', 'b', 'c']
  >>> sorted("zero")
  ['e', 'o', 'r', 'z']
  >>> sorted((3, 2, 1))
  [1, 2, 3]
  
  - 주의사항 : 리스트 자료형의 sort함수는 리스트 정렬만 하지 정렬결과를 리턴하지 않음
  >>> a = [3, 1, 2]
  >>> result = a.sort()
  >>> print(result)
  None
  >>> a
  [1, 2, 3]
  ```

- str : 문자열 형태로 객체를 변환하여 리턴

  ```python
  >>> str(3)
  '3'
  >>> str('hi')
  'hi'
  >>> str('hi'.upper())
  'HI'
  ```

- tuple : 반복 가능한 자료형을 입력받아 튜플 형태로 바꾸어 리턴하는 함수. 튜플이 들어오면 그대로 리턴

  ```python
  >>> tuple("abc")
  ('a', 'b', 'c')
  >>> tuple([1, 2, 3])
  (1, 2, 3)
  >>> tuple((1, 2, 3))
  (1, 2, 3)
  ```

- type : 입력값의 자료형이 무엇인지 알려주는 함수

  ```python
  >>> type("abc")
  <class 'str'>
  >>> type([])
  <class 'list'>
  >>> type(open("test", 'w'))
  <class '_io.TextIOWrapper'>
  ```

- zip : 동일한 개수로 이루어진 자로형을 묶어 주는 역할을 하는 함수

  ```python
  >>> list(zip([1, 2, 3], [4, 5 ,6]))
  [(1, 4), (2, 5), (3, 6)]
  >>> list(zip([1, 2, 3], [4, 5 ,6], [7, 8, 9]))
  [(1, 4, 7), (2, 5, 8), (3, 6, 9)]
  >>> list(zip("abc", "def"))
  [('a', 'd'), ('b', 'e'), ('c', 'f')]
  ```

## 2. 외장 함수

- sys

  - 정의 : 파이썬 인터프리터가 제공하는 변수들과 함수들을 직접 제어할 수 있게 해주는 모듈

  - 명령 행에서 인수 전달하기 - sys.argv

    ```python
    - sys.argv라는 리스트에 값들 추가
    C:/User/home>python test.py abc pey guido
    
    # argv_test.py
    import sys
    print(sys.argv)
    
    C:/Python/Mymodules>python argv_test.py you need python
    ['argv_test.py', 'you', 'need', 'python']
    ```

  - 강제로 스크립트 종료하기 - sys.exit

    ```python
    >>> sys.exit()
    ==> [Ctrl + Z] 또느 [Ctrl + D] 단축키도 종료명령
    ```

  - 자신이 만든 모듈 불러와 사용하기 - sys.path

    ```python
    - 파이썬 모듈들이 저장되어 있는 위치를 나타냄. 즉, 이 위체이 있는 파이썬 모듈들은 경로 상관없이 어디에서나 불러올 수 있음
    >>> import sys
    >>> sys.path
    ['라이브러리 경로들',....]
    
    - 파이썬 프로그램 파일에서 경로명 추가
    # path_append.py
    import sys
    sys.path.append("C:/Python/Mymodules")
    ```

- pickle : 객체의 형태를 유지하면서 파일에 저장하고 불러올 수 있게 하는 모듈

  ```python
  - pickle모듈의 dump함수를 이용해 딕셔너리 객체인 data를 그대로 파일에 저장
  >>> import pickle
  >>> f = open("test.txt", 'wb')
  >>> data = {1:'python', 2:'you need'}
  >>> pickle.dump(data, f)
  >>> f.close()
  
  - pickle.dump에 의해 저장된 파일을 pickle.load를 이용해 원래 있던 딕셔너리 객체 상태 그대로 불러오기
  >>> import pickle
  >>> f = open("test.txt", 'rb')
  >>> data = pickle.load(f)
  >>> print(data)
  {2:'you need', 1:'python'}
  ```

- OS 모듈 : 환경 변수나 디렉터리, 파일 등의 OS자원을 제어할 수 있게 해주는 모듈

  1. 내 시스템의 환경 변수값을 알고 싶을 때 - os.environ

     ```python
     >>> import os
     >>> os.environ
     environ({'환경변수이름':'경로', ......})
     
     >>> os.environ['PATH']
     'PATH 경로', ......
     ```

  2. 디렉터리 위치 변경하기 - os.chdir

     ```python
     >>> os.chdir("C:\WINDOWS")
     ```

  3. 디렉터리 위치 리턴받기 - os.getcwd

     ```python
     >>> os.getcwd()
     'C:\WINDOWS'
     ```

  4. 시스템 명령어 호출하기 - os.system

     ```python
     >>> os.system("dir")
     ```

  5. 실행한 시스템 명령어의 결과값 리턴하기(읽기 모드 형태 객체) - os.popen

     ```python
     >>> f = os.popen("dir")
     >>> print(f.read())
     ```

  6. 기타 유용한 os 관련 함수

     | 함수                 | 설명                                                         |
     | -------------------- | ------------------------------------------------------------ |
     | os.mkdir(디렉터리)   | 디렉터리를 생선한다.                                         |
     | os.rmdir(디렉터리)   | 디렉터리를 삭제한다.<br />단, 디렉터리가 비어 있어야 삭제가 가능하다. |
     | os.unlink(파일 이름) | 파일을 지운다.                                               |
     | os.rename(src, dst)  | src라는 이름의 파일을 dst라는 이름으로 바꾼다.               |

     

- shutil : 파일을 복사해 주는 파이썬 모듈

  ```python
  - 파일 복사하기 : shutil.copy(src, dst)
  -> src라는 이름의 파일을 dst로 복사
  >>> import shutil
  >>> shutil.copy("src.txt", "dst.txt")
  ```

- glob : 특정 디렉터리에 있는 파일 이름을 모두 알아야 할때 사용하는 모듈

  ```python
  - 디렉터리에 있는 파일들을 리스트로 만들기 - glb(pathname)
  1. glob모듈은 디렉터리 내 파일들을 읽어 리턴한다.
  2. *, ? 등의 메타 문자를 써서 원하는 파일만 읽기 가능
  >>> import glob
  >>> glob.glob("C:/Python/q*")
  ['C:\Python\quiz.py', 'C:\Python\quiz.py.bak']
  ```

- tempfile : 파일을 임스로 만들어서 사용할 떄 유요한 모듈

  ```python
  - tempfile.mktemp() : 중복되지 않는 임시 파일의 이름을 무작위로 만들어 리턴
  >>> import tempfile
  >>> filename = tempfile.mktemp()
  >>> filename
  'C:\WINDOWS\TEMP\~-275151-0'
  
  - tempfile.TemporaryFile() : 임시 저장 공간으로 사용될 파일 객체를 리턴. 이 파일은 기본적으로 바이너르 쓰기모드(wb)를 갖고, f.close가 호출되면 자동으로 사라짐
  >>> import tempfile
  >>> f = tempfile.TemporaryFile()
  >>> f.close -> 생성한 임시 파일이 자동으로 삭제됨
  ```

- time : 시각과 관련된 모듈

  - time.time : UTF를 이용해 현재 시간을 실수 형태로 리턴

    ```python
    >>> import time
    >>> time.time() --> 1970년 1월 1일 0시 0분 0초를 기준
    988458015.73417199
    ```

  - time.localtime : time.time()에 의해 반횐된 실수값을 이용해 연도, 월, 일, 시, 분, 초, ...의 형태로 바꾸어 주는 함수

    ```python
    >>> time.localtime(time.time())
    time.struct_time(tm_year=2013, tm_mon=5, tm_mday=21, tm_hour = 16,
                     tm_min=48, tm_sec=42, tm_wday=1, tm_yday=141, tm_isdst=0)
    ```

  - time.asctime : time.localtime에 의해 반환된 튜플 형태의 값을 인수로 받아 날짜와 시간을 아아보기 쉬운 형태로 리턴

    ```python
    >>> time.asctime(time.localtime(time.time()))
    'Sat Apr 28 20:50:20 2001'
    ```

  - time.ctime : time.asctime을 간편하게 표시한다. 차이는 항상 현재 시간만을 리턴함

    ```python
    >>> time.ctime()
    'Sat Apr 28 20:56:31 2001'
    ```

  - time.strftime : 시간에 관계된 겂을 세밀하게 표현할 수 있는 여러 포맷 코드 제공

    - 구조 : time.strftime('출력할 형식 포맷 코드', time.localtime(time.time()))

      | 코드 | 설명                                  | 예                |
      | ---- | ------------------------------------- | ----------------- |
      | %a   | 요일 줄임말                           | Mon               |
      | %A   | 요일                                  | Monday            |
      | %b   | 달 줄임말                             | Jan               |
      | %B   | 달                                    | January           |
      | %c   | 날짜와 시간을 출력함                  | 06/01/01 17:22:21 |
      | %d   | 날(day)                               | [00,31]           |
      | %H   | 시간(hour)-24시간 출력 형태           | [00,23]           |
      | %l   | 시간(hour)-12시간 출력 형태           | [01,12]           |
      | %j   | 1년 중 누적 날짜                      | [001,366]         |
      | %m   | 달                                    | [01,12]           |
      | %M   | 분                                    | [01,59]           |
      | %p   | AM or PM                              | AM                |
      | %S   | 초                                    | [00,61]           |
      | %U   | 1년 중 누적 주-일요일을 시작으로      | [00,53]           |
      | %w   | 숫자로 된 요일                        | [0(일요일),6]     |
      | %W   | 1년 중 누적 주-월요일을 시작으로      | [00,53]           |
      | %x   | 현재 설정된 로케일에 기반한 날짜 출력 | 06/01/01          |
      | %X   | 현재 설정된 로케일에 기반한 시간 출력 | 17:22:21          |
      | %Y   | 연도 출력                             | 2001              |
      | %Z   | 시간대 출력                           | 대한민국 표준시   |
      | %%   | 문자                                  | %                 |
      | %y   | 세기 부분을 제외한 연도 출력          | 01                |

    ```python
    >>> import time
    >>> time.strftime('%x', time.localtime(time.time()))
    '05/01/01'
    >>> time.strftime('%c', time.localtime(time.time()))
    '05/01/01 17:22:21'
    ```

  - time.sleep : 루프 안에서 많이 사용. 일정한 시간 간격을 두고 루프 실행

    ```python
    # sleep1.py
    import time
    for i in range(10):
        print(i)
        time.sleep(1)
    ```

- calendar : 파이썬에서 달력을 볼 수 있게 해주는 모듈

  - calendar.calendar(연도) : 그 해의 전체 달력을 볼 수 있음

    ```python
    >>> import calendar
    >>> print(calendar.calendar(2015))
    생략
    >>> calendar.prcal(2015)
    동일
    >>> calendar.prmonth(2015,12)
    2015년 12월의 달력만 보여줌
    ```

  - calendar.weekday : weekday(연도,월,일)함수는 그 날짜에 해당하는 요일 정보를 리턴(월:0,화:1,수:2,목:3,금:4,토:5,일:6)

    ```python
    >>> calendar.weekday(2015, 12, 31)
    3
    ```

  - calendar.monthrange : monthrange(연도,월)은 입력받은 달의 1일이 무슨 요일인지와 그 달이 며칠까지 있는지를 튜플 형태로 리턴

    ```python
    >>> calendar.monthrange(2015, 12)
    (1, 31)
    ```

- random : 난수(규칙이 없는 임의의 수)를 발생시키는 모듈

  - random : 0.0에서 1.0사이의 실수 중에서 난수값 리턴

    ```python
    >>> import random
    >>> random.random()
    0.53840103305098674
    ```

  - randint : 입력 인수 범위의 난수값 리턴

    ```python
    >>> random.randint(1,10)
    6
    >>> random.randint(1,55)
    43
    ```

- webbrowser : 자신의 시스템에서 사용하는 기본 웹 브라우저가 자동으로 실행되게 하는 모듈

  ```python
  >>> import webbrowser
  >>> webbrowser.open("http://google.com")
  --> 브라우저가 실행된 상태일 시 입력 주소로 이동
  
  - open_new() : 웹 브라우저가 실행된 상태일 때 새로운 창으로 해당 주소가 열림
  ```

### 3. 스레드

- 프로세스(Process)

  - 정의 : 컴퓨터에서 동작하고 있는 프로그램
  - 보통 1개의 프로세스는 1가지 일만 수행함

- 스레드(Thread)

  - 한 프로세스 내에서 2가지 이상 또는 그 이상의 일을 동시에 수행함

  ```python
  - 스레드의 테스트 실행 예제
  import threading
  import time
  
  def say(msg):
      while True:
          time.sleep(1)
          print(msg)
          
  for msg in ['you', 'need', 'python']:
      t = threading.Thread(target=say, args=(msg,))
      t.daemon = True
      t.start()
      
  for i in range(100):
      time.sleep(0.1)
      print(i)
      
  --> 실행 결과는 직접 해보기:스레드가 메인 프로그램과 별도로 수행되는 것을 알 수 있음
  ```

  ```python
  - 스레드를 클래스로 정의한 예제
  import threading
  import time
  
  class MyThread(thread.Thread):
      def __init__(self, msg):
          threading.Thread.__init__(self)
          self.msg = msg
          self.daemon = True
          
      def run(self):
          while True:
              time.sleep(1)
              print(self.msg)
              
  for msg in ['you', 'need', 'python']:
      t = MyThread(msg)
      t.start()
      
  for i in range(100):
      time.sleep(0.1)
      print(i)
      
  ==> 스레드를 클래스로 정의할 시 __init__메서드에서 threading.Thread.__init__(self)와 같이 부모 클래스의 생성자를 반드시 호출해야함
  ==> MyThread로 생성된 객체의 start 메서드를 실행시 MyThread 클래스의 run메서드가 자동으로 수행됨
  ```