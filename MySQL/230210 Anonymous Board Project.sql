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

# 데이터 수정
update members set memberPw='12' where memberId='son';

select * from members;





# 게시글 테이블 boards 생성
CREATE TABLE boards (
	boardNum		INTEGER NOT NULL PRIMARY KEY auto_increment,
    boardTitle		VARCHAR(40) NOT NULL,
    boardAuthor	VARCHAR(10),
    boardContent	VARCHAR(100),
    boardDate		DATETIME DEFAULT NOW(),
    boardLike INTEGER DEFAULT 0,
    FOREIGN KEY (boardAuthor) REFERENCES members(memberId) #MEMBERS의 memberId 와 같아야해.
);
drop table boards;

# 데이터 추가
INSERT INTO boards(boardTitle, boardAuthor, boardContent) values('플스 팔아요!', 'seo', '싸게 팔아요.. 네고 사절!'); # 나머지 colomn 데이터는 알아서 들어간다.
INSERT INTO boards(boardTitle, boardAuthor, boardContent) values('핸드폰 팔아요!', 'son', '5만원에 팔아요!');
INSERT INTO boards(boardTitle, boardAuthor, boardContent) values('지갑 팝니다~~', 'seo', '택포 28만원이고 네고 없습니다.');
INSERT INTO boards(boardNum, boardTitle, boardAuthor, boardContent, boardDate) values('1', '플스 팔아요!', 'seo', '싸게 팔아요.. 네고 사절!', '2023-02-13 10:30:40');
INSERT INTO boards(boardNum, boardTitle, boardAuthor, boardContent, boardDate) values('2', '핸드폰 팔아요!', 'son', '5만원에 팔아요!', '2023-02-13 11:32:41');
INSERT INTO boards(boardNum, boardTitle, boardAuthor, boardContent, boardDate) values('3', '지갑 팝니다~~', 'seo', '택포 28만원이고 네고 없습니다.', '2023-02-14 14:00:40');
# 		새 데이터 추가할 때 주의점 - foreign key로 등록된 members의 memberId에 존재하는 데이터가 아니면 오류 발생
# 		오류 내용 : Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails.

# 데이터 삭제
DELETE FROM boards WHERE boardNum>=4;
delete from boards where boardAuthor is null;
# delete from boards where boardAuthor = null; # 이건 안 되네

# 데이터 수정
UPDATE boards SET boardTitle='asdf', boardContent='34t2t23t' WHERE boardNum=43;

select * from boards;
SELECT boardNum, boardTitle, boardAuthor, boardContent, boardDate, boardLike FROM boards;





# 댓글 테이블 comments 생성
CREATE TABLE comments (
	commentNum		INTEGER NOT NULL PRIMARY KEY auto_increment,
    commentArticleNum		INTEGER NOT NULL,
    commentAuthor	VARCHAR(10) NOT NULL,
    commentContent	VARCHAR(100),
    commentDate		DATETIME DEFAULT NOW(),
    FOREIGN KEY (commentArticleNum) REFERENCES boards(boardNum)
);
drop table comments;

# 데이터 추가
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(1, 'seo', '안 살 건데요?', '2023-02-13 11:10:41');
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(1, 'son', '깎아드릴게요', '2023-02-13 11:13:19');
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(1, 'seo', '안 산다니까요?', '2023-02-14 14:21:30');
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(2, 'seo', '가격 좀 낮춰주세요', '2023-02-13 16:00:26');
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(2, 'son', '얼마 원하시나요?', '2023-02-13 17:44:55');
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(2, 'seo', '그냥 안 살 게요', '2023-02-14 21:33:04');
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(3, 'seo', '저도 그거 있어요', '2023-02-14 19:50:18');
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(3, 'son', '안 물어봤는데...', '2023-02-14 19:56:22');
INSERT INTO comments(commentArticleNum, commentAuthor, commentContent, commentDate) values(3, 'seo', '오키', '2023-02-15 01:41:47');

# 데이터 삭제
# DELETE FROM comments WHERE commentNum>=20;
# delete from comments where commentAuthor is null;

# 데이터 수정
# UPDATE
UPDATE comments SET commentContent = 'asdfasdf' WHERE commentNum = 1;

select * from comments;
select * from comments where commentArticleNum=2;