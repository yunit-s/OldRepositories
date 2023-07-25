-- 221227 JDBC 기초 1일차

SELECT
USE library;

show tables;

desc book;

SELECT * FROM book;
-- isbn, title, price, author 정도만 사용해보자.
SELECT bisbn, btitle, bauthor, bprice FROM book;
SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle like '%여행%';
SELECT btitle, bauthor, bprice FROM book WHERE btitle LIKE '%여행%';

desc book;
