CREATE TABLE MEMBERS (
	id			VARCHAR(10) NOT NULL PRIMARY KEY,
    name	VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL
);

INSERT INTO MEMBERS VALUES('hong', '홍길동', '1234');

#drop database servletsession;

select * from members;