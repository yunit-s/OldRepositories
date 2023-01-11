-- Online Library Project

USE library;
SELECT

-- library database - book table edit code
-- 컬럼 삭제
alter table book drop btranslator;
alter table book drop bsupplement;
-- 컬럼 추가
alter table book add bborrowable CHAR(2) default 'o';
alter table book add breturndate date default null;
-- 컬럼 변경
-- alter table book change bborrowed bborrowable boolean default true;
-- alter table book modify bborrowable CHAR(2) default 'O';
-- alter table book modify breturndate date default '-';




-- 책 추가
-- insert into book (bisbn, btitle, bdate, bpage, bprice, bauthor, bpublisher, bimgurl, bimgbase64, bborrowable, breturndate)
-- 	values ( )
-- 책 정보 수정
-- UPDATE 테이블명 SET 컬럼1 = 수정값1 [, 컬럼2 = 수정값2 ...] [WHERE 조건];
-- UPDATE book SET bborrowable = 'x' WHERE bisbn = ?;


show table status;
desc book;
select * from book order by bprice desc limit 50;
select * from book where btitle like '%java%';

update book set bborrowable = 'o' where bisbn = '978-89-6848-156-7';
update book set bborrowable = 'o', breturndate = null where bisbn = '978-89-6848-042-3';



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

insert into users values('admin', '관리자', 'qwer1234', 'admin@gmail.com', '010-1234-9999', '당신의 이름은?', '관리자', 'Admin', 0);
insert into users values('jelee', '이지은', 'qwer1234', 'jelee@gmail.com', '010-1111-1111', '당신의 이름은?', '이지은', 'Bronze', 0);
insert into users values('jslee', '창호', 'qwer1234', 'jslee@gmail.com', '010-2222-2222', '당신의 이름은?', '이종석', 'Bronze', 0);

-- UPDATE 테이블명 SET 컬럼1 = 수정값1 [, 컬럼2 = 수정값2 ...] [WHERE 조건];
-- UPDATE `library`.`users` SET `tier` = 'Admin' WHERE (`id` = 'admin');
-- UPDATE users SET nickname = ?, pw = ?, email = ?, phone = ?, identquest = ?, identanswer = ?, tier = ? WHERE id = ?;

desc users;
select * from users;
select pw from users where id = 'admin';
delete from users where id = 'jslee';

update users set point = 35, tier = 'Silver' where id = 'jslee';


-- --------------------------------------------------





-- library database - borrbook table init code
DROP TABLE IF EXISTS borrbook;
CREATE TABLE borrbook (
	bisbn		VARCHAR(20) Not Null primary key,
    btitle	VARCHAR(100) not null,
    id	VARCHAR(20) not null,
    borrdate	DATE not null,
    returndate	DATE not null
);

alter table borrbook modify btitle VARCHAR(100) not null;
update borrbook set returndate = DATE('20230109') where bisbn = '978-89-98756-79-6';


desc borrbook;
select * from borrbook;
select pw from users where id = 'admin';


-- --------------------------------------------------




-- 230109 MyBatis 교육
select * from book where bisbn = '89-7914-206-4';
select * from book where bprice = 99999;

