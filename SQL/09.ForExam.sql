--Ŭ���̾�Ʈ���� §��ó�� �������� �������� �������Ѽ� �����ִ� ��
BEGIN

  FOR i IN 0..9 LOOP
  	DBMS_OUTPUT.PUT_LINE(i || ': ����� �ְ�');
  END LOOP;

  -- ������ ���
  FOR i IN 2..9 LOOP
  	FOR j IN 1..9 LOOP
  		DBMS_OUTPUT.PUT(i ||'*' || j ||'=' || i*j || ' ');
  	END LOOP;
  	DBMS_OUTPUT.PUT_LINE(' ');
  END LOOP;
END;