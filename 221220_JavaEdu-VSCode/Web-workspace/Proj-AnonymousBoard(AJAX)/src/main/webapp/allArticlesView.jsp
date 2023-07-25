<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, boardncmt.vo.BoardNCmt, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 글 보기</title>
</head>
<body>

	<%
	// input data
	// data from session
	Member loginMember = (Member)session.getAttribute("loginMember");
	if (loginMember == null) {
		System.out.println("!!! Session Expiration! (allArticlesView.jsp)");
		response.sendRedirect("sessionError.jsp");
	}
	
	// data from request
	List<BoardNCmt> bncList = (List<BoardNCmt>)request.getAttribute("bncList");
	
	%>
	
	<header>
		<div style="float: right">
			<span>login : <%= loginMember.getMemberName() %></span>
			<form action="editMemberCall" method="post" style="display: inline">
				<button type="submit">개인정보수정</button>
			</form>
			<form action="logout" method="post" style="display: inline">
				<button type="submit">로그아웃</button>
			</form>
		</div>
		<br>
	</header>
	
	
	
	<div style="text-align: center">
		<h3>전체 글 보기</h3>
	</div>
	
	<!-- 새 글 작성 -->
	<form action="newArticleCall" method="post" style="text-align: center">
		<button type="submit">새 글 작성</button>
	</form>

	<!-- 게시글 목록 -->
	<table border="2" style="text-align: center; margin-left:auto; margin-right:auto;">
		<thead>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>글 작성자</th>
			<th>작성일</th>
			<th>댓글 수</th>
			<th>좋아요 수</th>
		</thead>
		<tbody>
			<%
			if (!bncList.isEmpty()) {
				for (BoardNCmt article : bncList) {
					int bNum = article.getBoardNum();
					String bTitle = article.getBoardTitle();
					String bAuthor = article.getBoardAuthor();
					String bDate = article.getBoardDate();
					int bCommentCount = article.getBoardCommentCount();
					int bLikeNum = article.getBoardLikeNum();
			%>
				<tr>
					<td><%= bNum %></td>
					<td>
						<a href="articleDetailsCall?bNum=<%= bNum %>&bLikeNum=<%= bLikeNum %>">
							<%= bTitle %>
						</a>
					</td>
					<td><%= bAuthor %></td>
					<td><%= bDate %></td>
					<td><%= bCommentCount %></td>
					<td><%= bLikeNum %></td>
				</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>

</body>
</html>