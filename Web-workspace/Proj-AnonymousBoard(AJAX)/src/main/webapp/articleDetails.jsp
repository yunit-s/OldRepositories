<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, comment.vo.Comment, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>

    <!-- jQuery 사용을 위한 CDN -->
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
        crossorigin="anonymous">
    </script>

	<!-- Javascript source code -->
	<script src="./js/articleDetails.js"></script>
	
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
	boolean isLiked = (boolean)request.getAttribute("isLiked");
	
	// java source code
	int bNum = board.getBoardNum();
	String bTitle = board.getBoardTitle();
	String bAuthor = board.getBoardAuthor();
	String bContent = board.getBoardContent();
	String bDate = board.getBoardDate();
	int bLikeNum = board.getBoardLikeNum();
	
	// page initialize
	String likeBtnText = null;
	if (isLiked) likeBtnText = "누르면 싫어함ㅠ";
	else likeBtnText = "누르면 좋아함!!";
	%>
	<input type="hidden" id="bNum" value="<%= bNum %>">
	
	<header>
		<button onclick="history.back()">뒤로가기</button>
		<a href="gotoAllArticlesView"><button>전체 글 보기</button></a>
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
	
	
	
	<main>
		<!-- 글 상세 정보 -->
		<div style="text-align: center">
			<h3>글 상세 정보</h3>
		</div>
		
		<table style="margin-left:auto; margin-right:auto;">
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
				<td width="300px" id="bLikeNumTbl"><%= bLikeNum %></td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align: right; align: right">
					<button id="likeBtnId" onclick="likeBtnFunc()" style="float: left; width: 150px"><%= likeBtnText %></button>
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
		
		<!-- 댓글 입력(form 태그) -->
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
		
		<!-- 댓글 입력(AJAX) -->
		<br><br><br>
		<div>
			<input type="hidden" name="cArticleNum" value="<%= bNum %>">
			<div style="text-align: center">댓글 입력</div>
			<table style="margin-left: auto; margin-right: auto">
				<tr>
					<td style="width: 80px">
						<input type="text" name="cAuthor" style="border: 0; width: 80px" value="<%= loginMember.getMemberId() %>">
					</td>
					<td>
						<input type="text" id="addCommentInputId" name="cContent" style="width: 250px"
							onkeypress="if(event.code == 'Enter'){addCommentBtnFunc();}">
					</td>
					<td><button onclick="addCommentBtnFunc()">댓글 입력</button></td>
				</tr>
			</table>
		</div>
		
		<table style="margin-left:auto; margin-right:auto;" border="1">
			<thead>
				<th scope="col" style="width: 80px">작성자</th>
				<th scope="col" style="width: 250px">내용</th>
				<th scope="col" style="width: 180px">작성일</th>
				<th scope="col" style="width: 100px"> </th>
			</thead>
			<tbody id="commentTbodyId">
				<%
				if (!cList.isEmpty()) {
					for (Comment item : cList) {
						int cNum = item.getCommentNum();
						int cArticleNum = item.getCommentArticleNum();
						String cAuthor = item.getCommentAuthor();
						String cContent = item.getCommentContent();
						String cDate = item.getCommentDate();
				%>
				<tr id="<%= "commentTrId" + cNum %>">
					<td id="<%= "cAuthorTdId" + cNum %>"><%= cAuthor %></td>
					<td id="<%= "cContentTdId" + cNum %>"><%= cContent %></td>
					<td id="<%= "cDateTdId" + cNum %>" style="text-align: center"><%= cDate %></td>
					<td id="<%= "editCommentTdId" + cNum %>" style="text-align: center">
						<!-- AJAX를 활용한 댓글 수정 -->
						<button id="<%= "editCommentBtnId" + cNum %>" onclick="editCommentBtnFunc(<%= cNum %>)">수정</button>
						<button id="<%= "delCommentBtnId" + cNum %>" onclick="delCommentBtnFunc(<%= cNum %>)">삭제</button>
						
						<!-- AJAX 없이 구현한 댓글 수정 -->
						<!--
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
						-->
					</td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
		
	</main>
	
</body>
</html>