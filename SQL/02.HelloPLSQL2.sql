/*
 * Ư�� ���̺��� ���� �˻��Ͽ� ������ �Ҵ��� �� ���
 */
DECLARE
    v_name VARCHAR2(20);
    v_salary NUMBER(8, 2);
    v_hiredate VARCHAR2(30);
BEGIN
    SELECT first_name, salary, TO_CHAR(hire_date, 'yyyy-MM-dd') INTO v_name, v_salary, v_hiredate
    FROM EMPLOYEES
    WHERE first_name = 'Ellen';

	  dbms_output.put_line('�˻��� ��� ����');
	  dbms_output.put_line(v_name || ' ' || v_salary || ' ' || v_hiredate);
END;
