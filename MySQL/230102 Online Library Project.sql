-- Online Library Project

USE library;
SELECT

-- library database - book table edit code
-- 컬럼 추가
alter table book add bborrowed boolean default false;
alter table book add breturndate date default null;
-- 컬럼 변경
alter table book change bborrowed bborrowable boolean default true;
alter table book modify bborrowable CHAR(2) default 'O';
alter table book modify breturndate date default '-';
-- 컬럼 삭제
alter table book drop btranslator;
alter table book drop bsupplement;


-- 책 추가
-- insert into book (bisbn, btitle, bdate, bpage, bprice, bauthor, bpublisher, bimgurl, bimgbase64, bborrowable, breturndate)
-- 	values ( )
-- 책 정보 수정
-- UPDATE 테이블명 SET 컬럼1 = 수정값1 [, 컬럼2 = 수정값2 ...] [WHERE 조건];
UPDATE book SET bborrowable = 'x' WHERE bisbn = ?;


show table status;
desc book;
select * from book order by bprice desc limit 50;
select * from book where btitle like '%java%';
-- --------------------------------------------------




-- library database - users table init code
DROP TABLE IF EXISTS users;
CREATE TABLE users (
	id		VARCHAR(20) primary key NOT NULL,
    nickname	VARCHAR(20) NOT NULL,
    pw	VARCHAR(20) NOT NULL,
    email	VARCHAR(50) NOT NULL,
    phone	VARCHAR(20) NOT NULL,
    identquest VARCHAR(50) NOT NULL,
    identanswer VARCHAR(50) NOT NULL,
    tier VARCHAR(10) NOT NULL,
    point INT NOT NULL default 0
);

alter table users add point int default 0;
insert into users values('admin', '관리자', 'qwer1234', 'admin@gmail.com', '010-1234-9999', '당신의 이름은?', '관리자', 'Admin', 0);
insert into users values('jelee', '이지은', 'qwer1234', 'jelee@gmail.com', '010-1111-1111', '당신의 이름은?', '이지은', 'Bronze', 0);

UPDATE `library`.`users` SET `tier` = 'Admin' WHERE (`id` = 'admin');
-- UPDATE 테이블명 SET 컬럼1 = 수정값1 [, 컬럼2 = 수정값2 ...] [WHERE 조건];
UPDATE users SET nickname = ?, pw = ?, email = ?, phone = ?, identquest = ?, identanswer = ?, tier = ? WHERE id = ?;



desc users;
select * from users;
select pw from users where id = 'admin';
delete from users where id = 'jslee';




-- --------------------------------------------------





-- library database - borrbook table init code
DROP TABLE IF EXISTS borrbook;
CREATE TABLE borrbook (
	bisbn		VARCHAR(20) Not Null primary key,
    btitle	VARCHAR(20) not null,
    id	VARCHAR(20) not null,
    borrdate	DATE not null,
    returndate	DATE not null
);


alter table borrbook modify btitle VARCHAR(50) not null;



desc borrbook;
select * from borrbook;
select pw from users where id = 'admin';


-- --------------------------------------------------