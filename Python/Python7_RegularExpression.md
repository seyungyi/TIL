# [ Python Basic Grammer_7 ]

## < 파이썬 정규 표현식(Regular Expression formula) >

- 참고 사이트 : [파이썬 하우투](https://docs.python.org/3.4/howto/regex.html)
- 정규 표현식
  - 정의 : 복잡한 문자열을 처리할 때 사용하는 기법
  - 파이썬만이 아닌 문자열 처리하는 모든 곳에서 사용

### 1. 정규 표현식의 필요성

```visual basic
- 다음의 문제가 주어졌을 경우
: 주민등록번호를 포함하고 있는 텍스트가 있다. 이 텍스트에 포함된 모든 주민등록번호의 뒷자리를 * 문자로 변경하시오.
```

- 프로그램 작성 순서
  1. 전체 텍스트를 공백 문자로 나눈다(split).
  2. 나누어진 단어들이 주민등록번호 형식인지 조사한다.
  3. 단어가 주민등록번호 형식이라면 뒷자리를 '*'로 변환한다.
  4. 나누어진 단어들을 다시 조립한다.

```python
- 기존 코드
data = """
park 800905-1049118
kim 700905-1059119
"""

result = []
for line in data.split("\n"):
    word_result=[]
    for word in line.split(" "):
        if len(word) == 14 and word[:6].isdigit() and word[7:].isdigit():
            word = word[:6] + "-" + "*******"
        word_result.append(word)
    result.append(" ".join(word_result))
print("\n".join(result))

결과값:
park 800905-*******
kim 700905-*******
```

```python
- 정규식을 사용한 간편하고 직관적인 코드
import re <- 정규 표현식을 사용하기 위한 re모듈

data = """
park 800905-1049118
kim 700905-1059119
"""

pat = re.compile("(\d{6})[-]\d{7}")
print(pat.sub("\g<1>-*******", data))

결과값:
park 800905-*******
kim 700905-*******
```

### 2. 정규 표현식 시작하기

- 정규 표현식으 기초, 메타 문자

  - 메타 문자 종류 : .^$*+?{}[]\\|()

  - 문자 클래스 []

    - '[와 ] 사이의 문자들과 매치' 라는 의미

    - []안의 두 문자 사이에 하이픈(-)을 사용하면 두 문자 사이의 범위를 의미

      - [a-zA-Z] : 알파벳 모두
      - [0-9] : 숫자

      | 정규식 | 문자열 | 매치 여부 | 설명                                                         |
      | ------ | ------ | --------- | ------------------------------------------------------------ |
      | [abc]  | a      | Yes       | "a"는 정규식과 일치하는 문자인 "a"가 있으므로 매치           |
      |        | before | Yes       | "before"는 정규식과 일치하는 문자인 "b"가 있으므로 매치      |
      |        | dude   | No        | "dude"는 정규식과 일치하는 문자인 a,b,c 중 어느 하나도 포함하고 있지 않으므로 매치되지 않음 |

    - 자주 사용하는 문자 클래스

      | 정규 표현식 | 설명                                                         |
      | ----------- | ------------------------------------------------------------ |
      | \d          | 숫자와 매치, [0-9]와 동일한 표현식                           |
      | \D          | 숫자가 아닌 것과 매치, `[^0-9]`와 동일한 표현식              |
      | \s          | whitespace 문자와 매치, [\t\n\r\f\v]와 동일한 표현식.<br />맨 앞의 빈 칸은 공백 문자(space)를 의미 |
      | \S          | whitespace 문자가 아닌 것과 매치, `[^\t\n\r\f\v]`와 동일한 표현식 |
      | \w          | 문자+숫자와 매치, [a-zA-Z0-9]와 동일한 표현식                |
      | \W          | 문자+숫자가 아닌 문자와 매치, `[^a-zA-Z0-9]`와 동일한 표현식 |

  - Dot(.)

    - 정의 : 줄바꿈 문자인 \n를 제외한 모든 문자와 매치됨을 의미

      ```
      a.b --> a와 b사이에 줄바꿈 문자를 제외한 어떤 문자가 들어가도 모두 매치
      (==)"a + 모든 문자 + b" : a와 b라는 문자 사이에 어떤 문자가 들어가도 매치
      
      a[.]b --> a와 b사이에 Dot(.) 문자가 있으면 매치
      (==)"a + Dot(.)문자 + b" : "a.b"라는 문자열과 매치, "a0b"라는 문자여로가 매치되지 않음
      ```

      | 정규식 | 문자열 | 매치 여부 | 설명                                                         |
      | ------ | ------ | --------- | ------------------------------------------------------------ |
      | a.b    | aab    | Yes       | "aab"는 가운데 문자 "a"가 모든 문자를 의미하는 .과 일치하므로 정규식과 매치 |
      |        | a0b    | Yes       | "a0b"는 가운데 문자 "0"이 모든 문자를 의미하는 .과 일치하므로 정규식과 매치 |
      |        | abc    | No        | "abc"는 "a"문자와 "b"문자 사이에 어떤 문자라도 하나는 있어야 하는 이 정규식과 일치하지 않으므로 매치되지 않음 |

  - 반복(*)

    - 정의 : * 메타 문자가 사용. * 바로 앞에 있는 문자가 0부터 무한대로 반복될 수 있다는 의미

    - 예 : ca*t -> * 문자 앞의 a가 0번 이상 반복되면 매치

      | 정규식 | 문자열 | 매치 여부 | 설명                                   |
      | ------ | ------ | --------- | -------------------------------------- |
      | ca*t   | ct     | Yes       | "a"가 0번 반복되어 매치                |
      |        | cat    | Yes       | "a"가 0번 이상 반복되어 매치(1번 반복) |
      |        | caaat  | Yes       | "a"가 0번 이상 반복되어 매치(3번 반복) |

      

  - 반복(+)

    - 정의 : + 문자 앞에 있는 문자가 1번 이상 반복되면 매치

      | 정규식 | 문자열 | 매치 여부 | 설명                                   |
      | ------ | ------ | --------- | -------------------------------------- |
      | ca+t   | ct     | No        | "a"가 0번 반복되어 매치되지 않음       |
      |        | cat    | Yes       | "a"가 1번 이상 반복되어 매치(1번 반복) |
      |        | caaat  | Yes       | "a"가 1번 이상 반복되어 매치(3번 반복) |

      

  - 반복({m, n}, ?)

    - 정의 : 반복 횟수를 고정시킬 경우에 사용. m부터 n까지로 고정하여 매치, m 또는 n을 생략할 수 도 있다

    1. {m}

       | 정규식 | 문자열 | 매치 여부 | 설명                               |
       | ------ | ------ | --------- | ---------------------------------- |
       | ca{2}t | cat    | No        | "a"가 1번만 반복되어 매치되지 않음 |
       |        | caat   | Yes       | "a"가 2번 반복되어 매치            |

    2. {m ,n}

       | 정규식   | 문자열  | 매치 여부 | 설명                               |
       | -------- | ------- | --------- | ---------------------------------- |
       | ca{2,5}t | cat     | No        | "a"가 1번만 반복되어 매치되지 않음 |
       |          | caat    | Yes       | "a"가 2번 반복되어 매치            |
       |          | caaaaat | Yes       | "a"가 5번 반복되어 매치            |

    3. ?

       | 정규식 | 문자열 | 매치 여부 | 설명                    |
       | ------ | ------ | --------- | ----------------------- |
       | ab?c   | abc    | Yes       | "b"가 1번 사용되어 매치 |
       |        | ac     | Yes       | "b"가 0번 사용되어 매치 |

- 파이썬에서 정규 표현식을 지원하는 re 모듈

  - 정의 : 파이썬이 설치될때 자동으로 설치되는 기본 라이브러리

    ```python
    >>> import re
    >>> p = re.comiple('ab*')
    ==> re.compile의 결과로 리턴되는 객체 p(컴파일된 패턴 객체)를 이용해 그 이후의 작업을 수행
    - 패턴 : 정규식을 컴파일한 결과를 말함
    ```
  
- 정규식을 이용한 문자열 검색

  | 메서드     | 목적                                                         |
  | ---------- | ------------------------------------------------------------ |
  | match()    | 문자열의 처음부터 정규식과 매치되는지 조사. 참이면 객체, 거짓이면 None을 리턴 |
  | search()   | 문자열 전체를 검색하여 정규식과 매치되는지 조사. 참이면 객체, 거짓이면 None을 리턴 |
  | findall()  | 정규식과 매치되는 모든 문자열(substring)을 리스트로 리턴     |
  | finditer() | 정규식과 매치되는 모든 문자열(substring)을 반복 가능한 객체로 리턴 |

  ```python
  >>> import re
  >>> p = re.compile('[a-z]+')
  
  - match
  >>> m = p.match("python")
  >>> print(m)
  <_sre.SRE_Match object at 0x01F3F9F8> <- match객체가 리턴됨
  
  >>> m = p.match("3 python")
  >>> print(m)
  None
  
  p = re.compile(정규 표현식)
  m = p.match("조사할 문자열")
  if m:
      print('Match found: ', m.group())
  else:
      print('No match')
  
  - search
  >>> m = p.search("python")
  >>> print(m)
  <_sre.SRE_Match object at 0x01F3F9F8>
  
  - findall
  >>> result = p.findall("life is too short")
  >>> print(result)
  ['life', 'is', 'too', 'short']
  
  - finditer
  >>> result = p.finditer("life is too short")
  >>> print(result)
  <callable_iterator object at 0x01F5E390>
  >>> for r in result: print(r)
      <_src.SRE_Match object at 0x01F3F9F8>
      ...
  ```

- match 객체의 메서드

  | 메서드  | 목적                                                |
  | ------- | --------------------------------------------------- |
  | group() | 매치된 문자열을 리턴함                              |
  | start() | 매치된 문자열의 시작 위치를 리턴함                  |
  | end()   | 매치된 문자열의 끝 위치를 리턴함                    |
  | span()  | 매치된 문자열의 (시작, 끝)에 해당되는 튜플을 리턴함 |

  ```python
  >>> import re
  >>> p = re.compile('[a-z]+')
  >>> m = p.match("python")
  >>> m.group()
  'python'
  >>> m.start()
  0
  >>> m.end()
  6
  >>> m.span()
  (0, 6)
  
  - 모듈 단위로 수행하기
  >>> m = re.match('[a-z]+', "python")
  ```

- 컴파일 옵션

  | 옵션명     | 약어 | 설명                                                         |
  | ---------- | ---- | ------------------------------------------------------------ |
  | DOTALL     | S    | 줄바꿈 문자를 포함하여 모든 문자와 매치할 수 있도록 한다     |
  | IGNORECASE | I    | 대,소문자에 관계 없이 매치할 수 있도록 한다                  |
  | MULTILINE  | M    | 여러 줄과 매치할 수 있도록 한다(^, $ 메타 문자의 사용과 관계가 있는 옵션) |
  | VERBOSE    | X    | verbose 모드를 사용가능<br />(정규식을 보기 편하게 만들 수도 있고 주석 등을 사용할 수 도 있다.) |

  ```python
  - DOTALL, S : \n 문자도 포함해 매치한다면 re. 옵션을 사용한다
  >>> import re
  >>> p = re.compile('a.b', re.DOTALL)
  >>> m = p.match('a\nb')
  >>> print(m)
  <_sre.SRE_Match object at 0x01FCF3D8>
  
  - IGNORECASE, I
  >>> p = re.compile('[a-z]', re.I)
  >>> p.match('python')
  <_sre.SRE_Match object at 0x01FCF3D8>
  
  - MULTILINE, M : ^, $ 메타 문자를 문자열의 각 라인마다 적용해주는 것
  >>> import re
  >>> p = re.compile("^python\s\w+", re.MULTILINE)
  
  data = """python one
  life is too short
  python two
  you need python
  python three"""
  
  print(p.findall(data))
  ['python one', 'python two', 'python three']
  
  - VERBOSE, X : 문자열에 사용된 whitespace는 컴파일 시 제거. 그리고 줄 단위로 # 기호를 이용해 주석문 작성 가능
  charref = re.compile(r'&[#](0[0-7]+|[0-9]+|x[0-9a-fA-F]+);')
  
  charref = re.compile(r"""
  $[#]
  (
  	0[0-7]+
  	| [0-9]+
  	| x[0-9a-fA-F]+
  )
  ;
  """, re.VERBOSE)
  ```

- 백슬래시 문제

  - \문자 자체를 사용하려면 백슬리시 2개를 사용

  - 정규식 엔진에 `\\`문자를 전달하려면 `\\\\` 4개를 사용해야함

  - 복잡함 문제 해결 : Raw String이라는 규칙 생김

    ```python
    >>> p = re.compile(r'\\section')
    ```

### 3. 강력한 정규 표현식의 세계

- 메타 문자

  ```python
  1. | 메타문자 : or와 동일한 의미. A 또는 B
  >>> p = re.compile('Crow|Servo')
  >>> m = p.match('CorwHello')
  >>> print(m)
  <_sre.SRE_Match object; span=(0,4), match='Crow'>
  
  2. ^ 메타 문자 : 문자열의 맨 처음과 일치함을 의미
  >>> print(re.search('^Life', 'Life is too short'))
  <_sre.SRE_Match object at 0x01FCF3D8>
  >>> print(re.search('^Life', 'My Life'))
  None
  
  3. $ 메타 문자 : ^ 메타 문자와 반대. 문자열의 끝과 매치함을 의미
  >>> print(re.search('short$', 'Life is too short'))
  <_sre.SRE_Match object at 0x01F6F3D8>
  >>> print(re.search('short$', 'Life is too short, you need python'))
  None
  
  4. \A 메타 문자 : 문자열의 처음과 매치됨. ^메타 문자와 동일한 의미이지만 re.MULTILINE 옵션을 사용할시 다르게 해석됨
  ^은 라인별 문자열의 처음과 매치 <-> \A는 라인과 상관없이 전체 문자열의 처음하곰나 매치
  
  5. \Z 메타 문자 : 문자열의 끝과 매치됨. \A와 유사
      
  6. \b 메타 문자 : 단어 구분자이다. 앞뒤가 whitespace로 구분된 class라는 단어와 매치됨을 의미
  >>> p = re.compile(r'\bclass\b')
  >>> print(p.search('no class at all'))
  <_sre.SRE_Match object at 0x01F6F3D8>
  !! 주의사항 : \b는 파이썬 리터럴 규칙에 의하면 백스페이스를 의미하므로 백스페이스가 아닌 단어 구분자임을 알려주기 위해 r'\bclass\b'처럼 Raw string임을 알려주느 기호 r을 반드시 붙여줘야 한다
      
  7. \B 메타 문자 : \b 메타 문자와 반대. whitespace로 구분된 단어가 아닌 경우에만 매치
  >>> p = re.compile(r'\Bclass\B')
  >>> print(p.search('no class at all'))
  None
  >>> print(p.search('the declassified algorithm'))
  <_sre.SRE_Match object at 0x01F6FA30>
  ```

- 그룹핑 : 문자열이 계속해서 반복되는지 조사하는 정규식을 작성할때 사용

  ```python
  >>> p = re.compile('(ABC)+')
  >>> m = p.search('ABCABCABC OK?')
  >>> print(m)
  <_src.SRE_Match object at ox01F7B320>
  >>> print(m.group(0))
  ABCABCABC
  ```

  | group(인덱스) | 설명                           |
  | ------------- | ------------------------------ |
  | group(0)      | 매치된 전체 문자열             |
  | group(1)      | 첫 번째 그룹에 해당하는 문자열 |
  | group(2)      | 두 번째 그룹에 해당하는 문자열 |
  | group(n)      | n 번째 글부에 해당하는 문자열  |

  - 그룹핑된 문자열 재참조하기 : 한번 그룹핑된 문자열을 재참조 가능

- 그룹핑된 문자열에 이름 붙이기

  - 그룹이 무척 많아질 경우 추가, 수정 삭제 등이 이루어지면 참조한 프로그램도 모두 바꾸는 위험이 있기에 이름으로 참조하는 방식 사용

  - 구조 : (?P<그룹명>...)

    ```python
    - 그룹에 이름을 지정하고 참조하는 예:
    >>> p = re.compile(r"(?P<name>\w+)\s+((\d+)[-]\d+[-]\d+)")
    >>> m = p.search("park 010-1234-1234")
    >>> print(m.group("name"))
    park
    ```

- 전방 탐색

  - 정의 : 검색 결과에서 특정 문자를 제외하고 출력할시 그룹핑은 추가로 할 수 없는 조건 등에서 사용할 수 있는 방식

    | 정규식  | 종류             | 설명                                                         |
    | ------- | ---------------- | ------------------------------------------------------------ |
    | (?=...) | 긍정형 전방 탐색 | ...에 해당하는 정규식과 매치되어야 하며 조건이 통과되어도 문자열이 소모되지 않는다 |
    | (?!...) | 부정형 전방 탐색 | ...에 해당되는 정규식과 매치되지 않아야 하며 조건이 통과되어도 문자열이 소모되지 않는다 |

  - 긍정형 전방 탐색

    - 구조 : `.*[.].*$`-> 파일명 + . + 확장자

    ```python
    예)
    .*[.][^b].*$ : bat인 파일은 제외한다
    ```

  - 부정형 전방 탐색

    ```python
    예)
    .*[.](?!bat$).*$ : 확장자가 bat가 아닌 경우에만 통과한다는 의미
    .*[.](?!bat$|exe$).*$ : exe 역시 제외한다는 조건 추가
    ```

- 문자열 바꾸기 : sub메서드를 이용하면 정규식과 매치되는 부분을 다른 문자로 쉽게 바꾸기 가능

  ```python
  >>> p = re.compile('(blue|white|red)')
  >>> p.sub('colour', 'blue socks and red shoes')
  'colour socks and colour shoes'
  
  - 바꾸기 횟수 지정
  >>> p.sub('colour', 'blue socks and red shoes', count=1)
  'colour socks and red shoes'
  ```

  - subn 메서드 : sub와 유사. 리턴되는 결과를 튜플로 리턴한다는 차이

    ```python
    첫 번째 요소는 변경된 문자열, 두 번째 요소는 바꾸기가 발생한 횟수
    >>> p = re.compile('(blue|white|red)')
    >>> p.subn('colour', 'blue socks and red shoes')
    ('colour socks and colour shoes', 2)
    ```

  - sub 메서드 사용 시 참조 구문 사용

    ```python
    - '이름 + 전화번호'의 문자열 -> '전화번호 + 이름'으로 변경
    >>> p = re.compile(r"(?P<name>\w+)\s+(?P<phone>(\d+)[-]\d+[-]\d+)")
    >>> print(p.sub("\g<phone> \g<name>", "park 010-1234-1234"))
    010-1234-1234 park
    
    - 그룹명 대신 참조 번호를 이용하기
    >>> p = re.compile(r"(?P<name>\w+)\s+(?P<phone>(\d+)[-]\d+[-]\d+)")
    >>> print(p.sub("\g<2> \g<1>", "park 010-1234-1234"))
    010-1234-1234 park
    ```

  - sub 메서드의 입력 인수로 함수 넣기

    ```python
    >>> def hexrepl(match):
        "Return the hex string for a decimal number"
        value = int(match.group())
        return hex(value)
    >>> p = re.compile(r'\d+')
    >>> p.sub(hexrepl, 'Call 65490 for printing, 49152 for user code.')
    'Call 0xffd2 for printing, 0xc000 for user code.'
    ==> 이 함수는 match 객체를 입력으로 받아 16진수로 변환하여 리턴하는 함수.
    sub의 첫 번째 입력인수로 함수를 사용시 해당 함수의 첫 번째 입력 인수에는 정규식과 매치된 match 객체가 입력된다. 그리고 매치되는 문자열은 함수의 리턴 값으로 바뀜
    ```

- Greedy vs Non-Greedy

  ```python
  >>> s = '<html><head><title>Title</title>'
  >>> len(s)
  32
  >>> print(re.match('<.*>', s).span())
  (0, 32)
  >>> print(re.match('<.*>', s).group())
  <html><head><title>Title</title>
  --> *문자는 탐욕스러워 매치 가능한 최대한의 문자열을 모두 소모함
  
  - 탐욕을 제한하고 <html>이라는 문자열까지만 소모하도록 제한하기
  >>> print(re.match('<.*?', s).group())
  <html>
  --> non-greedy 문자인 ? : *?, +?, ??, {m,n}? 와 같이 사용 가능
      가능한 한 가장 최소한의 반복을 수행하도록 도와주는 역할
  ```