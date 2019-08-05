# Web Programming

## 1. 공부 순서

- 웹 클라이언트
  1. HTML
  2. CSS
  3. JavaScript
  4. Ajax //자바스크립트 언어활용
  5. HTML5 주요 API //자바스크립트 언어활용
- 웹 서버
  1. Servlet & JSP
  2. Spring FrameWork : Servlet & JSP를 규격화한 서버 기술 (Spring MVC)
  3. MyBatis : jdbc를 세련되게 코딩할 수 있다. //하이버네이트도 있음.
- 웹기반 시각화 : D3.js //자바스크립트 언어활용
- 오픈 API : 네이버 또는 구글, 업그레이드가 자주 된다. //자바스크립트 언어활용

------

## 2. 설치 프로그램

- 웹서버 - Tomcat(Web Application Server : WAS)

  - [설치주소: tomcat.apache](http://tomcat.apache.org/)
  - 32-bit/64-bit Windows Service Installer(pgp,sha512)
  - hostmanager, example check : 체크하나 안하나 상관없다.
  - HTTP/1.1 Connector Port : 8000(오라클과 중복되어 변경필요)
  - Run Apache Tomcat, Show Readme : 체크해제 -> eclipse에서 직접 기동시키기 위해서(eclipse가 제어하게 설정)

- eclipse에서 Tomcat 서버 구동하기

  1. Tomcat 서버를 eclipse에 등록

     - File-New-Other-Server
     - Apache-Tomcat v9.0 Server 선택
     - Tomcat installation directory : C:\Program Files\Apache Software Foundation\Tomcat 9.0
     - Finish!

  2. edu생성 (edu - Dynamic Web Project)

     - File-New-Other-Web
     - Generate web.xml deployment descriptor : 체크
     - edu-Properties-Text file encoding-Other-UTF-8

  3. edu를 Tomcat 서버에 등록

     - Add and Remove - add

  4. first.html 파일 생성

     - WebContent-New-html파일
     - charset="UTF-8" 자동설정
       - Window-Preference-Web-HTML Files-Encoding-UTF-8선택

  5. 브라우저(크롬)에서 first.html 요청

     - 크롬 실행

       - <http://localhost:8000/edu/first.html>

         - 위 문장은 HTTP URL(Uniform Resource Locator) 문자열이다.

         - http(HyperText Transfer Protocol) : 웹의 표준 프로토콜이다.

         - [http://localhost:8000](http://localhost:8000/) : 서버 정보이다.

         - /edu/first.html : 클라이언트가 서버한테 요청하고자 하는 path정보이다.

           ​	URI(Uniform Resource Identifier) 문자열이다.

         - /edu : Context Path 라고 한다. 잘못 줄 경우 404오류가 발생한다.

         - /first.html : Document root에 가서 해당 파일을 보여달라고 요청한다.

           ​	(WebContent : Dynamic Web Project의 WebContent를 Document root 라고 한다.)

         - 웹 브라우저에서 내용이 출력되는 부분을 document라고 한다.

         - 렌더링 : html 소스를 파싱하여 각 태그에 알맞게 document에 출력해주는 것을 말한다.

           - 파싱(parsing)이란?

             -> parse에 ing를 붙인 형태로 어떤 데이터를 다른 모양으로 가공하는 것을 말한다.

             -> cf) 파서(parser) : compiler의 일부로써 원시 프로그램을 받아들여 그 문장의 구조를 알아내는 구문 분석을 행하는 프로그램이다.

     - 서버 다 사용한 뒤 끄기

- 웹클라이언트 - 크롬

  - 웹 표준
    - HTML : 문서의 내용과 구조 담당한다.
    - CSS : 스타일에 관련된 표현 담당한다.
    - Java Script : 클라이언트 종류에 무관하게 동작 담당한다.

------

## 3. HTML(Hyper Text Markup Language) 5

W3C(World Wide Web Consortium)의 HTML WG(Working Group)을 통해서 만들어지고 있는 차세대 마크업 언어 표준이다.

- 주석 : ctrl+shift+/ :

- <http://html5test.com/> : 자신의 브라우저에서 html5를 얼마나 지원하는지 점수로 알 수 있다.

- HTML 문서 구성

  | 요소              | 의미                                                 | 코드 예                 |
  | ----------------- | ---------------------------------------------------- | ----------------------- |
  | 태그(tag)         | '<'와 '>'로 둘러싸인 문자열                          | **<title>Test</title>** |
  | 내용(content)     | 태그로 둘러싸인 문자열                               | <title>**Test**</title> |
  | 엘리먼트(element) | 태그와 내용을 포함한 전체 문자열                     | **<title>Test</title>** |
  | 속성(attribute)   | 시작 태그 안에서 엘리먼트의 상세 기능 설정 사항 지시 | <a **href**="URL">      |
  | 속성값(value)     | 속성값 (' ' 또는 " "로 감쌈)                         | <a href=**"URL"**>      |

- HTML5의 문서구조

  ```
  <!DOCTYPE html>	<!--선언문-->
  <html>
  <head>
  	<meta charset="UTF-8">
  	<title>첫 번째 HTML</title>
  </head>
  <body>	<!--렌더링 되는 값은 body태그 안의 내용이다.-->
  	<h1>HTML을 테스트합니다.</h1> 
  </body>
  </html>
  ```

- 행바꿈

  - block style tag : 자동으로 행바꿈이 일어나는 태그
  - inline style tag : 자동으로 행바꿈이 일어나지 않는 태그

- HTML 특수 문자 표기법

  | 엔티티 이름 | 출력               |
  | ----------- | ------------------ |
  | &lt;        | <                  |
  | &rt;        | >                  |
  | &nbsp;      | (공백, Space 한칸) |
  | &amp;       | &                  |
  | &quot;      | " (큰따옴표 하나)  |
  | &copy       | ©                  |
  | &reg;       | ®                  |

- HTML5에서 문서 구조를 정의하는 태그(Semantic Tag)

  | 태그      | 설명                                                         |
  | --------- | ------------------------------------------------------------ |
  | <header>  | 머리말, 제목을 표현하기 위해 사용한다.                       |
  | <nav>     | "네비게이션"이라고 하고 주로 메뉴에 사용되고 위치에 영향을 받지 않는다. |
  | <section> | 본문 콘텐츠 내용을 담는다.                                   |
  | <article> | 실질적인 내용을 넣는다. 뉴스를 예로 들면 정치/연예 대분류는 <section>이고, 정치의 기사내용, 연예의 기사내용은 <article>에 넣는다. |
  | <aside>   | ''사이드바''라고 부르며 본문 이외의 내용을 담고 있는 시맨틱 태그이다. |
  | <footer>  | 화면의 구조 중 제일 아래 위치하며 회사소개/저작권/약관/제작정보 등 내용이 들어간다. |

- 정규 표현식

  | 정규 표현식           | 설명                                    |
  | --------------------- | --------------------------------------- |
  | [a-zA-Z]{n}           | n개만큼 영문 a-z, A-z를 입력            |
  | [0-9]{n}              | n개만큼 숫자 0~9를 입력                 |
  | [A-Za-z0-9]{min, max} | 영문자와 숫자를 min~max만큼 글자수 입력 |
  | [0-9]+                | 0~9 숫자 중 1개 이상 입력               |
  | [0-9]?                | 0~9 숫자 중 0개 또는 1개 입력           |
  | [0-9]*                | 0~9 숫자 중 0개 이상 입력               |

------

## 4. CSS

웹 문서에서 디자인 요소를 담당하는 언어이다.(텍스트의 색상,크기 또는 이미지의 크기,위치)

- 주석 : /* 주석내용 */ (단축키 : ctrl+shift+/)

  ### 4.1 CSS 선택자 종류

  1. 전체 선택자(Universal Selector) : *{속성: 값;}

  2. 타입(태그) 선택자 : 태그명{속성: 값;}

  3. 그룹 선택자 : 태그명, 태그명{속성: 값;}

  4. 클래스 선택자 : .class속성값{속성: 값;}

  5. 아이디(id) 선택자 : #id속성값{속성: 값;} - 특정하고 유일해야한다.

  6. 자식 선택자 : 부모태그>자식태그{속성: 값;} - 자손을 포함하지 않는다.

  7. 후손(하위) 선택자 : 조상태그 자손태그{속성: 값;} - (조상태그, 자손태그 사이 공백) 자손을 포함한 모든 자식레벨에서 적용한다.

  8. 형제 선택자 : 언니태그 ~ 동생태그{속성: 값;} - ex)li,tr과 같은

     인접 형제 선택자 : 언니태그 + 동생태그{속성: 값;} - 바로 밑에 동생태그에 적용

  9. 속성 선택자 : 태그명[속성명]{속성: 값;}

     ​	태그명[속성명="val"]{속성: 값;} - ex) 'val'과 일치하는 태그를 선택한다.

     ​	태그명[속성명~="val"]{속성: 값;} - ex) 'val'을 단어로 포함하는 태그를 선택한다.

     ​	태그명[속성명|="val"]{속성: 값;} - ex) 'val'이거나 시작하는 태그를 선택한다.

     ​	태그명[속성명^="val"]{속성: 값;} - ex) 'val' 시작하는 태그를 선택한다.

     ​	태그명[속성명*="val"]{속성: 값;} - ex) 'val'을 포함하는 태그를 선택한다.

     ​	태그명[속성명$=속성값]{속성: 값;} ex) img[src$=png] - png로 끝나는 속성값을 찾게다는 것이다.

  10. 가상 클래스 선택자 : ex) a:hover - 마우스가 올려져있는 a태그

      ​	p:first-letter - 첫 문자

  ### 4.2 HTML 태그에 대한 렌더링 규칙

  태그마다 출력되는 영역을 정하는 규칙에 따라 Inline Style Tag와 Block Style Tag로 나뉜다.

  - Inline Style Tag : 출력되어야하는 내용만큼만 영역으로 잡는다. ex) a, img, input, **span**

    - span

      -> width, height로 사이즈 조정이 불가하다. padding으로 사이즈 조정을 해야한다.

      -> 가운데로 위치시키는 방법 :

      - div 태그로 묶어 text_align 값을 center로 준다.

  - Block Style Tag : 행 끝까지 영역으로 잡는다. ex) hn, **div**, Semantic Tag(header, nav...), table, ul, ol, p, form

    - div

      -> width, height로 사이즈 조정이 가능하다.

      -> 가운데로 위치시키는 방법 : 좌우 margin을 auto로 준다.

    - 속성값 개수에 따른 margin 속성값

      - margin{속성값;}

      1. margin{10px;} : 상하좌우 모두
      2. margin{10px auto;} : 상하 좌우
      3. margin{10px 10px auto;} : 상 하 좌우
      4. margin{10px 10px 10px 10px;} : 상 우 하 좌

  - <http://troy.labs.daum.net/> : 모바일 반응형 웹페이지를 테스트해볼 수 있다.

  ### 4.3 웹페이지를 디자인할 때

  ​	(1) 모바일

  ​	(2) PC+모바일

  - 반응형 웹 디자인(total)

    ```
    * PC 디자인 + 모바일 디자인 : ex) PC : www.naver.com, 모바일 : m.naver.com
    ```

    

# < JavaScript >

- JavaScript : 라이브스크립트라는 이름에서 최종적으로 자바스크립트가 되었다. 동적인 웹페이지 제작에 사용되는 언어이며 정적인 웹페이지를 생산하는 HTML을 보완한다. OOP언어로 넷스케이프 -> ECMA로 바뀌면서 오픈언어가 되었다.
- Java : 범용 언어이면서 OOP언어이다. 썬마이크로시스템즈 -> Oracle로 바뀌었다.

## 1.1 JavaScript 구문 정리

- 데이터 타입, 변수 생성 방법
- 연산자
- 제어문
- 배열
- 함수 - 객체 상관없이 호출한다.
- 객체 생성
  - 객체 리터럴
  - 클래스
- 주요 API - 내장함수, 내장객체, BOM, **DOM**
- 주석
  - 한줄 주석 : //
  - 다중 주석 : /* 주석내용 */

------

## 1.2 변수 생성 방법, 데이터 타입

- 변수 생성 방법

(1) 변수명의 맨 앞에는 숫자가 올 수 없다.

(2) 영문, _(밑줄 문자), $만 사용 가능하다.

(3) **대소문자를 구분**한다.

- 데이터타입

​	변수 선언할 때 타입을 제한하지 않는다. 어떤 값을 넣는냐에 따라 타입이 정해진다.

- number

- string : " "(큰따옴표), ' '(작은따옴표) 모두 사용가능하다.

  ```
  v1 = 123; //number
  document.writeln(v1+45+"<br>");	//168
  v1 = '123'; //string
  document.writeln(v1+45+"<br>");	//12345
  ```

- boolean

- null

- undefined : 타입명 또는 값으로 쓰인다.

- object

- function

  ```
  //자바스크립트의 데이터타입 체크(1)
  <script>
  	document.write("<h2>"+typeof 100+"</h2>");	//number
  	document.write("<h2>"+typeof 3.14+"</h2>");	//number
  	document.write("<h2>"+typeof '가'+"</h2>");	//string
  	document.write("<h2>"+typeof "abc"+"</h2>"); //string
  	document.write("<h2>"+typeof '100'+"</h2>"); //string
  	document.write("<h2>"+typeof true+"</h2>"); //boolean
  	document.write("<h2>"+typeof undefined+"</h2>"); //undefined
  </script>
  
  //자바스크립트의 데이터타입 체크(2)
  <script>
      var v1;
  	document.write("<li>"+v1+"</li>");	//undefined - 값으로 쓰임
  	document.write("<li>"+ typeof v1+"</li>");	//undefined - 타입으로 쓰임
  	document.write("<li>"+(v1+10)+"</li>");	//NaN(Not a Number)이 나온다!!
  	v1 = 100;
  	document.write("<li>"+v1+"</li>");	//100
  	document.write("<li>"+ typeof v1+"</li>");	//number
  	document.write("<li>"+(v1+10)+"</li>");	//110
  	v1 = true;
  	document.write("<li>"+v1+"</li>");	//true
  	document.write("<li>"+ typeof v1+"</li>");	//boolean
  	document.write("<li>"+(v1+10)+"</li>");	//true -> 11 - true면 1 false면 0으로 바뀐다.
  	v1 = "가나다";
  	document.write("<li>"+v1+"</li>");	//가나다
  	document.write("<li>"+ typeof v1+"</li>");	//string
  	document.write("<li>"+(v1+10)+"</li>");	//가나다10
  </script>
  ```

------

## 1.3 연산자

관계 연산자

- A == B : A와 B의 **데이터 값**이 같은지 비교한다.
- A === B : A와 B의 **데이터 형**이 같은지 비교한다.

조건(삼항) 연산자

- (조건식)? A : B;

논리 연산자

- 식1&&식2&&식3

- 식1||식2||식3

  ```
  <script>
      /* 연산결과가 true 아니면 false가 된다. */ 
  	document.writeln(10>5);	//true	
  	document.writeln("abc">"ABC");	//true - 다른 문자부터 비교한다.
  	var str="가나다";
  	document.writeln(str == "가나다");
  	document.writeln(true == 1);	//true -> true를 1로 변환해서 비교한다.
  	document.writeln("100" == 100);	//true -> string으로 형변환해서 비교한다.
  	document.writeln(true === 1);	//false
  	document.writeln("100" === 100);	//false
  	/* 산술연산자 */
  	document.writeln(10/3);	//3.333... -> 자바스크립트는 실수로 만든다.
  </script>
  
  <pre> /* pre태그로 묶어주면 writeln의 개행문자가 줄바꿈 기능을 갖게 된다. */
      <script> //if문과 삼항 연산자를 쓰지 않고 출력할 수 있다. 
      	var num=5;
  		//num이 짝수이면 "xx는 짝수"
  		//num이 홀수이면 "xx는 홀수"
  		num%2 == 0 && document.writeln(num+"는 짝수");	//앞의 식이 참이면 두 번째 식 수행
  		num%2 == 0 || document.writeln(num+"는 홀수");	//앞의 식이 거짓이면 두 번째 식을 수행	
      </script>
  </pre>
  ```

- 브라우저 : GUI(Graphic User Interface) 모드 제공

------

## 1.4 제어문

- for, while, do~while, if, switch, break, continue
- **0, null, undefined** : **false로 간주**된다. ex) if(num % 2) 의 값이 1이면 true 0이면 false이다.

## 1.5 배열

- 배열 생성 방법

  (1) 배열 리터럴 : var 변수명 = **[값1, 값2, 값3 ... 값n]**;

  (2) 표준 API로 객체를 생성하여 만드는 방법 : **Array()** 라는 생성자 함수 활용(java의 class와 비슷)

  ​	var 변수명 = new Array(값1, 값2, 값3 ... 값n);

- 특징

  (1) 하나의 배열에 저장되는 데이터 타입의 제한이 없다. ex) var array=[10, '가나다', true, 3.5]

  (2) 배열이 생성된 이후에도 배열의 크기를 변경할 수 있다. (java의 arrayList와 비슷)

  (3) 인덱스는 0부터 시작한다.

  (4) length 라는 속성을 사용하여 배열의 크기를 알 수 있다.

- 배열 리터럴

  ```
  <script>
  	var a1 = [];
  	document.write("<h3>"+typeof a1+"</h3>"); //object
  	document.write("<h3>"+Array.isArray(a1)+"</h3>"); //true 
  	document.write("<h3>"+ a1.length +"</h3>"); //0
  	document.write("<h3>"+a1[0]+"</h3>"); //undefined
  </script>
  ```

- Java enhanced for문과의 차이

  (1) for(int data : array)에서 : 대신 for(int data in array) in을 사용한다.

  (2) undefined 값은 무시하고 유효한 값만 출력한다.

  (3) 원소값이 아닌 인덱스값을 가져온다. (이유 : 일반 자바스크립트 객체에서도 사용 가능하기 때문이다.)

  ```
  <script>
  	a1[4] = 100; //방 5개를 만든다.
  	document.write("<h3>"+ a1.length +"</h3>");	//5
  	for(var i=0;i<a1.length;i++)
  		document.write("<h4>"+ a1[i] +"</h4>");	//1~4 방은 값이 없으므로 undefined가 출력된다. 
  	for(var i in a1) //enhanced for문	
  		document.write("<h4>"+ a1[i] +"</h4>");
  	var a2 = [10, '가나다', true, 3.5];
  	for(var i in a2)	
  		document.write("<h4>"+ typeof a2[i]+" : "+a2[i] +"</h4>");
  </script>
  ```

- Array() 생성자 함수 이용한 배열 생성

  ```
  <script>
      var a1 = new Array(); //[ ]
  	var a2 = new Array(10);	//배열의 크기
  	var a3 = new Array('가'); //원소값
  	var a4 = new Array(10,20); //원소값
  	var a5 = new Array(1,2,3,4,5); //원소값
  </script>
  ```

- 배열 객체의 주요 메서드

  배열 객체와 관련된 다양한 메서드를 갖고 있다. [w3schools-배열객체 메서드](https://www.w3schools.com/jsref/jsref_obj_array.asp)

  - **sort()** : 기본 문자열 기반의 정렬을 한다.

    ```
    var ary=[30,11,5,27,9];
    	document.write(ary+"<br>");
    	var ary2=ary.sort(function(a, b){return a-b;}); //숫자기반의 오름차순 정렬을 해준다.
    	document.write(ary+"<br>");
    	document.write(ary2+"<br>");
    ```

  - **push()** : 배열의 끝에 값을 넣는다.

    ```
    <script>
    var ary5=[]; 
    	ary5.push(100);
    	ary5.push(200);
    	ary5.push(500);
    	ary5.push(600,700,800);
    	document.write(ary5+"<br>"); //100,200,500,600,700,800
    </script>
    ```

------

## 1.6 함수 정의

- 함수 정의 방법

  (1) **선언적 함수** 정의 방법(명시적 함수 정의)

  ​	function myFunction([매개변수 리스트]){

  ​	:

  ​	[return 리턴값]

  ​	}

  ​	리턴값 없이 리턴했을 경우 : undefined 가 리턴된다.

  - 사용방법

  ​	함수명();

  ​	var v = 함수명();

  ​	함수명(아규먼트리스트);

  ```
  <script>
  	function f1(){
  		document.write("f1() 호출<br>");
  	} 
  	function f2(p1, p2){
  		document.write('f2() 호출 : '+(p1+p2)+'<br>');
  	} 
  	f1();
  	f2(10,20); // argument를 주지 않으면 NaN값을 출력한다.
  	document.write('<hr>');
  	var result1=f1();
  	var result2=f2(100,200);
  	document.write("result1 : "+result1+", result2 : "+result2+"<br>"); //undefined
  	if(!result1) //true : undefined 값을 boolean값으로 바꾸면 false이다.
  		document.write("리턴값이 없군요!!!");
  	document.write('<hr>');
  	f1(100);
  	f2(100);
  </script>
  ```

  (2) **표현식 함수** 정의 방법

  ​	function([매개변수 리스트]){

  ​	:

  ​	}

  - 사용방법

  ​	var 함수명 = function ([매개변수리스트]){

  ​	}

  ​	f1(function () {..........} )

  ```
  <script>
  function clickProcess(p) {
  	if (typeof p == "number") { //""인용부호를 써서 문자열형식으로 비교해야한다. 
  		alert("숫자 전달!!");
  	} else if (typeof p == "string") {
  		alert("문자열 전달!!");
  	} else if (typeof p == "boolean") {
  		alert("논리값 전달!!");
  	} else if (typeof p == "function") {
  		alert("함수 전달!!");
  	} else if (typeof p == "object") {
  		if (Array.isArray(p)) //배열이면 true 아니면 false
  			alert("배열객체 전달!!");
  		else 
  			alert("객체 전달!!");
  	} else if (typeof p == "undefined") {  // p == undefined 와 같이 값만 비교가능 
  		alert("전달된 아규먼트 없음!!");
  	}	
  }
  </script>
  ```

  (3) 가변 아규먼트

- 호출시 아규먼트의 갯수가 제한없는 함수를 만들고 싶을 때는 다음과 같이 함수를 정의한다.

  function out() {

  ​	arguments //지역변수

  }

  함수가 호출되는 시점에 arguments라는 지역변수가 자동으로 초기화된다.

  함수 호출시 전달되는 아규먼트들을 유사배열 객체에 담아서 arguments 변수에 할당한다.

  ```
  <script>
    	function out(){
    		document.write("아규먼트 갯수 : "+arguments.length+"<br>");
    		for(var i=0;i<arguments.length;i++)
    			console.log(arguments[i]);
    		console.log("-------------------------------------------");
    	}
    	out(); out(10); out(10,20); out('a','b','c'); out(1,2,3,4,5,6,7,8);
  	//아규먼트 갯수 : 0
  	//아규먼트 갯수 : 1
  	//아규먼트 갯수 : 2
  	//아규먼트 갯수 : 3
  	//아규먼트 갯수 : 8
  </script>
  ```

- 함수의 아규먼트 처리

  - 아규먼트로 함수 전달하기(=고차함수)

    (1) 방법 : 익명함수, 함수표현식, 함수리터럴 방법

    (2) 방법 : 함수 선언식 활용

    (3) 방법 : 함수를 변수에 담아 사용하는 방법

  - 함수와 메서드의 차이

    - 함수 : 단독으로 호출 가능하다.
    - 메서드 : 객체 생성을 통해 호출 가능하다.

  ```
  <script>
    output("둘리");
    output(function (param) {console.log(param);}); //(1)방법
    function myAlert(param){ //(2)방법
    	window.alert(param); //경고창
    } 
    output(myAlert);
    var myAlert2 = function (param){ //(3)방법
    	window.alert(param); //경고창
    }
    output(myAlert2); //myAlert2 함수 자체를 전달하겠다는 것이므로 함수이름만 전달해야한다!!!
    function output(p){ //코드를 읽을 때 함수정의와 전역변수를 제일 먼저 읽는다.
    	if(typeof p == "function")
    		p("ㅋㅋㅋ");
    	else
    		document.write("<h2>ㅋㅋㅋ : "+p+"</h2><br>");
    }
    </script>
  ```

------

## 1.7 객체

OBP(Object Based Programming) -> OOP(Object Oriented Programming)

- 객체 생성 방법

  (1) 객체 리터럴

  (2) 생성자 함수 (자바의 클래스와 유사함)

- 객체 리터럴 : 1번만 객체를 만들어 사용할 경우

  {}

  {속성명 : 속성값, 속성명 : 속성값 ...} : 속성값으로는 숫자, 문자열, 논리값, 배열, 함수(메서드)

  - 객체의 멤버 접근 방법

    (1) 멤버 연산자 : .

    (2) 인덱싱 방법 : ['속성명']

    ​	obj.name, obj['name']

    ​	obj.project, obj['project']

    ​	obj.study()

    ​	obj.eat('딸기')

  ```
  <script src="util.js"></script>
  <script>
  var obj = {
  			name : "듀크", //멤버변수
  			eat : function(food){ //객체 메서드
  			write(this.name+"가 "+food+"를 먹어요.","h3"); //this를 생략해서는 안된다. 
               }  					//this를 사용하지 않으면 window객체의 name을 사용한다...
  		 }
  obj.eat("바나나"); //듀크가 바나나를 먹어요.			
  obj.eat("딸기"); //듀크가 딸기를 먹어요.		
  hr()
  write(typeof obj,"h2"); //Object
  obj.project="자바스크립트";
  obj.study=function(){
  	write(this.name+"는 "+this.project+"를 공부해요.","h3");
  }
  obj.study();
  for(var key in obj){ //key에는 obj가 갖고 있는 속성명(문자열형식)이 대입된다.
  	write(key+ " : "+obj[key],"h3"); // obj[key] 대신 obj.key를 사용하면 객체 obj의 속성 key라는 									    문자열을 찾기에 undefined 오류가 난다.
  }
  delete obj.study; //obj가 가지고 있는 study속성을 없애라는 것이다.
  hr();
  for(var key in obj){ 
  	write(key+ " : "+obj[key],"h3");
  }
  </script>
  ```

  ```
  //util.js
  function write(content, tag){
  	document.write("<"+tag+">"+content+"</"+tag+">");
  }
  function hr(){
  	document.write("<hr>");
  }
  ```

- 생성자 함수(클래스+생성메서드)

  객체를 초기화하는 역할의 함수이다. (객체를 초기화한다는 것은 비어있는 객체에 멤버를 넣어주는 역할을 말한다.)

  사용방법 : new와 함께 호출된다. (new 다음에 호출하지 않으면 이상해진다...)

  이름을 정할 때 첫 글자를 대문자로 한다.

- 객체 리터럴 방식과 생성자 함수 방식의 비교

- | 객체리터럴 방식                                              | 생성자 함수 방식                                             |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | -객체 리터럴 방식은 하나의 객체만을 만들 수 있게 된다. (싱글톤 객체) -prototype 속성 사용이 불가하다. | -동일한 속성 사양을 갖는 객체들을 여러개 생성하는 것이 가능하다. -prototype 속성 사용이 가능하다. -정적 멤버를 정의할 수 있다. -캡슐화나 정적 멤버와 같은 OOP 구문을 적용하여 객체를 생성하는 것이 가능하다. |

- prototype

  생성자 함수에는 멤버변수 초기화만 구현하고, 프로토타입에는 메서드를 초기화한다.

  객체리터럴 방식은 prototype 속성 사용이 불가하다.

  ```
  <script>
  function Student(p1,p2,p3,p4){ 
  								this.name = p1, 
  								this.kor = p2, 
  								this.eng = p3,
  								this.math = p4				
  }
  Student.prototype.getSum = function(){ //생성자 함수에 의해서 자동으로 만들어진다.
  	return this.kor+this.eng+this.math;  //메모리 구조를 효율적으로 사용한다.
  };
  Student.prototype.getAvg = function(){
  	return this.getSum()/3; 
  };
  Student.prototype.toString = function(){
  	return this.name+"학생의 총점은 "+this.getSum()+"입니다.";
  };
  
  var student=new Student("둘리", 90, 80, 95);
  var student1=new Student("또치", 80, 90,80);
  var student2=new Student("도우너", 85, 70, 80);
  
  writeColor("학생1 : "+student.toString(),"h3","green"); //객체를 생성하여 메서드 호출 : 객체명.메서드명
  writeColor("학생2 : "+student1,"h3","blue"); 
  writeColor("학생3 : "+student2,"h3","red"); 
  </script>
  ```

- prototype영역에 넣어서 정의한 메서드와 정적 메서드 차이

  - 메모리 영역에 한 번만 할당한다는 것은 같다.
  - 정적메서드는 this를 사용할 수 없다.
  - 단독으로 수행되어야할 경우 정적메서드로 구현한다.

  ```
  <script>
  function Area() { //기본적인 생성자함수 구조
  }
  Area.version = '1.0'; //정적속성
  Area.triangle = function(base, height) { //정적메서드
    return base * height / 2;
  }
  Area.diamond = function(width, height) {
    return width * height / 2
  }
  document.writeln('Area클래스의 버전：' + Area.version); //생성자함수 이름으로 멤버변수를 호출한다.
  document.writeln('삼각형의 면적：' + Area.triangle(5, 3));
  var a = new Area();
  document.writeln('마름모의 면적：' + Area.diamond(10, 2));
  document.writeln('마름모의 면적：' + a.diamond(10, 2));
  </script>
  ```