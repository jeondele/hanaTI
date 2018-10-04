SELECT first_name, department_name
FROM employees, departments;

SELECT E.First_Name, D.Department_Id
FROM employees e , departments d;

--ansi cross join 표준 규격(권장)
SELECT E.Employee_Id,
       E.Last_Name,
       E.Department_Id
FROM EMPLOYEES E
     CROSS JOIN DEPARTMENTS D;

-- 조인하고자 하는 두 테이블에서 공통적으로 존재하는 컬럼(department_id)의 값을 동등 비교하여 일치하는 행과 행을 조인     
-- ANSI 규격
SELECT    e.employee_id, 
          e.last_name, 
          d.department_name 
FROM      employees e 
          JOIN departments d 
          --ON e.department_id = d.department_id 
          USING (department_id) 
WHERE  e.salary >= 3000; 

---- 3개이상 테이블 조인
-- 딕셔너리 테이블로부터 테이블 종류 조회
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

-- 오라클 NON-EQUI JOIN
SELECT e.ename, 
       e.sal, 
       s.grade 
FROM   emp e, 
       salgrade s 
WHERE  e.sal BETWEEN s.losal AND s.hisal;

--범위를 가지고 하기 때문에 여러 행이 나올 수  있다.
SELECT e.employee_id, 
       e.last_name, 
       e.salary, 
       j.job_title 
FROM   employees e 
       JOIN jobs j 
ON  e.salary BETWEEN j.min_salary AND j.max_salary 
ORDER  BY e.employee_id; 

--시험은 ANSI 규격으로!
-- LEFT OUTER JOIN ANSI 버전
SELECT e.employee_id, 
       e.first_name, 
       e.last_name, 
       d.department_name 
FROM   employees e 
       LEFT OUTER JOIN departments d 
                    ON e.department_id = d.department_id; 
--WHERE  e.department_id IS NULL;

-- RIGHT OUTER JOIN ANSI 버전
SELECT e.employee_id, 
       e.first_name, 
       e.last_name, 
       d.department_name 
FROM   employees e 
       RIGHT OUTER JOIN departments d 
                    ON e.department_id = d.department_id; 
                
-- FULL OUTER JOIN ANSI 버전
SELECT e.employee_id, 
       e.first_name, 
       e.last_name, 
       d.department_name 
FROM   employees e 
       FULL OUTER JOIN departments d 
                    ON e.department_id = d.department_id;       

-- self join 버전
SELECT emp.first_name, 
       mng.first_name 
FROM   employees emp 
       LEFT OUTER JOIN employees mng 
                    ON EMP.manager_id = mng.employee_id; 