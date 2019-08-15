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
	margin-left: auto;
	margin-right: auto;
	width: 50%;
}
th, td {
	padding: 10px;
	border: 1px solid black;
	font-weight: bold;
}
th {
	font-size: 1.2em;
	background-color: #C0C0C0;
}
h1 {
	font-size: 50px;
	font-weight: bold; 
}
body{
  text-align:center;
}
body:before{
  content:'';
  height:100%;
  display:inline-block;
  vertical-align:middle;
}
button{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  height:60px;
  font-size:1.6em;
  padding:0 2em;
  margin: 10px;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}
form {
	font-size: 1.5em;
	font-weight: bold;
	margin: 10px; 
}
input {
	font-weight: bold;
	padding: 10px;  
}
div {
	background-color: #C0C0C0; 
	padding: 10px;
}
</style>
</head>
<body>
<h1>1인 가구 정보</h1>
<hr>
<div>
	<button onclick="list(1)">1인 가구가 많은순으로 전체 출력</button><br>
	<button onclick="list(2)">구별 1인 가구 명수 출력</button><br>
	<button onclick="list(3)">1인 가구수가 제일 많은 동의 구 이름과 동 이름 출력</button><br>
	<button onclick="list(4)">1인 가구수가 제일 많은 구 이름 출력</button><br>
	<form method="get" action="/springedu/one">
	<input type="hidden" name="action" value="desc">
		점검하려는 구이름 입력 :
		<input type="text" name="district">
		<input type="submit" value="검색">
	</form>
</div>
<hr>
<c:choose>
	<c:when test="${ list1 != null }">
		<table>
			<tr>
				<th>구 이름</th>
				<th>동 이름</th>
				<th>1인 가구수</th>
			</tr>		
			<c:forEach var="data"  items="${list1}">
			<tr>
				<c:if test="${ !empty data.district }"><td>${ data.district }</td></c:if>
				<c:if test="${ !empty data.dong }"><td>${ data.dong }</td></c:if>
				<c:if test="${ !empty data.ophouse }"><td>${ data.ophouse }</td></c:if>
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:when test="${ list2 != null }">
		<table>
			<tr>
				<th>구 이름</th>
				<th>1인 가구수</th>
			</tr>		
			<c:forEach var="data"  items="${list2}">
			<tr>
				<c:if test="${ !empty data.district }"><td>${ data.district }</td></c:if>
				<c:if test="${ !empty data.ophouse }"><td>${ data.ophouse }</td></c:if>
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:when test="${ list3 != null }">
		<table>
			<tr>
				<th>구 이름</th>
				<th>동 이름</th>
			</tr>		
			<c:forEach var="data"  items="${list3}">
			<tr>
				<c:if test="${ !empty data.district }"><td>${ data.district }</td></c:if>
				<c:if test="${ !empty data.dong }"><td>${ data.dong }</td></c:if>
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:when test="${ list4 != null }">
		<table>
			<tr>
				<th>구 이름</th>
			</tr>		
			<c:forEach var="data"  items="${list4}">
			<tr>
				<c:if test="${ !empty data.district }"><td>${ data.district }</td></c:if>
			</tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>
<script>
	function list(cv) {
		if(cv == 1) {
			location.href='/springedu/one?action=desc';			
		} else if(cv == 2) {
			location.href='/springedu/one?action=district';						
		} else if(cv == 3) {
			location.href='/springedu/one?action=alldesc';									
		} else if(cv == 4) {
			location.href='/springedu/one?action=max';												
		}
	}
</script>
</body>
</html>