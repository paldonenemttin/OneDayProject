-- 여기는 fooduser

CREATE TABLE tbl_foods(
    fd_code	CHAR(7)	PRIMARY KEY,
    fd_name	NVARCHAR2(125) NOT NULL,	
    fd_year	NUMBER ,
    fd_ccode CHAR(6) NOT NULL,
    fd_tcode CHAR(4) NOT NULL,
    fd_ones	NUMBER ,
    fd_all	NUMBER ,
    fd_kral	NUMBER NOT NULL	,
    fd_prot	NUMBER ,
    fd_fat	NUMBER ,
    fd_carb	NUMBER ,
    fd_suga	NUMBER		
);

CREATE TABLE tbl_company(
    cp_code	CHAR(6) PRIMARY KEY,
    cp_name	NVARCHAR2(125) NOT NULL	
);

CREATE TABLE tbl_items(
    it_code	CHAR(4)		PRIMARY KEY,
    it_name	NVARCHAR2(20)	NOT NULL	
);

SELECT COUNT(*) FROM tbl_foods;
SELECT COUNT(*) FROM tbl_company;
SELECT COUNT(*) FROM tbl_items;

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_company
FOREIGN KEY(fd_ccode)
REFERENCES tbl_company(cp_code);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_items
FOREIGN KEY(fd_tcode)
REFERENCES tbl_items(it_code);

CREATE VIEW view_식품정보 as
(
SELECT fd_code AS 식품코드, fd_name AS 식품명, fd_year as 출시일,
       c.cp_name as 제조사명, i.it_name as 분류명, f.fd_ones AS 일회제공량,
       f.fd_all as 총제공량, f.fd_kral as 칼로리, f.fd_prot as 단백질g,
       f.fd_fat as 지방g, f.fd_carb as 탄수화물g, f.fd_suga as 총당류g
FROM tbl_foods F
    LEFT JOIN tbl_company C
       on F.fd_ccode = C.cp_code
    LEFT JOIN tbl_items I
      on F.fd_tcode = I.it_code
);

select * from "VIEW_식품정보";

drop table tbl_myfoods;
CREATE TABLE tbl_myfoods(
  my_seq NUMBER PRIMARY KEY,
  my_date VARCHAR2(10) not null,
  my_code char(7) not null,
  my_eats NUMBER not null
);

drop view view_섭취정보;
create view view_섭취정보 as
(
select m.my_date as 날짜, f.fd_name as 식품명, m.my_eats as 섭취량,
       f.fd_all as 총제공량, f.fd_kral as 칼로리, f.fd_prot as 단백질,
       f.fd_fat as 지방, f.fd_carb as 탄수화물, f.fd_suga as 당류
from tbl_foods f
    left join tbl_myfoods m
    on f.fd_code = m.my_code
);

create SEQUENCE seq_myfoods
start with 1
INCREMENT by 1;