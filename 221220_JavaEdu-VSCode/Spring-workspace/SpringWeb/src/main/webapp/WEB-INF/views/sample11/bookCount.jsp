<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>MyBatis 적용 예제</h1>
	<div>bookCount.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample11/bookSearch.html</div>
	<hr>
	
	<h3>실행 모드 - ${ mode }</h3>
	<c:choose>
		<c:when test="${ mode.equals('count') }">
			<h3>mode 1 - 전체 도서 수 가져오기</h3>
			<div>책의 권수 : ${ result }</div>
		</c:when>
		
		<c:when test="${ mode.equals('selectAll') }">
			<h3>mode 2 - 모든 도서 리스트 확인하기</h3>
			<div>결과물 수 = ${ resultList.size() }</div>
			<table border="1"">
				<thead>
					<th>bookIsbn</th>
					<th>bookTitle</th>
				</thead>
				<tbody>
					<c:set var="cnt" value="0" />
					<c:forEach var="book" items="${ resultList }">
						<tr>
							<td>${ book.getBookIsbn() }</td>
							<td>${ book.getBookTitle() }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		
		<c:when test="${ mode.equals('search') }">
			<h3>mode 3 - 도서 검색</h3>
			<div>결과물 수 = ${ resultList.size() }</div>
			<table border="1"">
				<thead>
					<th>bookIsbn</th>
					<th>bookTitle</th>
				</thead>
				<tbody>
					<c:set var="cnt" value="0" />
					<c:forEach var="book" items="${ resultList }">
						<tr>
							<td>${ book.getBookIsbn() }</td>
							<td>${ book.getBookTitle() }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		
		<c:otherwise>
			<h3>Error. 해당하는 mode가 없다.</h3>
		</c:otherwise>
	
	</c:choose>
	

</body>
</html>