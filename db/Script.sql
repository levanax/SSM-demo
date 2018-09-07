CREATE TABLE product_tbl(
 id int(4) PRIMARY KEY auto_increment,
 name varchar(16) not null,
 spec varchar(64),
 weight varchar(64),
 remark varchar(64) 
)
auto_increment = 1;

insert into product_tbl(name) VALUES('锡丝');

CREATE TABLE store_tbl(
 id int(4) PRIMARY KEY auto_increment,
 product_id int(4) not null,
 total int(10) not null,
 remark VARCHAR(64) ,
 update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (product_id) REFERENCES product_tbl(id)
)

CREATE TABLE store_record_tbl(
 id int(4) PRIMARY KEY auto_increment,
 product_id int(4) not null,
 user_id int(4) not null,
 
 instructions VARCHAR(6) not null, #入库/出库
 quantity int(10) not null,
 price DOUBLE ,
 remark VARCHAR(64) ,
 update_date TIMESTAMP ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (product_id) REFERENCES product_tbl(id),
 FOREIGN KEY (user_id) REFERENCES user_tbl(id)
)

INSERT INTO store_record_tbl(product_id, user_id, instructions, quantity, price, remark)
VALUES(1,1,'import',1000,23.2,'note')


select store_tbl.id,store_tbl.product_id as 'productID',store_tbl.total,store_tbl.remark,store_tbl.update_date as 'updateDate',
product_tbl.name as 'productName',product_tbl.spec as 'productSpec' from store_tbl,product_tbl where product_tbl.id=store_tbl.product_id order by product_tbl.id


SELECT * from store_record_tbl as s left JOIN product_tbl as p on s.product_id=p.id WHERE s.product_id=1 order by s.update_date desc



CREATE TABLE role_tbl(
 id int(4) PRIMARY KEY auto_increment,
 name VARCHAR(64) not null, #admin/user/guest
 description VARCHAR(64) 
)
INSERT into role_tbl(name) VALUES('DBA')
INSERT into role_tbl(name) VALUES('ADMIN');
INSERT into role_tbl(name) VALUES('USER');


INSERT into user_tbl(login_id, login_password) VALUES('admin','123456');


CREATE TABLE user_role_tbl(
 id int(4) PRIMARY KEY auto_increment,
 user_id int(4) not null,
 role_id int(4) not null,
 description VARCHAR(64),
 FOREIGN KEY (user_id) REFERENCES user_tbl(id),
 FOREIGN KEY (role_id) REFERENCES role_tbl(id),
  UNIQUE KEY (user_id,role_id)
)

INSERT into user_role_tbl(user_id, role_id) VALUES('2','2');

SELECT role_tbl.name from user_role_tbl left JOIN role_tbl on user_role_tbl.role_id = role_tbl.id WHERE user_role_tbl.user_id = 2;

CREATE TABLE api_tbl(
 id int(4) PRIMARY KEY auto_increment,
 api_name VARCHAR(64) not null,
 api_method VARCHAR(64) not null,
 api_link VARCHAR(64) not null,
 description VARCHAR(64)
)
