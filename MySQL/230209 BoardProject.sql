
/* Make Database Schema */
CREATE SCHEMA mydatabase;

USE mydatabase;

CREATE TABLE members (
	memberId		varchar(10) NOT NULL PRIMARY KEY,
    memberName	varchar(20) NOT NULL,
    memberPw		varchar(20) NOT NULL
);

select * from members;

insert into members values('hong', '홍길동', '1234');