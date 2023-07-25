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

	<h1>로또 프로그램</h1>
	<div>lottoView.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample06/lottoForm.html</div>
	<div>html을 먼저 접근한 뒤, 이미지 클릭했을 때 LottoController.java를 거치고 온다.</div>

	<h3>lotto 결과</h3>
	<div>당첨결과 : ${ lotto.result }</div>
	<br>
	<a href="${ header.referer }">뒤로가기</a>

</body>
</html>