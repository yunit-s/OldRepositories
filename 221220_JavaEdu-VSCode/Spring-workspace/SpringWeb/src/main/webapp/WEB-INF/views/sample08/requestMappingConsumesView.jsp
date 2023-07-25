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

	<h1>@RequestMapping - Consumes 속성</h1>
	<div>requestMappingConsumesView.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample08/requestMappingConsumesTest.html</div>
	<hr>
	
	<h3>수행 결과</h3>
	<div>Post 방식으로 호출했을 경우에만 정상적으로 이 화면이 출력된다.</div>
	<div>Response Headers - Content-Type: text/html;charset=UTF-8</div>
	<div>출력 후 화면은 결국 jsp를 출력했기 때문에, 이 페이지가 뜬다.</div>
	<div>Request Headers - Content-Type: application/x-www-form-urlencoded</div>
	<div>form 태그의 post 방식으로 호출했을 때는 기본값이 application/x-www-form-urlencoded 이다.</div>

</body>
</html>