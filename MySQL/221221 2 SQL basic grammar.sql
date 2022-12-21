
-- 제일 처음은 사용할 데이터베이스 지정하기
-- USE : 사용할 데이터베이스 지정하기
USE employees;

-- SQL은 대소문자를 구분하지 않는다.
-- 하지만 가독성(Readability)을 위해서, 키워드는 대문자, 사용자 정의어는 소문자로 사용한다.

-- 데이터베이스 조회
SHOW DATABASES; -- 현재 접속한 사용자 계정의 권한으로 접근할 수 있는 데이터베이스만 보여줌.

-- 테이블의 상태 조회
SHOW TABLE STATUS; -- 현재 접근 중인 DB의 테이블들 상태를 확인한다.

-- 특정 테이블 명세 조회(Table Inspector의 기능)
DESC departments; -- DESC : describe. 내림차순
DESC employees;


-- SELECT 구문
-- 데이터를 추출하기 위해서 사용
-- SELECT (컬럼명, 컬럼명, ...) TABLE (테이블명)
SELECT first_name, last_name, birth_date
FROM employees;
-- 위 코드를 실행하면, 결과 레코드 집합(혹은 result set, result grid 이라고 한다.)이 리턴된다.
-- 결과물 보면, 이것도 테이블처럼 생겼지? 결국, 얘네도 테이블처럼 활용이 가능해진다. (실제로 테이블은 아니긴 하지)

-- 결과집합의 컬럼명 바꾸기
-- Alias 이용하면 된다.
-- 대체명에 공백이나 특수기호를 넣고 싶을 때는 ' '(single quotation mark)를 활용한다.
SELECT first_name AS '나의 이름',
		last_name AS 성,
		birth_date AS 생년월일
FROM employees;

-- 조건절이 없다면, 당연히 모든 데이터를 가져오게 된다.
-- 만약 원하는 조건이 있다면, 조건절을 이용해야 한다. WHERE 사용.
-- 교수님께서 자료 주심. 12.21_create_schema(prof).sql / 12.21_insert_data(prof).sql
-- 앞 파일로 DB, 테이블 생성, 뒤 파일로 데이터 추가(한글 처리할 때 조심할 것)

-- Q. 이름이 김경호인 사람의 정보를 출력하세요.
-- WHERE
SELECT *
FROM usertbl
WHERE name = '김경호'; -- 키워드로 존재하는 거는 컬럼 명으로 안 쓰는 것이 좋다.

-- Q. 1970년 이후에 출생하고, 신장이 182인 사람의 아이디와 이름을 조회하세요.
-- AND
SELECT userID, name
FROM usertbl
WHERE birthYear >= 1970 AND height >= 182; -- 연산자 우선순위에서 AND 는 낮은 편이라서, 여기서는 굳이 괄호 안 해도 된다.

desc usertbl; -- table 안의 정보를 간략하게 출력

-- Q. 키가 180~183인 사람의 이름과 아아디를 조회하세요.
-- AND 를 사용하는 방법
SELECT userID, name
FROM usertbl
WHERE (height >= 180) AND (height <= 183);
-- BETWEEN 을 사용하는 방법
SELECT userID, name
FROM usertbl
WHERE height BETWEEN 180 AND 183; -- 이상-이하 이기 때문에, 초과-미만에서 사용하는 게 아니다.

-- Q. 지역이 경남, 전남, 경북 인 사람의 이름과 지역을 출력하세요.
-- OR 사용. 기본적인 코드 방식
SELECT name, addr
FROM userTBL
WHERE (addr = '경남') OR (addr = '전남') OR (addr = '경북');
-- IN 연산자 사용. ~~에 포함되는...
SELECT name, addr
FROM userTBL
WHERE addr IN ('경남', '전남', '경북');

-- 패턴 매칭
-- Q. 김씨 성을 가진 사람들의 이름과 키를 조회하자.

-- 와일드카드 문자(두 가지. %, _)
-- % : 0개 이상의 문자열
-- 자바% ( 자바 로 시작하는 모든 문자열 )
-- 자바 , 자바1, 자바어려워요
-- %자바% : 자바 라는 글자가 들어있는 모든 
-- _ : 1개 문자열
-- 자바_ -> 자바킹, 자바왕, 자바원, 자바호, ...

SELECT name, height
FROM usertbl
-- WHERE name = '김%'; -- 이러면 안 돼. 이렇게 표현하면, %는 그냥 특수문자로 읽혀
WHERE name LIKE '김%'; -- 이렇게 써야, 김씨 성을 가진 사람들을 검색하게 된다.

-- Q. 김경호보다 키가 크거나 같은 사람의 이름과 키를 출력하자.
-- 김경호의 키를 찾자.
SELECT height
FROM usertbl
WHERE name = '김경호';
-- 177 을 가지고 데이터를 검색해보자.
SELECT name, height
FROM usertbl
WHERE height >= 177;

-- SubQuery 를 활용해보자.
-- 서브 쿼리의 결과를 주 쿼리에 넘겨주면서 실행하기
SELECT name, height
FROM usertbl
WHERE height >= (SELECT height
				FROM usertbl
				WHERE name = '김경호');

-- Q. 지역이 '경남'인 사람의 키보다 크거나 같은 사람을 조회하세요.
-- ANY : 집합들 중 하나라도 true면 된다.
-- ALL : 집합들 모두와 비교해서 true여야 한다.
SELECT name, height
FROM usertbl
WHERE height >= ALL(SELECT height
				FROM usertbl
				WHERE addr = '경남');

-- 정렬하기. ASC, DESC
-- Q. 먼저 가입한 순서대로 회원이 이름과 가입일을 출력하세요.
SELECT name, mdate
FROM usertbl
ORDER BY mdate DESC; -- 항상 하나의 SQL문에서 맨 마지막에 있어야 한다. 결과에 대한 정렬은 마지막에 이뤄져야 하기 때문

-- 2차 정렬 기준 정하기
-- Q. 회원의 이름과 가입일을 출력하는데, 키가 큰 순서로 정렬하세요.
-- 만약 키가 같으면, 가입일이 빠른 순서로 정렬하세요.
SELECT name, mdate, height
FROM usertbl
ORDER BY height DESC, mdate ASC;

-- 중복 배제하기. DISTINCT
-- Q. 모든 회원들의 거주 지역이 어디인지 출력하세요.
SELECT DISTINCT addr
FROM usertbl;

-- 출력물 수 제한하기. LIMIT
-- Q. 회원가입이 오래된 사람들 3명을 출력하세요.
SELECT * 
FROM usertbl
ORDER BY mdate ASC
LIMIT 3; -- 결과물에서 딱 3줄만 출력하기

-- 테이블을 복사하는 가장 간단한 방법
CREATE TABLE USERTBL2 (
	SELECT *
    FROM usertbl
);
-- 쉽고 간편하게 복사할 순 있지만..
-- 제약사항은 포함이 안 된다. (primary key, foreign key, ...)

-- 여기까지가 기본 SQL SELECT 구문이다. 인간적으로, 쉽다.

-- Grouping

-- Q. 구매 테이블에서 사용자가 구매한 물품의 개수를 출력하세요.
-- 각각의 사용자별로 제품은 상관없이 모두 몇 개를 지금까지 구입했는지 알고 싶어요!
-- SUM() : mysql 이 가지고 있는 함수.
-- GROUP BY 는 집계 함수와 같이 오는 경우가 많다.
SELECT userID, SUM(amount) AS '총 구매 개수'
FROM buytbl
GROUP BY userID; -- 사용자별로 그룹화하기

-- Alias 응용하기
-- Q. 각 사용자별 구매액의 총합을 구하고, 구매액이 큰 순서로 출력하세요.
SELECT userID, SUM(price * amount) AS total
FROM buytbl
GROUP BY userID
ORDER BY total DESC;

-- AVG() : 평균값
-- Q. 우리 사이트에서 한 사람이 평균적으로 몇 개를 구매했나요?
SELECT AVG(amount)
FROM buytbl;

-- MAX(), MIN()
-- Q. usertbl에서 가장 큰 키와 가장 작은 키의 회원 이름과 키를 출력하세요.
-- (이거는 그룹핑 아니다. 서브 쿼리 이용하는 문제다.)
SELECT userID, height
FROM buytbl
WHERE height = MAX(height);

-- COUNT() : 몇 개 있는지 세어준다. NULL 은 세지 않는다.
-- Q. usertbl에서 휴대폰이 있는 사용자의 수를 출력하세요.
SELECT COUNT(userID)
FROM usertbl;

-- HAVING절
-- Q. 사용자별 총 구매금액이 1,000 이상인 사용자의 ID와 구매 금액을 출력하세요.
SELECT userID, SUM(price * amount) AS total
FROM buytbl
-- WHERE total >= 1000
GROUP BY userID
HAVING total >= 1000; -- 그룹에 대한 조건은 WHERE 절이 아니라, HAVING 절을 사용한다.

-- 기본적인 SQL구문의 순서
-- SELECT (무조건)
-- FROM (웬만하면 거의 무조건)
-- WHERE (조건)
-- GROUP BY (그룹화)
-- HAVING (그룹에 대한 조건)
-- ORDER BY (정렬)

