###### 초기 ######
# 스키마 생성
CREATE SCHEMA gymmanna;

# 스키마 선택
USE gymmanna;

###### 테이블 생성 ######
# 사용자 테이블
CREATE TABLE `user` (
	`user_id`		varchar(30)	NOT NULL 	PRIMARY KEY,
	`user_password`	varchar(20)	NOT NULL,
	`user_name`		varchar(20)	NOT NULL,
	`user_phone`	char(13)	NOT NULL,
	`user_nickname`	varchar(8)	NOT NULL,
	`user_isadmin`	boolean		NULL		DEFAULT false,
	`user_route`	integer		NOT NULL
);

# 오운완 게시글 
CREATE TABLE `article_photo` (
	`article_pnum`		bigint			NOT NULL 	AUTO_INCREMENT	PRIMARY KEY,
	`article_ptitle`	varchar(100)	NOT NULL,
	`article_pcontent`	varchar(500)	NOT NULL,
	`article_pdate`		date			NOT NULL	DEFAULT (current_date),
	`user_id`			varchar(20)		NOT NULL
);

# 오운완 댓글
CREATE TABLE `comment_photo` (
	`comment_pnum`		bigint			NOT NULL 	AUTO_INCREMENT PRIMARY KEY,
	`comment_pdate`		date			NOT NULL,
	`article_pnum`		bigint			NOT NULL,
    `user_nickname`		varchar(30)		NOT NULL,
    `comment_pcontent`	varchar(100)	NOT NULL
);

# 모집 게시글
CREATE TABLE `article_gathering` (
	`article_gnum`		bigint			NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`article_gtitle`	varchar(100)	NOT NULL,
	`article_gcontent`	varchar(500)	NOT NULL,
	`article_gdate`		date			NOT NULL	DEFAULT (current_date),
	`user_id`			varchar(20)		NOT NULL,
	`category_type`		varchar(12)		NOT NULL	DEFAULT '헬스',
	`center_num`		bigint			NOT NULL
);

# 모집 댓글
CREATE TABLE `comment_gathering` (
	`comment_gnum`	bigint		NOT NULL 	AUTO_INCREMENT 	PRIMARY KEY,
	`comment_gdate`	date		NOT NULL	DEFAULT (current_date),
	`article_gnum`	bigint		NOT NULL,
    `user_nickname`	varchar(30)	NOT NULL,
    `comment_gcontent`	varchar(100)	NOT NULL
);

# 좋아요 테이블
CREATE TABLE `liketbl` (
	`user_id`		varchar(30)	NOT NULL,
	`article_pnum`	bigint	NOT NULL
);

# 카테고리 
CREATE TABLE `category` (
	`category_type`	varchar(12)	NOT NULL PRIMARY KEY DEFAULT '헬스' 
);

# 만나 방
CREATE TABLE `post_gathering` (
	`post_num`		bigint		NOT NULL	AUTO_INCREMENT	PRIMARY KEY,
	`article_gnum`	bigint		NOT NULL,
	`user_id`		varchar(20)	NOT NULL
);

# 이미지 테이블
CREATE TABLE `imgtbl` (
	`article_pnum`		bigint			NOT NULL ,
	`article_imgurl`	varchar(100)	NOT NULL
);

# 센터 테이블
CREATE TABLE `centertbl` (
	`center_num`	bigint	NOT NULL AUTO_INCREMENT	PRIMARY KEY,
	`center_name`	varchar(30)	NOT NULL
);

###### 테이블 조회 ######
SELECT * FROM user;
SELECT * FROM article_gathering;
SELECT * FROM article_photo;
SELECT * FROM comment_gathering;
SELECT * FROM comment_photo;
SELECT * FROM post_gathering;
SELECT * FROM category;
SELECT * FROM liketbl;
SELECT * FROM imgtbl;
SELECT * FROM centertbl;

DESC user;
DESC article_gathering;
DESC article_photo;
DESC comment_gathering;
DESC comment_photo;
DESC post_gathering;
DESC category;
DESC liketbl;
DESC imgtbl;
DESC centertbl;

##### 테이블 참조 #####
# 유저 테이블 - 모집 게시글 테이블
ALTER TABLE `article_gathering` ADD CONSTRAINT `FK_user_TO_article_gathering` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
)
ON DELETE CASCADE;

# 카테고리 테이블 - 모집 게시글 테이블
ALTER TABLE `article_gathering` ADD CONSTRAINT `FK_category_TO_article_gathering` FOREIGN KEY (
	`category_type`
)
REFERENCES `category` (
	`category_type`
)
ON DELETE CASCADE;

# 유저 테이블 - 사진 게시글 테이블
ALTER TABLE `article_photo` ADD CONSTRAINT `FK_user_TO_article_photo` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
)
ON DELETE CASCADE;

# 모집 게시글 테이블 - 모집 게시글 댓글 테이블 (안됨 이유: 안에 자료값이 없어서)
ALTER TABLE `comment_gathering` ADD CONSTRAINT `FK_article_gathering_TO_comment_gathering` FOREIGN KEY (
	`article_gnum`
)
REFERENCES `article_gathering` (
	`article_gnum`
)
ON DELETE CASCADE;

# 사진 게시글 테이블 - 사진 게시글 댓글 테이블
ALTER TABLE `comment_photo` ADD CONSTRAINT `FK_article_photo_TO_comment_photo` FOREIGN KEY (
	`article_pnum`
)
REFERENCES `article_photo` (
	`article_pnum`
)
ON DELETE CASCADE;

# 유저 테이블 - 좋아요 테이블
ALTER TABLE `liketbl` ADD CONSTRAINT `FK_user_TO_liketbl` FOREIGN KEY (
	`user_id`
)
REFERENCES `user` (
	`user_id`
)
ON DELETE CASCADE;

# 사진 게시글 테이블 - 좋아요 테이블
ALTER TABLE `liketbl` ADD CONSTRAINT `FK_article_photo_TO_liketbl` FOREIGN KEY (
	`article_pnum`
)
REFERENCES `article_photo` (
	`article_pnum`
)
ON DELETE CASCADE;

# 사진 게시글 테이블 - 이미지 테이블
ALTER TABLE `imgtbl` ADD CONSTRAINT `FK_article_photo_TO_imgtbl` FOREIGN KEY (
	`article_pnum`
)
REFERENCES `article_photo` (
	`article_pnum`
)
ON DELETE CASCADE;

# 센터 테이블 - 만나 게시글 테이블
ALTER TABLE `article_gathering` ADD CONSTRAINT `FK_centertbl_TO_article_gathering` FOREIGN KEY (
	`center_num`
)
REFERENCES `centertbl` (
	`center_num`
)
ON DELETE CASCADE;

# 이미지 저장
ALTER TABLE imgtbl MODIFY article_imgurl VARCHAR(255);


##### 더미 데이터 입력 #####
# 유저
INSERT INTO user
VALUES ('admin', '1234', '백승전', '010-0000-0000', '관리자', true, 0);

INSERT INTO user
VALUES ('bbbbb', '1234', '장진희', '010-0000-0000', '백승전', false, 0);

INSERT INTO user (user_id, user_password, user_name, user_phone, user_nickname, user_route)
VALUES ('jjjjj', '1234', '장진희', '010-0000-0000', '예쁠희', 0);

INSERT INTO user (user_id, user_password, user_name, user_phone, user_nickname, user_route)
VALUES ('hhhhh', '1234', '이윤형', '010-0000-0000', '유노윤형', 1);

INSERT INTO user (user_id, user_password, user_name, user_phone, user_nickname, user_route)
VALUES ('ccccc', '1234', '권찬민', '010-0000-0000', '최강찬민', 0);

# 사진 게시글
INSERT INTO article_photo (article_ptitle, article_pcontent, user_id)
VALUES ('오운완 게시글 제목', '오운완 게시글 내용', 'admin');

INSERT INTO article_photo (article_ptitle, article_pcontent, user_id)
VALUES ('오운완 게시글 제목2', '오운완 게시글 내용2', 'admin');

INSERT INTO article_photo (article_ptitle, article_pcontent, user_id)
VALUES ('오운완 게시글 제목3', '오운완 게시글 내용3', 'admin');

# 카테고리
INSERT INTO category
VALUES ('헬스');

# 운동 센터 정보
INSERT INTO centertbl (center_name)
VALUES ('혜화 헬스장');

INSERT INTO centertbl (center_name)
VALUES ('강남 필라테스');

# 모집 게시글
INSERT INTO article_gathering (article_gtitle, article_gcontent, user_id, center_num)
VALUES ('운동할 사람', '고고고', 'admin', 1);

INSERT INTO article_gathering (article_gtitle, article_gcontent, user_id, center_num)
VALUES ('운동할 사람2', '고고고2', 'admin', 2);

INSERT INTO article_gathering (article_gtitle, article_gcontent, user_id, center_num)
VALUES ('운동할 사람3', '고고고3', 'admin', 1);

INSERT INTO article_gathering (article_gtitle, article_gcontent, user_id, center_num)
VALUES ('운동할 사람4', '고고고4', 'admin', 1);

INSERT INTO article_gathering (article_gtitle, article_gcontent, user_id, center_num)
VALUES ('운동할 사람5', '고고고5', 'admin', 2);

# 외래키 확인
select * from information_schema.table_constraints where constraint_schema = 'gymmanna';
select * from information_schema.table_constraints where table_name = 'centertbl';

# primary key 추가
# ALTER TABLE article_gathering ADD PRIMARY KEY (article_gnum);
select * from article_gathering;
select * from centertbl;
select * from user;
delete from user where user_id='innateace@gmail.com';


select * from comment_gathering;
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (1,'닉네임01','내용01');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (1,'닉네임02','내용02');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (1,'닉네임01','내용033');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (1,'닉네임02','내용04444');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (1,'닉네임01','오키오키');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (3,'닉네임31','내용31');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (3,'닉네임32','내용32');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (3,'닉네임31','내용333');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (3,'닉네임32','내용34444');
INSERT INTO comment_gathering (article_gnum,user_nickname,comment_gcontent) VALUES (3,'닉네임31','오키오키');

INSERT INTO article_gathering (article_gtitle, article_gcontent,user_id,category_type,center_num) VALUES ('글제목', '내용은 이렇게 작성한다.', 'ccccc', '헬스', 2);
select * from centertbl;