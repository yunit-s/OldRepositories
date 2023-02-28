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
	<div>registerStep1.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample07/memberRegister.html</div>
	<div>html을 먼저 접근한 뒤, 이미지 클릭했을 때 MemberRegisterController.java를 거치고 온다.</div>

	<h3>Step1 - 사용자 기본 정보 입력</h3>
	<form action="/SpringWeb/memberRegisterStep2" method="post">
		<div>아이디 : <input type="text" name="memberId" value="${ memberInfo.memberId }"><br></div>
		<div>이름 : <input type="text" name="memberName" value="${ memberInfo.memberName }"><br></div>
		<div>주소 : <input type="text" name="memberAddr" value="${ memberInfo.memberAddr }"><br></div>
		<input type="submit" value="두 번째 페이지로 이동">
	</form>
	
	<div>history 기록 남아있을까?</div>
	<div>아이디 : <input type="text" name="memberId"><br></div>
	<div>이름 : <input type="text" name="memberName"><br></div>
	<div>주소 : <input type="text" name="memberAddr"><br></div>
	
	
	<a href="${ header.referer }">뒤로가기</a>

</body>
</html>