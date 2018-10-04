-- 서브쿼리를 사용하지 않을 경우...
SELECT salary 
FROM   employees 
WHERE  LOWER(last_name) = 'seo';

SELECT * 
FROM   employees 
WHERE  salary = 2700; 

-- 단일행 서브쿼리
SELECT * 
FROM   employees 
WHERE  salary = (SELECT salary 
                 FROM   employees 
                 WHERE  Lower(last_name) = 'seo'); 
                
SELECT * 
FROM   employees 
WHERE  salary > ANY (SELECT (salary) 
                      FROM    employees WHERE DEPARTMENT_ID = 30);

-- 부서별 최소급여자 정보
SELECT * 
FROM   employees 
WHERE  ( department_id, salary ) IN(SELECT department_id, 
                                           MIN(salary) 
                                    FROM   employees 
                                    GROUP  BY department_id) 
ORDER  BY department_id;

-- 가상컬럼(ROWID, ROWNUM)
SELECT ROWID, 
       ROWNUM, 
       employee_id,
       last_name
FROM   employees;

-- 테이블의 같은 행이라도 서로 다른 ROWNUM을 가질 수 있다
-- ROWNUM : 동적인 값. 어떤 셀렉문을 만드느냐에 따라 다른 값을 가진다.
SELECT ROWNUM, employee_id
FROM   employees;

SELECT ROWNUM, employee_id
FROM   employees
ORDER BY employee_id DESC;

SELECT *
FROM   employees
WHERE  ROWNUM > 0;


-- 첫번째 행의 rownum이 1이므로
-- 1 > 1은 false가 되어 rownum은 더이상 증가하지 않으며, 하나의 행도 반환되지 않음
SELECT *
FROM   employees
WHERE  ROWNUM > 1 ;

-- 첫번째 10개행(범위)만을 조회할 경우
-- 첫번째 행의 rownum이 1이므로
-- 1 <= 10은 true가 되어 첫번째 행에 1이 할당되고 rownum은 2로 증가
SELECT *
FROM   employees
WHERE  ROWNUM <= 10;

/* 특정 컬럼을 기준으로 정렬하여 상위 5개(범위)를 조회하고자 한다면 */
-- 예)전체 사원의 급여순으로 5명 가져오기
-- 전체 급여 순위가 아닌 처음 5명안에서의 급여순위가 됨
SELECT first_name, salary
FROM   employees
WHERE  ROWNUM <=5
ORDER  BY salary DESC;

-- FROM절에서 서브쿼리(Inline View)를 사용해야 한다
SELECT * 
FROM   (SELECT * 
        FROM   employees 
        ORDER  BY salary DESC) 
WHERE  ROWNUM <= 5;


-- FROM절에서 서브쿼리(Inline View)를 사용해야 한다
SELECT * 
FROM   (SELECT employee_id, ROWNUM NUM FROM EMPLOYEES order by department_id)
WHERE NUM between 2 and 3
;

-- 급여순으로 10 ~ 20 사이
SELECT page, 
       employee_id, 
       first_name, 
       salary 
FROM   (SELECT CEIL(ROWNUM / 10) page, 
               employee_id, 
               first_name, 
               salary 
        FROM   (SELECT ROWNUM num, 
                          employee_id, 
                          first_name, 
                          salary 
                   FROM   employees 
                   ORDER  BY salary DESC)) 
WHERE  page = 1; 

-- 급여순으로 10 ~ 20 사이
SELECT  
       employee_id, 
       first_name, 
       salary 
FROM   (SELECT ROWNUM num, 
               employee_id, 
               first_name, 
               salary 
        FROM   employees 
        ORDER  BY salary DESC) 
WHERE  num BETWEEN 1 and 10; 

-- EXISTS 연산자 활용
-- 서브쿼리의 결과 유무에 따른 조회
-- EXIST안의 서브쿼리가 적어도 하나 존재해야 SELECT 문을 실행.

SELECT *
FROM   employees 
WHERE  EXISTS(SELECT * 
                     FROM   employees 
                     WHERE  department_id = 30);
           --AND department_id = 30;


