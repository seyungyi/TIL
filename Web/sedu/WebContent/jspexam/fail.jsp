<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	text-align: center;
	margin-left: 30%;
	margin-right: 30%;
}
h2 {
	color: red;
}
img {
	border: solid 1px gray;
}
</style>
</head>
<body>
<h2>아쉽아쉽......</h2>
<img src="http://2runzzal.com/media/SFprZ1pyMzJUeWhkcVJ0VG9ZVEdIdz09/thum.jpg">
<br>
<a href="<%= request.getHeader("referer") %>">로또 응모</a>
</body>
</html>