/* ��� ����ϱ� */
DECLARE
  v_no NUMBER(2) := 5;
  v_score NUMBER(3) := 80;
BEGIN
  -- �ܼ� if ~ end if;
  IF v_no = 5 THEN
  	DBMS_OUTPUT.put_line('5�Դϴ�..');
  END IF;

  -- if ~ else ~ end if;
  IF v_no = 4 THEN
  	DBMS_OUTPUT.put_line('5�Դϴ�..');
  ELSE
  	DBMS_OUTPUT.put_line('5�� �ƴմϴ�.');
  END IF;

  -- ���� if ~~ elseif ~ end if;
  IF v_score >=90 THEN
  	DBMS_OUTPUT.put_line('��');
  ELSIF v_score >=80 THEN
  	DBMS_OUTPUT.put_line('��');
  ELSIF v_score >= 70 THEN
  	DBMS_OUTPUT.put_line('��');
  ELSIF v_score >= 60 THEN
  	DBMS_OUTPUT.put_line('��');
  ELSE
  	DBMS_OUTPUT.put_line('��');
  END IF;
END;