--����� NULL �Է�

-- ������ ��ųʸ� ��ȸ
select *
from USER_CONSTRAINTS;

INSERT INTO departments 
                  (department_id, 
                   department_name, 
                   manager_id,  --FK : �Է����� �ʴ´ٴ� ������ NULL���� �Է�
                   location_id) --FK
VALUES        (900, -- ����Ŭ ��ü , �����ͺ��̽� ��ü 
               'KOSTA', 
                NULL, 
                NULL); 
SELECT * FROM DEPARTMENTS;

-- �������� �̿��� �μ���ȣ �Է� 
INSERT INTO departments (department_id,  department_name, manager_id, location_id) 
VALUES       (departments_seq.NEXTVAL, 'KOSTA', NULL, NULL); 

/*
DELETE FROM departments 
WHERE  department_name LIKE '%KOSTA%'; 
*/

--������ ��ųʸ� , �ý��� ���̺� �ش�, �����̸Ӹ� Ű�� ���� ����.
SELECT * 
FROM   user_sequences; 

SELECT *
FROM user_tables;

-- ������ NULL �Է� 
INSERT INTO departments (department_id, department_name) 
VALUES     (510,  'KOSTA1'); 


CREATE TABLE dept
     AS SELECT * 
        FROM DEPARTMENTS
        WHERE 0 = 1;

insert into dept
select * from DEPARTMENTS;

-- UPDATE
UPDATE employees 
SET    salary = salary * 1.1 
WHERE  department_id = 30;

-- DELETE
DELETE FROM departments 
WHERE  department_name LIKE '%KOSTA%'; 

DELETE FROM departments 
WHERE  department_name LIKE '%KOSTA%'; 

DELETE FROM EMP 
WHERE  salary > (SELECT AVG   (salary) 
                       FROM   employees); 

INSERT INTO EMPLOYEES (EMPLOYEE_ID,
                        FIRST_NAME,
                        LAST_NAME,
                        EMAIL,
                        PHONE_NUMBER,
                        HIRE_DATE,
                        JOB_ID,
                        SALARY,
                        COMMISSION_PCT,
                        MANAGER_ID,
                        DEPARTMENT_ID
                       ) 
VALUES     (EMPLOYEES_SEQ.NEXTVAL,  '��', '����', 'jeondele@github.com','010.6642.1489', sysdate, 
            'IT_PROG', 10000, NULL, 103, 60); 
            
SELECT * FROM EMPLOYEES;
SELECT MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE MANAGER_ID =103;