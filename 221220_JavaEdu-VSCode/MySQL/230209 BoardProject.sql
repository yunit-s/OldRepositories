# BoardProject

# Make Database Schema
CREATE SCHEMA mydatabase;

USE mydatabase;

# 사용자 데이터 관리 테이블
CREATE TABLE members (
	memberId		varchar(10) NOT NULL PRIMARY KEY,
    memberName	varchar(20) NOT NULL,
    memberPw		varchar(20) NOT NULL
);

select * from members;

insert into members values('hong', '홍길동', '1234');

# 글 관리 테이블
CREATE TABLE boards (
	boardNum		INTEGER NOT NULL PRIMARY KEY auto_increment,
    boardTitle		VARCHAR(40) NOT NULL,
    boardContent	VARCHAR(100),
    boardAuthor	VARCHAR(10),
    boardDate		DATETIME DEFAULT NOW(),
    boardLike INTEGER,
    FOREIGN KEY (boardAuthor) REFERENCES members(memberId) #MEMBERS의 memberId 와 같아야해.
);

# drop table boards;

INSERT INTO boards(boardTitle, boardAuthor, boardContent, boardLike) values('플스 팔아요!', 'hong', '싸게 팔아요.. 네고 사절!', 5); # 나머지 colomn 데이터는 알아서 들어간다.
INSERT INTO boards(boardTitle, boardAuthor, boardContent, boardLike) values('핸드폰 팔아요!', 'hong', '5만원에 팔아요!', 2);

SELECT * FROM boards;

SELECT boardNum, boardTitle, boardContent, boardAuthor, boardDate, boardLike FROM boards;
