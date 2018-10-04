--CREATE TABLE users(
--     id VARCHAR2(8),
--     name VARCHAR2(20) NOT NULL,
--     passwd VARCHAR2(8) NOT NULL,
--     email VARCHAR2(50) NOT NULL,
--     regdate DATE DEFAULT SYSDATE,
--     CONSTRAINT users_id_pk PRIMARY KEY(id)
--);

desc users;

insert into users(id, name, passwd, email, regdate) values ('jeondele', '¿¸ªÛ¿œ', 1234, 'jeondele@github.com', sysdate);
insert into users(id, name, passwd, email, regdate) values ('adele', 'æ∆µ®', 1234, 'adele@github.com', sysdate);
commit;

select * from users;

select * from users where id = 'jeondele' and passwd = 'w';
select id, name, passwd, email, regdate from users where id = 'jeondele';
delete from users where id ='jeondele';
commit;
rollback;

select e.employee_id id, e.last_name name, e.salary sal, d.department_name dName, l.city city
from employees e left outer join departments d
  on e.department_id = d.department_id 
       left outer JOIN locations l 
         ON d.location_id = l.location_id
order by id asc;

UPDATE users
SET name = 'æ∆µ®', passwd = '1234', email = 'adele@github.com', regdate = sysdate
WHERE id = 'adele';

desc employees;
desc departments;
desc locations;