<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
	font-size : 15px;
}
	
button {
	font-size : 14px;
	background : linear-gradient(to right, yellow, green);
}
</style>
</head>
<body>
<h1>선택된 상품 정보는 다음과 같습니다.(EL)</h1>
<hr> 
<ul>
	<li>선택된 사과의 개수 :${ sessionScope.product.appleNum }</li>
	<li>선택된 바나나의 개수 : ${ sessionScope.product.bananaNum }</li>
	<li>선택된 한라봉의 개수 : ${ sessionScope.product.hanrabongNum }</li> 
</ul>
<hr>
<button onclick='location.href="/springedu/resources/product.html"'>상품 선택화면</button>
</body>
</html>