/* �ݺ��� */
DECLARE
	i NUMBER := 0;
BEGIN
	LOOP
      i := i+1;
      -- ����
      EXIT WHEN i >= 10;
      DBMS_OUTPUT.PUT_LINE(i);
    END LOOP;
END ;