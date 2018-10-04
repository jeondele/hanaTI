--명시적 NULL 입력

-- 데이터 딕셔너리 조회
select *
from USER_CONSTRAINTS;

INSERT INTO departments 
                  (department_id, 
                   department_name, 
                   manager_id,  --FK : 입력하지 않는다는 뜻으로 NULL값을 입력
                   location_id) --FK
VALUES        (900, -- 오라클 객체 , 데이터베이스 객체 
               'KOSTA', 
                NULL, 
                NULL); 
SELECT * FROM DEPARTMENTS;

-- 시퀀스를 이용한 부서번호 입력 
INSERT INTO departments (department_id,  department_name, manager_id, location_id) 
VALUES       (departments_seq.NEXTVAL, 'KOSTA', NULL, NULL); 

/*
DELETE FROM departments 
WHERE  department_name LIKE '%KOSTA%'; 
*/

--데이터 딕셔너리 , 시스템 테이블에 해당, 프라이머리 키로 많이 쓴다.
SELECT * 
FROM   user_sequences; 

SELECT *
FROM user_tables;

-- 묵시적 NULL 입력 
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
VALUES     (EMPLOYEES_SEQ.NEXTVAL,  '전', '상일', 'jeondele@github.com','010.6642.1489', sysdate, 
            'IT_PROG', 10000, NULL, 103, 60); 
            
SELECT * FROM EMPLOYEES;
SELECT MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE MANAGER_ID =103;