<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 실패</title>
</head>
<body>

	<%
	// input data
	// data from request
	String userId = (String)request.getAttribute("userId");
	%>

	<h3>Sign up failed!</h3>
	<div>ID "<%= userId %>" is duplicated!</div>
	<button onclick="history.back()">뒤로가기</button>
	
</body>
</html>