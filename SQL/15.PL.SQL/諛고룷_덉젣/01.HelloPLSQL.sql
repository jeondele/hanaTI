SET SERVEROUTPUT ON;

-- SQL Plus���� ����� set serveroutput on; ���� �ʿ�...
-- �����
DECLARE
	-- ��������
  v_no NUMBER(3) := 10;
  -- ���ó��
  c_message CONSTANT VARCHAR2(50) := '�ȳ��ϼ��� PL/SQL';
  v_hireDate VARCHAR2(30) := TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS');
-- �����
BEGIN
	-- DBMS_OUTPUT ��Ű���� put_line ���ν����� �̿��� ��� ���
  dbms_output.put_line('--- ���ú��� PL/SQL�Դϴ� ---');
	dbms_output.put_line(v_no);
  dbms_output.put_line(c_message);
  dbms_output.put_line(v_hiredate);
END;