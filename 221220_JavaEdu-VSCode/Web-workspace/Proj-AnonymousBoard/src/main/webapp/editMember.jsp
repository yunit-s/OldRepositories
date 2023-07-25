<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 수정</title>
</head>
<body>

	<%
	// input data
	// data from session
	Member loginMember = (Member)session.getAttribute("loginMember");
	if (loginMember == null) {
		System.out.println("!!! Session Expiration! (editMember.jsp)");
		response.sendRedirect("sessionError.jsp");
	}
	
	%>
	
	<header>
		<button onclick="history.back()">뒤로가기</button>
	</header>
	
	
	
	<div style="text-align: center">
		<h3>개인 정보 수정</h3>
	</div>
	
	<form action="editMemberResult" method="post">
		<%
		String mId = loginMember.getMemberId();
		String mPw = loginMember.getMemberPw();
		String mName = loginMember.getMemberName();
		%>
		<table style="margin-left:auto; margin-right:auto;">
			<tr>
				<td style="text-align: right">ID : </td>
				<td><input type="text" name="mId" value="<%= mId %>" style="border: 0" readonly></td>
			</tr>
			<tr>
				<td style="text-align: right">PW : </td>
				<td><input type="password" name="mPw"></td>
			</tr>
			<tr>
				<td style="text-align: right">이름 : </td>
				<td><input type="text" name="mName" value="<%= mName %>"></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right"><button type="submit">수정 완료</button></td>
			</tr>
		</table>
	</form>
	
	<form action="signoutCall" method="post" style="text-align: center">
		<button type="submit">회원탈퇴</button>
	</form>

</body>
</html>