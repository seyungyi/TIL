# 자바스크립트 함수와 생성방법

## 주제

> - 자바스크립트 함수의 개념과 특징
> - 함수선언문과 함수표현식의 차이와 사용법
> - 호이스팅이란?



## 함수(Function)

- 코드의 집합을 나타내는 자료형

- 여러 개의 인자를 받아 특정 결과를 출력, 연산, 반환한다

- 파라미터의 개수와 인자의 개수가 일치하지 않아도 오류를 반환하지 않는 특징을 가짐

  - 예로, 파라미터 1개가 정의된 함수를 호출할 경우에 인자를 전달하지 않고 실행한다면 이미 정의되어있던 파라미터(=매개변수)의 값은 `undefined`라는 값을 가진다.
  - 해석하자면 변수는 초기화되었지만, 값이 할당되지 않았다는 뜻을 가진다.

- `하나의 객체로 정의`될 수 있다.

  - 다른 객체와 마찬가지로 함수형 객체를 넘기거나 할당할 수 있다.

  - 함수를 객체 프로퍼티에 할당 가능함

    ````javascript
    function printFunction() {
      console.log('Print Success!!');
    }
    
    const empty = {}
    empty.text = printFunction;
    empty.printFunction();
    ````

  - 함수를 객체 배열 요소로 할당 가능함

    ````javascript
    const array = [1, 2, 3];
    array[1] = printFunction;
    array[1]();
    ````

### 함수선언문과 함수표현식의 차이

#### 함수선언문 (Function Declaration)

- 일반적인 프로그래밍 언어와 비슷한 형태의 선언 방식

  ```` javascript
  function 함수명() {
    // 실행할 로직
  }
  
  function print() {
    console.log('Print Function Log');
  }
  ````

#### 함수표현식 (Function Expression)

- 변수값에 함수 표현을 담아놓은 형태

  - 유연한 자바스크립트 언어의 특징을 활용한 선언 방식이다.

- 함수표현식은 익명과 기명 함수표현식으로 나눌 수 있다.

  - 일반적인 함수표현식의 경우 앞에 익명이 생략된 형태로 볼 수 있다.
  - 익명 함수표현식 : 함수에 식별자가 주어지지 않음
  - 기명 함수표현식 : 함수에 식별자가 존재

- 장점

  - 클로져로 사용
  - 콜백으로 사용(다른 함수의 인자로 넘기는 것이 가능)

  ````javascript
  const run1 = function() {
    return '익명 함수표현식';
  }
  
  const run2 = function run2() {
    return '기명 함수표현식';
  }
  ````

#### 함수선언문과 함수표현식 차이

- 함수선언문은 `호이스팅`에 영향을 받지만, 함수표현식은 `호이스팅`에 영향을 받지 않는다.

  - 함수선언문은 코드 구현 위치에 상관없이 자바스크립트의 특징인 `호이스팅`에 따라 **브라우저가 자바스크립트를 해석할 때 맨 위로 끌어 올려짐**
  - 함수표현식은 함수선언문과 달리 **선언과 호출 순서**에 따라 정상적으로 함수가 실행되지 않을 수 있음

- 함수표현식의 Error 발생

  ````javascript
  /* 정상 */
  function printConsole(name) {
    const inner = function() {
      return 'Bred';
    }
    
    const result = inner();
    console.log('name is ' + result);
  }
  
  printConsole();	// name is Bred
  ````

  ````javascript
  /* 오류 */
  function printConsole(name) { // 함수선언문
      console.log(inner); // "undefined": 선언은 되어 있지만 값이 할당되어있지 않은 경우
      const result = inner(); // ERROR!!
      console.log("name is " + result);
  
      const inner = function() { // 함수표현식 
          return "Bred";
      }
  }
  printConsole(); // TypeError: inner is not a function
  
  
  /** --- JS Parser 내부의 호이스팅(Hoisting)의 결과 --- */
  /* 오류 */
  function printConsole(name) { // 함수선언문
      let inner; // Hoisting - 변수값을 끌어올린다. (선언은 되어 있지만 값이 할당되어있지 않은 경우)
      console.log(inner); // "undefined"
      const result = inner(); // ERROR!!
      console.log("name is " + result);
  
      inner = function() { // 함수표현식 
          return "Bred";
      }
  }
  
  printConsole(); // TypeError: inner is not a function
  ````