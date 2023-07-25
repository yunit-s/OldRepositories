<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>* 접속 url : http://127.0.0.1:8080/example/login_jsp.jsp</div>
	<div>이 부분을 servlet 코드로 바꾸면, 한 줄 한 줄이 out.println() 으로 변환된다.</div>
	<br><br>
	
	<div>* Scriptlet %</div>
	
	<%
		// 1. 입력받기
		// 2. 로직처리
		//		여기에 MyBatis 처리코드가 나온다.
		// 3. 출력은 HTML에 끼워넣기
	%>
	
	<%
		String name = "홍길동"; // method 내에서 선언된 거니까 지역변수 취급
			// 이게 왜 메소드 취급??
		for (int i = 0; i < 5; i++) {
	%>
		<h1>for()에 걸려서 이 부분이 반복된다. out.println()이 반복적으로 찍힌다는 뜻.</h1>
	<%
		}
	%>
	
	사용자의 이름은 : <%= name %> 입니다.
	
</body>
</html>