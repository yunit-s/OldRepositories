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

	<h1>Session 데이터 활용하기 예제 - 과일가게</h1>
	<div>fruitshopBasket.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample07/fruitshopForm.html</div>
	<div>물품 리스트에서 상품을 담으면 fruitshopController.java 를 통해 접근</div>
	<hr>
	
	<h3>장바구니 리스트</h3>
	<div>사과 : ${ basket.appleNum }</div>
	<div>바나나 : ${ basket.bananaNum }</div>
	<div>한라봉 : ${ basket.halabongNum }</div>
	<br>

	<form action="/SpringWeb/showList" method="post">
		<input type="submit" value="리스트보기">
	</form>

</body>
</html>