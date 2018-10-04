DECLARE
  -- ���۷��� Ÿ��
  employee_record  employees%ROWTYPE;-- ����ü ������ �����͸� ���� �� ��,,
  v_department_name departments.department_name%TYPE;
BEGIN
  -- �����̳� ���������� ������� �ʾƵ� ��..
  SELECT * INTO employee_record
  FROM employees
  WHERE first_name = 'Lisa';

  SELECT department_name INTO v_department_name
  FROM departments
  WHERE department_id = employee_record.department_id;

  DBMS_OUTPUT.put_line('====== �˻��� ��� ���� ======');
  DBMS_OUTPUT.put_line(employee_record.employee_id || ', ' || employee_record.first_name || ', ' || employee_record.salary || ', ' || v_department_name);
END;

