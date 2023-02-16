<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<header>
		<button onclick="history.back()">뒤로가기</button>
	</header>
	
	
	
	<div style="text-align: center">
		<h3>회원가입</h3>
	</div>
	
	<form action="signupResult" method="post">
		<table style="margin-left:auto; margin-right:auto;">
			<tr>
				<td style="text-align: right">ID : </td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td style="text-align: right">PW : </td>
				<td><input type="password" name="userPw"></td>
			</tr>
			<tr>
				<td style="text-align: right">이름 : </td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right">
					<button type="submit">회원가입</button>
				</td>
			</tr>
		</table>
	</form>
	

</body>
</html>