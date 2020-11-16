# [ TemplateEngine ]

## 소개

- 일반적인 웹 개발에 있어서의 템플릿 엔진이란, **지정된 템플릿 양식과 데이터**가 합쳐져 HTML 문서를 출력하는 소프트웨어를 의미한다.
- 스프링, 서블릿에서 사용되는 JSP, Freemaker와 최근 이슈가 되는 React, Vue 등이 이에 해당함
- 단, 차이점은 분명히 존재함
  - 서버 사이드 템플릿 엔진
    - 해당 템플릿 엔진을 이용한 JSP의 경우 화면 생성시 서버에서 Java 코드로 문자열을 만든 뒤에 이 문자열을 HTML로 변환하여 브라우저로 전달하는데, JSP 내에서 작성된 Java 코드는 HTML을 만드는 과정에서 해당 Java 코드를 실행할 뿐이며, 이 때의 자바스크립트 코드는 단순한 문자열일 뿐이다.
  - 클라이언트 사이드 템플릿 엔진
    - 자바스크립트는 브라우저 위에서 작동함. 브라우저에서 작동할 경우에는 서버 템플릿 엔진의 손을 벗어나기 때문에 제어할 수 없지만, 클라이언트 템플릿 엔진의 경우에는 제어가 가능하다.
    - Vue, React 등의 SPA(Single Page Application)가 서버에서 이미 코드가 벗어난 경우
    - 서버에서는 JSON 혹은 XML 형식의 데이터만 전달하고 클라이언트에서 조립하는 방식의 사용방법이다.

### 템플릿 엔진들의 장단점

- 장점
  - Mustache : 다른 템플릿 엔진보다 심플함. 로직 코드를 사용할 수 없어 View의 역할과 서버의 역할이 명확히 분리됨. Mustache.js와 Mustache.java 2가지 형태가 존재하여, 하나의 문법으로 클라이언트/서버 템플릿을 모두 사용 가능하다.
- 단점
  - JSP, Velocity : 스프링 부트에서는 권장하지 않는 템플릿 엔진
  - Freemaker : 템플릿 엔진으로는 너무 과하게 많은 기능을 지원함. 높은 자유도로 인해 숙련도가 낮을수록 Freemaker 안에 비즈니스 로직이 추가될 확률이 높다
  - Thymeleaf : 스프링 진영에서 적극적으로 밀고 있지만 문법이 어려운 단점. HTML 태그에 속성으로 템플릿 기능을 사용하는 방식이 기존 개발자들에게 높은 허들로 느껴지는 경우가 많음. 실제 사용해본 이들은 자바스크립트 프레임워크를 배우는 느낌이라는 후기가 많음. Vue.js를 사용해 본 경험이 있어 태그 속성 방식이 익숙한 경우에는 해당 템플릿 엔진을 사용해도 무방하다.



## Mustache

- 수많은 언어를 지원하는 가장 심플한 템플릿 엔진으로 JSP와 같이 HTML을 만들어 준다.
- 루비, 자바스크립트, 파이썬, PHP, 자바, 펄, Go, ASP 등 현존하는 대부분의 언어를 지원한다.
- 대표적인 예로 자바에서 사용될 경우에는 서버 템플릿 엔진, 자바스크립트에서 사용될 경우에는 클라이언트 템플릿 엔진으로 모두 사용될 수 있다.
  - 자바에서는 JSP, Velocity, Freemaker, Thyeleaf 등의 서버 사이드 템플릿 엔진이 존재함

#### 사용법

- 인텔리제이 커뮤니티 버전에서도 사용 가능. Handlebars/Mustache 플러그인 설치하기

- 의존성 등록

  - 해당 머스테치 스타터로 컨트롤러에서 문자열 반환시에 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨 ( *.mustache )

  ````
  compile('org.springframework.boot:spring-boot-starter-mustache')
  ````

- 템플릿 파일 기본 위치

> 머스테치 파일 경로 : src/main/resources/templates
>
> 정적 파일 경로 : src/main/resources/static

### 머스테치 레이아웃 구조

- 공통 영역을 별도의 파일로 분리하여 필요한 곳에서 가져다 쓰는 방식. 부트스트랩, 제이쿼리 등은 어디서나 필요하기 때문이다.

- 페이지 로딩속도를 높이기 위해서는 css는 header, js는 footer에 둔다. HTML은 위에서부터 코드가 실행되기 때문에 head가 실행되고서야 body가 실행되기 때문이다. 만약, head가 다 불러지지 않으면 사용자 측에서는 백지 화면만 노출되며 특히 js의 용량이 크면 클수록 body 부분의 실행이 늦어지기 때문에 화면이 다 그려진 뒤에 호출하는 것이 좋다.

  - 아래 예제에서 bootstrap.js의 경우 제이쿼리가 필수적이기 때문에 부트스트랩보다 먼저 호출되도록 코드를 작성해야함을 기억하자!

  - 공통 header

    ```html
    <!DOCTYPE HTML>
    <html>
      <head>
        <title>타이틀</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
      </head>
    <body>
    ```

  - 공통 footer

    ```html
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
    </body>
    </html>
    ```

  - 메인 페이지

    ````html
    {{>layout/header}}
    
    <h1>머스테치 레이아웃 구성</h1>
    
    {{>layout/footer}}
    ````