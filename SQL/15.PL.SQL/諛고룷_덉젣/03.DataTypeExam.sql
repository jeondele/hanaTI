/* 	����������(�⺻������ Ÿ��, ���۷���Ÿ��) */
DECLARE
	-- �⺻������Ÿ��
    v_search VARCHAR2(20) := 'Lisa';
    -- ���۷���Ÿ��
    v_name employees.last_name%TYPE;
    v_salary employees.salary%TYPE;
BEGIN
    SELECT last_name, salary INTO v_name, v_salary
    FROM employees
    WHERE first_name = v_search;
    DBMS_OUTPUT.put_line(v_name || ', ' || v_salary);
END;