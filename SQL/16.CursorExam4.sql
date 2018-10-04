/* FOR...IN...LOOP...END LOOP;������ �ζ���Ŀ�� ����� */
DECLARE
	  v_total_salary NUMBER := 0;
    v_row_count NUMBER := 0;
BEGIN
	  DBMS_OUTPUT.put_line('=======================================');
    DBMS_OUTPUT.put_line('�����ȣ, ��-�̸�, �޿�, �޿�����');
    DBMS_OUTPUT.put_line('=======================================');

    FOR employee_record IN (SELECT employee_id, first_name, salary
                            FROM employees) LOOP
    		v_total_salary :=  v_total_salary + employee_record.salary;
        v_row_count := v_row_count + 1;
        DBMS_OUTPUT.put_line(employee_record.employee_id || ',  ' || employee_record.first_name || ',  ' || employee_record.salary || ', '  || v_total_salary);
    END LOOP;

    DBMS_OUTPUT.put_line(v_row_count||'���� �˻��Ǿ����ϴ�.');
END;