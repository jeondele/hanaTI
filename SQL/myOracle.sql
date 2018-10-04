SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE hire_date like '02%';

/* 정렬 */
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE hire_date like '02%'
ORDER BY commission_pct ASC, salary DESC;

--GROUP BY 절
SELECT department_id, count(department_id)
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

--HAVING 절
SELECT department_id, count(department_id)
FROM employees
GROUP BY department_id
HAVING department_id IS NOT NULL
ORDER BY department_id;

-- 서브쿼리를 이용한 테이블 복사
CREATE TABLE emp AS
SELECT *
FROM employees;

-- UNION 연산자 (똑같기 때문에 합쳐도 107개)
SELECT * 
FROM employees
UNION
select *
from emp;

-- UNION ALL 연산자 (똑같기 때문에 합치면 각 열이 2개씩 ->  214개)
SELECT * 
FROM employees
UNION ALL
select *
from emp;

-- INTERSECT (교집합)
SELECT * 
FROM employees
INTERSECT
select *
from emp;

-- MINUS (차집합)
SELECT * 
FROM employees
MINUS
select *
from emp;

