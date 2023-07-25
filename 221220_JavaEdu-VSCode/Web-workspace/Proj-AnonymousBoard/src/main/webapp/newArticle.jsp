<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성</title>
</head>
<body>

	<%
	// input data
	// data from session
	Member loginMember = (Member)session.getAttribute("loginMember");
	if (loginMember == null) {
		System.out.println("!!! Session Expiration! (newArticle.jsp)");
		response.sendRedirect("sessionError.jsp");
	}
	
	%>
	
	<header>
		<button onclick="history.back()">뒤로가기</button>
		<div style="float: right">
			<span>login : <%= loginMember.getMemberName() %></span>
			<form action="editMemberCall" method="post" style="display: inline">
				<button type="submit">개인정보수정</button>
			</form>
			<form action="logout" method="post" style="display: inline">
				<button type="submit">로그아웃</button>
			</form>
		</div>
	</header>
	
	
	
	<div style="text-align: center">
		<h3>새 글 쓰기</h3>
	</div>
	
	<form action="newArticleResult" method="post">
		<table style="margin-left:auto; margin-right:auto;">
			<tr>
				<td style="text-align: right">글 제목 : </td>
				<td><input type="text" name="bTitle"></td>
			</tr>
			<tr>
				<td style="text-align: right">글 작성자 : </td>
				<td><input type="text" name="bAuthor" value="<%= loginMember.getMemberId() %>" style="border: 0" readonly></td>
			</tr>
			<tr>
				<td style="text-align: right">글 내용 : </td>
				<td><input type="text" name="bContent"></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right"><button type="submit">작성 완료</button></td>
			</tr>
		</table>
	</form>

</body>
</html>