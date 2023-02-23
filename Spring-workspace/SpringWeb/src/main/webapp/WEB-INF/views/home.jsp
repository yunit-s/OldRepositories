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

<div> 접속 url </div>
<div> http://localhost:8080/SpringWeb/ </div>

<P>  The time on the server is ${serverTime}. </P>
<p>여기서 '$ {}' 이 표현은 EL 방식을 사용하는 것이다.</p>
<P>  request.getAttribute() 로 model에 저장된 값 불러오기 : <%= request.getAttribute("serverTime") %>. </P>
<P>  request.getAttribute() 로 request에 저장된 값 불러오기 : <%= request.getAttribute("attr_key") %>. </P>

</body>
</html>
