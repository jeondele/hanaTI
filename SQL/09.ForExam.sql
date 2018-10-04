--클라이언트에서 짠거처럼 보이지만 서버에서 구동시켜서 보여주는 것
BEGIN

  FOR i IN 0..9 LOOP
  	DBMS_OUTPUT.PUT_LINE(i || ': 김기정 최고');
  END LOOP;

  -- 구구단 출력
  FOR i IN 2..9 LOOP
  	FOR j IN 1..9 LOOP
  		DBMS_OUTPUT.PUT(i ||'*' || j ||'=' || i*j || ' ');
  	END LOOP;
  	DBMS_OUTPUT.PUT_LINE(' ');
  END LOOP;
END;