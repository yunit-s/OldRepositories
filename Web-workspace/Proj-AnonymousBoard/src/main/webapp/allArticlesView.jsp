<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 글 보기</title>
</head>
<body>

	<%
	// input data
	Member loginMember = (Member)session.getAttribute("loginMember"); // session에 저장한 데이터
	Member loginMember2 = (Member)request.getAttribute("loginMember"); // request에 저장한 데이터
	
	%>
	<div>
		<h3 style="text-align: center">전체 글 보기</h3>
		
		<div style="text-align: center"><%//= loginMember.getMemberId() %>, <%//= loginMember.getMemberName() %></div>
		<div style="text-align: center"><%//= loginMember2.getMemberId() %>, <%//= loginMember2.getMemberName() %></div>

		<form action="newArticleCall" method="post" style="text-align: center">
			<button type="submit">새 글 작성</button>
		</form>

		<table border="2" style="text-align: center; margin-left:auto; margin-right:auto;">
			<thead>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>글 작성자</th>
				<th>작성일</th>
				<th>좋아요 수</th>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < 5; i++) {
				%>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>6</td>
				</tr>
				<%
				} 
				%>
			</tbody>
		</table>
	</div>

</body>
</html>