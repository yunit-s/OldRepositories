<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>testController08.jsp 출력</h1>
	<h3>EL에 대해서 알아보아요!</h3>
	<div>html에서 입력하면, </div>
	
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
		
		<li>산술연산(+, -, *, /, %) 사용하기 : ${ param.userAge + 50 } </li>
		<li>논리연산(&&, ||, !) 사용하기 : ${ !false } </li>
		<li>비교연산(==, !=, 비교연산자들) 사용하기 : ${ param.userAge < 20 } </li>
		<li>삼항연산(논리 ? a : b) 사용하기 : ${ param.userAge < 20 ? "(참)미성년자" : '(거짓)성인' } </li>
		<li>empty 연산  사용하기 : 공백 문자열 "" -> ${ empty "" } </li>
		<li>empty 연산  사용하기 : 문자열 "abcd"-> ${ empty "abcd" } </li>
		<li>empty 연산  사용하기 : null -> ${ empty null } </li>
		<li>empty 연산  사용하기 : 리스트 데이터 myList(2개 있을 때) -> ${ empty myList } </li>
		
	</ul>
	
	
	
</body>
</html>