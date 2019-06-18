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