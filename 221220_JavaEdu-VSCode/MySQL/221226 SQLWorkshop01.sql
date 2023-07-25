-- SQL Workshop 01(221226)

USE mysql_workshop_db;

-- 1번
-- inner join, rank()
select *
	from (
		select category, dpt.department_name, count(std.department_no),
				rank() over(partition by category order by count(std.department_no) desc) as ranking
			from tb_student as std
			inner join tb_department as dpt on std.department_no = dpt.department_no and category in ('공학', '자연과학')
			group by std.department_no
		) as tmp
    where ranking <= 2;

-- 2번
-- inner join, left outer join 동시에 사용하기, wildcard %
-- 예시 출력과 완전 똑같이 출력하려면, class_name 이 아니라 class_type에서 '%논문%' 을 검색해야 한다.
select CLASS_NAME, DEPARTMENT_NAME from tb_class cls
    inner join tb_department dpt on cls.DEPARTMENT_NO = dpt.DEPARTMENT_NO and CATEGORY = '예체능'
	left outer join tb_class_professor clsp on cls.CLASS_NO = clsp.CLASS_NO
    where CLASS_NAME like '%논문%' and PROFESSOR_NO is null
	order by DEPARTMENT_NAME;

-- 3번
-- left outer join 과 subquery 동시에 사용하기
select category as '계열', dpt.DEPARTMENT_NAME as '학과', count(PROFESSOR_NO) as '교수수'
	from tb_department dpt
	left outer join tb_professor prof on dpt.department_no = prof.DEPARTMENT_NO
	where category = (select category from tb_department where DEPARTMENT_NAME = '환경조경학과')
	group by dpt.DEPARTMENT_no having count(PROFESSOR_NO) = 0;

-- 4번
select cyear, format(avg(point), 1)
	from (
		select *, substring(TERM_NO, 1, 4) as cyear from tb_grade
			where STUDENT_NO = any(
				select STUDENT_NO from tb_student where COACH_PROFESSOR_NO = (
					select COACH_PROFESSOR_NO from tb_student where STUDENT_NAME = '서가람'
					)
				)
		) as subtable
    where cyear between 2002 and 2008
    group by cyear
    order by cyear asc;

-- 5번
-- not exists, inner join
select professor_name as '지도교수', count(stud.coach_professor_no) as '학생 수' from tb_professor prof
	inner join tb_student stud on prof.professor_no = stud.coach_professor_no
	where not exists(select professor_no from tb_class_professor cprof where prof.professor_no = cprof.professor_no)
	group by stud.coach_professor_no
    order by professor_name asc;

-- 6번
-- left outer join
-- join 다른 걸로 하면 체육학과 출력 안 나옴
select category as '계열', department_name as '학과이름', count(stud.department_no) as '학생 수'
	from tb_department dpt
	left outer join tb_student stud on dpt.department_no = stud.department_no
	where category in ('예체능', '공학')
    group by dpt.department_no
    order by category asc, count(stud.department_no) desc;

-- 7번
-- count() 와 cast()를 하나의 select문에서는 사용하지 못하는 듯...
select count(student_no), subq1.class_no as '과목번호', class_name as '과목이름'
	from (
		select student_no, class_no, cast(substring(term_no, 1, 4) as unsigned int) as cyear from tb_grade
			where cast(substring(term_no, 1, 4) as unsigned int) between 2001 and 2005
		) as subq1
	inner join tb_class cls on subq1.class_no = cls.class_no
	group by subq1.class_no
    order by count(student_no) desc
    limit 3;
