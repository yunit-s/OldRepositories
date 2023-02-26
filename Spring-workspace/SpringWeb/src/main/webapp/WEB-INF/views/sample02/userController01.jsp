<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Lombok 테스트</h1>
	<div>userController01.jsp 화면</div>
	<h3>접근 방법</h3>
	<div>http://localhost:8080/SpringWeb/userCtr01/callByGet</div>
	<div>UserController01.java 를 통해서 접근</div>
	
	<h3>EL을 활용하여 VO 데이터 잘 가져왔는지 확인하기</h3>
	<div>1. $ { lombokUser.getUserName() } -> ${ lombokUser.getUserName() }</div>
	<div>2. $ { lombokUser.getUserAge() } -> ${ lombokUser.getUserAge() }</div>
	<div>3. $ { lombokUser.getUserDept() } -> ${ lombokUser.getUserDept() }</div>
	<div>4. $ { lombokUser.getUserAddress() } -> ${ lombokUser.getUserAddress() }</div>
	<div>디폴트 생성자함수, getter, setter 모두 정상적으로 입력됐다.</div>
	
	<h3>이번엔 @AllArgsConstructor 로 자동생성된 생성자를 활용해보자.</h3>
	<div>1. $ { lombokUser2.getUserName() } -> ${ lombokUser2.getUserName() }</div>
	<div>2. $ { lombokUser2.getUserAge() } -> ${ lombokUser2.getUserAge() }</div>
	<div>3. $ { lombokUser2.getUserDept() } -> ${ lombokUser2.getUserDept() }</div>
	<div>4. $ { lombokUser2.getUserAddress() } -> ${ lombokUser2.getUserAddress() }</div>
	<div>전체 필드를 초기화하는 생성자함수, getter, setter 모두 정상적으로 입력됐다.</div>
	
	<h3>체크포인트</h3>
	<div>생성자 자동 생성의 경우, @Data만으로는 완벽하지 않은 것 같다.</div>
	<div>@Data 만 사용할 경우, 디폴트 생성자만 활용 가능한 것 같다.</div>
	<div>그렇다고 @AllArgsConstructor 를 사용하게 되면, 디폴트 생성자를 자동으로 생성해주지 않는다.</div>
	<div>따라서 복수의 생성자를 활용하고 싶다면, 각각에 맞는 어노테이션을 활용해야 한다.</div>
	<h3>@RequiredArgsConstructor 에 대해...</h3>
	<div>이건 뭔지 잘 모르겠다. 우선, 전체 필드를 모두 인자로 갖는 생성자는 만들어주지 않는다.</div>
	<div>근데 또 이걸로는 디폴트 생성자는 활용 가능했다.</div>
	
</body>
</html>