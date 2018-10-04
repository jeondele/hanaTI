-- SAMPLE DATA INSERT
--locations ���õ����� �Է�

INSERT INTO locations 
            (location_no, 
             location_name) 
VALUES     (1, 
            'NA'); 

INSERT INTO locations 
            (location_no, 
             location_name) 
VALUES     (2, 
            'SA'); 

INSERT INTO locations 
            (location_no, 
             location_name) 
VALUES     (3, 
            'AF'); 

INSERT INTO locations 
            (location_no, 
             location_name) 
VALUES     (4, 
            'ME'); 

INSERT INTO locations 
            (location_no, 
             location_name) 
VALUES     (5, 
            'EU'); 

--address���õ�����
INSERT INTO address 
            (address_no, 
             location_no, 
             city, 
             post_no, 
             address_name) 
VALUES     (1, 
            1, 
            'Seattle', 
            '98101', 
            '1823 Minor Ave, Seattle WA 98101'); 

INSERT INTO address 
            (address_no, 
             location_no, 
             city, 
             post_no, 
             address_name) 
VALUES     (2, 
            2, 
            'Sao Paulo', 
            '17800-000', 
'Estrada De Servidao Jose M. Almeida Silva | Bairro Corrego, Adamantina, State of Sao Paulo' 
); 

INSERT INTO address 
            (address_no, 
             location_no, 
             city, 
             post_no, 
             address_name) 
VALUES     (3, 
            3, 
            'Kumasi', 
            '103', 
            '103 Old Bekwai Rd, Kumasi, Ghana'); 

--departments���õ�����
INSERT INTO departments 
            (dept_no, 
             address_no, 
             dept_name) 
VALUES     (10, 
            1, 
            'Sales'); 

INSERT INTO departments 
            (dept_no, 
             address_no, 
             dept_name) 
VALUES     (20, 
            1, 
            'Executive'); 

INSERT INTO departments 
            (dept_no, 
             address_no, 
             dept_name) 
VALUES     (30, 
            1, 
            'Marketing'); 

INSERT INTO departments 
            (dept_no, 
             address_no, 
             dept_name) 
VALUES     (40, 
            1, 
            'Accounting'); 

--jobs ���õ����� 
INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (1, 
            'Chief executive officer'); 

INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (2, 
            'Sales Manager'); 

INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (3, 
            'Sales Representative'); 

INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (4, 
            'Accounting Manager'); 

INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (5, 
            'Accountant'); 

INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (6, 
            'Marketing Manager'); 

INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (7, 
            'Marketing Representative'); 

INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (8, 
            'Executive Manager'); 

INSERT INTO jobs 
            (job_no, 
             job_name) 
VALUES     (9, 
            'Executive Representative'); 

--cummissions ���õ�����
INSERT INTO commissions 
            (commission_no, 
             commission_rate) 
VALUES     (1, 
            10); 

INSERT INTO commissions 
            (commission_no, 
             commission_rate) 
VALUES     (2, 
            12.5); 

INSERT INTO commissions 
            (commission_no, 
             commission_rate) 
VALUES     (3, 
            15); 

INSERT INTO commissions 
            (commission_no, 
             commission_rate) 
VALUES     (4, 
            17.5); 

INSERT INTO commissions 
            (commission_no, 
             commission_rate) 
VALUES     (5, 
            20); 

--employees ���õ�����
INSERT INTO employees 
            (employee_no, 
             commission_no, 
             job_no, 
             dept_no, 
             position, 
             salary, 
             comments, 
             employee_system_id, 
             last_name, 
             hiredate, 
             first_name, 
             employee_pw) 
VALUES     (1, 
            5, 
            1, 
            20, 
            '�̻�', 
            10000, 
            '�Ǹ���', 
            'abc123', 
            '����', 
            '1995-01-01', 
            '��', 
            '1234'); 

--customers���õ�����
INSERT INTO customers 
            (customer_no, 
             employee_no, 
             address_no, 
             credit_no, 
             customer_name, 
             customer_phone_no, 
             customer_comment, 
             customer_id, 
             customer_pw) 
VALUES     (1, 
            1, 
            1, 
            1, 
            '��ȣ��', 
            '082)010-6666-7777', 
            '��������ǰ ������', 
            'qwedasd', 
            '1234'); 


--credits ���õ�����
INSERT INTO credits 
            (credit_no, 
             credit_name) 
VALUES     (1, 
            'EXCELLENT'); 

INSERT INTO credits 
            (credit_no, 
             credit_name) 
VALUES     (2, 
            'GOOD'); 

INSERT INTO credits 
            (credit_no, 
             credit_name) 
VALUES     (3, 
            'POOR'); 

--order_items���õ�����
INSERT INTO order_items 
            (order_item_no, 
             product_no, 
             order_no, 
             product_quantity) 
VALUES     (1, 
            1, 
            1, 
            100); 

INSERT INTO order_items 
            (order_item_no, 
             product_no, 
             order_no, 
             product_quantity) 
VALUES     (2, 
            2, 
            2, 
            200); 

--orders ���õ�����
INSERT INTO ORDERS
            (ORDER_NO, 
             CUSTOMER_NO, 
             EMPLOYEE_NO, 
             SHIPMENT_DATE, 
             ORDER_MONEY,
             PAY_METHOD,
             SHIPMENT_STATUS,
             ORDER_METHOD,
             ORDER_DATE
             ) 
values(1,1,1,TO_DATE('2018-07-01'),100000,'Credit','Y','�ѽ�',TO_DATE('2018-05-01'));    

--payments ���õ�����
INSERT INTO payments 
            (payment_no, 
             transport_status_no, 
             order_no, 
             payment_date) 
VALUES     (1, 
            1, 
            1, 
            '2018-03-03'); 

--product_category ���õ�����
INSERT INTO product_categories 
            (product_category_no, 
             product_category_name) 
VALUES     (1, 
            '�߱���ǰ'); 

INSERT INTO product_categories 
            (product_category_no, 
             product_category_name) 
VALUES     (2, 
            '�౸��ǰ'); 

INSERT INTO product_categories 
            (product_category_no, 
             product_category_name) 
VALUES     (3, 
            '������ǰ'); 

--products ���õ�����
INSERT INTO products 
            (product_no, 
             product_category_no, 
             product_name, 
             product_brief_comment, 
             product_price, 
             product_bundle_quantity, 
             product_detail_comment, 
             product_picture, 
             product_release_date) 
VALUES     (1, 
            1, 
            '�Ѹ��� ACAYBB511 5150 ���ҳ� ���տ��Ʈ -11���', 
            '���ҳ� ��Ʋ ���տ��Ʈ�Դϴ�.', 
            59000, 
            100, 
' ��� ��� �Ұ�, �˷�̴� ��Ʈ - ����Ƽ : 6������ ĸ������ ����' 
            , 
'/product/101.jpg', 
'2015-03-01'); 

INSERT INTO products 
            (product_no, 
             product_category_no, 
             product_name, 
             product_brief_comment, 
             product_price, 
             product_bundle_quantity, 
             product_detail_comment, 
             product_picture, 
             product_release_date) 
VALUES     (2, 
            2, 
            '�������� ��ǰ ���� ������(SC)', 
            '���ø�ī', 
            41000, 
            100, 
            '�Ƶ�ٽ� ���� ������', 
            '/product/102.jpg', 
            '2014-05-01'); 

--transport_status���õ�����
INSERT INTO transport_status 
            (transport_status_no, 
             payment_no, 
             transport_date, 
             transport_start, 
             transport_destination, 
             current_position) 
VALUES     (1, 
            1, 
            '2018-03-21', 
            'korea', 
            'Japan', 
            'Japan'); 

--product_lines ���õ�����
INSERT INTO product_lines 
            (product_line_no, 
             product_no, 
             address_no, 
             employee_no, 
             special_status) 
VALUES     (1, 
            1, 
            1, 
            1, 
            NULL); 

INSERT INTO product_lines 
            (product_line_no, 
             product_no, 
             address_no, 
             employee_no, 
             special_status) 
VALUES     (2, 
            2, 
            2, 
            1, 
            NULL); 

INSERT INTO product_lines 
            (product_line_no, 
             product_no, 
             address_no, 
             employee_no, 
             special_status) 
VALUES     (3, 
            3, 
            3, 
            1, 
            'special'); 


--outstock_reason���õ�����
INSERT INTO outstock_reason 
            (outstock_reason_no, 
             outstock_reason_name, 
             reorder_date, 
             restocked_date) 
VALUES     (1, 
            '����', 
            '2018-09-21', 
            NULL, 
            NULL); 

INSERT INTO outstock_reason 
            (outstock_reason_no, 
             outstock_reason_name, 
             reorder_date, 
             restocked_date) 
VALUES     (2, 
            'ǰ��', 
            '2018-07-15', 
            '2018-08-20', 
            '2018-08-25'); 

--stocks���õ�����
INSERT INTO stocks 
            (stock_items_no, 
             product_no, 
             outstock_reason_no, 
             employee_no, 
             stock_max, 
             stock_quantity) 
VALUES     (1, 
            1, 
            NULL, 
            1, 
            2000, 
            50); 

INSERT INTO stocks 
            (stock_items_no, 
             product_no, 
             outstock_reason_no, 
             employee_no, 
             stock_max, 
             stock_quantity) 
VALUES     (2, 
            2, 
            NULL, 
            1, 
            2500, 
            1500); 

--stock_items���õ����� 
INSERT INTO stock_items 
            (storage_no, 
             stock_items_no) 
VALUES     (); 

--storages ���õ����� 
INSERT INTO storages 
            (storage_no, 
             employee_no, 
             address_no, 
             storage_name) 
VALUES     (1, 
            3, 
            1, 
            'America storage'); 

INSERT INTO storages 
            (storage_no, 
             employee_no, 
             address_no, 
             storage_name) 
VALUES     (2, 
            3, 
            3, 
            'Africa storage'); 