# [ JSP Programming ]

- 정의
  - **HTML 또는 XML 기반의 동적인 웹 콘텐츠를 개발하는 기술**이다. Servlet과 JSP 모두 웹서버단에서 수행되는 기술이라는 것은 동일하지만 구현방식이 다르다. Sevlet은 상속구문, 메서드 오버라이딩 구문 등을 적용한 완전한 Java 프로그래밍이고 JSP는 정적인 내용은 HTML 또는 XML 기술로 작성하고, **동적인 내용은 JSP 태그와 스크립트 코드(Java 언어)로 작성**하는 기술이다.

-  JSP 공부 순서

  (1) JSP 태그

  (2) JSP 내장객체

- 시간출력

  - javascript: 클라이언트 시간
  - jsp&java : 서버 시간

### [ JSP 태그 ]

1. 스크립트 태그 : 필요한 자바 코드를 정의하는 용도의 태그.  Servlet으로 변환될 때 try-catch문으로 표현된다.

   - C:\yschoi\eclipse\workspace.metadata.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\sedu\org\apache\jsp (Servlet으로 변환된 코드를 확인할 수 있다.)

   ```
   <%=	%> : 표현식 태그(출력을 나타낼때)
   1. 식만 올 수 있다
   2. if문은 안된다!!
   3. 표현식 태그에는 식만 올 수 있으므로 ;는 넣을 수 없다.
   ex) <%= num %> 가 servlet으로 바뀔 때 out.print(num);로 바뀌어 표현식 태그 안의 값이 out.print의 아규먼트가 된다. Servlet으로 변환될 때 표현식 태그는 out.print로 표현되고 나머지는 out.write로 표현된다.
   
   <%	%> : 수행문 태그
   1. 수행만 하고 결과는 출력하지 않는다. 
   2. Servlet으로 변환될 때 수행문 코드는 그대로 들어간다.
   
   <%!	%> : 선언문 태그(용도 명확 : 멤버변수 선언, 메소드 정의)
   
   <%@	%> : 지시자 태그
   1. jsp는 최초 요청시 servlet으로 바뀌는데 톰캣 안에 있는 자스퍼 엔진이 바꿔준다.
   2. <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   3. <%@ page [ language="java" : 사용할 언어 [ extends="package.class" ] : 상속하는 부모 [ import="{package.class | package.*}, ..." ] : 여러번 반복해도 상관없다.
   ex) 
   import = "java.util.*, java.io.File" [ session="true|false" ] : 디폴트는 true이다. 따라서 session객체가 자동으로 준비된다. 
   [ buffer="none|8kb|sizekb" ] : 출력버퍼의 사이즈를 조절한다. 디폴트는 8kb이다. 버퍼가 꽉차면 자동으로 flush가 일어난다.
   [autoFlush="true|false" ] : 버퍼가 꽉차면 자동으로 flush가 일어나는 기능이다.
   [ errorPage="relativeURL" ] : relativeURL은 동일한 웹 어플리케이션에 있는 페이지만 사용가능하다.
   [ contentType="mimeType [ ; charset=characterSet ]" |"text/html ; charset=ISO 8859 1" ] : 디폴트는 charset=ISO 8859 1이다. 따라서 UTF-8로 인코딩해주어야한다.
   
   [ isErrorPage="true|false" ] : exception 내장객체를 통해 오류를 출력할 수 있다. [ pageEncoding="characterSet | ISO8859 1" ] : 디폴트는 charset=ISO 8859 1이다. 따라서 UTF-8로 인코딩해주어야한다. [ isELIgnored="true|false"] %>
   
   4. <%@ include file="part1.jspf" %>
   - 반복되는 부분을 .jspf(JSP Fragment)로 저장하여 JSP 페이지에 불러 사용한다.
   - 다른 jsp결과를 포함해서 결과를 출력할 때 사용한다.
   
   
   <%-- --%> : 주석(HTML 주석:<!-- -->, 자바주석://, /*...*/)
   ```

2. 액션 태그

   ```
   <jsp:useBean ..../>
   <jsp:forward page=""/> : 다른 jsp page로 이동한다.
   <jsp:include ...../> : 수행자체는 별개로 이루어지고 출력버퍼는 공유한다. JSP 페이지의 수행 결과 내에 다른 자원의 내용 또는 수행결과를 포함시킨다.
   <jsp:param name="" value=""/> : 전달할 데이터를 id name값을 가지고 value값을 전달한다.
   <jsp:setProperty ..../>
   <jsp:getProperty ..../>
   
   속성값에는 " "를 주고 empty tag 즉 종료태그가 없을 때는 '/'로 닫아주어야한다.
   ```

3. 커스텀 태그
   1. 필요에 의해 개발자가 직접 태그를 만들어서 사용하는 태그
   2. JSTL

4. include 지시자와 include 액션태그의 차이점

   1. exam9.jsp --- part1.jspf, part2.jspf : **include 지시자** ---> 서블릿 소스의 개수? **1개** (소스를 포함해서 수행되므로)
   2. exam11.jsp --- greeting.jsp 3번 : **include 액션태그** ---> 서블릿 소스의 개수? **2개** (exam11과 greeting은 각각 수행되므로)

- 표현식 태그에서 out.print();안에 아규먼트만 오고 추가적인 연산기호 등이나 세미콜론으 기호를 사용할 수 없다
- JSP파일을 Servlet로 변환한 폴더 위치 : eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\sedu\org\apache\jsp\jspexam

### < JSP 내장객체 >

- <%= request.getParameter("stname") %> : request는 내장객체로 선언하지 않아도 사용할 수 있다.
- <% out.print(); %>
- <%= session.isNew() %>
- <%= application.getServerInfo() %>
- <% String msg = "오류 원인 : " + exception; %> : <%@ page isErrorPage="true" %>인 jsp 페이지에서만 사용가능하다.

요약 정리

서버가 클라이언트를 찾아오는 일은 절대 없다!! HTTP 프로토콜은 **Connection Oriented**(접속이 먼저 이루어져야 통신한다.) 와 **Stateless 방식**으로 동작한다. 신뢰성있는 통신을 하면서도 처리 효율이 좋다. 클라이언트와 서버는 계속 연결되어있는 것이 아니고 클라이언트가 계속 새로운 요청을 하는 것이다. Cache 기술을 써서 이전에 방문했던 주소를 기억한다.

HTTP에는 다양한 요청 방식(GET,HEAD,POST,OPTIONS,DELETE,PUT)이 있다. GET방식은 요청헤더와 요청바디로 구성된다. POST방식은 쿼리문자열을 요청바디에 넣어 전송한다. 쿼리문자열에 타입을 원하는대로 부여할 수 있어 파일을 요청하고자 하는 경우에 사용한다.

JSP 파일은 WAS에 의해 Servlet파일로 변경된다. 컨테이너에 의해 관리되는 프로그램을 **웹 컴포넌트**라고 한다.

Assembly Root는 WebContent이다. WEB-INF는 클라이언트가 직접적으로 접근할 수 없는 폴더이다. 나중에 JDBC라이브러리를 넣을 것이다. 웹 어플리케이션의 디렉토리 구조는 다른 서버를 사용해도 같다.

MVC패턴은 요청받는 부분(servlet)(Controller)과 응답하는 부분(jsp)(View)으로 나눈다.

**Servlet은 하나의 Servlet 객체를 공유해서 수행한다!!!**

같은 서버에 같은 프로그램이면 **Forward**를 사용한다. jsp는 get과 post를 구분하지 않고 브라우저가 끝날 때까지 유지된다.

### < 요청 동안의 객체공유방법 > 

(1) **HttpServletRequest 객체**에 저장하여 전달하는 방법 : **request scope**를 사용한다. 요청이 끝날 떄 까지 사용, **가장 많이 사용한다.** 요청이 끝나면 사라진다.

(2) **HttpServletSession 객체**에 저장하여 전달하는 방법 : **session scope**를 사용한다. session 객체가 유지되는 동안 ex) 쇼핑카트에 물품보관

(3) **ServletContext 객체**에 저장하여 전달하는 방법 : **application scope**를 사용한다. 서버가 죽을 때 까지 ex) **모든 클라이언트에 의해 공유**되는 데이터를 저장할 때 사용한다.

cf) **page scope는 공유가 불가**하다.

위의3 방법은 아래 3가지 메서드를 갖고 있다.

setAttribute(이름,객체)

getAttribute(이름)

removeAttribute(이름)

배열, 문자열

이름, 번호, 나이, 주소 ---> 여러개의 객체를 보낼 때는 **VO(Value Object), DTO(Data Transfer Object) 클래스**를 생성하여 전달한다.

```
class MyDataVO{
    String name;
    int number;
    int age;
    String address;
}
```

## [ MVC(Model-View-Controller) ]

모델-뷰-컨트롤러(Model–View–Controller, MVC)는 소프트웨어 공학에서 사용되는 아키텍처 패턴이다.

- Model : vo,dto

  어플리케이션의 정보를 담당한다.

  - 도메인 모델 ex) VO
  - 서비스 모델 ex)...SERVICE,...BIZ

- view : jsp

  사용자 인터페이스 요소를 담당한다.

- controller : servlet

  어플리케이션 기능을 담당한다.

## [ EL(Expression Language) ]

**주어진 변수명으로 보관되어 있는 객체를 뜻한다**. 표현식 태그를 대신할 수 있는 기술이다.특정 스코프 영역에 보관되어 있는 객체를 추출하여 이 객체의 값 또는 속성 값을 추출하여 표현하는 경우 사용한다. ${ ... }으로 사용한다.

- <% out.println(request.getParameter(“q”)); %> : 스크립트 태그

- <%= request.getParameter(“q”) %> : 액션 태그

- **${param.q}** 또는 **${param[“q”]}** : param은 EL의 내장객체이다. .연산자 뿐만 아니라 대괄호도 사용가능하다.

  - ${} : $앞에 \ 를 붙이면 일반 문자열이 된다.
  - param. 쿼리 문자열 name
  - ${ header.user-agent} : 이렇게 사용할 수 없다.
  - **${ header["user-agent"] }** : user-agent라는 문자열로 인식한다.

- pageContext를 제외한 나머지 EL 내장 객체가 참조하는 객체는 **HashMap 객체**이다.

  - 변수명.xxx

    (1) 변수명이 참조하는 객체가 **Map 객체이면 get(“xxx”)**를 호출한 결과와 같다.

    (2) 변수명이 참조하는 객체가 **일반 Java 객체이면 getXxx()**를 호출한 결과와 같다.

## [ JUNIT ]

단위 테스트 기술이다. 메인 클래스가 없어도 테스트하고 싶은 클래스를 제대로 동작하는지 확인 해볼 수 있는 기술이다.

서블릿, JSP, Service, DAO 등등

- ojdbc6.jar 경로 : C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib

- 방명록 기능의 웹 프로그램

  (1) VisitorVO.java 생성

  (2) VisitorDAO.java 생성

  -------------------------------------- JUnit 테스트

  (3) HTML은 이전 실습에서 만든 거 복사, 수정

  (4) VisitorServlet.java 복사, 수정

  (5) visitorView.jsp 생성

### < sequence >

sequence는 유니크한 값을 뽑아낼 뿐 순차적일 필요가없다. sequence값은 오류가 발생해도 insert문을 사용하면 값이 증가한다.

### < 수정 기능 >

(1) 미팅 정보 수정 이미지가 클릭되었을 때 - **GET 방식**

​	정보를 수정하기 위한 입력 폼화면 출력

(2) 미팅 정보 수정 폼에서 '수정하기' 버튼이 클릭되었을 떄 - **POST(hidden 타입이 필수!)**

​	새로 입력된 내용을 서버에 전송하여 실제 DB수정이 이루어져야 한다.

## [ JSTL (JSP Standard Tag Library ) ]

아파치오픈그룹이 만든 JSP의 커스텀태그 모음이다.

종류

- **core Library**

  - 변수 선언, 반복문 등 간단한 프로그램 로직 구현을 대신하는 커스텀태그를 지원하는 라이브러리이다.

  - <%@ taglib **prefix="c"** uri="<http://java.sun.com/jsp/jstl/core>" %> -> <c:xxxx>

    <prefix:xxx> : JSP 커스텀 태그이다. taglib 지시자 태그에 prefix를 설정한다.

  - 태그 종류

    (1) <c:set> : 특정 scope에 데이터를 저장한다. setAttribute와 비슷하다.

    (2) <c:remove> : removeAttribute와 비슷하다.

    (3) <c:out> : EL과 비슷한데 default값을 설정할 수 있다.

    (4) <c:if> : else절은 지원하지 않는다.

    (5) <c:choose>,<c:when>,<c:otherwise> : 다중 if문 처리할 수 있다. when태그는 원하는 만큼 줄 수 있다.

    (6) <c:forEach> : traditional for와 enhanced for(varStatus속성 지원)문을 모두 지원한다.

    (7) <c:forTokens> : items에 지정한 문자열을 delims에 저장된 구분자 단위로 나눈다.

    (8) **<c:import>** : 외부의 다른 자원을 읽어와 포함시킬 수 있다. 가져온 자원을 scope 영역에 저장해준다.

    (9) **<c:param>** : URL문자열에 쿼리 문자열을 준다.

    (10) <c:url> :URL을 생성 해주는 기능을 제공한다.

    (11) <c:redirect> :지정한 페이지로 리다이렉트 시킨다.

    (12) <c:catch> :예외가 발생할 수 있는 코드를 작성하여 var이름에 저장한다.

- format(i18n) Library : 각 나라를 위한 라이브러리이다.

  - <%@ taglib **prefix="fmt"** uri="<http://java.sun.com/jsp/jstl/fmt>" %> -> <fmt:xxxx>

- sql Library

  - <%@ taglib **prefix="sql"** uri="<http://java.sun.com/jsp/jstl/sql>" %> -> <sql:xxxx>

- **xml Library**

  - <%@ taglib **prefix="x"** uri="<http://java.sun.com/jsp/jstl/xml>" %> -> <x:xxxx>

  - 태그 종류

    (1) <x:parse> : xml 문서를 읽어서 dom객체를 생성한다.

- function Library

css selector : html

Xpath(XML Path Language) :xml - 문서의 구조를 통해 경로 위에 지정한 구문을 사용하여 항목을 배치하고 처리하는 방법을 기술하는 언어이다.

```
<?xml version="1.0" encoding="utf-8"?>
<wikimedia> //루트 엘리먼트이다.
  <projects> //자식 엘리먼트는 3개(빈칸,projects,빈칸)이다. 빈칸도 포함한다.
    <project name="Wikipedia" launch="2001-01-05">
      <editions>
        <edition language="English">en.wikipedia.org</edition>
        <edition language="German">de.wikipedia.org</edition>
        <edition language="French">fr.wikipedia.org</edition>
        <edition language="Polish">pl.wikipedia.org</edition>
      </editions>
    </project>
    <project name="Wiktionary" launch="2002-12-12">
      <editions>
        <edition language="English">en.wiktionary.org</edition>
        <edition language="French">fr.wiktionary.org</edition>
        <edition language="Vietnamese">vi.wiktionary.org</edition>
        <edition language="Turkish">tr.wiktionary.org</edition>
      </editions>
    </project>
  </projects>
</wikimedia>

Xpath
= : equals -등가연산자는 '='로 준다.
/wikimedia/projects/project/@name 
: @를 붙이면 속성명으로 인식한다. 모든 project 요소의 name 속성을 선택
/wikimedia/projects/project/editions/edition[@language="English"]/text()
: 모든 영문 Wikimedia 프로젝트의 주소(language 속성이 English인 모든 edition 요소의 문자열)를 선택

ex) 개발자 도구에서 
Copy Selector : #예
Copy Xpath : //*[@id="예"] (//는 조상이 누가있든 이라는 의미다.)

section/article/h1/div/span/a
section//a : section 밑에 자손 a를 찾으라는 말이다.
section/a : section 밑에 자식 a를 찾으라는 말이다.
```