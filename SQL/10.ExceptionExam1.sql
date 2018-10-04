/*
 * ����(����)ó��
 * PL/SQL�� ������ ���ܶ� �Ѵ�.
 * ������ �� �������� ������ �߻��ϴ� ������ Ÿ�� ������, ���α׷��� ���� �� �߻��ϴ� ��Ÿ�� ������ ����
 *
 * 1) �̸� ���ǵ� ����Ŭ ���� ���� : ������ �ʿ䵵 ����, �߻��ÿ� �������� �ڵ� �̵�
 * 2) ����� ���� ����Ŭ ���� ���� : ����ο��� ���ܸ� �����ϰ� �߻��� �ڵ� �̵�
 * 3) ����� ���� ���� �߻� : ����ο��� ���ܸ� �����ϰ� ����ο��� RAISE ���� ���
 */

-- �̸� ���ǵ� ���� ���� ó��
DECLARE
     employee_record employees%ROWTYPE;

BEGIN
     SELECT employee_id, first_name, department_id
     	INTO employee_record.employee_id, employee_record.first_name, employee_record.department_id
     FROM employees
     WHERE department_id = 50 ;
     DBMS_OUTPUT.PUT_LINE('��� : ' || employee_record.employee_id);
     DBMS_OUTPUT.PUT_LINE('�̸� : ' || employee_record.first_name);
     DBMS_OUTPUT.PUT_LINE('�μ���ȣ : ' || employee_record.department_id);

-- �ڵ����� �Ѿ��. 
	EXCEPTION
      --UNIQUE ������ ���� �÷��� �ߺ��Ǵ� �����Ͱ� INSERT��
      WHEN DUP_VAL_ON_INDEX THEN 
          DBMS_OUTPUT.PUT_LINE('�̹� �����ϴ� ����Դϴ�.');
      -- �ϳ��� �����ؾ��ϴ� SELECT ���� �ϳ� �̻��� ���� ��ȯ�� ��
      WHEN TOO_MANY_ROWS THEN
          DBMS_OUTPUT.PUT_LINE('�˻��� ���� �ʹ� �����ϴ�.');
      -- SELECT ���� �ƹ��� ������ ���� ��ȯ���� ���Ҷ�
      WHEN NO_DATA_FOUND THEN
          DBMS_OUTPUT.PUT_LINE('�˻��� ����� �����ϴ�.');
      -- INVALID_CURSOR : �߸��� Ŀ�� ����
      WHEN OTHERS THEN
          DBMS_OUTPUT.PUT_LINE('�����ڿ��� ���ǹٶ��ϴ�.');
END;
