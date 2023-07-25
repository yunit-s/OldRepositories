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
	<!-- 변수를 만들고 값을 할당할 수 있어요! -->
	<% 
		int k = 100; 	
	%>
	<c:set var="num1" value="100" />
	<!-- 제어문 중 대표적인 제어문.. if -->
	<!-- else문이 없어요! -->
	<c:if test="${ num1 + myNum > 100 }">
		100보다 커요!!
	</c:if>
	
	<!-- 일반적으로 조건이 여러개인 경우는 c:if대신 다른걸 사용해요! -->
	<c:choose>
		<c:when test="${ num1 + myNum > 50 }">
			50보다 커요!!
		</c:when>
		<c:when test="${ num1 + myNum > 100 }">
			100보다 커요!
		</c:when>
		<c:when test="${ num1 + myNum > 300 }">
			300보다 커요!
		</c:when>	
		<c:otherwise>
			이도저도 아니예요!
		</c:otherwise>	
	</c:choose>	
	
	<br><br>
	<!-- 반복문도 해 보아요! -->
	<!-- 기본적인 형태 - 반복횟수를 알려줘서 반복하는 경우 -->
	<ul>
	<c:forEach var="tmp" begin="1" end="5" step="1">
		<li>${ tmp }</li>
	</c:forEach>
	</ul>
	<br><br>
	
	<!-- 일반적으로 집합자료구조를 이용한 반복처리를 많이 해요! -->
	<ul>
	<c:forEach var="name" items="${ myList }">
		<li>${ name }</li>
	</c:forEach>
	</ul>
	
	<!-- fmt를 사용하기 위해 변수를 하나 선언해 보아요! -->
	<c:set var="number" value="123456789" />
	<br><br>
	
	<!-- 숫자표현할 때 3자리마다 콤마 표시하는거.. -->
	<fmt:formatNumber value="${ number }" />
	<br><br>
	
	<!-- 화폐단위 -->
	<fmt:formatNumber value="${ number }" type="currency" />
	<br><br>
	
	<!-- fmt를 사용하기 위해 변수를 하나 선언해 보아요! -->
	<c:set var="number" value="0.783" />	
	<br><br>
	
	<fmt:formatNumber value="${ number }" type="percent" />
	<br><br>
	
</body>
</html>