<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>선언문 태그</h1>
<hr>
<%! 
	int multiply(int n1, int n2) {
		return n1 * n2;
	}
%>
<%
	String p1 = request.getParameter("num1");
	String p2 = request.getParameter("num2");
	if(p1 == null || p2 == null) {
%>
	<h2>num1=xx&amp;num2=yy 형식의 쿼리를 전달하시오</h2>
<%		
	} else {
		int result = multiply(Integer.parseInt(p1), Integer.parseInt(p2));
		out.print("<h2>연산 결과 : " + result + "</h2>");
	}	
%><%--out.print는 내장객체로서 사용되었다 --%>
</body>
</html>