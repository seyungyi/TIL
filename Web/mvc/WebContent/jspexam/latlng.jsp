<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<c:choose>
		<c:when test="${ pageContext.request.method=='GET' }">
			<h2>찾으려는 장소를 입력하시오</h2>
			<hr>
			<form method=POST action="/mvc/jspexam/latlng.jsp">
				장소 : <input type="text" name="location" required> <input
					type="submit" value="찾기">
			</form>
		</c:when>
		<c:otherwise>
			<h2>${param.location}위치정보</h2>
			<hr>
			<c:catch var="ex">
				<c:import var="xmldata"
					url="https://maps.googleapis.com/maps/api/geocode/xml?address=${param.location}&language=ko&key=AIzaSyCymy5ucS__gaVvSVE_udW4SSO2fLn8MnE" />
				<x:parse xml="${xmldata}" varDom="xdata" />
				<%-- <c:set var="locStr" value="${param.location}" /> --%>
				<x:if select="$xdata//status = 'OK'">
					주소 : <x:out select="$xdata//formatted_address" />
					<br>
					위도 : <x:out select="$xdata//location/lat" />
					<br>
					경도 : <x:out select="$xdata//location/lng" />
					<br>
				</x:if>
				<x:if select="$xdata//status != OK">
					<h3>${param.location}이 없습니다</h3>
				</x:if>
			</c:catch>
			<c:if test="${ !empty ex }">
				<h3>오류가 발생했어요....</h3>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>