-- ���ν��� �Ű����� ó��
-- �����ȣ �Է¹޾� �޾� �����ȣ, �̸�, �޿� ���
CREATE OR REPLACE PROCEDURE getEmployee(in_id      IN  employees.employee_id%TYPE,
                                        out_id     OUT employees.employee_id%TYPE,
                                        out_name   OUT employees.first_name%TYPE,
                                        out_salary OUT employees.salary%TYPE)
IS

BEGIN
  	SELECT employee_id, first_name, salary INTO out_id, out_name, out_salary
    FROM employees
    WHERE employee_id = in_id;
END;

-- ���ν��� ����
-- ���Ϲ��� ���� �ޱ� ���� ��������
/*
VAR b_id NUMBER;
VAR b_name VARCHAR2(20);
VAR b_salary NUMBER;

EXECUTE getEmployee(100, :b_id, :b_name, :b_salary);
-- ������ ���
print b_id;
*/
