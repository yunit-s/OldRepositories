<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
</head>
<body>

	<%
	// input data
	// data from request
	Board tgBoard = (Board)request.getAttribute("tgBoard");
	
	%>
	
	<header>
		<button onclick="history.back()">뒤로가기</button>
	</header>
	
	
	
	<div style="text-align: center">
		<h3>글 수정하기</h3>
	</div>
	
	<form action="editArticleResult" method="post">
		<%
		int bNum = tgBoard.getBoardNum();
		String bTitle = tgBoard.getBoardTitle();
		String bAuthor = tgBoard.getBoardAuthor();
		String bContent = tgBoard.getBoardContent();
		String bDate = tgBoard.getBoardDate();
		int bLikeNum = tgBoard.getBoardLikeNum();
		%>
		<input type="hidden" name="bNum" value="<%= bNum %>">
		<table style="margin-left:auto; margin-right:auto;">
			<tr>
				<td style="text-align: right">글 제목 : </td>
				<td><input type="text" name="bTitle" value="<%= bTitle %>"></td>
			</tr>
			<tr>
				<td style="text-align: right">글 작성자 : </td>
				<td><input type="text" name="bAuthor" value="<%= bAuthor %>" style="border: 0" readonly></td>
			</tr>
			<tr>
				<td style="text-align: right">글 내용 : </td>
				<td><input type="text" name="bContent" value="<%= bContent %>"></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right"><button type="submit">수정 완료</button></td>
			</tr>
		</table>
	</form>

</body>
</html>