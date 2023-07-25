<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>testController07.jsp 호출!!</h1>
	<h1>Model안에 저장되어 있는 데이터를 들고와서 여기서 출력해야 해요!</h1>
	<!--  HTML 주석 -->
	<%--  JSP 주석 --%>
	<h3>EL을 이용해서 데이터를 추출해야 해요!</h3>
	<ul>
		<li>이름 : ${ myName }</li>
		<li>나이 : ${ myAge }</li>
	</ul>
</body>
</html>