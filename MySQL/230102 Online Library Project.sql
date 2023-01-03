-- Online Library Project

USE library;
SELECT

-- library database - book table edit code
alter table book add bborrowed boolean default false;

-- --------------------------------------------------



show table status;
desc book;
select * from book limit 50;
select * from book where btitle like '%java%';




-- library database - users table init code
DROP TABLE IF EXISTS users;
CREATE TABLE users (
	id		VARCHAR(20) Not Null primary key,
    nickname	VARCHAR(20),
    pw	VARCHAR(20),
    email	VARCHAR(50),
    phone	VARCHAR(20),
    identquest VARCHAR(50),
    identanswer VARCHAR(50),
    tier VARCHAR(10)
);

insert into users values('admin', '관리자', 'qwer1234', 'admin@gmail.com', '010-1234-9999', '당신의 이름은?', '관리자', '관리자');

desc users;
select * from users;
select pw from users where id = 'admin';


-- --------------------------------------------------