-- ����� ���� ���� �߻�
DECLARE
    e_user_exception EXCEPTION;
    cnt NUMBER;
BEGIN
	SELECT COUNT(employee_id)
		INTO cnt
    FROM employees
	WHERE department_id = 40;

    IF cnt < 5 THEN
    	-- RAISE ���� ����Ͽ� ���� ���� �߻�
        RAISE e_user_exception;
    END IF;

EXCEPTION
	WHEN e_user_exception THEN
		DBMS_OUTPUT.PUT_LINE('5�� ������ �� �����ϴ�.');
END;

