<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--QueryTestServlet 서블릿 소스를 JSP로 변환하는 실습 1 -->
<h1>JSP 실습 - 1</h1>
<hr>
<% String day = null; %>
<%
	switch(LocalDateTime.now().getDayOfWeek()) {
	case SUNDAY: day = "일"; break;	
	case MONDAY: day = "월"; break;	
	case TUESDAY: day = "화"; break;	
	case WEDNESDAY: day = "수"; break;	
	case THURSDAY: day = "목"; break;	
	case FRIDAY: day = "금"; break;	
	default : day = "토"; break;	
	}  %>
<h2><%= request.getParameter("name") %>님 반가워요.. 오늘은 <%= day %>요일입니다!!</h2>
</body>
</html>