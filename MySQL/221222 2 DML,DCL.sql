
-- INSERT 구문
-- 테이블 안에 데이터를 삽입하기 위한 SQL 구문(DML)

USE sqldb;

-- DDL을 이용해서 테이블 하나 생성하기
-- DDL 은 TRANSACTION을 적용할 수 없다.
CREATE TABLE testtbl1 (
	id			INT, -- int : 정수형 데이터타입. 그리고 constraint 제약사항 안 넣었음.
    username	CHAR(3),	-- 연산을 많이 하게 되면 CHAR, 연산 많이 안 하고 많은 데이터를 다뤄야 할 때는 VARCHAR 가 유리하다.
    age			INT
);

-- 가장 일반적인 데이터 삽입하는 INSERT 구문
INSERT INTO testtbl1
VALUES (1, '홍길동', 20); -- VALUES : 어떤 값을 넣어줄 지 지정해주는 키워드

-- NULL을 포함한 데이터 삽입하는 방법
INSERT INTO testtbl1(id, age)
VALUES (2, 30);

INSERT INTO testtbl1(username, age, id)
VALUES ('최길동', 40, 3);

SELECT * FROM testtbl1;

-- 이번에는 TABLE을 약간 색다르게 만들어보자.
CREATE TABLE testtbl2 (
	id			INT		AUTO_INCREMENT	PRIMARY KEY,
    -- auto_increment : row가 생길 때마다 숫자가 자동으로 증가하게 해주는 옵션. 숫자에만 적용 가능하다.
					-- 그리고 일반적으로는 primary key가 따라 나온다.
	username	CHAR(3),
					-- CHAR(3) : 한글도 3글자, 영문도 3글자. 이거 말고 nchar 라는 것도 있음.
	age			INT
);

INSERT INTO testtbl2
VALUES (NULL, '홍길동', 20); -- id 에 AUTO_INCREMENT 설정해줬으니까, 자동으로 입력되게 된다.

INSERT INTO testtbl2
VALUES (NULL, '최길동', 30);

-- AUTO_INCREMENT 는 기본적으로 1부터 시작해서 1씩 증가한다. 그런데 시작값과 증가되는 값을 변경할 수 있다.
-- 물론, 변경하는 경우는 거의 없다.

SELECT * FROM testtbl2;

-- 여기까지가 INSERT 내용이다.

-- UPDATE 구문
-- 데이터를 수정할 때 사용.
UPDATE testtbl2
SET username = '홍길동'
WHERE age = 30;

-- DELETE 구문
-- 데이터를 삭제할 때 사용. DROP은 테이블 자체를 지우는 거고, DELETE는 데이터 일부를 지우는 것.
START TRANSACTION;

-- DELETE FROM testtbl2; -- 테이블 안에 있는 모든 데이터 삭제
DELETE
FROM testtbl2
WHERE age = 30; -- age가 30인 row 삭제

ROLLBACK;

-- 삭제와 관련된 키워드 3가지
-- DELETE : 테이블에서 row를 삭제할 때 사용. transaction log를 기록한다. 그래서 시간이 오래 걸린다.
-- DROP : 테이블 자체를 삭제
-- TRUNCATE : 테이블에서 row를 삭제한다. transaction log를 기록하지 않는다. 그래서 속도가 빠르다.


-- ---------------------------------------------------

-- SQL 형변환
-- buytbl에서

SELECT AVG(amount) AS '평균 구매 개수'
FROM buytbl;

-- CAST()
-- 실수를 정수로 변환하자.
-- 실수 -> 정수 형변환 시 반올림이 기본으로 되어 있다.
SELECT CAST(AVG(amount) AS UNSIGNED INTEGER) AS '평균 구매 개수'
FROM buytbl;

-- 날짜 다루기
-- 다양한 구분자로 되어 있는 날짜를 날짜 형식으로 바꾸어 보자.
-- 지금까지는 'SELECT 컬럼 FROM 테이블' 방식으로 썼는데, SELECT는 다른 방식으로도 쓸 수 있다.
SELECT '홍길동'; -- 어찌됐든 데이터를 가져와서, 결과 집합으로 표현해주는 것이 바로 SELECT다.
SELECT CAST('2022/12/22' AS DATE); -- '2022-12-22' 출력됨. 문자열이 아니라 날짜 형태로 출력이 된다.
-- 왜 굳이 날짜 형식으로 형변환을 할까?
-- ㄴ> 숫자 데이터로 저장이 되면서, 연산을 하기가 편하기 때문

-- CONCAT()
-- 문자열을 연결한다. 많이 사용한다.
SELECT num,
	CONCAT('price', '*', 'amount') AS '계산식',
	price * amount
FROM buytbl;

SELECT num,
	CONCAT(CAST(price AS CHAR(6)), '*', CAST(amount AS CHAR(4))) AS '단가 * 수량',
	price * amount AS '구매액'
FROM buytbl;

-- MySQL(SQL)은 묵시적 형 변환이 좀 특이하다. 이거를 다 외우기는 힘들다.
-- 그냥 한 번 훑어보면서 이상하다는 것만 기억하고 있자.
SELECT '100' + '200'; -- 300 출력. +는 무조건 숫자 더하는 연산인거야. 그래서 앞뒤를 숫자로 바꿔버려.
SELECT 'Hello' + 'World'; -- 자동으로 concatenate 될까? 아냐 안 돼. 앞뒤가 숫자가 아니니 그냥 0으로 취급한다.
SELECT 'Hello' + '35World';
SELECT CONCAT('Hello', 'World'); -- HelloWorld
SELECT CONCAT(100, '200'); -- 100200

SELECT 1 > '2hoho'; -- 0 (false를 의미)
SELECT 1 > '0hoho'; -- 1 (true를 의미)
SELECT 0 = 'Hello'; -- 1

-- ---------------------------------------------------------

-- 기본 연산에 대해서 알아보았어요. => '+'

-- 제공되는 함수
-- 굉장히 많은 함수들이 MySQL에 의해 제공된다. 외울 필요는 없다.
-- 그래도 기본 함수는 알아두자. 문자열 관련 함수들은 많이 사용된다.

-- 문자열 관련 함수
-- LENGTH() : 문자열을 저장하는 데 필요한 공간의 크기 리턴
SELECT LENGTH('abcde'); -- 5
SELECT LENGTH('홍길동'); -- 9. 한글은 한 글자를 저장하는 데 3bytes 가 필요하다. 유니코드.

-- CHAR_LENGTH() : 문자열의 길이를 리턴
SELECT CHAR_LENGTH('abcde');
SELECT CHAR_LENGTH('홍길동');

-- CONCAT() : 문자열 연결하기
-- CONCAT_WS() : 연결자를 문자들 사이사이에 넣어준다. 맨 앞이 연결자
SELECT CONCAT('Hello', 'World');
SELECT CONCAT_WS('-', 'Hello', 'World', 'hahaha');

-- INSTR() : 기준 문자열에서 찾고자하는 문자열의 시작위치 리턴
SELECT INSTR('이것은 소리없는 아우성!!', '소리'); -- 5. DBMS 표준은 점자가 1부터 시작한다.
SELECT INSTR('이것은 소리없는 아우성!!', '박수'); -- 0. 못 찾으면 0

-- FORMAT()
-- 숫자를 소숫점 아래 자릿수까지 표현하는 방법. 3자리마다 콤마를 찍어준다.
SELECT FORMAT(12345678.14159265358979, 4); -- 5번째 자리에서 반올림

-- ROUND() : 반올림
SELECT ROUND(3.141592);

-- CURDATE() : 시스템 현재 날짜
SELECT CURDATE();

-- NOW() : 날짜, 시분초
SELECT NOW();

-- YEAR(), MONTH(), DAY()
SELECT YEAR(CURDATE()); -- 2022
SELECT YEAR(NOW()); -- 2022
SELECT MONTH(NOW()); -- 12
SELECT DAY(NOW()); -- 22
SELECT MONTH('2022/12/22'); -- 12

-- ADDDATE() : 날짜 더해주는 연산. 윤년, 윤달 다 계산해준다.
SELECT ADDDATE('2022/12/22', INTERVAL 2 MONTH); -- 2023-02-22
SELECT ADDDATE('2022/10/31', INTERVAL 4 MONTH); -- 2023-02-28

-- 그 외 함수들은 문제 풀면서 직접 찾아보자.

-- Join
SELECT * FROM buytbl;
SELECT * FROM (usertbl
	INNER JOIN buytbl);
    -- 일반적으로 join 한다고 하면, 기본이 INNER JOIN 이다.
    -- 괄호 안 쳐도, inner join을 먼저 실행한 뒤 그 결과를 from이 가져간다.
SELECT * FROM usertbl
	INNER JOIN buytbl
    ON usertbl.userID = buytbl.userID;

-- 만약 동일한 이름의 column이 존재하는데 select하고자 한다면?
-- ㄴ> ambiguous 오류. 모호한 거지.
SELECT userID, name FROM usertbl
	INNER JOIN buytbl
    ON usertbl.userID = buytbl.userID;

-- 해결책. 테이블을 명시해주기
SELECT usertbl.userID, name FROM usertbl
	INNER JOIN buytbl
    ON usertbl.userID = buytbl.userID;

SELECT usertbl.userID, name FROM usertbl U
	INNER JOIN buytbl B
    ON U.userID = B.userID;

-- 물품을 한 번이라도 구매한 기록이 있는 회원들에게 감사의 안내문을 보내자.
-- Q. 물품을 한 번이라도 구매한 사람의 이름과 주소를 출력하세요.
SELECT DISTINCT name, addr
FROM usertbl U
	INNER JOIN buytbl B
    ON U.userID = B.userID;

-- 위 방식은 JOIN 을 이용한 방식이다.
-- 이거를 SubQuery 를 이용해서 할 수도 있다. 더 좋을 수도 있음.
-- EXISTS()를 활용해서 서브 퀘리의 결과 안에 존재하는 것들만 가져오기
SELECT U.userID, U.name, U.addr
FROM usertbl U
WHERE EXISTS(
	SELECT *
    FROM buytbl B
    WHERE U.userID = B.userID);

-- Script를 만들어서 주심. 이거 실행시켜서 테이블과 데이터를 생성하고, 문제 해결해보기.

-- Q. 학생을 기준으로 학생이름, 지역, 가입한 동아리, 동아리방을 출력하세요.
-- stdName, addr, clubName, roomNo
SELECT S.stdname, s.addr, SC.clubname, C.roomno
FROM stdtbl S
	INNER JOIN stdclubtbl SC
    ON S.stdname = SC.stdname
    INNER JOIN clubtbl C -- 테이블이 여러 개 있으면, 두 개씩 순차적으로 작업해나가도 된다.
    ON SC.clubname = C.clubname;

-- INNER JOIN 에 대해서 알아보았어요.

-- Q. 전체 회원의 구매기록을 조사하세요. 단, 구매 기록이 없는 회원도 출력되어야 합니다.
-- OUTER JOIN 이용하면 편하다.
SELECT *
FROM usertbl U
	LEFT OUTER JOIN buytbl B
    ON U.userid = B.userid;

-- Q. 한 번도 구매한 적이 없는 회원의 이름과 주소를 출력하세요.
-- 모든 사용자의 구매 목록을 구한 다음, 그 중 구매한 제품이 없는 사람을 뽑아내면 되겠네!
SELECT *
FROM usertbl U
	LEFT OUTER JOIN buytbl B
    ON U.userid = B.userid
-- WHERE B.prodName = null -- 이거 아니야
WHERE B.prodName IS NULL;

-- -------------------------------------------------------------------

-- UNION. 합집합
-- 테이블을 합칠 수 있어.
-- 전체 결과 집합 구조는 위쪽에 있는 결과 집합의 구조를 따라간다.
-- 위쪽 결과집합의 컬럼 수와 아래쪽 결과집합의 컬럼 수가 같아야 한다.
-- 위쪽 결과집합의 데이터 타입과 아래쪽 결과집합의 데이터 타입이 같아야 한다. (컬럼 이름같은 건 상관없다.)
-- UNION(중복 배제), UNION ALL(중복 허용. 무조건 다 붙이기)
(SELECT name, height
FROM usertbl
WHERE height > 180)
UNION
(SELECT userid, price
FROM buytbl
WHERE price > 500);

-- Q. 모든 사용자를 조회하는데 전화가 없는 사람을 제외하고 출력하세요.
SELECT name, CONCAT_WS('-', mobile1, mobile2)
FROM usertbl
WHERE mobile1 IS NOT NULL;

