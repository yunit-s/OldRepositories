<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>sample01/testController07.jsp 실행</h1>
	<div>접근 경로 : http://localhost:8080/SpringWeb/testController07</div>
	
	<div>Model 안에 저장되어 있는 데이터를 들고와서 여기서 출력하려 한다.</div>
	<div>(참고. Model 객체와 request 객체는 다른 객체다.)</div>
	<div>우리가 Model의 데이터를 뽑기 위해서는 EL 이라는 특수한 표기법이 필요하다. script let이나 expression? 이거 안 된다.</div>
	<div>EL 표현법 : $ { }</div>
	<div>(이거 jQuery 아님)</div>
	<div>주의. 이 안에 model 객체에 대한 reference가 필요 없다.</div>
	<div>Model 객체는 request 객체 안에 있는데, 얘가 다른 저장된 데이터에 접근 가능하기 때문이다.</div>
	
	<ul>
		<li>이름 : ${ myName }</li>
		<li>나이 : ${ myAge }</li>
	</ul>
	
	<h1>EL 표현에 대한 주석 방식</h1>
	<div>EL은 html방식 말고 jsp 방식으로 주석표시해야한다.</div>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	<div>이름 :<%-- ${ myName } --%></div> 

</body>
</html>