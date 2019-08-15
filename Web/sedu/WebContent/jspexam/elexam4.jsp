<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ page import="jspbean.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title> 
</head>
<body>
<h2>객체의 getter 메서드, 컬렉션 객체의 원소, 클래스의 정적 멤버 사용</h2> 
<hr> 
<%--pageContext가 가장 우선순위가 높음 --%> 
<%
pageContext.setAttribute("today", new Today());
ArrayList<TestBean> mylist = new ArrayList<>();
mylist.add(new TestBean("둘리"));
mylist.add(new TestBean("또치"));
mylist.add(new TestBean("도우너"));
pageContext.setAttribute("list", mylist); 
%>
<h3>객체의 멤버 접근</h3>
<%--pageScope.today.year 도 같음. 이것은 getyear와 같은 기능을 의미한다 --%>
${ today.year }년 ${ today.month }월 ${ today.date }일
<h3>컬렉션의 객체 사용</h3>
<%--el에서는 컬렉션에 접근할시 대괄호의 인덱싱 방식을 사용한다 --%>
${ list[0].name }-${ list[1].name }-${ list[2].name }<br>
<h3>클래스의 정적 멤버 사용</h3>
${ LanguageInfoBean.name }<br>
${ LanguageInfoBean.getBirthYear() }<br>
${ LanguageInfoBean.getKindInfo() }<br> 
</body>
</html>