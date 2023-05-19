CREATE SCHEMA lumos;

USE lumos;

desc center;
desc childcare_eval;
desc childcare_violation;
desc kidsdata_detail;
desc sidocode;

select * from center order by center_num desc;
select * from center where center_num > 0 and center_num < 10;
select * from center where center_state = '경기도';
select * from childcare_violation order by center_num desc;
select * from kidsdata_detail where center_num = 1 or center_num = 2;
select * from kidsdata_detail where center_num > 0 and center_num < (0 + 5);
select count(*) from sidocode;
select * from sidocode limit 5;