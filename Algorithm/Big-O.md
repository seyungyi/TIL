# Big-O: functions ranking

"시간 복잡도와 Big-O표기"

- 알고리즘(Algorithm) 

  > 어떤 목적을 달성하거나 결과물을 만들어내기 위해 거쳐야 하는 일련의 과정들 

  - 한 문제는 여러가지의 알고리즘으로 풀 수 있습니다.
  - 시간 복잡도를 분석하는 것은 **input n에 대하여 알고리즘이 문제를 해결하는 데에 얼마나 오랜 시간이 걸리는 지를 분석하는 것**, 이는 <u>Big-O표기</u>를 이용하여 정의할 수 있다.

- Big-O 표기

  > ```
  > Regular       Big-O
  > 2             O(1)   --> It's just a constant number
  > 2n + 10       O(n)   --> n has the largest effect
  > 5n^2          O(n^2) --> n^2 has the largest effect
  > 시간복잡도에서 중요한 것은 정해진 표현식에 가장 큰 영향을 미치는 n의 단위이다. 
  > ```

  - 대표적인 시간 복잡도들
    - O(1) - 상수시간: 문제를 해결하는데 오직 한 단계만 거칩니다.
    - O(log n) - 로그 시간: 필요한 단계들이 연산마다 특정 요인에 의해 줄어듭니다.
    - O(n) - 직선적 시간: 문제를 해결하기 위한 단계의 수와 입력값 n이 1:1단계
    - O(n^2) - 2차 시간:                                    '''                                       의 제곱
    - O(C^n) - 지수 시간:                          '''                          는 주어진 값 C의 n제곱

- 문제라는 것은 정답이나 최선의 답의 관점에서 접근하는 것보다, 상황에 더 맞는 답인지 아닌지의 관점에서 접근해야 합니다.





[출처](https://joshuajangblog.wordpress.com/2016/09/21/time_complexity_big_o_in_easy_explanation/)