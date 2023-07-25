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

	<h1>@RequestMapping - Produces 속성</h1>
	<div>requestMappingProducesView.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample08/requestMappingProducesTest.html</div>
	<hr>
	
	<h3>수행 결과</h3>
	<div>model에 저장된 데이터 : ${ msg }</div>
	<div>jsp 출력을 통한 Response Headers 의 기본 Content-type 값 : Content-Type: text/html;charset=UTF-8</div>
	<div>사실상 method 1, 2만 이 페이지로 접근하게 된다. 나머지는 output stream을 직접 열었기 때문</div>

</body>
</html>