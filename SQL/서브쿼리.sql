-- ���������� ������� ���� ���...
SELECT salary 
FROM   employees 
WHERE  LOWER(last_name) = 'seo';

SELECT * 
FROM   employees 
WHERE  salary = 2700; 

-- ������ ��������
SELECT * 
FROM   employees 
WHERE  salary = (SELECT salary 
                 FROM   employees 
                 WHERE  Lower(last_name) = 'seo'); 
                
SELECT * 
FROM   employees 
WHERE  salary > ANY (SELECT (salary) 
                      FROM    employees WHERE DEPARTMENT_ID = 30);

-- �μ��� �ּұ޿��� ����
SELECT * 
FROM   employees 
WHERE  ( department_id, salary ) IN(SELECT department_id, 
                                           MIN(salary) 
                                    FROM   employees 
                                    GROUP  BY department_id) 
ORDER  BY department_id;

-- �����÷�(ROWID, ROWNUM)
SELECT ROWID, 
       ROWNUM, 
       employee_id,
       last_name
FROM   employees;

-- ���̺��� ���� ���̶� ���� �ٸ� ROWNUM�� ���� �� �ִ�
-- ROWNUM : ������ ��. � �������� ������Ŀ� ���� �ٸ� ���� ������.
SELECT ROWNUM, employee_id
FROM   employees;

SELECT ROWNUM, employee_id
FROM   employees
ORDER BY employee_id DESC;

SELECT *
FROM   employees
WHERE  ROWNUM > 0;


-- ù��° ���� rownum�� 1�̹Ƿ�
-- 1 > 1�� false�� �Ǿ� rownum�� ���̻� �������� ������, �ϳ��� �൵ ��ȯ���� ����
SELECT *
FROM   employees
WHERE  ROWNUM > 1 ;

-- ù��° 10����(����)���� ��ȸ�� ���
-- ù��° ���� rownum�� 1�̹Ƿ�
-- 1 <= 10�� true�� �Ǿ� ù��° �࿡ 1�� �Ҵ�ǰ� rownum�� 2�� ����
SELECT *
FROM   employees
WHERE  ROWNUM <= 10;

/* Ư�� �÷��� �������� �����Ͽ� ���� 5��(����)�� ��ȸ�ϰ��� �Ѵٸ� */
-- ��)��ü ����� �޿������� 5�� ��������
-- ��ü �޿� ������ �ƴ� ó�� 5��ȿ����� �޿������� ��
SELECT first_name, salary
FROM   employees
WHERE  ROWNUM <=5
ORDER  BY salary DESC;

-- FROM������ ��������(Inline View)�� ����ؾ� �Ѵ�
SELECT * 
FROM   (SELECT * 
        FROM   employees 
        ORDER  BY salary DESC) 
WHERE  ROWNUM <= 5;


-- FROM������ ��������(Inline View)�� ����ؾ� �Ѵ�
SELECT * 
FROM   (SELECT employee_id, ROWNUM NUM FROM EMPLOYEES order by department_id)
WHERE NUM between 2 and 3
;

-- �޿������� 10 ~ 20 ����
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

-- �޿������� 10 ~ 20 ����
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

-- EXISTS ������ Ȱ��
-- ���������� ��� ������ ���� ��ȸ
-- EXIST���� ���������� ��� �ϳ� �����ؾ� SELECT ���� ����.

SELECT *
FROM   employees 
WHERE  EXISTS(SELECT * 
                     FROM   employees 
                     WHERE  department_id = 30);
           --AND department_id = 30;


