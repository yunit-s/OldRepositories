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

	<h1>PathController를 활용해서 이미지 파일 띄우기</h1>
	<div>detailView.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/character/detail/kakao/1</div>
	<div>PathController.java 를 통해서 접근</div>
	
	<img src="/SpringWeb/resources/images/${ imgname }.jpg">

</body>
</html>