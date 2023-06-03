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
select * from kidsdata_detail
	where center_detail_state like '%서울%' and center_detail_city like '%종로%'
		and center_detail_Latitude > 37.571 - 0.004 and center_detail_Latitude < 37.571 + 0.004
		and center_detail_longitude > 126.975 - 0.004 and center_detail_longitude < 126.975 + 0.004;
select count(*) from sidocode;
select * from sidocode limit 5;
select * from sidocode;

SELECT * FROM center WHERE center_state LIKE '%서울%' AND center_city LIKE '%남%' ORDER BY center_num ASC LIMIT 5;
select * from kidsdata_detail
	where center_detail_state like '%서울%' and center_detail_city like '%강남%'
		and center_detail_Latitude > 37.48850 - 0.008 and center_detail_Latitude < 37.48850 + 0.008
		and center_detail_longitude > 127.0510 - 0.008 and center_detail_longitude < 127.0510 + 0.008;



# user 테이블 관련 쿼리
select * from user_tb;


# favorite 관련 테스트 쿼리
select * from favorite_tb;






# 데이터 문제점 발견
select center_num, center_detail_state, center_detail_city, center_detail_name, center_detail_Latitude, center_detail_longitude from kidsdata_detail
	where center_detail_Latitude > 37.571 - 0.005 and center_detail_Latitude < 37.571 + 0.005
		and center_detail_longitude > 126.975 - 0.005 and center_detail_longitude < 126.975 + 0.005;