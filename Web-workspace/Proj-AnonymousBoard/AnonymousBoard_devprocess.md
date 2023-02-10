# Anonymous Board 개발 과정

## 기본 틀 구성하기

* 프로젝트 생성
context root : AnonymousBoard

* Convert to Maven Project
Group Id : ServletProject
Artifact Id : AnonymousBoard

* Maven repository 사이트에서 관련 자료 가져오기
pom.xml	>	dependencies 등록
	- tomcat-servlet-api
	- mysql-connector-java
	- mybatis

## 파일 별 정보

* Java Resources - src/main/java (java)
	- MainView.java
		package : common
		URL mappings : /mainview


* Java Resources - resources (xml, properties)



* src - /main/webapp (html, jsp 파일)
	- login.html
		첫 화면


## 남은 할 일
v 로그인 화면 작성
로그인 후 나오는 페이지 작성
DB를 통해서 로그인 성공하기

