�� ���º� - ���ѽð� 40��(bangry313@naver.com �̸��� ����)

--1. employees ���̺��� �޿��� 5000�̻� 15000���� ���̿� ���Ե��� �ʴ� ����� �����ȣ(employee_id), �̸�(last_name), �޿�(salary), �Ի�����(hire_date)�� ��ȸ�Ͻÿ�.
SELECT employee_id "�����ȣ", 
       last_name   "�̸�", 
       salary      "�޿�", 
       hire_date   "�Ի�����" 
FROM   employees 
WHERE  NOT salary BETWEEN 5000 AND 15000; 
--2. �μ���ȣ(department_id) 50, ����(job_id) 'ST_MAN', �Ի��� 2004-7-18���� ����� �����ȣ, �̸�, ����, �Ի����� ��ȸ�Ͻÿ�.
SELECT department_id "�μ���ȣ", 
       job_id        "����", 
       hire_date     "�Ի���" 
FROM   employees 
WHERE  department_id = 50 
       AND job_id = 'ST_MAN' 
       AND hire_date = '2004-7-18'; 
--3. 2002�� ���� �Ի��� ����߿� ���('ST_MAN', 'ST_CLERK')������ ����ϴ� ������� ��� �÷��� ��ȸ�Ͻÿ�.
SELECT * 
FROM   employees 
WHERE  To_char(hire_date, 'YYYY') >= '2002' 
       AND job_id = 'ST_MAN' 
        OR job_id = 'ST_CLERK'; 
--4. ���(manager_id)�� ���� ����� ��� �÷��� ��ȸ�Ͻÿ�.
SELECT * 
FROM   employees 
WHERE  manager_id IS NULL; 
--!!5. �޿��� 10000 �̸��� ����߿��� ���('SH_CLERK')�̳� ����('PU_MAN', 'PU_CLERK')������ ����ϴ� ������� ��� �÷��� ��ȸ�Ͻÿ�.
SELECT * 
FROM   employees 
WHERE  ( salary < 10000 ) 
       AND job_id = 'SH_CLERK' 
        OR job_id = 'PU_MAN' 
        OR job_id = 'PU_CLERK'; 

--!!6. ����̸�(last_name)�� J, A �Ǵ� M���� �����ϴ� ��� ����� �̸�(ù ���ڴ� �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ� ǥ��) �� �̸� ���̸� ��ȸ�Ͻÿ�(��, last_name ���������� ���� ����).
SELECT Initcap(last_name) "����̸�", 
       Length(last_name)  "�̸� ����" 
FROM   employees 
WHERE  Initcap(last_name) LIKE 'J%' 
        OR Initcap(last_name) LIKE 'A%' 
        OR Initcap(last_name) LIKE 'M%' 
ORDER BY Length(last_name) ASC;

--7. �⵵�� �Ի��ο����� ��ȸ�Ͻÿ�.
SELECT To_char(hire_date, 'YYYY') "�⵵", 
       Count(*)                   "������ �Ի��ο� ��" 
FROM   employees 
GROUP  BY To_char(hire_date, 'YYYY'); 

--8. �����ȣ(employee_id)�� Ȧ���� ����� ��� ������ ��ȸ�Ͻÿ�.
SELECT * 
FROM   employees 
WHERE  MOD(employee_id, 2) = 1; 
--9.���ú��� 6���� �� ���ƿ��� ù��° �ݿ����� ��¥�� ����Ͻÿ�.
--   (��¥ ���� ��: 2002-06-05 15:23:10 �ݿ���)
SELECT TO_CHAR(Next_day(Add_months(SYSDATE, 6), 6), 'YYYY-MM-DD HH24:MI:SS') "���ƿ��� �ݿ���" 
FROM   dual; 

--!!10.�����ȣ(employee_id), �����(first_name), ����ȣ(manager_id)�� ��ȸ�ϵ�
--   ��簡 ����(NULL) ��� ����ȣ�� '�뻧'�̶� ����Ͻÿ�.
SELECT employee_id "�����ȣ", first_name "�����",
        DECODE(manager_id, NULL, '�뻧', manager_id)
FROM employees;

--11.������� 3���౸������ �з��ϱ� ���� ����� 3���� ������
--   �������� 0�̸� "��ȭ�����"
--   �������� 1�̸� "���׸���"
--   �������� 2�̸� "������"���� �з��Ͽ� ���̸�, �����ȣ, ������� ����Ͻÿ�.

SELECT first_name  "�����", 
       employee_id "�����ȣ", 
       CASE 
         WHEN MOD(employee_id, 3) = 0 THEN '��ȭ�����' 
         WHEN MOD(employee_id, 3) = 1 THEN '���׸���' 
         WHEN MOD(employee_id, 3) = 2 THEN '������' 
         ELSE '�ƹ� �� ����' 
       END         "���̸�" 
FROM   employees; 

--!!12.����� �޿��׷����� �Ʒ��� ���� ����Ͻÿ�.
--   Steven King     *****($5,000) // $1000�޷��� �� 1���߰�.
--   Neena Kochhar   ***($3,000)--    .........
--   XXXX XXXXX      *****************($17,000)
SELECT RPAD(First_Name||' '||Last_Name, 20,' ') "�̸�", 
       LPAD('($'||TRIM(to_char(salary,'999,999'))||')',(FLOOR(salary/1000))+LENGTH(salary)+4,'*')
FROM employees;

--13.2002�� 3������ 2003�� 2�� �Ⱓ ���� �Ի��� ����� ������� �μ��� �ο����� ��ȸ�Ͻÿ�.
--   (����� �ο����� ���� ������� �����Ͽ� ���)
  SELECT DEPARTMENT_ID, COUNT(*) "�μ��� �ο� ��"
  FROM EMPLOYEES
  WHERE To_char(hire_date, 'YYYY-MM-DD') BETWEEN '2002-03-00' AND '2003-02-00'
  GROUP BY DEPARTMENT_ID
  ORDER BY COUNT(*) DESC;
  
--!!14.������ ��� �޿��� ����϶�. ��, ��ձ޿��� 10000�� �ʰ��ϴ� ���� �����ϰ� ��� �޿��� ���� ������������ �����Ͻÿ�.
SELECT DEPARTMENT_ID "�μ�" , AVG(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING AVG(NVL(SALARY, 0)) <= 10000
ORDER BY AVG(SALARY) ASC;

--!!15.2004�⿡ �Ի��� ������� ������κ��� �б⺰ �Ի����� ���� �Ʒ��� ���� ����Ͻÿ�.(��Ʈ: ���˹��� Q Ȱ��)
--�б�   �����
-----------------
--1      3
--2      1
--3      2
select To_char(hire_date, 'Q') "�б�", count(*) "�����"
from employees
WHERE  To_char(hire_date, 'YYYY') = '2004'
group by  To_char(hire_date, 'Q');
