```
html5시작시 선언하는 문장
html5 각 태그(nav, head 등)
링크 만들때 사용되는 태그 : a태그
주석태그 사용법 : <!-- -->
블럭스타일, 인라인스타일 태그 종류
선택자 문제 4문제: id선택자, class선택자, 자식선택자, 자손선택자
:hover기능 (css기능으로 마우스 올라갈때 흐리게)
인라인, 전역, 에서 우선순위 : 가까운 순으로
특별한 연산자 '''
객체 만들때는 중괄호 사용
자바스크립트 함수는 생성하는 아규먼트와 호출하는 아규먼트 개수가 맞지 않아도 에러가 나지 않음
가변개수 함수(개수제한 없는 아규먼트) (...) arguments
자바스크립트 삭제할때 delete연산자
페이지 이동 자바스크립트로 하고자 할때, 내장객체와 속성
브라우저 클라이언트 정보 추출할때 사용되는 내장객체
ajax 통신의 특징
xmlHttpRequest의 주요 속성,특징
readystatus값 
readystate, status 종류 특징
```



html5시작시 선언하는 문장

`<!DOCTYPE html>`

HTML5 레이아웃 나누는 태그
h,br,hr,pre
문자 : b,del,em,i,ins,mark,small,strong,sub,sup
분할 : p,div,span
이미지 : figure,figcaption
목록 : ul , ol , dl

링크 만들때 사용하는 태그
`<a href=" " target=" "></a>`

주석 태그
`<!-- 설명할 내용 -->`

블럭스타일 / 인라인스타일
블럭 : 화면 전체를 사용하는 태그(h,p,div,...)
인라인 : 화면의 일부를 차지하는 태그(a,img,strong,span,...)

id,class,자식,자손 선택자 4문제
*{} -> 전체선택자
#id명{속성 : 값;}
.class{속성 : 값;}
tag1 tag2{속성 : 값;} -> 후손선택자 (아래의 모든 항목 선택)
tag1 > tag2{속성 : 값;} -> 자식선택자 (아래의 한 줄만 선택)

가상 클래스 선택자
link(방문x링크),visited(방문o링크),active(마우스 클릭),hover(마우스 올림)
,focus(포커스를 가질 때),nth-child(첫번째/마지막/n번째/끝에서 n번째 태그 요소 선택)
,before(선택 태그 앞에 지정 콘텐츠 삽입)
,after(선택 태그 뒤에 지정 콘텐츠 삽입)

인라인 , 내부 , 외부
인라인 : 태그에 직접 css 코드 기술
내부 : head 태그에 style 태그를 추가해 css코드 기술
외부 : css 코드를 쓴 것을 href 로 읽어옴

=== 가 뭔가?
값 과 타입 이 모두 같은지에 대한 관계연산자

중괄호 대괄호

스크립트 함수 문제
function name(arg1,arg2,...){}; -> 함수 선언 전,후 모두 호출 가능
var name = function(arg1,arg2,...){}; -> 함수 선언 후 만 호출 가능
호출 : name(val1,val2,...);

가변개수 함수?
arguments 쓰는건가..

삭제 : delete 연산자

페이지 이동 javascript로 할때 객체,속성

 href 는 location 객체에 속해있는 프로퍼티로 현재 접속중인 페이지 정보를 갖고 있습니다.

   또한 값을 변경할 수 있는 프로퍼티이기 때문에 다른 페이지로 이동하는데도 사용되고 있습니다.

`<script type="text/javascript">
 location.href="notice/List.jsp";
</script><br />`

Ajax 통신 특징
장점 :  페이지 이동 없이 고속으로 화면 전환 가능
   서버처리 기다리지 않고 비동기 요청이 가능
   수신 데이터 양을 줄일수 있고,클라이언트에게 처리를 위임할 수 있음
단점 :  Ajax 쓸 수 없는 브라우저의 문제
   Http 클라이언트 기능 한정
   보안상의 문제
   지원하는 Charset 한정
   디버깅이 용이하지 않음
   요청 남발시 서버 부하가 늘어남
   동일 출처 정책으로 다른 도메인과 통신 불가능(Cross-Domain 문제) -> 하나의 서버의 도메인에서만 콘텐츠를 이용가능

// non-blocking-IO : 읽을시 비동기IO로 시행후 다른 일을 수행 가능하게 하는 처리방법