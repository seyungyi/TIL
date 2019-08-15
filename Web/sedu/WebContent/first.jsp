<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>맛보기 JSP</h1>
<hr>
<h2>당신의 이름은 <%= request.getParameter("guest") %> 입니다.</h2>
</body>
</html>