-- ���ڿ� ���� ������ �Լ�
SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;

-- dual�̶�� ���̺� �׽�Ʈ �� �� �ֵ��� �������̺��� ����� ���� ��.
DESC dual;

SELECT *
FROM DUAL;

-- �����̽� ������� �ܾ�ܾ�� �빮�ڷ� �ٲپ� �ش�.
SELECT INITCAP('j s i jeon sang il')
FROM dual;

-- ���� where ���� �ҹ��� james�̱� ������ �ȶ�������. ���ڷ� �ϸ� ��ҹ��� ���������ʰ� ��ȸ�� �����ϴ�.
SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james';

SELECT UPPER('bangry')
FROM dual;

-- ���� ���� �κ� *�� ä���
SELECT LPAD('DataBase', 10, '*')
FROM dual;

-- ������ ���� �κ� *�� ä���
SELECT RPAD('DataBase', 10, '*')
FROM dual;

--SQL�� 1���� ���� ���� �Ķ���ʹ� �̾Ƴ� ������ ������ �ǹ��Ѵ�.
SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

--���� �Ķ���� �Ⱦ��� �ڿ� ���δ� �̾Ƴ���
SELECT SUBSTR('����ð��굿', 4)
FROM dual;

SELECT first_name, LENGTH(first_name)
FROM employees;

--�ش� ���ڿ��� �ְ�� �ٲ۴�
SELECT REPLACE('�����ٺ�', '��', '�ְ�')
FROM dual;

SELECT REPLACE('���� ��', ' ', '')
FROM dual;

-- B�� ���°�� ��ġ�ϴ� �� // ������ 0
SELECT INSTR('DataBase', 'a', 4, 2)
FROM dual;

--n ���� ��ġ���� index ���°�� �����ϴ°�
-- a ���� ��ġ���� 2��°�� ����
-- INSTR('���� ���', '���ϰ����ϴ� ��', �񱳸� ������ ��ġ, �˻��� ����� ����)
SELECT INSTR('DataBase', 'a', 3, 2)
FROM dual;

--SELECT LTRIM('    JavaDeveloper')
--SELECT LTRIM('    JavaDeveloper', ' ')
-- JAVA�� �����
SELECT LTRIM('JavaDeveloper', 'Java')
FROM dual;

--SELECT RTRIM('JavaDeveloper      ')
--SELECT RTRIM('JavaDeveloper      ', ' ')
SELECT RTRIM('JavaDeveloper', 'Developer')
FROM dual;

--���� �� �����
SELECT TRIM('      Java  Developer      ')
FROM dual;


-- ���� ���� ������ �Լ� (�⺻ �Ҽ��� ����
SELECT  ROUND(45.923), ROUND(45.923, 0), ROUND(45.923, 1), ROUND(45.923, 2), ROUND(45.923, -1)
FROM dual;

--����
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

-- ���������� �ּҰ� ��ȯ
SELECT  LEAST(10, 20, 30, 40)
FROM dual;

-- ���������� �ִ밪 ��ȯ
SELECT  GREATEST(10, 20, 30, 40)
FROM dual;

-- ��¥�Լ�

--��ȣ�� ����. ����Ŭ ������ �����ϴ� ���� �ý��� ��¥
SELECT SYSDATE
FROM dual;

-- DATE Ÿ�Կ� ���� ����(DATE�� ���ڸ� �⺻���� �ϰ� �ֱ� ������ +-�� �����ϴ�
SELECT SYSDATE - 1 "����" , SYSDATE "����", SYSDATE + 1 "����"
FROM dual;

-- ����� �ٹ� �ϼ� �˻� (���� 1�Ϸ� ����Ѵ�.)
SELECT first_name,  hire_date, SYSDATE, CEIL(SYSDATE - hire_date) "�ٹ��ϼ�"
FROM employees;

-- ����� �ٹ� ������ �˻�
SELECT first_name, TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date))  "�ٹ�������"
FROM employees;

-- Ư���������� ���� ��¥ ��ȯ
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) "���ú��� 2���� ��"
FROM dual;

-- �̹��� ����� ��¥ (�̹��ֿ� ���Ե� �����)
SELECT SYSDATE "����", NEXT_DAY(SYSDATE, 7) "�̹��� �����"
FROM dual;

SELECT SYSDATE "����", NEXT_DAY(SYSDATE, '�����') "�̹��� �����"
FROM dual;

SELECT SYSDATE "����", NEXT_DAY(SYSDATE, '��') "�̹��� �����"
FROM dual;

-- �̹��� ������ ��¥
SELECT SYSDATE "����", NEXT_DAY(SYSDATE, '��') "�̹��� �����"
FROM dual;

--����ȯ �Լ� (SQL DEVELOPER
SELECT TO_DATE('2011/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

--�����ϸ� ���ϴ� ��
SELECT first_name, hire_date
FROM employees;

--TO_DATE : ������ �ú��ʱ��� ���ϰ��� �Ѵ�.
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

--���˹��ڿ� 0�� ������ ������ �ڸ���, 9�� ������ �ȳ����� �ڸ��� 
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

-- SYSDATE�� ���� ���ϴ´�� �̾Ƴ��� ���� ��
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY')
FROM dual;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY', 'NLS_DATE_LANGUAGE=ENGLISH')
--SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY', 'NLS_DATE_LANGUAGE=ENGLISH')
FROM dual;

-- �ʱ� �Ķ����(ȯ�漳��) ��� �˻�
SELECT * FROM  NLS_SESSION_PARAMETERS;

SELECT first_name, hire_date, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI')
FROM employees;

-- �Ի�⵵�� 2002�⵵�� ����� //���� ���� ���
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') = '2002';

-- NULL���� �ٸ� ������ ��ȯ�� �� ��� ���� 

SELECT 10 * NULL, 10 * NVL(NULL, 1)
FROM dual;

SELECT first_name, salary, commission_pct, ( salary + ( salary * commission_pct ) ) * 12 "����"
FROM   employees
ORDER BY "����" DESC;

SELECT first_name, 
          salary, 
          NVL(commission_pct, 0 ), 
          ( salary + ( salary * NVL(commission_pct, 0) ) ) * 12 "����" 
FROM   employees;

SELECT first_name, 
          job_id, 
          salary, 
          DECODE(job_id, 'IT_PROG', salary * 1.5, 
                              'AC_MRG', salary * 1.3, 
                              'AC_ASST', salary * 1.1, 
                              salary) "�λ�ȱ޿�" 
FROM   employees;

SELECT first_name, 
          department_id, 
          CASE 
             WHEN department_id = 10 THEN '������' 
             WHEN department_id = 20 THEN '�ѹ���' 
             WHEN department_id = 30 THEN '�λ��' 
             ELSE '�λ�߷�' 
          END "�μ���" 
FROM   employees 
ORDER  BY department_id ASC;

-- �׷��Լ�
-- Ŀ�̼��� �޴� ����� ��(�̶� NULL�� ������ �������� ����)
SELECT COUNT(commission_pct)
FROM employees;

-- * : NULL���� ������ ����, COUNT(commission_pct)-> null ����
SELECT COUNT(*) "��ü�����", COUNT(commission_pct) "Ŀ�̼ǻ����"
FROM employees;

-- �޿� �Ѿ�(NULL�� ����) 
SELECT SUM(salary), SUM(commission_pct)
FROM employees;

-- �޿� ���(NULL�� ����)
SELECT AVG(salary)
FROM employees;

-- 107�� ���� ����̹Ƿ� null���� �ٲ�����Ѵ�. 
SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;

-- �ִ밪, �ּҰ�
SELECT MAX(salary), MAX(commission_pct)
FROM employees;

SELECT MAX(hire_date), MIN(hire_date), MAX(hire_date) - MIN(hire_date) "«����" 
FROM employees;

-- GROUP BY ��(Ư�� �÷��� �������� �׷���)
SELECT department_id
FROM employees
GROUP BY department_id;

-- �μ��� �޿��Ѿ�, ���
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id;

-- HAVING ��(�׷쿡 ���� ����)
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

