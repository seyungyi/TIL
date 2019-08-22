# [ Python Basic Grammer_2 ]

## <  프로그램의 입력과 출력 >

1. 함수 : 입력값을 가지고 어떤 일을 수행한 다음에 결과물을 내어놓는 것이 함수가 하는 일

   - 함수를 사용하는 이유

     1. 반복적으로 사용되는 가치 있는 부분을 묶어 어떤 입력값을 주었을 때 어떤 결과값을 돌려준다는 식으로 작성하는 것이 현명
     2. 자신이 만든 프로그램을 함수화하면 프로그램의 흐름을 일목요연하게 볼 수 있음

   - 파이썬 함수의 구조

     - def : 함수를 만들 때 사용하는 예약어
     - 함수명 : 함수를 만드는 사람이 임의로 만들 수 있음
     - 괄호 안의 입력 인수 : 함수에 입력될 값

     ```python
     def 함수명(입력 인수):
         수행할 문장1
         수행할 문장2
     
     def sum(a, b):
         return a+b
     ==> 함수의 이름(함수명)은 sum이고 입력 인수로 2개의 값을 받으며 결과값은 2개으 입력값을 더한 값이다.
     ```

   - 입력값과 결과값에 따른 함수의 형태

     - 일반적인 함수 : 입력값이 있고 결과값이 있는 함수가 일반적인 함수

     - 입력값이 없는 함수

       ```python
       결과값을 받을 변수 = 함수명()
       >>> def say():
           return 'Hi'
       >>> a = say()
       >>> print(a)
       Hi
       ```

     - 결과값이 없는 함수 : 결과값은 오로지 return 명령어로만 받을 수 있다

       ```python
       함수명(입력 인수1, 입력 인수2,,,)
       >>> def sum(a,b):
           print("%d, %d의 합은 %d입니다." % (a, b, a+b))
       >>> sum(3,4)
       3, 4의 합은 7입니다.
       >>> a = sum(3,4)
       >>> print(a)
       None -> 거짓을 나타내는 자료형
       ```

     - 입력값도 결과값도 없는 함수 : 입력 인수를 받는 곳도 없고 return문도 없어 입력값도 결과값도 없는 함수

       ```python
       >>> def say():
           print('Hi')
       >>> say()
       Hi
       ```

   - 입력값이 몇 개가 될지 모를 경우 해결할 방법

     - 여러 개의 입력값을 받는 함수 만들기

       ```python
       >>> def 함수명(*입력 변수):
           수행할 문장
       >>> def sum_many(*args):
           sum=0
           for i in args:
               sum = sum + i --> *args에 입력받은 모든 값을 더한다
           return sum
       >>> def sum_mul(choice, *args):
           if choice == "sum":
               return = 0
           	for i in args:
                   result = result + i
           elif choice == "mul":
               result = 1
               for i in args:
                   result = result * i
           return result
       >>> result = sum_mul('sum', 1,2,3,4,5)
       >>> print(result)
       15
       => *args에 입력되는 모든 값을 더해 15를 돌려준다
       ```

   - 함수의 결과값은 언제나 하나이다 : 함수는 return문을 만다는 순간 결과값을 돌려준 다음 함수를 빠져나가게 된다

   - 입력 인수에 초깃값 미리 설정하기

     ```python
     >>> def say_myself(name, old, man=True):
         print("나의 이름은 %sㅇ비니다." % name)
         print("나이는 %d살입니다." % old)
         if man:
             print("남자입니다")
         else:
             print("여자입니다.")
     >>> say_myself("박응용", 27) or say_myself("박응용", 27, True)
     나의 이름은 박응용입니다.
     나이는 27살입니다.
     남자입니다.
     ```

     - 함수 입력 인수에 초깃값을 설정시 주의할 사항 : 초깃값을 설정해 놓은 입력 인수 뒤에 초깃값을 설정해 놓지 않은 입력 인수는 사용할 수 없음
     - 결론 : 초기화시키고 싶은 입력 변수들을 항상 뒤쪽에 위치시키는 것을 잊지 말기

   - 함수 안에서 선언된 변수의 효력 범위

     - 함수 안에서 선언된 변수는 함수 안에서만 사용가능함

     - 함수 안에서 함수 밖의 변수를 변경하는 방법

       1. return 이용하기

          ```python
          # vartest_return.py
          >>> a = 1
          >>> def vartest(a):
              a = a + 1
              return a
          >>> a= vartest(a)
          >>> print(a)
          2
          ```

       2. global 명령어 이용하기 : 함수 안에서 함수 밖의 a 변수를 직접 사용하겠다는 뜻이다

          ```python
          # vartest_global.py
          >>> a = 1
          >>> def vartest():
              global a
              a = a + 1
          >>> vartest()
          >>> print(a)
          2
          ```

          - 프로그래밍시 global 명령어는 사용하지 않는 것이 좋음 : 함수는 독립적으로 존재하는 것이 좋기 때문

2. 사용자 입력과 출력( 사용자 입력 -> 처리(프로그램, 함수 등) -> 출력 )

   - 사용자 입력

     - input의 사용 : input은 입력되는 모든 것을 문자열로 취급

       ```python
       >>> a = input()
       Life is too short, you need python <- 사용자가 입력한 문장을 a에 대입
       >>> a
       'Life is too short, you need python'
       ```

     - 프롬프트를 띄워서 사용자 입력 받기

       ```python
       >>> number = input("숫자를 입력하세요: ")
       숫자를 입력하세요:
       >> print(number)
       3
       ```

       

   - print 자세히 알기

     - 큰따옴표(")로 둘러싸인 문자열은 + 연산과 동일
     - 문자열 띄어쓰기는 콤마로 한다
     - 한 줄에 결과값 출력하기

3. 파일 읽고 쓰기