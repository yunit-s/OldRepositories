-- USE employees; -- 이 database를 사용하겠다는 뜻
USE shopdb;

SELECT * -- 테이블에 있는 모든 컬럼 가져오기
FROM memberTBL;

-- View를 만들어보자
CREATE VIEW v_memberTBL
AS
	SELECT memberID, memberName
    FROM memberTBL;

SELECT *
FROM v_membertbl;

-- 구분자 DELIMITER //
-- 구분자를 // 로 바꾼다.
DELIMITER //
CREATE PROCEDURE myCall()
BEGIN
	SELECT memberName
    FROM memberTBL
    WHERE memberID = 'hong';
    
    SELECT memberName
    FROM memberTBL
    WHERE memberID = 'shin';
END //
DELIMITER ; -- 구분자를 다시 ; 으로 바꾼다.

CALL myCall();

SELECT *
FROM membertbl;

-- ---------------------------------------------------

-- 임시 테이블을 하나 만들어보자.
-- memberTBL에서 회원이 삭제되면 삭제된 회원정보를 다른 테이블에 저장해 놓는다.

CREATE TABLE deleteMemberTBL (
	-- 컬럼명		데이터타입		제약사항,
    memberID	CHAR(8)		PRIMARY KEY,
    memberName	CHAR(4)		NOT NULL,
    memberAddr	VARCHAR(20)
);

DELIMITER //
CREATE TRIGGER trg_memberTBL
	AFTER DELETE -- 언제 동작할지를 지정. 지워진 뒤
	ON memberTBL -- 이 테이블에서
    FOR EACH ROW -- 행 하나하나 지워질 때마다
BEGIN
	-- 실제 트리거가 해야할 일
    INSERT INTO deleteMemberTBL VALUES(
		OLD.memberID, OLD.memberName, OLD.memberAddr -- OLD : 지워진 그 행
    );
END //
DELIMITER ;

-- 이번엔 행을 지워보자
DELETE
FROM memberTBL
WHERE memberID = 'hong';

SELECT *
FROM memberTBL;

SELECT *
FROM deleteMemberTBL;
