-- Ư�� ���̺� � �̺�Ʈ(DML ����)�� �߻��Ǹ� �׿� ���� �ٸ� �۾���
-- �ڵ����� ����Ǵ� ���ν���
-- ����ڰ� ���� ������ �� ����.
CREATE OR REPLACE TRIGGER dept_insert_trigger
-- �̺�Ʈ ����: BEFORE | AFTER
-- �̺�Ʈ ����: insert | update | delete
AFTER INSERT -- �μ�Ʈ �̺�Ʈ �߻� �Ŀ�..
ON DEPARTMENTS
--FOR EACH ROW
/*
 * Ʈ��������
   - ���巹��Ʈ����: DML �߻��� �ѹ��� Ʈ���� ����
   - �෹��Ʈ���� : DML �߻��� �� ���� ����� ������ Ʈ���� ����
  */
BEGIN
	dbms_output.put_line('�μ����̺� �� �߰���...');
END;


