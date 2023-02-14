<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
</head>
<body>

	<%
	// input data
	// session에 저장한 데이터
	Member loginMember = (Member)session.getAttribute("loginMember");
	
	// request에 저장한 데이터
	Board board = (Board)request.getAttribute("tgBoard");
	
	%>
	
	<header>
		<button onclick="history.back()">뒤로가기</button>
		<div style="text-align: right">
			login : <%= loginMember.getMemberName() %>
		</div>
		<form action="logout" method="post" style="text-align: right">
			<button type="submit">로그아웃</button>
		</form>
	</header>
	
	
	
	<!-- 글 상세 정보 -->
	<div style="text-align: center">
		<h3>글 상세 정보</h3>
	</div>

	<table style="margin-left:auto; margin-right:auto;">
		<%
		int bNum = board.getBoardNum();
		String bTitle = board.getBoardTitle();
		String bAuthor = board.getBoardAuthor();
		String bContent = board.getBoardContent();
		String bDate = board.getBoardDate();
		int bLike = board.getBoardLike();
		%>
		<tr>
			<td style="text-align: right" width="100px">글 번호 : </td>
			<td width="300px"><%= bNum %></td>
		</tr>
		<tr>
			<td style="text-align: right" width="100px">글 제목 : </td>
			<td width="300px"><%= bTitle %></td>
		</tr>
		<tr>
			<td style="text-align: right" width="100px">글 작성자 : </td>
			<td width="300px"><%= bAuthor %></td>
		</tr>
		<tr>
			<td style="text-align: right" width="100px">글 내용 : </td>
			<td width="300px"><%= bContent %></td>
		</tr>
		<tr>
			<td style="text-align: right" width="100px">좋아요 : </td>
			<td width="300px"><%= bLike %></td>
		</tr>
		<tr>
			<td></td>
			<td style="text-align: right">
				<form action="editArticleCall" method="post">
					<input type="hidden" name="bNum" value="<%= bNum %>">
					<button type="submit">글 수정</button>
				</form>
				<form action="delArticleCall" method="post">
					<input type="hidden" name="bNum" value="<%= bNum %>">
					<button type="submit">글 삭제</button>
				</form>
			</td>
		</tr>
	</table>
	<br><br>
	
	
	
	<!-- 댓글 -->
	<div style="text-align: center">
		<h3>댓글</h3>
	</div>
	<table style="margin-left:auto; margin-right:auto;" border="1">
		<thead>
			<th scope="col">작성자</th>
			<th scope="col">내용</th>
			<th scope="col"> </th>
			<th scope="col"> </th>
		</thead>
		<tbody>
			<tr>
				<td>aaa</td>
				<td>댓글내용내용내용</td>
				<td>
					<form action="editCommentCall" method="post">
						<button type="submit">수정</button>
					</form>
				</td>
				<td>
					<form action="delCommentCall" method="post">
						<button type="submit">삭제</button>
					</form>
				</td>
			</tr>
			<tr>
				<td>bbb</td>
				<td>댓글내용내용내용</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
		</tbody>
	</table>

</body>
</html>