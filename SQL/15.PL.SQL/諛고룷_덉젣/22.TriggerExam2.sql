CREATE OR REPLACE TRIGGER emp_insert_trigger
BEFORE INSERT --AFTER INSERT OR UPDATE OR delete
ON employees
FOR EACH ROW
-- ��� �߰��� salary�� ����
BEGIN
	UPDATE emp
    SET salary = salary + 5000;
END;
/* �׽�Ʈ SQL
insert into employees
values(207, '����', '��', 'kkkk@kkk.co.kr', '011.123.4567', sysdate, 'SH_CLERK', 5000, null, 100, 10);
*/