-- SQL Exercise 01(221222)

USE exercisesqldb;

SHOW TABLE STATUS;
DESC course1;
DESC course2;
DESC dept;
DESC emp;
DESC locations;
DESC salgrade;
SELECT * FROM course1;
SELECT * FROM course2;
SELECT * FROM dept;
SELECT * FROM emp;
SELECT * FROM locations;
SELECT * FROM salgrade;

-- 1번
SELECT job AS '직무', (FLOOR(AVG(sal) / 100) * 100) AS '급여 평균' FROM emp WHERE DEPTNO = 30 GROUP BY job;

-- 2번
SELECT dname AS '부서명', COUNT(E.deptno) AS '직원 수' FROM dept D
	INNER JOIN emp E ON D.deptno = E.deptno
    GROUP BY E.deptno HAVING COUNT(E.deptno) >= 4;
-- GROUP 안 하고는 못 하나?

-- 3번
-- UNION
(SELECT job AS '직무명', FORMAT(SUM(sal), 0) AS '급여의 합' FROM emp GROUP BY job ORDER BY job)
UNION
(SELECT 'TOTAL', FORMAT(SUM(sal), 0) FROM emp);
-- 왜 정렬이 안 되지??????????????????????????????????????????????????????????????

-- 4번
SELECT ename AS '직원명', E.sal AS '급여', grade AS '급혀 등급' FROM emp E
    INNER JOIN salgrade S ON E.sal BETWEEN S.losal AND S.hisal
	WHERE E.sal = (SELECT MAX(sal) FROM emp);

-- 5번
-- IFNULL()
SELECT ename AS '직원명', CONCAT(FORMAT(SAL+IFNULL(COMM, 0), 0), '원') AS 급여 FROM EMP
	ORDER BY SAL+IFNULL(COMM, 0) DESC;

-- 6번
-- CASE문, LPAD()
SELECT ename AS '직원명',
	CONCAT(YEAR(hiredate), '년 ', LPAD(MONTH(hiredate), 2, 0), '월 ', DAY(hiredate), '일') AS '입사년월일',
    CASE
		WHEN (YEAR(hiredate) = 1980) THEN 'A'
		WHEN (YEAR(hiredate) = 1981) THEN 'B'
		WHEN (YEAR(hiredate) = 1982) THEN 'C'
		WHEN (YEAR(hiredate) = 1983) THEN 'D'
	END AS '그룹'
	FROM emp;

-- 7번
SELECT E1.empno AS '사원 사번', E1.ename AS '사원 이름', E1.mgr AS '관리자 사번', E2.ename AS '관리자 이름' FROM emp E1
    INNER JOIN emp E2 ON E1.mgr = E2.empno;

-- 8번
-- 2중 서브쿼리
select * from emp;
select * from locations;
select * from dept;
SELECT empno, ename, deptno FROM emp
    WHERE DEPTNO = (
		SELECT deptno FROM dept WHERE LOC_CODE = (
			SELECT loc_code FROM locations WHERE CITY = 'CHICAGO'));

-- 9번
select * from emp;
select * from emp where deptno = 30;
SELECT ename, sal FROM emp WHERE sal > ALL(
	SELECT sal FROM emp WHERE deptno = 30);

