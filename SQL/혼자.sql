--1999년 주문 내역을 아래와 같이 얻어보자.
-- 결과) 반기, 주문방식, 주문금액의 합

SELECT *
FROM employees
WHERE EXTRACT(YEAR FROM hire_date) = 2002;

SELECT department_id,
       TO_CHAR(hire_date, 'Q') "분기",
       AVG(salary) "평균 연봉"
FROM employees
group by DEPARTMENT_ID, TO_CHAR(hire_date, 'Q')
order by DEPARTMENT_ID asc, TO_CHAR(hire_date, 'Q') asc ;

SELECT employee_id, CASE TRUNC(EXTRACT(MONTH FROM hire_date) / 7)
          WHEN 0 THEN '상반기'
          WHEN 1 THEN '하반기'
       END "반기"
FROM employees;

SELECT employee_id, 
       DECODE(TRUNC(EXTRACT(MONTH FROM hire_date) / 7), 0 , '상반기', 1 , '하반기')
FROM employees;

SELECT employee_id,
       salary,
       hire_date,
       MAX(salary) OVER(ORDER BY hire_date ASC)
FROM employees;

SELECT employee_id,
       salary,
       department_id,
       MAX(salary)
FROM employees
GROUP BY department_id;
--나 혼자
select e.first_name, e.last_name, e.department_id, D.Department_Name
FROM employees e JOIN departments d
ON e.department_id = d.department_id
WHERE D.Department_Name = Initcap('EXECUTIVE');

select department_name, location_id, count(employee_id), round(avg(salary),2) avg_salary
from EMPLOYEES e JOIN DEPARTMENTS d
on E.DEPARTMENT_ID = D.DEPARTMENT_ID
group by D.DEPARTMENT_NAME, D.LOCATION_ID
ORDER BY D.LOCATION_ID;

select EMPLOYEE_ID, last_name, hire_date 
from EMPLOYEES
where DEPARTMENT_ID = (select DEPARTMENT_ID from EMPLOYEES where lower(last_name) = 'zlotkey')
and lower(last_name) != 'zlotkey';

select EMPLOYEE_ID, last_name
from EMPLOYEES
where salary > ( select avg(SALARY) from EMPLOYEES); 

select e.EMPLOYEE_ID, last_name
from ( select DEPARTMENT_ID from EMPLOYEES where last_name like '%u%') uname join employees e
on UNAME.DEPARTMENT_ID = E.DEPARTMENT_ID;

select e.last_name, e.DEPARTMENT_ID, e.job_id
from (select * from EMPLOYEES e join DEPARTMENTS d on e.department_id = d.department_id where d.location_id = 1700) emp1700 join EMPLOYEES e
on emp1700.employee_id = e.employee_id;

SELECT * 
FROM   employees 
WHERE  salary > ALL (SELECT salary 
                            FROM   employees 
                            WHERE  department_id = 30);
