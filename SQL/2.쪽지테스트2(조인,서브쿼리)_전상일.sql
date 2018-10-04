�� ���º� - ���ѽð� 60��(bangry313@naver.com �̸��� ����)

--1. 'London'���� �ٹ��ϴ� ��� ����� �����ȣ(employee_id), ����̸�(last_name), �����̸�(job_title), �μ��̸�(department_name), �μ���ġ(city)�� ��ȸ�Ͻÿ�.
--  -���� ���̺� : employees, jobs, departments, locations
SELECT e.employee_id, 
       e.last_name, 
       job_title, 
       department_name, 
       city 
FROM   employees e 
       JOIN departments d 
         ON e.department_id = d.department_id 
       JOIN locations l 
         ON d.location_id = l.location_id 
       JOIN jobs j 
         ON e.job_id = j.job_id 
WHERE  Lower(city) = 'london'; 


--2. ����̸�(last_name)�� 'A'�� ���Ե� ����� �̸�(last_name)�� �μ���(department_name)�� ��ȸ�Ͻÿ�.
SELECT last_name, 
       department_name 
FROM   employees e 
       JOIN departments d 
         ON e.department_id = d.department_id 
WHERE  last_name LIKE '%A%'; 

--3. �޿�(salary)�� 3000���� 5000 ������ ����� ��ȣ, �̸�, �޿�, �μ����� ��ȸ�϶�.
SELECT employee_id, 
       last_name, 
       salary, 
       department_name 
FROM   employees e 
       JOIN departments d 
         ON e.department_id = d.department_id 
WHERE  salary BETWEEN 3000 AND 5000; 

--4. 'Accounting' �μ��� �ٹ��ϴ� ����� �̸��� �Ի����� ��ȸ�϶�.
--   - �Ի��� ��� ���� - 2007�� 05�� 21��(������)
SELECT last_name, 
       To_char(hire_date, 'YYYY-MM-DD DAY', 'NLS_DATE_LANGUAGE=KOREAN') 
FROM   employees e 
       JOIN departments d 
         ON e.department_id = d.department_id 
WHERE  D.department_name = 'Accounting'; 

--!5. 'Landry(last_name)'�� ���� �μ��� �ٹ��ϴ� ����� ��� ��� ������ ��ȸ�϶�.
--    (��. Landry�� ����)
SELECT employee_id, 
       last_name, 
       salary, 
       department_id 
FROM   employees 
WHERE  department_id = (SELECT department_id 
                        FROM   employees 
                        WHERE  last_name = 'Landry') 
       AND last_name != 'Landry'; 


--6. 'Lee(last_name)'���� �ʰ� �Ի��� ����� �̸��� �Ի��� ��ȸ�϶�.
SELECT last_name, 
       hire_date 
FROM   employees 
WHERE  hire_date < (SELECT hire_date 
                    FROM   employees 
                    WHERE  Lower(last_name) = 'lee'); 

7. 'Lee(last_name)'���� ���� �޿��� �޴� ����� �̸��� �޿��� ��ȸ�϶�.

SELECT last_name, 
       salary 
FROM   employees 
WHERE  salary > (SELECT salary 
                 FROM   employees 
                 WHERE  Lower(last_name) = 'lee');        

8. 50�� �μ��� ������ ���� �޿��� �޴� ����� �̸��� �޿��� ��ȸ�϶�.

SELECT last_name, salary
FROM   employees
WHERE  salary = ANY (SELECT salary 
                     FROM   employees 
                     WHERE  department_id = 50);                

9. ��� ����� ��ձ޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿��� ��ȸ�϶�.

SELECT employee_id, 
       last_name, 
       salary 
FROM   employees 
WHERE  salary > ANY (SELECT Avg(Nvl(salary, 0)) 
                     FROM   employees); 

10.�̸�(last_name)��  'T'�� ���ԵǾ� �ִ� ����� ������ �μ��� �ٹ��ϴ� ����� ��ȣ, �̸��� ��ȸ�϶�.
SELECT employee_id, 
       last_name 
FROM   employees 
WHERE  department_id = ANY (SELECT department_id 
                            FROM   employees 
                            WHERE  last_name LIKE '%T%'); 
                    
11.10�� �μ� �ִ�޿��ڿ� ������ �޿��� �޴� ����� ��ȣ, �̸�, �޿��� ��ȸ�϶�.
SELECT employee_id, 
       last_name, 
       salary 
FROM   employees 
WHERE  salary > ALL (SELECT salary 
                     FROM   employees 
                     WHERE  department_id = 10);            

12. 10���μ��� �ٹ��ϴ� ����� �̸��� �μ��� ��ȸ�϶�.

SELECT e.last_name, 
       d.department_name 
FROM   employees e 
       JOIN departments d 
         ON e.department_id = d.department_id 
WHERE  d.department_id = 10; 

13. 'IT_PROG' ������ �ִ� �޿��ں��� ���� �޿��� �޴� ��� ����(�μ���ȣ, �����ȣ, �̸�, �޿�)�� ����϶�.

SELECT e.department_id, 
       e.employee_id, 
       e.last_name, 
       e.salary 
FROM   employees e 
       JOIN departments d 
         ON e.department_id = d.department_id 
WHERE  e.salary > ALL (SELECT salary 
                       FROM   employees e 
                              JOIN jobs j 
                                ON e.job_id = j.job_id 
                       WHERE  j.job_id = 'IT_PROG'); 

14. ��� �޿����� ���� �޿��� �ް� �̸��� u�� ���Ե� ����� ���� �μ��� �ٹ��ϴ� ��� ����� ��� ����(�����ȣ, �̸�, �޿�)�� ��ȸ�϶�.

SELECT e.department_id, 
       e.last_name, 
       e.salary 
FROM   (SELECT department_id 
        FROM   employees 
        WHERE  last_name LIKE '%u%' 
               AND salary >= (SELECT Avg(salary) 
                              FROM   employees)) d 
       JOIN employees e 
         ON d.department_id = e.department_id; 

15. ��ձ޿��� ���� ���� ������ȣ(job_id)�� ��ձ޿��� ����϶�
    ��) ������ȣ  ��ձ޿�
       -------------------
        CLERK      2300    
SELECT  round(avg(salary),0) "��ձ޿�"
FROM    EMPLOYEES
WHERE   job_id in  (
                          SELECT  job_id
                          FROM    jobs
                          WHERE   SALARY >= (
                                              SELECT  MIN(min_salary)
                                              FROM    jobs
                                            )
                          )
;