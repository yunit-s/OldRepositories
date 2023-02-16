<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, comment.vo.Comment, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
</head>
<body>

	<%
	// input data
	// data from session
	Member loginMember = (Member)session.getAttribute("loginMember");
	if (loginMember == null) {
		System.out.println("!!! Session Expiration! (articleDetails.jsp)");
		response.sendRedirect("sessionError.jsp");
	}
	
	// data from request
	Board board = (Board)request.getAttribute("tgBoard");
	List<Comment> cList = (List<Comment>)request.getAttribute("cList");
	
	%>
	
	<header>
		<button onclick="history.back()">뒤로가기</button>
		<a href="gotoAllArticlesView"><button>전체 글 보기</button></a>
		<div style="float: right">
			<span>login : <%= loginMember.getMemberName() %>	</span>
			<form action="logout" method="post" style="display: inline">
				<button type="submit">로그아웃</button>
			</form>
		</div>
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
		int bLikeNum = board.getBoardLikeNum();
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
			<td width="300px"><%= bLikeNum %></td>
		</tr>
		<tr>
			<td></td>
			<td style="text-align: right; align: right">
				<form action="editArticleCall" method="post" style="display: inline">
					<input type="hidden" name="bNum" value="<%= bNum %>">
					<button type="submit">글 수정</button>
				</form>
				<form action="delArticleCall" method="post" style="display: inline">
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
	
	<form action="newCommentCall" method="post" style="text-align: center">
		<input type="hidden" name="cArticleNum" value="<%= bNum %>">
		<div style="text-align: center">댓글 입력</div>
		<table style="margin-left: auto; margin-right: auto">
			<tr>
				<td style="width: 80px">
					<input type="text" name="cAuthor" style="border: 0; width: 80px" value="<%= loginMember.getMemberId() %>">
				</td>
				<td><input type="text" name="cContent" style="width: 250px"></td>
				<td><button type="submit">댓글 입력</button></td>
			</tr>
		</table>
	</form>
	
	<table style="margin-left:auto; margin-right:auto;" border="1">
		<thead>
			<th scope="col" style="width: 80px">작성자</th>
			<th scope="col" style="width: 250px">내용</th>
			<th scope="col" style="width: 180px">작성일</th>
			<th scope="col" style="width: 100px"> </th>
		</thead>
		<tbody>
			<%
			if (!cList.isEmpty()) {
				for (Comment item : cList) {
					int cNum = item.getCommentNum();
					int cArticleNum = item.getCommentArticleNum();
					String cAuthor = item.getCommentAuthor();
					String cContent = item.getCommentContent();
					String cDate = item.getCommentDate();
			%>
			<tr>
				<td><%= cAuthor %></td>
				<td><%= cContent %></td>
				<td style="text-align: center"><%= cDate %></td>
				<td style="text-align: center">
					<form action="editCommentCall" method="post" style="display: inline">
						<input type="hidden" name="bNum" value="<%= bNum %>">
						<input type="hidden" name="cNum" value="<%= cNum %>">
						<button type="submit">수정</button>
					</form>
					<form action="delCommentCall" method="post" style="display: inline">
						<input type="hidden" name="bNum" value="<%= bNum %>">
						<input type="hidden" name="cNum" value="<%= cNum %>">
						<button type="submit">삭제</button>
					</form>
				</td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>

</body>
</html>