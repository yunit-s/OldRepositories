# Anonymous Board Project

# Database 생성
CREATE SCHEMA proj_anonymous_board;
USE proj_anonymous_board;





# 사용자 테이블 members 생성
CREATE TABLE members (
	memberId		varchar(10) NOT NULL PRIMARY KEY,
    memberPw		varchar(20) NOT NULL,
    memberName	varchar(20) NOT NULL
);
# drop table boards; #테이블 삭제

# 데이터 추가
insert into members values('seo', '1234', '서강준');
insert into members values('son', '1234', '손석구');

select * from members;





# 게시글 테이블 boards 생성
CREATE TABLE boards (
	boardNum		INTEGER NOT NULL PRIMARY KEY auto_increment,
    boardAuthor	VARCHAR(10),
    boardTitle		VARCHAR(40) NOT NULL,
    boardContent	VARCHAR(100),
    boardDate		DATETIME DEFAULT NOW(),
    boardLike INTEGER DEFAULT 0,
    FOREIGN KEY (boardAuthor) REFERENCES members(memberId) #MEMBERS의 memberId 와 같아야해.
);
drop table boards;

# 데이터 추가
INSERT INTO boards(boardAuthor, boardTitle, boardContent) values('seo', '플스 팔아요!', '싸게 팔아요.. 네고 사절!'); # 나머지 colomn 데이터는 알아서 들어간다.
INSERT INTO boards(boardAuthor, boardTitle, boardContent) values('son', '핸드폰 팔아요!', '5만원에 팔아요!');
# 새 데이터 추가할 때 주의점 - foreign key로 등록된 members의 memberId에 존재하는 데이터가 아니면 오류 발생
# 		오류 내용 : Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails.

select * from boards;
SELECT boardNum, boardAuthor, boardTitle, boardContent, boardDate, boardLike FROM boards;
