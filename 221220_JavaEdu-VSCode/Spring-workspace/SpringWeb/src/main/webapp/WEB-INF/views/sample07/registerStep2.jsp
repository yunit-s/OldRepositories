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

	<h1>Session 데이터 활용하기 예제 - 사용자 등록</h1>
	<div>registerStep2.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample07/memberRegister.html</div>
	<div>html을 먼저 접근한 뒤, 이미지 클릭했을 때 MemberRegisterController.java를 거치고 온다.</div>

	<h3>Step2 - 사용자 기본 정보 입력</h3>
	<form action="/SpringWeb/memberRegisterStep3" method="post">
		<div>취미 : <input type="text" name="memberHobby" value="${ memberInfo.memberHobby }"><br></div>
		<div>자기소개 : <input type="text" name="memberContent" value="${ memberInfo.memberContent }"><br></div>
		<input type="submit" value="저장">
	</form>
	<form action="/SpringWeb/memberRegisterStep1" method="post">
		<input type="submit" value="첫 번째 페이지로 이동">
	</form>
	
	<a href="${ header.referer }">뒤로가기</a>

</body>
</html>