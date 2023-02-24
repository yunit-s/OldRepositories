<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>연산 오류 발생!</h1>
	<div>파일 경로 : sample02/errorResult.jsp</div><br>
	
	<h3>데이터 불러오는 3가지 방법</h3>
	<div>오류의 원인 : ${ msg }</div>
	<div>오류의 원인 : <%= request.getAttribute("msg") %></div>
	<div>오류의 원인 : ${ requestScope.msg }</div>

</body>
</html>