<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-weight: bold;
	font-size: 1.3em;
}
</style>
</head>
<body>
<!--QueryTestServlet 서블릿 소스를 JSP로 변환하는 실습 2 -->
<h1>전달된 내용</h1>
<hr>
<ul>
	<li>이름 : <%=request.getParameter("name") %></li>
	<li>암호 : <%=request.getParameter("pwd") %></li>
	<li>나이 : <%=request.getParameter("age") %></li>
	<li>성별 : <%=request.getParameter("gender") %></li>
	<li>취미 : <% String[] hobby = request.getParameterValues("hobby");
				if(hobby == null) {
					out.print("없음</li>");
				} else {
					for(String data : hobby) {
						out.print(data + ", ");
					}
					out.print("</li>");
				} %>
	<li>좋아하는 색 : <% String color = request.getParameter("likeColor");
				if(color.equals("")) {
					out.print("없음</li>");
				} else {
					out.print(color + "</li>");
				} %>
	<li>좋아하는 음식 : <% String[] food = request.getParameterValues("likeFood");
				if(food == null) {
					out.print("없음</li>");
				} else {
					for(String data : food) {
						out.print(data + ", ");
					}
					out.print("</li>");
				} %>
	<li>의견 : <%=request.getParameter("document") %></li>
	<li>비밀1 : <%=request.getParameter("hid1") %></li>
	<li>비밀2 : <%=request.getParameter("hid2") %></li>
</ul>
<hr>
<a href='http://localhost:8000/sedu/html/queryForm2.html'>입력화면으로</a>
</body>
</html>