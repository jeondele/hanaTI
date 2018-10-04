/*
 * Ŀ��(CURSOR)
 * SELECT���� ó������� ó���ϱ� ���� �������� Ȯ���ϴ� �޸� ����
 * SELECT���� ��������� �������� ��� �ݵ�� Ŀ���� �̿��ؾ� �Ѵ�.
 */
DECLARE
	-- #1. Ŀ�� ����
    CURSOR department_cursor IS
    	SELECT department_id, department_name, location_id
      FROM DEPARTMENTS;
    --��������
    department_record department_cursor%ROWTYPE;
BEGIN
	-- #2. Ŀ�� ����(���Ǹ� �����ϰ� ��� ������ ������ ������� �����ϰ�,
    -- Ŀ���� ������� ù��°���� ����Ų��)
    OPEN department_cursor;

    LOOP
    	FETCH department_cursor INTO department_record.department_id, department_record.department_name, department_record.location_id;
        EXIT WHEN department_cursor%NOTFOUND;
        -- Ŀ���� �����ϴ� �Ӽ�(������Ƽ): FOUND, NOTFOUND, ROWCOUNT
        DBMS_OUTPUT.put_line(department_record.department_id || ',  ' || department_record.department_name || ',  '|| department_record.location_id);
    END LOOP;

	DBMS_OUTPUT.put_line(department_cursor%rowcount||'���� �˻��Ǿ����ϴ�.');

    -- #3.Ŀ�� �ݱ�
    CLOSE department_cursor;

   END;


