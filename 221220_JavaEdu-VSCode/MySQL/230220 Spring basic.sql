CREATE SCHEMA spring;
USE spring;

CREATE TABLE users (
	id		VARCHAR(10) PRIMARY KEY,
    password	VARCHAR(10),
    name		VARCHAR(10)
);

insert into users values('hong', 12, '홍길동');
SELECT * FROM users WHERE id = 'hong';
select * from users;
delete from users;