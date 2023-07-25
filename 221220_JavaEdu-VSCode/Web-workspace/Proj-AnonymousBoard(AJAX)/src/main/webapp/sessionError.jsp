<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 오류 발생</title>
</head>
<body>

	<%
	// input data
	// data from session
	Member loginMember = (Member)session.getAttribute("loginMember");
	if (loginMember != null) {
		System.out.println("!!! memberId = " + loginMember.getMemberId());
	} else {
		System.out.println("!!! loginMember == null");
	}
	%>
	
	<h3>세션 오류 발생</h3>
	
	<%
	if (loginMember != null) {
	%>
		<div>loginMember ID : <%= loginMember.getMemberId() %></div>
	<%
	} else {
	%>
		<div>loginMember is null.</div>
	<%
	}
	%>
	<a href="login.html"><button>로그인 화면으로(a tag)</button></a>
	<form action="login.html" method="post">
		<button type="submit">로그인 화면으로(from tag)</button>
	</form>

</body>
</html>