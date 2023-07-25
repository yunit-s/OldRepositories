<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="comment.vo.Comment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정하기</title>
</head>
<body>

	<%
	// input data
	// data from request
	// int bNum = (int)request.getAttribute("bNum");
	Comment tgComment = (Comment)request.getAttribute("tgComment");
	
	%>


	<header>
		<button onclick="history.back()">뒤로가기</button>
	</header>
	
	
	
	<div style="text-align: center">
		<h3>댓글 수정하기</h3>
	</div>
	
	<form action="editCommentResult" method="post">
		<%
		int cNum = tgComment.getCommentNum();
		int cArticleNum = tgComment.getCommentArticleNum();
		String cAuthor = tgComment.getCommentAuthor();
		String cContent = tgComment.getCommentContent();
		%>
		<input type="hidden" name="cNum" value="<%= cNum %>">
		<input type="hidden" name="cArticleNum" value="<%= cArticleNum %>">
		<table style="margin-left:auto; margin-right:auto;">
			<tr>
				<td style="text-align: right">댓글 작성자 : </td>
				<td><input type="text" name="cAuthor" value="<%= cAuthor %>" style="border: 0" readonly></td>
			</tr>
			<tr>
				<td style="text-align: right">댓글 내용 : </td>
				<td><input type="text" name="cContent" value="<%= cContent %>"></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right"><button type="submit">수정 완료</button></td>
			</tr>
		</table>
	</form>

</body>
</html>