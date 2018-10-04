-- ���� ���Ǵ� PL/SQL ���� ������ �� �ֵ��� ���ȭ�Ͽ� DBMS�� �����ϰ�, ���(ȣ��)
-- �μ���ȣ �޾� �������Ʈ ó��
CREATE OR REPLACE PROCEDURE listByDeptno(p_deptno employees.department_id%TYPE)
IS
	employee_record employees%ROWTYPE ;
    CURSOR employee_cursor IS
    	SELECT * FROM employees
        WHERE department_id = p_deptno;
BEGIN
	DBMS_OUTPUT.put_line('--- ��� ����Ʈ ---');
    FOR employee_record IN employee_cursor LOOP
    	--EXIT WHEN employee_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(p_deptno || ',' || employee_record.employee_id || ', ' || employee_record.first_name || ', ' || employee_record.salary);
    END LOOP;
END;

-- ���ν��� ����
--EXECUTE listByDeptno(100);
