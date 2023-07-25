
USE sqldb;

-- 트랜잭션 시작
-- 실제 자바 프로그램에서 사용하는 방법은 아니다.
START TRANSACTION;

SELECT *
FROM usertbl;

DELETE
FROM usertbl; -- 실행은 하지마.. 데이터 다 지워져 ㅋㅋ

ROLLBACK;
-- COMMIT or ROLLBACK 이 나오면 트랜잭션 설정 종료.
-- COMMIT : 위에서 작업한 SQL 구문을 정말로 적용하는 것
-- ROLLBACK : 트랜잭션으로 설정된 작업을 무시한다. atomicity 특성

SELECT *
FROM usertbl;
SELECT *
FROM buytbl;
