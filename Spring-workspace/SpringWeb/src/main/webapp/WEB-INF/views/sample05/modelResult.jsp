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

	<h1></h1>
	<div>modelResult.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/modelAttributes1</div>
	<div>ModelAttributesController.java 를 통해서 접근</div>
	
	<h3>model 안의 데이터</h3>
	<div>v1 일반 문자열 String (v1) : ${ v1 }</div>
	<div>v2 User VO 객체의 이름(v2.userName) : ${ v2.userName }</div>
	<div>두 숫자의 합 num1 + num2 = ${ sum }</div>

</body>
</html>