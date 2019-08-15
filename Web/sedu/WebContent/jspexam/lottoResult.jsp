<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.LottoResultVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	LottoResultVO vo = (LottoResultVO)request.getAttribute("data");
%>
<h1><%= vo.getMsg() %></h1>
<img src="<%= vo.getUrl() %>">
<br>
<% 
	if(vo.getButton() != null) {
%>
<%=vo.getButton() %>
<%
	}
%>
</body>
</html>