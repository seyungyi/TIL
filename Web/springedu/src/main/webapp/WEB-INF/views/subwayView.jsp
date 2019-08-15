<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	text-align: center;
	border: 1px solid black;
	border-collapse: collapse;
}
th, td {
	padding: 10px;
	border: 1px solid black;
}
</style>
</head>
<body>
    <h2> 지하철 정보 </h2>
    <hr>
    <c:choose>
	<c:when test="${ list != null }">  
		<table>
			<tr>
				<th>Line</th>
				<th>Time</th>
				<th>Ride</th>
				<th>Takeoff</th>
			</tr>		
			<c:forEach var="data"  items="${list}">
			<tr>
				<td>${ data.line }</td>
				<td>${ data.time }</td>
				<td>${ data.ride }</td>
				<td>${ data.takeoff }</td>
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>  
			${msg}
	</c:otherwise>
	</c:choose>
</body>
</html>