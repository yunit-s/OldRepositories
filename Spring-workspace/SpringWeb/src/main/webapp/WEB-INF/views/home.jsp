<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<div>home.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>- url</div>
	<div>http://localhost:8080/SpringWeb/</div>
	<div>- HomeController.java 를 통해서 접근</div>
	
	<br><br>
	<h3>  The time on the server is ${serverTime}. </h3>
	<div>  여기서 '$ {}' 이 표현은 EL 방식을 사용하는 것이다.</div>
	<div>  request.getAttribute() 로 model에 저장된 값 불러오기 : <%= request.getAttribute("serverTime") %>. </div>
	<div>  request.getAttribute() 로 request에 저장된 값 불러오기 : <%= request.getAttribute("attr_key") %>. </div>

</body>
</html>
