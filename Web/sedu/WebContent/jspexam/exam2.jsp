<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP의 멤버변수와 지역변수</h1>
<hr>
<%! int member_v = 0; %> <%-- 멤버변수 --%>
<% int local_v = 0; %> <%--지역변수 --%>
<h3>member_v : <%= ++member_v %></h3>
<h3>local_v : <%= ++local_v %></h3>
</body>
</html>