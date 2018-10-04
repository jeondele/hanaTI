DECLARE
	CURSOR employee_cursor IS
    	SELECT employee_id, first_name, salary
      FROM employees;

  employee_record employee_cursor%ROWTYPE;

  v_totalsalary NUMBER := 0;

BEGIN
	OPEN employee_cursor;

    DBMS_OUTPUT.put_line('=======================================');
    DBMS_OUTPUT.put_line('�����ȣ, ����̸�, �޿�, �޿�����');
    DBMS_OUTPUT.put_line('=======================================');

    LOOP
    	FETCH employee_cursor  INTO employee_record;
        EXIT WHEN employee_cursor%NOTFOUND;
        v_totalsalary :=  v_totalsalary + employee_record.salary;
        DBMS_OUTPUT.put_line(employee_record.employee_id || ',  ' || employee_record.first_name || ',  ' || employee_record.salary || ', '  || v_totalsalary);
    END LOOP;

    DBMS_OUTPUT.put_line(employee_cursor%rowcount||'���� �˻��Ǿ����ϴ�.');

    CLOSE employee_cursor;

END;