<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
span {
	color: red;
}
</style>
</head>
<body>
<h1>요청을 처리하는 동안 오류가 발생했어요.</h1>
<h2>오류의 원인 : <span><%= request.getAttribute("msg") %></span></h2>
<h2>오류의 원인 : <span>${ requestScope.msg }</span></h2>
<a href="<%= request.getHeader("referer") %>">입력화면</a>
</body>
</html>