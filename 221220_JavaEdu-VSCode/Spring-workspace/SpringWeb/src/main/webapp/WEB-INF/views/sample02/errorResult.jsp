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
	<div>sample02/errorResult.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample02/calcForm.html</div>
	<div>CalcController.java 를 통해서 접근</div>>
	<br>
	
	<h3>데이터 불러오는 3가지 방법</h3>
	<div>EL로 model에 저장된 데이터 가져오기($ { }) -> 오류의 원인 : ${ msg }</div>
	<div>EL로 requestScope에 저장된 데이터 가져오기 -> 오류의 원인 : ${ requestScope.msg }</div>
	<div>jsp에서 scriptlet 사용하기(< %= % >) -> 오류의 원인 : <%= request.getAttribute("msg") %></div>

</body>
</html>