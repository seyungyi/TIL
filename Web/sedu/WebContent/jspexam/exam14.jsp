<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%--@ page session="false" --%><%--이 jsp에서는 session을 사용하지 않는다 --%>)
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSP에서의 HttpSession 객체</h2>
<hr>
<%= session.isNew() %><br>
<%= session.getId() %><br>
<%= session.getCreationTime() %><br>
<%= new java.util.Date(session.getCreationTime()) %><br>
</body>
</html>