-- 새로운 테이블을 하나 만들어서, 아래에서 가져온 데이터를 입력하자.

-- 테이블 만들기
CREATE TABLE indexTBL (
	-- DB명을 명시하지 않았으니, 만약 shopdb를 선택한 상태라면, 그 db 안에 테이블을 생성하겠지
	first_name	VARCHAR(14),
    last_name	VARCHAR(16),
    hire_date	DATE
);

INSERT INTO indexTBL -- 아래 내용을 가져와서 indexTBL에 밀어넣기
	SELECT first_name, last_name, hire_date
	FROM employees.employees
	LIMIT 500; -- 이거 가져올 때 500개만 가져오라는 뜻. MySQL에서만 지원해주는 비표준 구문.

-- 잘 입력됐는지 확인하기
SELECT * -- 모든 컬럼 다 가져오기
FROM indexTBL;

-- 데이터가 들어갔고, 아직 index는 설정하지 않았다.
-- 이 상태에서 특정 사람 검색해보자.
-- first_name 이 Mary 인 사람을 찾아서, 이름과 성, 입사일을 출력해보자.
SELECT first_name, last_name, hire_date
FROM indexTBL
WHERE first_name = 'Mary';

-- index를 생성해보자.
CREATE INDEX idx_indexTBL_firstname
ON indexTBL(first_name);
