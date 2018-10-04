-- 문자열 관련 단일행 함수
SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;

-- dual이라는 테이블에 테스트 할 수 있도록 가상테이블을 만들어 놓은 것.
DESC dual;

SELECT *
FROM DUAL;

-- 스페이스 기분으로 단어단어마다 대문자로 바꾸어 준다.
SELECT INITCAP('j s i jeon sang il')
FROM dual;

-- 전자 where 절은 소문자 james이기 때문에 안떨어진다. 후자로 하면 대소문자 구분하지않고 조회가 가능하다.
SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james';

SELECT UPPER('bangry')
FROM dual;

-- 왼쪽 공백 부분 *로 채우기
SELECT LPAD('DataBase', 10, '*')
FROM dual;

-- 오른쪽 공백 부분 *로 채우기
SELECT RPAD('DataBase', 10, '*')
FROM dual;

--SQL은 1부터 시작 다음 파라미터는 뽑아낼 글자의 갯수를 의미한다.
SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

--다음 파라미터 안쓰면 뒤에 전부다 뽑아내기
SELECT SUBSTR('서울시가산동', 4)
FROM dual;

SELECT first_name, LENGTH(first_name)
FROM employees;

--해당 문자열을 최고로 바꾼다
SELECT REPLACE('기정바보', '기', '최고')
FROM dual;

SELECT REPLACE('서울 시', ' ', '')
FROM dual;

-- B가 몇번째에 위치하는 가 // 없으면 0
SELECT INSTR('DataBase', 'a', 4, 2)
FROM dual;

--n 시작 위치에서 index 몇번째에 출현하는가
-- a 시작 위치에서 2번째에 출현
-- INSTR('비교할 대상', '비교하고자하는 값', 비교를 시작할 위치, 검색된 결과의 순번)
SELECT INSTR('DataBase', 'a', 3, 2)
FROM dual;

--SELECT LTRIM('    JavaDeveloper')
--SELECT LTRIM('    JavaDeveloper', ' ')
-- JAVA를 지운다
SELECT LTRIM('JavaDeveloper', 'Java')
FROM dual;

--SELECT RTRIM('JavaDeveloper      ')
--SELECT RTRIM('JavaDeveloper      ', ' ')
SELECT RTRIM('JavaDeveloper', 'Developer')
FROM dual;

--양쪽 다 지우기
SELECT TRIM('      Java  Developer      ')
FROM dual;


-- 숫자 관련 단일행 함수 (기본 소숫점 이하
SELECT  ROUND(45.923), ROUND(45.923, 0), ROUND(45.923, 1), ROUND(45.923, 2), ROUND(45.923, -1)
FROM dual;

--절하
SELECT  TRUNC(45.923), TRUNC(45.923, 0), TRUNC(45.923, 2), TRUNC(45.923, -1) 
FROM dual;

SELECT  MOD(123456, 2)
FROM dual;

SELECT  CEIL(123.123)
FROM dual;

SELECT  FLOOR(123.123)
FROM dual;

SELECT  ABS(-500)
FROM dual;

SELECT  LN(10)
FROM dual;

SELECT  POWER(5, 2), SQRT(5), SIN(30), COS(30), TAN(30)
FROM dual;

-- 전달인자중 최소값 반환
SELECT  LEAST(10, 20, 30, 40)
FROM dual;

-- 전달인자중 최대값 반환
SELECT  GREATEST(10, 20, 30, 40)
FROM dual;

-- 날짜함수

--괄호가 없음. 오라클 엔진이 제공하는 현재 시스템 날짜
SELECT SYSDATE
FROM dual;

-- DATE 타입에 연산 가능(DATE도 숫자를 기본으로 하고 있기 때문에 +-가 가능하다
SELECT SYSDATE - 1 "어제" , SYSDATE "오늘", SYSDATE + 1 "내일"
FROM dual;

-- 사원별 근무 일수 검색 (빼면 1일로 계산한다.)
SELECT first_name,  hire_date, SYSDATE, CEIL(SYSDATE - hire_date) "근무일수"
FROM employees;

-- 사원별 근무 개월수 검색
SELECT first_name, TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date))  "근무개월수"
FROM employees;

-- 특정개월수를 더한 날짜 반환
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) "오늘부터 2개월 후"
FROM dual;

-- 이번주 토요일 날짜 (이번주에 포함된 토요일)
SELECT SYSDATE "오늘", NEXT_DAY(SYSDATE, 7) "이번주 토요일"
FROM dual;

SELECT SYSDATE "오늘", NEXT_DAY(SYSDATE, '토요일') "이번주 토요일"
FROM dual;

SELECT SYSDATE "오늘", NEXT_DAY(SYSDATE, '토') "이번주 토요일"
FROM dual;

-- 이번달 마지막 날짜
SELECT SYSDATE "오늘", NEXT_DAY(SYSDATE, '토') "이번주 토요일"
FROM dual;

--형변환 함수 (SQL DEVELOPER
SELECT TO_DATE('2011/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

--연월일만 비교하는 것
SELECT first_name, hire_date
FROM employees;

--TO_DATE : 연월일 시분초까지 비교하고자 한다.
SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('2003-06-17 18:45:23', 'YYYY-MM-DD HH24:MI:SS');

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE(20030617, 'YYYY-MM-DD');

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('2002/01/13', 'YYYY-MM-DD');


SELECT TO_NUMBER('12345') + 1
FROM dual;

SELECT TO_NUMBER('12,345', '00,000') + 1
FROM dual;

SELECT TO_NUMBER('1000') + TO_NUMBER('2,000', '0,000') + 1
FROM dual;

SELECT TO_CHAR(12345), TO_CHAR(12345.67)
FROM dual;

--포맷문자열 0은 무조건 나오는 자릿수, 9는 없으면 안나오는 자릿수 
SELECT TO_CHAR(12345, '999,999'), TO_CHAR(12345.677, '999,999.99')
FROM dual;

SELECT TO_CHAR(12345, '000,000'), TO_CHAR(12345.677, '000,000.00')
FROM dual;

SELECT TO_CHAR(150, '$9999'), TO_CHAR(150, '$0000')
FROM dual;

SELECT TO_CHAR(150, 'S9999'), TO_CHAR(150, 'S0000')
FROM dual;

SELECT TO_CHAR(150, '9999MI'), TO_CHAR(-150, '9999MI')
FROM dual;

SELECT TO_CHAR(150, '9999EEEE'), TO_CHAR(150, '99999B')
FROM dual;

SELECT TO_CHAR(150, 'RN'), TO_CHAR(150, 'rn')
FROM dual;

SELECT TO_CHAR(10, 'X'), TO_CHAR(10, 'x'), TO_CHAR(15, 'X')
FROM dual;

-- SYSDATE를 내가 원하는대로 뽑아내고 싶을 때
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY')
FROM dual;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY', 'NLS_DATE_LANGUAGE=ENGLISH')
--SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY', 'NLS_DATE_LANGUAGE=ENGLISH')
FROM dual;

-- 초기 파라메터(환경설정) 목록 검색
SELECT * FROM  NLS_SESSION_PARAMETERS;

SELECT first_name, hire_date, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI')
FROM employees;

-- 입사년도가 2002년도인 사원들 //제일 쉬운 방법
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') = '2002';

-- NULL값을 다른 값으로 변환할 때 사용 가능 

SELECT 10 * NULL, 10 * NVL(NULL, 1)
FROM dual;

SELECT first_name, salary, commission_pct, ( salary + ( salary * commission_pct ) ) * 12 "연봉"
FROM   employees
ORDER BY "연봉" DESC;

SELECT first_name, 
          salary, 
          NVL(commission_pct, 0 ), 
          ( salary + ( salary * NVL(commission_pct, 0) ) ) * 12 "연봉" 
FROM   employees;

SELECT first_name, 
          job_id, 
          salary, 
          DECODE(job_id, 'IT_PROG', salary * 1.5, 
                              'AC_MRG', salary * 1.3, 
                              'AC_ASST', salary * 1.1, 
                              salary) "인상된급여" 
FROM   employees;

SELECT first_name, 
          department_id, 
          CASE 
             WHEN department_id = 10 THEN '영업부' 
             WHEN department_id = 20 THEN '총무부' 
             WHEN department_id = 30 THEN '인사부' 
             ELSE '인사발령' 
          END "부서명" 
FROM   employees 
ORDER  BY department_id ASC;

-- 그룹함수
-- 커미션을 받는 사원의 수(이때 NULL은 개수에 포함하지 않음)
SELECT COUNT(commission_pct)
FROM employees;

-- * : NULL값을 개수에 포함, COUNT(commission_pct)-> null 빠짐
SELECT COUNT(*) "전체사원수", COUNT(commission_pct) "커미션사원수"
FROM employees;

-- 급여 총액(NULL은 무시) 
SELECT SUM(salary), SUM(commission_pct)
FROM employees;

-- 급여 평균(NULL은 무시)
SELECT AVG(salary)
FROM employees;

-- 107명에 대한 평균이므로 null값을 바꿔줘야한다. 
SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;

-- 최대값, 최소값
SELECT MAX(salary), MAX(commission_pct)
FROM employees;

SELECT MAX(hire_date), MIN(hire_date), MAX(hire_date) - MIN(hire_date) "짬밥차" 
FROM employees;

-- GROUP BY 절(특정 컬럼을 기준으로 그룹핑)
SELECT department_id
FROM employees
GROUP BY department_id;

-- 부서별 급여총액, 평균
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id;

-- HAVING 절(그룹에 대한 조건)
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING department_id = 20;

SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary) >= 3000;

SELECT department_id, MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) > 20000; 

SELECT  hire_date, COUNT(*)
FROM employees
GROUP BY hire_date
ORDER BY hire_date ASC;  
--ORDER BY COUNT(*);

DESC Employees;

