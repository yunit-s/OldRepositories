-- SQL Workshop 01(221226)

USE mysql_workshop_db;

-- 1번
-- inner join, rank()
select * from (
	select category, dpt.department_name, count(std.department_no), rank() over(partition by category order by count(std.department_no) desc) as ranking
		from tb_student as std
		inner join tb_department as dpt on std.department_no = dpt.department_no and category in ('공학', '자연과학')
		group by std.department_no
    ) as tmp
    where ranking <= 2;

-- 2번
-- left outer join, wildcard %
-- 예시 출력과 완전 똑같이 출력하려면, class_name 이 아니라 class_type에서 '%논문%' 을 검색해야 한다.
select CLASS_NAME, DEPARTMENT_NAME from tb_class cls
    inner join tb_department dpt on cls.DEPARTMENT_NO = dpt.DEPARTMENT_NO and CATEGORY = '예체능'
	left outer join tb_class_professor clsp on cls.CLASS_NO = clsp.CLASS_NO
    where CLASS_NAME like '%논문%' and PROFESSOR_NO is null
	order by DEPARTMENT_NAME;

-- 3번
select category as '계열', dpt.DEPARTMENT_NAME as '학과', count(PROFESSOR_NO) as '교수수'
	from tb_department dpt
	left outer join tb_professor prof on dpt.department_no = prof.DEPARTMENT_NO
	where category = (select category from tb_department where DEPARTMENT_NAME = '환경조경학과')
	group by dpt.DEPARTMENT_no having count(PROFESSOR_NO) = 0

