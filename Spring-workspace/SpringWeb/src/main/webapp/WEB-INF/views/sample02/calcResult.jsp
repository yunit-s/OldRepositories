<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>연산 성공!</h1>
	<div>clacResult.jsp 출력</div>
	
	<!--
	EL 검색 순서
		pageScope -> requestScope -> sessionScope -> applicationScope
	pageContext
		jsp가 가지는 기본 객체
		이 데이터의 유효 범위는 이 .jsp 페이지 뿐. 가장 작은 단위다.
	-->
	<% pageContext.setAttribute("msg", "pageContext에 저장한 데이터"); %>
	<br>
	<div>request.getAttribute("msg") 의 결과 : <%= request.getAttribute("msg") %></div>
	<div>$ { msg } 의 결과 : ${ msg }</div>
	<div>$ { param.msg } 의 결과 : ${ param.msg }</div>
	<div>ㄴ> param 은 client가 보내는 request 파라미터다. client에서 보내는 데이터가 아예 없기 때문에 찍히는 게 없다.</div>
	<div>$ { param.firstNum } 의 결과 : ${ param.firstNum }</div>
	<div>ㄴ> 이건 잘 출력된다. 왜?</div>
	<div>$ { pageScope.msg } 의 결과 : ${ pageScope.msg }</div>
	<div>ㄴ> 출력 안 된다.</div>
	<div>$ { requestScope.msg } 의 결과 : ${ requestScope.msg }</div>
	<div>ㄴ> 정상 출력됨</div>
	
	<% pageContext.setAttribute("myData", "pageContext에 저장한 데이터"); %>
	<br><br>
	<a href="${ header.referer }">뒤로가기</a>

</body>
</html>