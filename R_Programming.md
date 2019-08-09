# [ R_Programming ]

---

## < 빅데이터 >

- 데이터 크기가 테라바이트 혹은 페타바이트까지 이르는 매우 다양한 범위의 데이터를 말함
- 정의(가트너가 정의) : BIg-Data 3V Model
  - 데이터의 기하급수적인 성장, 데이터의 가용성, 데이터의 정보화 관점에서 정의
  - High-Volume = 대용량의 데이터 규모
  - High-Velocity = 빠른 입출력 속도
  - High-Variety = 다양성
- R과 파이썬
- R의 장점과 단점
  - 장점
  - 단점

---

## < R 설치 >



---

## < R Studio 설치 >



---

## < R 언어의 구문 >

1. R이란

   - 통계 계산과 그래픽을 위한 프로그래밍 언어이자 소프트웨어 환경
   - 뉴질랜드 오클랜드 대학의 로버트 젠틀맨과 로스 이하카에 의해 시작되어 현재는 R 코어 팀이 개발
   - 빅데이터 분석 언어
   - 시각화 언어

2. R에서 지원하는 데이터 타입의 종류

   1. R의 자료형

      - 문자형 : 문자, 문자열
      - 수치형 : 정수, 실수
      - 복소수형 : 실수 + 허수
      - 논리형 : 참값과 거짓값

   2. R의 리터럴

      - 문자형 리터럴 : "가나다", '가나다', "", '', '123', "abc" 등
      - 수치형 리터럴 : 100, 3.14, 0
      - 논리형 리터럴 : TRUE(T), FALSE(F)
      - NULL(데이터 셋이 비어있음을 의미)
      - NA(데이터 셋의 내부에 존재하지 않는 값(결측치)를 의미)
      - NaN(Not a Number : 숫자가 아님)
      - Inf : 무한대 값

   3. 타입체크 함수

      ```
      is.character(x) - 문자형	is.logical(x) - 논리형		is.numeric(x) - 수치형		is.double(x) - 실수형		is.integer(x) - 정수형		is.null(x)	is.na(x)	is.nan(x)	is.finite(x)	is.infinite(x)		as.logical(x)
      ```

   4. 자동 형 변환 룰

      - 문자형 -> 복소수형 -> 수치형 -> 논리형

   5. 강제 형 변환 함수

      ```R
      as.character(x)		as.complex(x)		as.numberic(x)		as.double(x)	as.integer(x)
      ```

   6. 자료형 확인 함수

      ```R
      class(x)	str(x)		mode(x)
      ```

3. R의 데이터

   - 종류
     - **벡터(팩터)**, 행열, 배열, **데이터프레임**, 리스트