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

	<h1>JSTL 활용하기</h1>
	<div>jstlExample.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/jstlExample</div>
	<div>JSTLExampleController.java 를 통해서 접근</div>

	<!-- 변수 만들고 값 할당하기 -->
	<h3>변수 만들고 값 할당하기</h3>
	<%
	int k = 100;
	%>
	<c:set var="num1" value="100" />
	<div>c:set으로 할당된 변수 num1 = ${ num1 }</div>
	
	<!--
	제어문 중 대표적인 제어문 if
		test
			정해진 속성명이다. 참거짓을 논할 명제 입력
			여기에는 EL문을 활용한다.
		num1
			위에 c:set으로 설정한 숫자
		myNum
			model에 저장된 데이터
	c:if문의 문제점
		else 문이 없다.
	-->
	<h3>조건문 c:if</h3>
	<c:if test="${ num1 + myNum > 100 }">
		if문. 100보다 크다.
	</c:if>
	
	<!-- 
	조건이 여러 가지로 나뉠 경우에는 c:if가 아니라 c:choose를 사용한다.
		여러 개의 c:when이 있는 경우 위에서부터 차례대로 체크하게 되며, 하나라도 참이 되면 그것만 실행하고 끝난다.
		c:when
			조건에 걸릴 때 호출한다.
		c:otherwise
			when에 걸리는 조건이 하나도 없는 경우에 호출되는 부분
	-->
	<h3>조건문 c:choose</h3>
	<c:choose>
		<c:when test="${ num1 + myNum > 50 }">
			choose문-when. 50보다 크다.
		</c:when>
		<c:when test="${ num1 + myNum > 100 }">
			choose문-when. 100보다 크다.
		</c:when>
		<c:when test="${ num1 + myNum > 300 }">
			choose문-when. 300보다 크다.
		</c:when>
		<c:otherwise>
			choose문-when. 아무 경우에도 해당되지 않는다.
		</c:otherwise>
	</c:choose>
	
	<!-- 반복문 -->
	<!--
	기본적인 형태. (반복횟수를 알려줘서 반복하는 경우)
		var
			기준이 되는 변수
		begin
			변수의 시작값
		end
			변수의 끝값
		step
			증감의 크기
		
	-->
	<h3>기본적인 반복문. c:forEach</h3>
	<c:forEach var="tmp" begin="1" end="5" step="1">
		<li>${ tmp }</li>
	</c:forEach>
	
	<!--
	집합 자료구조를 활용한 반복처리
		var
			반복문마다 사용되는 타겟의 이름
		items
			저장되어있는 집합자료구조
			EL로 가져오면 되겠지
	-->
	<h3>집합 자료구조를 활용한 반복문. c:forEach</h3>
	<c:forEach var="name" items="${ myList }">
		<li>${ name }</li>
	</c:forEach>
	
	<!--
	fmt(formatter) 사용하기
		number
			테스트를 위해 할당한 변수. 데이터타입을 명시하지 않기 때문에 아직 문자열인지 정수인지 모른다.
	-->
	<h3>fmt(formatter) 사용하기</h3>
	<c:set var="number" value="123456789" />
	<c:set var="number2" value="0.783" />
	
	<!--
	fmt:formatNumber
		숫자 표현할 때 3자리마다 콤마 표시하는 방법
	-->
	<div>
		<div>숫자 3자리마다 콤마 찍어주기 : fmt:formatNumber</div>
		<fmt:formatNumber value="${ number }" />
	</div>
	<div>
		<div>화폐단위 표현하기 : fmt:formatNumber type="currency"</div>
		<fmt:formatNumber value="${ number }" type="currency" />
	</div>
	<div>
		<div>백분율 표현하기 : fmt:formatNumber type="percent"</div>
		<fmt:formatNumber value="${ number2 }" type="percent" />
	</div>
	
</body>
</html>