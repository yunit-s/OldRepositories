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
	<div>sample02/calcResult.jsp 출력</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/resources/sample02/calcForm.html</div>
	<div>CalcController.java 를 통해서 접근</div>
	<br>
	
	<!--
	EL 검색 순서
		pageScope -> requestScope -> sessionScope -> applicationScope
	pageContext
		jsp가 가지는 기본 객체
		이 데이터의 유효 범위는 이 .jsp 페이지 뿐. 가장 작은 단위다.
	-->
	<% pageContext.setAttribute("msg", "pageContext에 저장한 msg"); %>
	<br>
	<h3>param 객체 데이터 접근하기</h3>
	<div>$ { param.msg } 의 결과 : ${ param.msg }</div>
	<div>- 출력 없음. param 은 client가 보내는 request 파라미터다. client에서 보내는 데이터가 아예 없기 때문에 찍히는 게 없음.</div>
	<br>
	<div>$ { param.firstNum } 의 결과 : ${ param.firstNum }</div>
	<div>- 이건 잘 출력된다. calcForm.html 에서 key값이 firstNum 인 데이터를 전송해서 그 데이터가 request 객체에 저장되었기 때문</div>
	<br>
	
	<h3>우선적으로 선택되는 Scope 실험</h3>
	<div>request.getAttribute("msg") 의 결과 : <%= request.getAttribute("msg") %></div>
	<div>- request객체를 직접적으로 언급했기 때문에 pageScope를 거치지 않는다.</div>
	<br>
	<div>$ { msg } 의 결과 : ${ msg }</div>
	<div>- 제일 작은 단계인 pageScope에서 찾음</div>
	<br>
	<div>$ { pageScope.msg } 의 결과 : ${ pageScope.msg }</div>
	<div>- pageScope 직접 명시</div>
	<br>
	<div>$ { requestScope.msg } 의 결과 : ${ requestScope.msg }</div>
	<div>- requestScope 직접 명시. ModelAndView.addObject()를 통해 저장한 데이터는 requestScope에 저장되게 된다.</div>
	<br>
	<div>$ { myData } 의 결과 : ${ myData }</div>
	<div>- 출력 안 됨. 코드를 위에서부터 실행하기 때문에 정의가 안 된 상태인 듯...</div>
	<br>
	<% pageContext.setAttribute("myData", "pageContext에 저장한 myData"); %>
	<div>$ { myData } 의 결과 : ${ myData }</div>
	<div>- 정상 출력. pageContext에 myData라는 데이터를 저장했기 때문</div>
	<br>
	<% request.setAttribute("myRequestData", "jsp에서 request객체에 저장한 myRequestData"); %>
	<div>$ { myRequestData } 의 결과 : ${ myRequestData }</div>
	<div>- 정상 출력. pageScope에는 저장된 게 없고, 그 다음 scope인 requestScope에서 찾은 듯</div>
	<br><br>
	
	<a href="${ header.referer }">뒤로가기</a>

</body>
</html>