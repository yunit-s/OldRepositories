<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>EL을 이용해서 데이터를 추출하는 다양한 방법</h1>
	<div>testController08.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample01/testController08.html</div>
	<div>/SpringWeb/resources/sample01/testController08.html 에서 이름과 나이를 입력하면,</div>
	<div>/SpringWeb/sample01/TestController08.java 에서 POST방식으로 호출되고,</div>
	<div>/WEB-INF/views/sample01/testController08.jsp 가 데이터를 가져와서 화면에 출력한다.</div>
	
	<h3>현재 Http 전송 방식 : ${ param.httpMethod }</h3>
	
	<h3>Post로 호출하는 경우</h3>
	<div>Controller에서 Model 객체를 매개변수로 사용하기 때문에, 여러 가지 데이터를 출력할 수 있다.</div>
	<div>html에서 form으로 전송한 데이터는 param객체에 담겨져있기 때문에 불러올 수 있다.</div>
	
	<h3>Get으로 호출하는 경우</h3>
	<div>매개변수가 아무것도 없기 때문에, Controller에서 전달해주는 데이터는 따로 없다.</div>
	<div>html에서 form으로 전송한 데이터는 param객체에 담겨져있기 때문에 불러올 수 있다.</div>
	
	<ul>
		<li>문자열 출력 - 1 : 큰따옴표 가능 -> ${ "test" } </li>
		<li>문자열 출력 - 2 : 작은따옴표 가능 -> ${ 'test' } </li>
		<li>숫자 출력 : 그냥 출력하면 된다. ${ 3.141592 } </li>
		<li>논리값 출력 : 그냥 출력하면 된다. ${ true } </li>
		<li>null 객체 출력 : ${ null } </li>
		<li>list출력(myList[1]) : ${ myList[1] } </li>
		<li>JavaBean(VO) : ${ myUser.userName } <li>
		<li>Map : ${ myName } </li>
		<li>param객체를 통한 데이터 전달 : ${ param.userName }</li>
		<li>param객체를 통한 데이터 전달 : ${ param.userAge }</li>
		<li>header객체를 통한 데이터 전달 : ${ header.referer }</li>
		<li>뒤로가기 버튼 : <a href=${ header.referer }>뒤로가기</a></li>
		<br>
		
		<li>산술연산(+, -, *, /, %) 사용하기 : ${ param.userAge + 50 } </li>
		<li>논리연산(&&, ||, !) 사용하기 : ${ !false } </li>
		<li>비교연산(==, !=, 비교연산자들) 사용하기 : ${ param.userAge < 20 } </li>
		<li>삼항연산(논리 ? a : b) 사용하기 : ${ param.userAge < 20 ? "(참)미성년자" : '(거짓)성인' } </li>
		<li>empty 연산  사용하기 : 공백 문자열 "" -> ${ empty "" } </li>
		<li>empty 연산  사용하기 : 문자열 "abcd"-> ${ empty "abcd" } </li>
		<li>empty 연산  사용하기 : null -> ${ empty null } </li>
		<li>empty 연산  사용하기 : 리스트 데이터 myList(2개 있을 때) -> ${ empty myList } </li>
	</ul>
	<br>
	
</body>
</html>