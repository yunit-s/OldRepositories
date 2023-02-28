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
	<div>fruitshopList.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample07/fruitshopForm.html</div>
	<div>html url 직접 접근 후 가게 입장</div>
	<hr>

	<h3>물품 리스트</h3>
	
	<!-- Get방식 핸들러 3개 활용하는 방법 -->
	<div>Get방식 핸들러 3개 활용하는 방법</div>
	<table style="text-align: center">
		<thead>
			<th>사과</th>
			<th>바나나</th>
			<th>한라봉</th>
		</thead>
		<tbody>
			<tr>
				<td><a href="addApple"><img src="/SpringWeb/resources/images/apple.gif" style="width: 150px"></a></td>
				<td><a href="addBanana"><img src="/SpringWeb/resources/images/banana.jpg" style="width: 150px"></a></td>
				<td><a href="addHalabong"><img src="/SpringWeb/resources/images/halabong.jpg" style="width: 150px"></a></td>
			</tr>
		</tbody>
	</table>
	<br>
	
	<!-- Get방식 핸들러 1개와 VO를 활용하는 방법 -->
	<div>Get방식 핸들러 1개와 VO의 setter 메소드 자동호출을 활용하는 방법</div>
	<div>단순히 setter 메소드를 호출만 하면 알아서 값이 +1 되기 때문에 필드값에 아무 값이나 전달한다.</div>
	<a href="addFruit?appleNum=0"><img src="/SpringWeb/resources/images/apple.gif" style="width: 150px"></a>
	<a href="addFruit?bananaNum=0"><img src="/SpringWeb/resources/images/banana.jpg" style="width: 150px"></a>
	<a href="addFruit?halabongNum=0"><img src="/SpringWeb/resources/images/halabong.jpg" style="width: 150px"></a>
	
	<hr>
	<form action="/SpringWeb/emptyBasket" method="post">
		<input type="submit" value="장바구니 비우기">
	</form>

</body>
</html>