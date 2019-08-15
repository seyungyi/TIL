<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL 변수</h2>
<hr>
name 변수의 값 : ${name}<br>
<% String name="듀크"; %>
name 변수의 값(표현식 태그) : <%= name %><br>
name 변수의 값(EL) : ${name}<br>
<% pageContext.setAttribute("name", "자바");  %><%--pageContext는 el의 내장객체이면서
자바의 ....... 이다 --%>
name 변수의 값 : ${name}<br>
pageScope.name 변수의 값 : ${pageScope.name}<br>
<hr>
<% pageContext.setAttribute("number", 100); %>
number 변수의 값 : ${number}<br>
pageScope.number 변수의 값 : ${pageScope.number}<br>
number 변수의 값에 23을 더한 값 : ${ number + 23 }
</body>
</html>