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

	<h1>Session 기본예제 - 결과화면</h1>
	<div>sessionResult03.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample07/sessionForm.html</div>
	<div>html url 직접 접근 -> SessionAttributesController03.java 를 통해서 접근</div>
	
	<h3>RequestScope</h3>
	<div>requestScope.data1 : ${ requestScope.data1 }</div>
	<div>ㄴ> SessionAttributesController01 에서 @ModelAttribute로 저장한 데이터</div>
	<div>requestScope.data2 : ${ requestScope.data2 }</div>
	<div>ㄴ> SessionAttributesController01 에서 @ModelAttribute로 저장한 데이터</div>
	<div>param.msg: ${ param.msg }</div>
	<div>ㄴ> aaaaa 데이터</div>
	<div>requestScope.studentVO : ${ requestScope.studentVO }</div>
	<div>ㄴ> 안 나옴. 스코프에 저장된 이름은 이게 아니라 직접 지정한 이름이다.</div>
	<div>requestScope.student : ${ requestScope.student }</div>
	<div>ㄴ> 안 나옴. 이름을 직접 지정하지 않았을 때만 자동으로 이름을 클래스 이름을 참조하기 때문</div>
	<div>requestScope.newStudent : ${ requestScope.newStudent }</div>
	<div>ㄴ> aaaaa 데이터</div>
	
	<hr>
	
	<h3>SessionScope</h3>
	<div>sessionScope.data1 : ${ sessionScope.data1 }</div>
	<div>ㄴ> SessionAttributesController01 에서 @ModelAttribute로 저장한 데이터</div>
	<div>sessionScope.data2 : ${ sessionScope.data2 }</div>
	<div>ㄴ> SessionAttributesController01 에서 @ModelAttribute로 저장한 데이터</div>
	<div>sessionScope.newStudent : ${ sessionScope.newStudent }</div>
	<div>ㄴ> aaaaa 데이터</div>
	<div>sessionScope.shin.studentName : ${ sessionScope.shin.studentName }</div>
	<div>ㄴ> aaaaa 데이터</div>
	<div>sessionScope.shin.studentDept : ${ sessionScope.shin.studentDept }</div>
	<div>ㄴ> aaaaa 데이터</div>
	
	
	<a href="${ header.referer }">뒤로가기</a>

</body>
</html>