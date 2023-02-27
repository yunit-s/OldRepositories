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

	<h1>JSTL과 Controller 활용하는 예제</h1>
	<div>.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/jstlExample</div>
	<div>JSTLExampleController.java 를 통해서 접근</div>
	
	<h3>회원 정보 보기</h3>
	<div>member1 버튼으로 호출된 경우, 아래 내용이 자동으로 작성된다.</div>
	<ul>
		<li>이름 : ${ name }</li>
		<li>전화 : ${ phone }</li>
		<li>아이디 : ${ id }</li>
		<li>비밀번호 : ${ password }</li>
	</ul>
	<br>
	
	<h3>이번엔 조건에 따라 출력을 달리해보자.</h3>
	<div>member2 버튼으로 호출된 경우, 아래 내용이 자동으로 작성된다.</div>
	<c:choose>
		<c:when test="${ !empty requestScope.memberVO }">
			<!-- ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ 여기서 empty 뭐지? -->
			<ul>
				<li>memberVO가 존재하는 경우(member2 호출됨)</li>
				<li>이름 : ${ memberVO.name }</li>
				<li>전화 : ${ memberVO.phone }</li>
				<li>아이디 : ${ memberVO.id }</li>
				<li>비밀번호 : ${ memberVO.password }</li>
			</ul>		
		</c:when>
		<c:otherwise>
			<ul>
				<li>memberVO가 존재하지 않는 경우(member1 호출됨)</li>
				<li>이름 : ${ name }</li>
				<li>전화 : ${ phone }</li>
				<li>아이디 : ${ id }</li>
				<li>비밀번호 : ${ password }</li>
			</ul>	
		</c:otherwise>
	</c:choose>
	
	<h3>@ModelAttribute 를 사용해서 자동으로 등록된 데이터 불러오기</h3>
	<div>자동으로 등록되는 곳은 Model 객체다. 따라서 requestScope에서 확인 가능하다.</div>
	<c:choose>
		<c:when test="${ !empty requestScope.member }">
			<ul>
				<li>member가 존재하는 경우(member3 호출됨)</li>
				<li>이름 : ${ memberVO.name }</li>
				<li>전화 : ${ memberVO.phone }</li>
				<li>아이디 : ${ memberVO.id }</li>
				<li>비밀번호 : ${ memberVO.password }</li>
			</ul>		
		</c:when>
		<c:otherwise>
			<ul>
				<li>member가 존재하지 않음</li>
			</ul>	
		</c:otherwise>
	</c:choose>
	
	<h3>@ModelAttribute 를 사용해서 자동으로 등록된 데이터 불러오기 - 데이터 이름 바꾸기</h3>
	<c:choose>
		<c:when test="${ !empty requestScope.mem }">
			<ul>
				<li>mem이 존재하는 경우(member33 호출됨). value 속성으로 Model에 저장된 데이터에 이름을 강제로 지정해줌.</li>
				<li>이름 : ${ mem.name }</li>
				<li>전화 : ${ mem.phone }</li>
				<li>아이디 : ${ mem.id }</li>
				<li>비밀번호 : ${ mem.password }</li>
			</ul>		
		</c:when>
		<c:otherwise>
			<ul>
				<li>mem이 존재하지 않음</li>
			</ul>	
		</c:otherwise>
	</c:choose>
	
	<!-- header가 가지고 있는 referer -->
	<a href="${ header.referer }">뒤로가기</a>

</body>
</html>