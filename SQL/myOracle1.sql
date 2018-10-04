SELECT employee_id, last_name, salary
FROM employees;

SELECT e.employee_id id, e.last_name ename, e.salary salary, to_char(e.hire_date, 'YYYY-MM-DD HH24:MI:SS')   hiredatee, d.department_name dname
FROM employees e
     JOIN departments d
       ON e.department_id = d.department_id;
       
INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES (DEPARTMENTS_SEQ.NEXTVAL, 'kosta', NULL, NULL);

select * from departments;

delete from departments where DEPARTMENT_ID = ?;
