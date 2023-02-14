# Anonymous Board 개발 과정

## 기본 틀 구성하기

* 프로젝트 생성 <br>
context root : AnonymousBoard

* Convert to Maven Project <br>
Group Id : ServletProject <br>
Artifact Id : AnonymousBoard

* Maven repository 사이트에서 관련 자료 가져오기 <br>
pom.xml	->	dependencies 등록
	- tomcat-servlet-api
	- mysql-connector-java
	- mybatis





## 파일 별 정보

* Java Resources - src/main/java (java)
	> 모든 controller 특징
		- type : 전부 Servlet으로 구현함.
		- URL mappings : 클래스 이름에서 Servlet만 지움
		
	- common
		- LoginServlet.java
		- LogoutServlet.java
		
	- common.mybatis
		- MyBatisConnectionFactory.java
		
	- board.controller
		- ArticleDetailsCallServlet.java
		- DelArticleCallServlet.java
		- EditArticleCallServlet.java
		- EditArticleResultServlet.java
		- NewArticleCallServlet.java
		- NewArticleResultServlet.java
			
	- comment.controller
		- DelCommentCallServlet.java
		- EditCommentCallServlet.java
		- EditCommentResultServlet.java

	- member.service
		- MemberService
		
	- member.dao
		- MemberDao.java
		
	- member.vo
		- Member.java



* Java Resources - resources (xml, properties)
	- driver.properties <br>
		DB 연결 기본 정보
		
	- SqlMapConfig.xml <br>
		DB 연결 세부 설정
		
	- sqlmap
		Member.xml



* src - /main/webapp (html, jsp 파일)
	- login.html <br>
		첫 화면
		
	- allArticlesView.jsp <br>
		전체 게시글 보기
		
	- articleDetails.jsp <br>
		글 세부 내용 보기





## 남은 할 일
- [x] 로그인 화면 작성
- [x] 로그인 후 servlet으로 html 페이지 만들어보기
- [x] DB를 통해서 로그인 성공하기
- [x] 로그인 성공 여부에 따라 출력 페이지 다르게 하기 - RequestDispatcher
- [x] .jsp 파일로 화면 출력하기
- [x] 기본 story board 그리기
- [x] 기본 View 전환 완성하기
- [ ] 클래스 다이어그램? 그리기





## 미완료 세부 작업
- [x] login.html에서 테이블 가운데정렬 -> style="margin: center" 으로 정렬 가능
- [ ] mapper.xml에서 resultMap 기능 적용해보기
- [ ] transaction 실행 단위 구분짓기
- [ ] hidden으로 페이지마다 primary key 정보 꾸준히 전달하기
- [ ] DAO에서 select() 구문 범용성있게 만들기





## 발생한 오류
* 412 error
>브라우저를 포함한, 사용자 설정 전반적으로 문제를 야기시킬 가능성이 있다.   
내 경우, 브라우저를 전부 닫았다가 다시 켜니 해결됐다.(시크릿 모드라서 캐시가 모두 삭제됨)

* .jsp 에서 변수 출력할 때 띄어쓰기 반영 안 되는 경우
>html의 속성값은 기본적으로 모두 "" 로 감싸야한다. 그래야 공백도 포함시킨다.
그렇지 않으면 공백 전까지만 포함시킨다.




## 의문사항
* .jsp에서는 session, request를 통해서 데이터를 전달할 수 있다. 그럼 html에서는 데이터를 전달하는 방법이 없을까?<br>
> 없다. 기본적으로 html은 정적 resource다. 정해진 화면을 출력하는 용도로 사용된다.
입력된 값에 따라 화면이 달라지는 것을 보기 위해서는 동적 resource인 servlet이나 jsp를 활용해야 한다.

* response는 request처럼 데이터 전달 못 하나?
> 의미가 없다. 애초에 request는 처리할 데이터를 입력받아야 하기 때문에 입력을 받는 것이다. 굳이 response에 화면이 아닌 추가적인 데이터를 전달할 필요가 없다.

* id에 실명 거론. 필수인가?
> 필수 아니다. 로그인 멤버와 그에 따른 CRUD 기능만 정상적으로 동작하면 상관없다.

