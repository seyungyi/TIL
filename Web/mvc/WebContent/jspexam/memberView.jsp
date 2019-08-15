<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MemberVO vo = (MemberVO)request.getAttribute("data"); %>
<h1>회원 정보(스크립트 태그)</h1>
<hr>
<ul>
	<li>회원 이름 : <%= vo.getName() %></li>
	<li>회원 계정 : <%= vo.getId() %></li>
	<li>회원 암호 : <%= vo.getPwd() %></li>
	<li>회원 전화번호 : <%= vo.getPhone() %></li>
</ul> 
<hr>
<jsp:useBean id="data" class="model.vo.MemberVO" scope="request"/>
<%--jsp:useBean 은 객체를 꺼내서 자동으로 변환한다. id값과 변수명이 일치하는지 확인한다 --%>
<h1>회원 정보(액션 태그)</h1>
<hr>
<ul>
	<li>회원 이름 : <jsp:getProperty property="name" name="data"/></li>
	<li>회원 계정 : <jsp:getProperty property="id" name="data"/></li>
	<li>회원 암호 : <jsp:getProperty property="pwd" name="data"/></li>
	<li>회원 전화번호 : <jsp:getProperty property="phone" name="data"/></li>
</ul>
<hr>
<h1>회원 정보(EL:Expression Language)</h1>
<hr>
<ul>
	<li>회원 이름 : ${ requestScope.data.name }</li>
	<li>회원 계정 : ${ requestScope.data.id }</li>
	<li>회원 암호 : ${ requestScope.data.pwd }</li>
	<li>회원 전화번호 : ${ requestScope.data.phone }</li>
</ul>
</body>
</html>