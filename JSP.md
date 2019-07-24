# [ JSP Programming ]

- JSP 는 수행할 때 Servlet처럼 수행된다

## < JSP 공부 순서 >

(1) JSP 태그 (2) JSP 내장 객체

### [ JSP 태그 ]

1. 스크립트 태그 : 필요한 자바 코드를 정의하는 용도의 태그들

   ```
   <%=	%> : 표현식 태그(출력을 나타낼때)
   <%	%> : 수행문 태그(출력 나타내지않고 수행만 하는 태그)
   <%!	%> : 선언문 태그(용도 명확 : 멤버변수 선언, 메소드 정의)
   <%@	%> : 지시자 태그(말 그대로의 태그문)
   <%-- --%> : 주석(HTML 주석:<!-- -->, 자바주석://, /*...*/)
   ```

2. 액션 태그

   ```
   <jsp:useBean .../>
   <jsp:forward .../>
   <jsp:include .../>
   <jsp:setProperty .../>
   <jsp:getProperty .../>
   ```

3. 커스텀 태그
   1. 필요에 의해 개발자가 직접 태그를 만들어서 사용하는 태그
   2. JSTL

- 표현식 태그에서 out.print();안에 아규먼트만 오고 추가적인 연산기호 등이나 세미콜론으 기호를 사용할 수 없다
- JSP파일을 Servlet로 변환한 폴더 위치 : eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\sedu\org\apache\jsp\jspexam

### [ 서블릿에서 JSP로 객체 전달 방법(= forward관계에서 값 전달) ]

1. **HttpServletRequest 객체에 저장하여 전달하는 방법 - request scope(가장 많이 사용)**
2. HttpSession 객체에 저장하여 전달하는 방법 - session scope
3. ServletContext 객체에 저장하여 전달하는 방법 - applicaion scope

- 객체 모두 가지고 있는 메소드

  1. setAttribute(이름, 객체)
  2. getAttribute(이름)
  3. removeAttribute(이름)

- 배열, 문자열( 보내야할 데이터가 여러개일 경우 )

  - 이름, 번호, 나이, 주소 : VO(Value Object), DTO클래스

  ```servlet
  class {
  
  }
  ```

- VO 클래스 (  )

```
1. java src에 vo 패키지 생성후 클래스 생성
2. 클래스 안에 private 멤버변수 선언 후 getter, setter 생성
```



- EL(Expression Language) 변수 : 주어진 변수명으로 보관되어 있는 객체
  
  - el의 param 내장객체 사용시 자바가 식별불가능한 변수명 사용시 대괄호([ " " ])를 사용한다->param["0"]
  
- JUnit - 단위 테스트 : 전체 기능에서 각 기능이 문제없이 수행하는지 확인하는 단위

  - 자바-Junit Test Case-New Junit 4 test 생성
  - JDBC Test시 ojdbc6.jar 확장자 파일이 WEB-INF폴더-lib에 존재해야함

- DAO : 테스트 전용 클래스를 통해 각각의 기능의 수행동작 확인

  

- 방명록 기능의 웹 프로그래밍 실습

  - oracle의 visitor 테이블 필요(방문자 정보)

  1. VisitorVO.java 생성 (항상 사용되는 것을 먼저 구현)
  2. VisitorDAO.java 생성

  ---

  ( 수평선까지 JUnit 테스트 )

  3. HTML은 이전 실습에서 만든 것 복사
  4. VisitorServlet.java 복사 수정

---

- request.getHeader("referer")  = 이번 요청을 보내온 클라이언트 웹 페이지의 URL을 추출해 준다.

  ---

## < EL(Expression Language) >

- 정의
  - 해석 그대로 표현 언어를 이해하고 속성 값들을 편리하게 출력하기 위해 제공된 언어
  - <%= %>, out.println() 등의 자바코드를 사용하지 않고 좀더 간편한 출력을 지원하는 도구
  - 배열이나 컬렉션에서도 사용되며, JavaBean 프로퍼티에서도 사용됨
- 문법
  - Attribute 형식 : ${ cnt + 1 }
    - cnt는 자바에서는 변수이름, EL식에서는 Attribute이름으로 해석.
    - 작은 Scope에서 큰 Scope로 값을 찾는다( page -> request -> session -> application )
    - attribute란 : 메소드를 통해 저장되고 관리되는 데이터를 말한다
      - PageContext / Request 에서 사용시
        - setAttribute("key", value) = 값을 넣는다
        - getAttribute("key") = 값을 가져온다
        - removeAttribute("key") = 값을 지운다
      - Session 에서 사용시
        - set / get / remove 기능은 동일하고 추가로 ++ 이 있음
        - invalidate() = 값을 전부 지운다( = 세션을 지운다)
  - Parameter 형식 : ${ param.abc }
    - 내장 객체의 종류
      - pageScope : 페이지 Scope에 접근
      - requestScope : 리퀘스트 Scope에 접근
      - sessionScope : 세션 Scope에 접근
      - applicationScope : 어플리케이션Scope에 접근
      - param : 파라미터값 얻어올때(1개의 key에 1개의 value)
      - paramValues : 파라미터값 배열로 얻어올때(1개의 key에 여러개의 value)
      - header : 헤더값 얻어올때(1개의 key에 1개의 value)
      - headerValues : 헤더값 배열로 얻을시(1개의 key에 여러개 value)
      - cookie: ${cookie. key값. value값}으로 쿠키값 조회
      - initParam : 초기 파라미터 조회
      - pageContext : 페이지컨텍스트 객체를 참조할때
    - 값을 배열로 얻을시 사용법(paramValues, headerValues)
      - ${ paramValues.boadDto[0] } : 인덱스가  0부터 시작
      - ${ headerValues`["bardDto"]`[1] } : 인덱스 1부터 시작
- 사용법
  - JSP 시작 선언문 태그의 페이지 인코딩 부문 마지막에 추가
    - isELIgnored="false"

---

## < JSTL(JSP Standard Tag Library) >

- 정의

  - 표준 액션태그로 처리하기 힘든 부분을 담당한다
  - 아파치오픈그룹이 만든 JSP의 커스텀태그 모음
  - 자신만의 태그를 추가할 수 있는 기능을 제공하며 if문, for문, DB를 편하게 처리할 수 있는 것(두 번째와 같은 말)

- 종류

  - Core 라이브러리 ( prefix:c )
    - 일반 프로그래밍과 유사한 변수선언
    - 실행 흐름의 제어기능을 제공
    - 페이지 이동 기술 제공
    - 참고 URI -> http://java.sun.com/jsp/jstl/core
  - Formatting(i18n) 라이브러리 (prefix:fmt )
    - 숫자, 날짜, 시간을 포매팅하는 기능 제공
    - 국제화, 다국어 지원 기능 제공
    - URI → http://java.sun.com/jsp/jstl/fmt
  - Database 라이브러리 ( prefix:sql )
    - DB의 데이터를 입력/수정/삭제/조회하는 기능 제공
    - URI → http://java.sun.com/jsp/jstl/sql
  - XML 라이브러리 ( prefix:x )
    - XML문서를 처리할 때 필요한 기능 제공
    - URI → http://java.sun.com/jsp/jstl/xml
  - Function 라이브러리 (prefix:fn )
    - 문자열을 제공하는 함수 제공
    - URI → http://java.sun.com/jsp/jstl/functions

- 특징

  - 초기에는 성능저하로 사용빈도가 작았음
  - 현재에 이르러는 단점을 개선하여 활용을 하고있음

- 사용법

  ```
  [ 시작에 선언문 필수 ] 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  필요한 JSTL태그가 있다면 prefix와 uri만 변경
  <c:xxx >
  
  ( 차이 비교 )
  JSP : <% %>
  JSP표준태그 : <jsp:xxx >
  JSP커스텀태그 : taglib 지시자 태그에 prefix를 설정함
  	- 사용형식 : <prefix설정:xxxx >
  	- <c:xxx > or <core:xxxx >
  	- <sql:xxx >
  	- <fmt:xxx >
	- <x:xxx >형식
  	- 지시자 태그의 형식은 자유롭지만 관례적인 형식을 주로 쓴다
  ```
```
  
  ## < Core 태그 >
  
  - **<c:set >**
    - var 속성 : 값을 저장할 EL 변수의 이름( EL : ${ a } )
    - value 속성 대신 content 속성으로 할 수 있다. 단, content 사용시 닫는 태그는 필수적이다.
  - 어떠한 대상의 값을 설정할 시 set 태그로 처리 가능
    - 어떠한 getter의 기능으로서 action태그와 유사하게 사용 가능
    - scope 속성 생략시 모든 범위가 설정됨. scope는 변수를 저장할 영역 설정
  - `<c:out>`
    - 자바의 System.out.println(""); 을 간단히 사용할수 있게 변경
    - <c:out value="출력문장">
  - <c:remove >태그
    - 한 영역의 변수명을 지우는 코드
    - 영역을 생략할 시 모든 영역의 변수가 삭제됨
  - 영역의 순서는 attribute 영역 순서와 동일
  - `<c:if>`
    - 자바의 if-else 문과 동일하지만 else문이 없다
    - scope값을 생략시 기본으로 page영역이 지정됨
  - `<c:choose>` / `<c:when>` / `<c:otherwise>`
    - 자바의 switch 구문과 if-else 구문을 혼합한 형태
    - 다수의 조건문을 걸고 싶을때 사용
- `<c:forEach>`
    - 자바의 for문이 JSTL에서 변경된 방식
  - 배열이나 Map, Collection에 저장된 값들을 순서대로 처리할시 사용
    - 사용법
    - <c:forEach var="i" begin="1" end="10" step="1"> ${i} </c:forEach>
  - <c:forTokens >
    - java.util.StringTokenizer 클래스와 동일한 기능을 제공하는 태그
    - var라는 변수에 items라는 속성으로 전달받은 문자열을 구분하여 저장한다.
    - delims=" " 속성의 값으로 구분할 문자를 준다.
    - **핵심적으로는 반복문의 기능을 가지고있다고 생각하면 된다**
    - 사용법
      - <c:forTokens var="abc" items="안녕/하세요/누구/입니다" delims="/">
  - `<c:catch>`
    - 자바의 try-catch 구문과 같음
    - 단, 에러의 내용을 ${abc} 로 빼내서 처리해야한다
  - `<c:redirect>`
    - 파라티머 값을 지정된 url로 보낸다
    - 사용법
      - <c:redirect url="abc.jsp">
      - <c:param name="abc" value="Hi" /> 
      - `</c:redirect>`
  - `<c:url>`
    - `<c:set>`과 비슷하며 GET방식으로 파라미터를 전달
  - **<c:import >**
    - 다른 URI를 사용할 때 필수적
    - `<jsp:include>`와 비슷
  
```
  <c:import var="xmldata"
  url="url주소" charEncoding="UTF-8">
  	<c:param name="address" value="${param.var변수명}"/>
  </c:import>

  ```
  ## < XML 태그 >
  - xPath 에서의 // 의미는 자손 태그 안에서 찾으라는 뜻(자식부터 모든 것을 찾아라), / 는 자식태그 안에서 찾아라
  - //*[@id="예"]
  - #mv-content-text > div > h2:nth-child(12) > span.mw-editsection > a
  - //*[@id="mw-content-text"]/div/h2[2]/span[3]a
  - Goolge API 등으로 받는 날씨나 위도, 경도 등의 xml 파일을 받는 횟수가 지정되어있기 때문에 연습을 위해서 여러번의 반복을 하지 않는 것이 나중에 개발자로 등록하여 사용하는데 이상이 없다
  ```