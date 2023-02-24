<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>@GetMapping 에서 params 속성 사용하기</h1>
	<div>sample01/testController05.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/testController05?myName=홍길동</div>
	<div>http://localhost:8080/SpringWeb/testController05?myName=신사임당</div>
	<div>TestController05.java 를 통해서 접근</div>
	<div>끝에 전달해준 value값에 따라 호출되는 메소드가 달라진다. 더 상세하게 들어맞는 메소드가 우선순위에 있다.</div>
	
</body>
</html>