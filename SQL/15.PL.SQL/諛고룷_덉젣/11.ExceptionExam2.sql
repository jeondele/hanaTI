-- ����� ���� ����Ŭ ���� ���� ó��
DECLARE
	-- ���ܼ��� �� ����Ŭ ���� ���� ��ȣ�� ����
    e_notnull EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_notnull, -1400);

BEGIN
	INSERT INTO employees(first_name, department_id)
  VALUES('James', 30);

	EXCEPTION
		WHEN e_notnull THEN
			DBMS_OUTPUT.PUT_LINE('�̸��� �ݵ�� �Է��Ͽ� �ּ���');
END;


