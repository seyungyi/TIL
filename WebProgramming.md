# [ 웹 프로그래밍 ]

- 웹 클라이언트 : HTML, CSS, JavaScript, Ajax, HTML5 주요 API
- 웹 서버 : Servelet&JSP, Spring FW, MyBatis
- 웹기반 시각화 : D3.js
- 오픈 API : 네이버 또는 구글



- 웹서버 - Tomcat(Web Application Server : WAS)
- 웹클라이언트 - 크롬

## 설치경로 

http://tomcat.apache.org/

아파치의 포트번호 8080은 오라클과 중복되기에 8000으로 수정

톰캣을 이클립스에서 기동과 정지를 제어할 예정

javaexam - java project 자바 소스
edu - Dynamic Web Project 에서 웹개발 진행
(1) Tomcat 서버를 eclipse에 등록
(2) edu 생성
(3) edu를 Tomcat 서버에 등록

## HTML

```
브라우저(크롬)에서 first.html 요청
http://localhost:8000/edu/first.html
http://ip주소:포트번호/edu/first.html ---> HTTP URL 문자
					---------------
							URI 문자열
					------
					컨텍스트패스
				
WebContent/images	 ----- 이미지 파일들
		 /htmlexam	----- HTML 파일들
		 /cssexam	----- HTML, CSS 파일들
		 /jsexam	----- HTML, CSS 파일들
a 태그 = 링크를 연결시키는 기능
img 태그 = 이미지를 출력하는 기능
```

# CSS

```
<style>
태그 {
속성: 속성값;
}
</style>

선택자의 종류
- 전체선택자 = *
- 태그선택자(타입선택자) = 태그명
- 그룹선택자 = 태그명, 태그명, ....
- 클래스선택자 = .class속성값
- 아이디선택자 = #id속성값
- 자식선택자 = 부모태그>자식태그
- 자손선택자 = 조상태그 자손태그
- 형제선택자 = 언니태그~동생태그, 언니태그+동생태그
- 속성선택자 = [속성명]
			 [속성명=속성값]
			 [속성명^=속성값]
			 [속성명$=속성값]
			 img[src$=png] --> png로 끝나는 이미지형식을 display하는 선택자태그
			 
주석 : <style>태그 안에서 /* */ 안에 사용

[ HTML태그에 대한 랜더링 규칙(1) ]
태그마다 출력되는 영역을 정하는 규칙에 따라 inlinestyle 태그와 blockstyle 태그로 나뉜다
inlinestyle 태그 ; a, img, input, span, hn(h태그의 n숫자), div(... 시맨틱 태그들), table, ul, ol, p, form

Assistance Web Site
- http://troy.labs.daum.net/
- https://www.w3schools.com/default.asp
```

## [ 웹페이지를 디자인 할 때 ]

```
1. 모바일
2. PC + 모바일 : 반응형 웹디자인
			   PC 디자인, 모바일 디자인 : www.naver.com
			   						  m.naver.com
			   	
```

## [ JavaScript ]

```
Java : 범용언어. OOP. 썬마이크로시스템즈 -> 오라클

JavaScript : 동적인 웹페이지 제작에 사용되는 언어. OOP. 넷스케이프 -> ECMA(오픈언어)
			정적인 웨피이지를 생산하는 HTML을 보완하는 프로그래밍 언어
			라이브스크립트
			CSS와 동일하게 HTML문서 안에 작성	
			독립된 파일(xxx.js)로 만든 다음 HTML문서 안으로 import 가능
[ JavaScript 구문 정리 ]
1. 데이터 타입, 변수 생성 방법
2. 연산자
3. 제어문(for, while, do-while, if, switch, break, continue)
4. 배열
5. 함수
6. 객체생성 -(방법) 객체 리터럴
				 클래스
7. 주요 API - 내장 함수, 내장 객체, BOM, DOM

[ 자바스크립트의 데이터 타입 ]
number
boolean
string
undefined
object
function

식1 && 식2 && 식3 : 값이 참인경우
식 || 식2 || 식3 : 값이 거짓인 경우

[ 자바스크립트의 배열 ]
배열 생성 방법 :
1. 배열 리터럴 [값1, 값2, 값3 ....]
2. 표준 API(Array())로 객체를 생성하여 만드는 방법
   new Array()
   new Array(숫자)
   new Array(값1, 값2,...)
[ 특징 ]
하나의 배열에 저장되는 데이터 타입의 제한이 없다.
배열이 생성된 이후에도 배열의 크기를 변경할 수 있다.
인덱스는 0부터 시작한다.
length라는 속성을 사용하여 배열의 크기를 알 수 있다.

[ 함수 정의와 활용 ]
함수의 정의
(1) 선언적 함수 정의(명시적 함수 정의)
	function 함수명([매개변수 리스트]) {
		.
		.
		return 리턴값;
	}
	리턴값 없이 리턴했을 떄 : undefined
	함수명();
	var v = 함수명();
	함수명(아규먼트리스트);

(2)	function ([매개변수리스트]) {
	.
	.
}
   var 함수명 = function ([매개변수리스트]) {
	
  }
f1(function() { ........... } )

(3)호출시 아규먼트의 갯수가 제한없는 함수 생성
functino out() {
	arguments
}
함수가 호출되는 시점에 arguments라는 지역변수가 자동으로 초기화된다.
함수 호출시 전달되는 아규먼트들을 유사배열 객체에 담아서 arguments 변수에 할당한다.

[ 자바스크립트 객체 ]
OBP --> OOP
- 객체 생성 방법
(1) 객체 리터럴
(2) 생성자 함수(자바의 클래스와 유사)
- 객체 리터럴
{ }
{ 속성명:속성값, 속성명:속성값 ... }
		-----
		숫자, 문자열, 논리값, 배열, 함수
								-----
								메서드
- 객체의 멤버 접근 방법 : 
(1) 멤버 연산자 : ,
(2) 인덱싱 방법 : [속성명]
obj.name, obj['name']
obj.project.obj['project']

- 생성자 함수(클래스+생성자메서드)
객체를 초기화하는 역할의 함수
new 다음에 호출 -> new 와 함께 호출됨
이름을 정할때 첫 글자를 대문자로 한다.(미실시시 오류는 안나지만 구분을 위해서)
==> 새로 만들어진 멤버에 자바스크립트의 멤버를 넣는 역할 = 생성자 함수
new Student(....)  :  {  } 와 유사. 비어있는 자바스크립트 객체를 만들라는 뜻
```
