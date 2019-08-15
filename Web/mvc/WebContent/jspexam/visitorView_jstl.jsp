<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.VisitorVO, java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ !empty list }">
<%-- <c:if test="${ !empty request.scope.list }"> 리스트라는
		값이 있다면 수행하라는 문장 --%>
	<h2>방명록 글 리스트 - JSTL</h2>
	<table border="1">
	<c:forEach var="vo" items="${ list }">
		<tr>
		<td>${ vo.name }</td>
		<td>${ vo.writeDate }</td>
		<td>${ vo.momo }</td>
		<td><a href='/mvc/visitor?id=${ vo.id }'>
			<img src="/mvc/images/delete.png" width="30"></a>
		</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${ !empty msg }">
	<h2>${msg}</h2>
</c:if>
<hr>
<a href='<%= request.getHeader("referer") %>'>방명록 홈 화면으로 가기</a>
</body>
</html>