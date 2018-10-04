SELECT first_name, department_name
FROM employees, departments;

SELECT E.First_Name, D.Department_Id
FROM employees e , departments d;

--ansi cross join ǥ�� �԰�(����)
SELECT E.Employee_Id,
       E.Last_Name,
       E.Department_Id
FROM EMPLOYEES E
     CROSS JOIN DEPARTMENTS D;

-- �����ϰ��� �ϴ� �� ���̺��� ���������� �����ϴ� �÷�(department_id)�� ���� ���� ���Ͽ� ��ġ�ϴ� ��� ���� ����     
-- ANSI �԰�
SELECT    e.employee_id, 
          e.last_name, 
          d.department_name 
FROM      employees e 
          JOIN departments d 
          --ON e.department_id = d.department_id 
          USING (department_id) 
WHERE  e.salary >= 3000; 

---- 3���̻� ���̺� ����
-- ��ųʸ� ���̺�κ��� ���̺� ���� ��ȸ
SELECT e.employee_id, 
          e.last_name, 
          d.department_name, 
          l.city, 
          l.state_province, 
          c.country_name 
FROM   employees e 
         JOIN departments d 
            ON e.department_id = d.department_id 
         JOIN locations l 
            ON d.location_id = l.location_id 
         JOIN countries c 
            ON l.country_id = c.country_id; 

-- ����Ŭ NON-EQUI JOIN
SELECT e.ename, 
       e.sal, 
       s.grade 
FROM   emp e, 
       salgrade s 
WHERE  e.sal BETWEEN s.losal AND s.hisal;

--������ ������ �ϱ� ������ ���� ���� ���� ��  �ִ�.
SELECT e.employee_id, 
       e.last_name, 
       e.salary, 
       j.job_title 
FROM   employees e 
       JOIN jobs j 
ON  e.salary BETWEEN j.min_salary AND j.max_salary 
ORDER  BY e.employee_id; 

--������ ANSI �԰�����!
-- LEFT OUTER JOIN ANSI ����
SELECT e.employee_id, 
       e.first_name, 
       e.last_name, 
       d.department_name 
FROM   employees e 
       LEFT OUTER JOIN departments d 
                    ON e.department_id = d.department_id; 
--WHERE  e.department_id IS NULL;

-- RIGHT OUTER JOIN ANSI ����
SELECT e.employee_id, 
       e.first_name, 
       e.last_name, 
       d.department_name 
FROM   employees e 
       RIGHT OUTER JOIN departments d 
                    ON e.department_id = d.department_id; 
                
-- FULL OUTER JOIN ANSI ����
SELECT e.employee_id, 
       e.first_name, 
       e.last_name, 
       d.department_name 
FROM   employees e 
       FULL OUTER JOIN departments d 
                    ON e.department_id = d.department_id;       

-- self join ����
SELECT emp.first_name, 
       mng.first_name 
FROM   employees emp 
       LEFT OUTER JOIN employees mng 
                    ON EMP.manager_id = mng.employee_id; 