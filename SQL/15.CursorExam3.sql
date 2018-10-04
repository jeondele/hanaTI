/* FOR...IN...LOOP...END LOOP;�� �̿��Ͽ� �����ϰ� Ŀ�� ���*/
DECLARE
	CURSOR employee_cursor IS
    	SELECT employee_id, first_name, salary
      FROM employees;

    employee_record employee_cursor%ROWTYPE;
    v_total_salary NUMBER := 0;
    v_row_count NUMBER := 0;

BEGIN
	--OPEN employee_cursor;
    DBMS_OUTPUT.put_line('=======================================');
    DBMS_OUTPUT.put_line('�����ȣ, ��-�̸�, �޿�, �޿�����');
    DBMS_OUTPUT.put_line('=======================================');

    FOR employee_record IN employee_cursor LOOP
    	--FETCH employee_cursor  INTO employee_record;
        --EXIT WHEN employee_cursor%NOTFOUND;
        v_total_salary :=  v_total_salary + employee_record.salary;
        v_row_count := v_row_count + 1;
        DBMS_OUTPUT.put_line(employee_record.employee_id || ',  ' || employee_record.first_name || ',  ' || employee_record.salary || ',  '  || v_total_salary);
    END LOOP;
    DBMS_OUTPUT.put_line(v_row_count||'���� �˻��Ǿ����ϴ�.');
    --CLOSE employee_cursor;

END;