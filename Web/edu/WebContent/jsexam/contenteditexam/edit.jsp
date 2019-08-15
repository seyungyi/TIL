<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
 	request.setCharacterEncoding("utf-8");
 	String memo = request.getParameter("memo");
 	if(memo != null)
 		out.println("jsp가 응답함 : 메모내용 = " + memo);
 %>