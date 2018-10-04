SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE hire_date like '02%';

/* ���� */
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE hire_date like '02%'
ORDER BY commission_pct ASC, salary DESC;

--GROUP BY ��
SELECT department_id, count(department_id)
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

--HAVING ��
SELECT department_id, count(department_id)
FROM employees
GROUP BY department_id
HAVING department_id IS NOT NULL
ORDER BY department_id;

-- ���������� �̿��� ���̺� ����
CREATE TABLE emp AS
SELECT *
FROM employees;

-- UNION ������ (�Ȱ��� ������ ���ĵ� 107��)
SELECT * 
FROM employees
UNION
select *
from emp;

-- UNION ALL ������ (�Ȱ��� ������ ��ġ�� �� ���� 2���� ->  214��)
SELECT * 
FROM employees
UNION ALL
select *
from emp;

-- INTERSECT (������)
SELECT * 
FROM employees
INTERSECT
select *
from emp;

-- MINUS (������)
SELECT * 
FROM employees
MINUS
select *
from emp;

