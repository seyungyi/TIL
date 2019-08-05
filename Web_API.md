# [ WebProgramming API ]

## 	< BOM (Browser Object Model) >

- 정의

  - 웹 브라우저와 관련된 모든 객체들의 집합을 말한다.
- 브라우저가 제공하는 자바스크립트 API
  
- 미리 객체를 생성해서 제공 (브라우저가 기동될 떄 생성해서 제공)

  - window, location, document, history, screen(화면 사이즈, 해상도를 담고 있는 객체), navigator(브라우저에 대한 정보, 플랫폼에 대한 정보를 담고 있는 객체 / 위도, 경도)

  - window 객체(전역 객체)

    - id = setInterval(func, 밀리초시간) : 주기적으로 함수를 수행시킨다.

      clearInterval(id) : setInterval로 설정시킨 시간을 초기화시키는 것(=해제)

    - id = setTimeout(func, 밀리초시간) : 어떤 시간이 지났을 때 어떤 함수를 1번만 수행시킨다. 주기적인 것은 없다.

      clearTimeout(id)

    - alert(), confirm(), prompt(), open() :  서브창 띄우는 명령

  - location

    - href : 현재 보고있는 페이지의 url 정보를 가지고 있다.
    - reload() : 현재 페이지를 자동으로 새로고침한다. (href와 reload는 기억하기!)

  - history

    - go(n) : 현재 페이지를 기준으로 전이면

  - screen

    - width
    - height

  - navigator 객체

    웹 브라우저에 대한 정보를 제공하는 객체

    - **user-agent**
    - getLocation() : 위도, 경도 알아내는 메소드

## < DOM(Document Object Model) >

- HTML 파서들은 파싱한 HTML 문서의 각각의 태그들, 태그의 속성들, 태그의 텍스트 형식의 컨텐트들을 자바스크립트 객체로 생성한다. (이유 : 자바스크립트에서 HTML태그에 접근가능하도록 지원하기 위해서)

- HTML태그를 document 객체의 자손 객체로 등록한다.

```
(ex) document.body
< 자주 사용하는 객체 요소를 추출하는 메소드 선택자 2가지 >
( 직접 접근 방법 )
document.getElementById("id속성값")  //태그에 정의된 id속성, Dom객체 1개 리턴
document.getElementsClassName("class속성값") //태그에 정의된 class속성, 배열객체리턴
document.getElementsTagName("태그명")
document.getQuerySelector("CSS선택자") //다양하게 태그를 찾을 수 있다.
document.getQuerySelectorAll("CSS선택자")

( 노드 워킹 접근 방법 )
document.getElementById("id속성값").innerHTML : 요소 내용을 HTML로 설정하거나 반환
동일.innerText : 요소 내용을 Text로 설정하거나 반환
동일.nodeValue
동일.getAttribute('속성명')

window 이벤트핸들러 함수안에 write가 사용된다면 기존 렌더링된 자료들을 다 삭제하고 새로운 것만 남긴다. 그렇기에 alert사용을 권장한다.
```

이벤트핸들러 : 이벤트가 발생됬을때 발생하는 함수

window : 페이지 로딩이 끝났을때 발생됨

## < 이벤트 핸들러 구현 >

- 이벤트 : 웹 페이지상에서 발생되는 일
  1. 브라우저에서 자동으로 발생(load)
  2. 사용자의 액션에 의해서 발생(click, mouseover, mouseenter, mouseout, keyin, keypress,keyout, scroll, change, submit, reset....)

- 타겟 : 이벤트 발생된 대상 객체

- 이벤트 핸들러(리스너) : 이벤트가 발생했을 때 수행되는 코드를 담고 있는 함수

- 이벤트 모델 : 특정한 타겟에서 정해진 이벤트가 발생했을 때 핸들러 수행되도록 구현하는 방법

  1. 인라인 이벤트 모델(지역)

     `-` 태그의 속성으로 등록

     ` - ` onXXX = "코드작성"

     ` - ` onclick(onClick, onCLICK) = "수행문장1:수행문장2:수행문장3"

  2. 고전 이벤트 모델(전역)

     ` - ` DOM 객체를 찾는다

     `-` DOM객체.onXXX = 함수;

  3. 표준 이벤트 모델(전역)

     `-` DOM 객체를 찾는다

     `-` DOM객체.addEventListener("xxx", 함수);

     `-` DOM객체.removeEventListener("xxx", 함수);

