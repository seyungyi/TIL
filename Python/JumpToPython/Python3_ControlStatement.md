# [ Python Basic Grammer_3 ]

## <  제어문(Control Statement) >

### 1. IF

- if 문

  - 프로그래밍에서 조건을 판단하여 해당 조건에 맞는 상황을 수행하는 데 쓰이는 것

  - 기본 구조

    ```python
    if 조건문:
        수행할 문장1
        수행할 문장2
        ...
    else:
        수행할 문장1
        수행할 문장2
        ...
    ```

  - 들여쓰기

    - if문을 만들 때 **if 조건문:** 바로 아래 문자부터 if문에 속하는 모든 문장에 들여쓰기를 해야한다
    - 파이썬에서 들여쓰기를 제대로 작성하지 않으면 구문 오류가 발생
    - 들여쓰기는 언제나 같은 깊이로 해야함
    - 공백(Spacebar)와 탭(Tap)키 둘 중 하나를 사용하지만 혼용해서 사용하지는 않기 -> 요즘은 공백 4개를 사용하는 것을 권장하는 추세

  - 조건문 다음에 콜론(:)을 잊지 말기

- 조건문에 대한 정의

  - 참과 거짓을 판단하는 문장을 말함

  - 자료형의 참과 거짓에 대한 표

    | 자료형   | 참            | 거짓 |
    | -------- | ------------- | ---- |
    | 숫자     | 0이 아닌 숫자 | 0    |
    | 문자열   | "abc"         | ""   |
    | 리스트   | [1, 2, 3]     | []   |
    | 튜플     | (1, 2, 3)     | ()   |
    | 딕셔너리 | {"a":"b"}     | {}   |

  - 비교연산자

    | 비교 연산자 | 설명                   |
    | ----------- | ---------------------- |
    | x < y       | x가 y보다 작다         |
    | x > y       | x가 y보다 크다         |
    | x == y      | x와 y가 같다           |
    | x `!`= y    | x와 y가 같지 않다      |
    | x `>`= y    | x가 y보다 크거나 같다  |
    | x `<`= y    | x가  y보다 작거나 같다 |

  - and, or, not

    | 연산자  | 설명                             |
    | ------- | -------------------------------- |
    | x or y  | x와 y 둘 중 하나만 참이면 참이다 |
    | x and y | x와 y 모두 참이어야 참이다       |
    | not x   | x가 거짓이면 참이다              |

  - in, not in

    | in          | not in          |
    | ----------- | --------------- |
    | x in 리스트 | x not in 리스트 |
    | x in 튜플   | x not in 튜플   |
    | x in 문자열 | x not in 문자열 |

  - 조건문에서 아무 일도 하지 않게 설정하고자 한다면? pass 를 적용

    ```python
    >>> pocket = ['paper', 'money', 'cellphone']
    >>> if 'money' in pocket:
    ...		pass --> 아무런 결과값을 보여주지 않음
    	else:
            print("카드를 꺼내라")
    ```

- 다양한 조건을 판단하는 elif

  - if와 else만으로는 다양한 조건을 판단하기 어려움이 따름

  - 다양한 조건시 복잡함을 해결하기 위한 다중 조건 판단을 가능하게 하는 기능

  - 이전 조건문이 거짓일 때 수행함

  - elif는 개수에 제한 없이 사용 가능함

  - 기본 구조

    ```python
    if 조건문:
        수행할 문장 1-1
        수행할 문장 1-2
    elif 조건문2:
        수행할 문장 2-1
        수행할 문장 2-2
    else:
        수행할 문장 A
    ```



### 2. WHILE

- while문 기본 구조

  - 반복해서 문장 수행이 필요할 시 사용함

    ```python
    while 조건문:
        수행할 문장1
        수행할 문장2
    ```

  - 조건문이 참인 동안에 while문 아래에 속하는 문장들이 반복해서 수행됨

    ```python
    예제)
    >>> number = 0
    >>> while number != 4
    		print(prompt)
        	number = int(input())
    1.Add
    2.Del
    3.List
    4.Quit
    
    Enter number:
    1 --> 4를 입력하지 않으면 계속 prompt 출력
    
    4
    >>> 종료됨
    
    ```

- while문 강제로 빠져나가기

  - 조건이 참인 동안 계속 반복수행하는데 강제로 나가고 싶다 : break문 실행

    ```python
    예제) break문 이용해 자판기 작동 과정 만들기
    # cofffee.py
    coffee = 10
    while True:
        money = int(input("돈을 넣어주세요: "))
        if money == 300:
            print("커피를 줍니다")
            coffee = coffee - 1
        elif money > 300:
        	print("거스름돈 %d를 주고 커피를 줍니다." %(money - 300))
            coffee = coffee - 1
        else:
            print("돈을 다시 돌려주고 커피를 주지 않습니다.")
            print("남은 커피의 양은 %d개입니다." % coffee)
        if not coffee:
            print("커피가 다 떨어졌습니다. 판매를 중지합니다.")
            break
            
    coffee.py 실행법( cmd 프롬로트 창에서 해당 경로로 이동하여 실행 )
    C:\Python>python coffee.py
    
    => 실행시 오류가 발생한다면 소스 코드 첫 줄에 코드 추가(인코딩 셋)
    # -*- coding: utf-8 -*-
            
    ```

- 조건에 맞지 않는 경우 맨 처음으로 돌아가기

  - while문 문장을 수행시 조건을 검사하여 맞지 않으면 while문을 빠져나가는게 아니라 while문의 맨 처음으로 돌아가고자 한다면 ? continue 사용
  - continue : while문의 맨 처음으로 돌아가게 하는 명령어

- 무한 루프

  - 무한히 반복된다는 의미
  - 무한 루프가 의미 없이 돌아갈 경우 [ Ctrl + C ]를 눌러 강제로 빠져나온다

### 3. FOR

- for문 기본 구조

  ```python
  for 변수 in 리스트(또는 튜플, 문자열):
      수행할 문장 1
      수행할 문장 2
  ```

  - 전형적인 for문

    ```python
    >>> test_list = ['one', 'two', 'three']
    >>> for i in test_list:
        print(i)
    one
    two
    three
    ```

  - 다양한 for문 사용

    ```python
    >>> a = [(1,2), (3,4), (5,6)]
    >>> for(first, last) in a:
        print(first+last)
    3
    7
    11
    ```

  - for문의 응용

    ```python
    예제) 점수를 검사해 합격인지 불합겨인지 통보하는 프로그램
    # marks1.py
    marks = [90, 25, 67, 45, 80]
    number = 0
    for mark in marks:
        number = number + 1
        if mark >= 60:
            print("%d번 학생은 합격입니다." % number)
        else:
            print("%d번 학생은 불합격입니다." % number)
    ```

- for문과 continue

  - continue : for문 안의 문장을 수행하는 도중에 만나면 for문의 처음으로 돌아감

- for와 함께 자주 사용하는 range함수

  - **range** : 숫자 리스트를 자동으로 만들어 주는 함수(자주 사용됨)

    ```python
    >>> a = range(10)
    >>> a
    range(0, 10) -> 0,1,2,3,4,5,6,7,8,9
    
    >>> a = range(11)
    >>> a
    range(1, 11) -> 1,2,3,4,5,6,7,8,9,10
    
    예제) 60점 이상이면 합격 출력
    # marks3.py
    marks = [90, 25, 67, 45, 80]
    for number in range(len(marks)):
        if marks[number] < 60: continue
        print("%d번 학생 축하합니다. 합격입니다." % (number+1))
        
    예제2) 구구단 출력
    >>> for i in range(2,10):
        for j in range(1,10):
            print(i*j, end=" ")
        print('')
    => 입력인수 end : 해당 결과값을 출력할 떄 다음 줄로 넘어가지 않고 그 줄에 계속 출력하기 위해 사용
    ```

- 리스트 안에 for문 포함하기

  - 리스트 안에 for문을 포함하는 리스트 내포를 이용하면 편리하고 직관적인 프로그램을 만들 수 있음

    ```python
    >>> a = [1,2,3,4]
    >>> result = []
    >>> for num in a:
        result.append(num*3)
    >>> print(result)
    [3, 6, 9, 12]
    
    --> 리스트 내포를 이용시 간단하게 구현
    >>> result = [num * 3 for num in a]
    >>> print(result)
    [3, 6, 9, 12]
    --> 짝수에만 3곱하여 담고자 한다면
    >>> result = [num*3 for num in a if num % 2 == 0]
    >>> print(result)
    [6, 12]
    ```

  - 리스트 내포의 일반적 문법

    ```python
    - 일반적인 문법
    [표현식 for 항목 in 반복 가능 객체 if 조건]
    - for문 2개 사용하는 것도 가능
    [표현식 for 항목1 in 반복 가능 객체1 if 조건1
     		for 항목2 in 반복 가능 객체 if 조건2
     		...
     		for 항목n in 반복 가능 객체 if 조건n]
    
    예제) 구구단 모두 담는다면
    >>> result = [x*y for x in range(2,10)
                 			for y in range(1,10)]
    print(result)
    [2,4,6,8,10,12,14,16 ....... 54, 63, 72, 81]
    ```

### 4. 기타

- while 문과 for 문은 아주 비슷한 문법이다
  - while문 -> for문으로 바꿀 수 있음
  - for문 -> while문을 바꿀 수 있음