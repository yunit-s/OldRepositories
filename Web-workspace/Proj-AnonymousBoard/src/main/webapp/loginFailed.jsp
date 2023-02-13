<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>

	<h3>Login failed!</h3>
	<div>userId : <%= request.getAttribute("userId") %></div>
	<div>userPw : <%= request.getAttribute("userPw") %></div>
	<button onclick="history.back()">뒤로가기</button>
	
</body>
</html>