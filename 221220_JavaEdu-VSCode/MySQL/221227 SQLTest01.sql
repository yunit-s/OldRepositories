-- SQL Test 01(221227)

USE mysql_test_db;

-- 1번
select count(department_no) as '학생 수' from tb_student
	where department_no = (
			select department_no from tb_department where department_name = '사학과'
		) and year(entrance_date) = 2001
	group by department_no;



-- 2번
select category, department_name, capacity
	from tb_department
	where category = '공학' and capacity between 20 and 30
    order by department_name asc;


