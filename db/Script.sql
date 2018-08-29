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
 update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
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
 update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (product_id) REFERENCES product_tbl(id),
 FOREIGN KEY (user_id) REFERENCES user_tbl(id)
)

select store_tbl.id,store_tbl.product_id as 'productID',store_tbl.total,store_tbl.remark,store_tbl.update_date as 'updateDate',
product_tbl.name as 'productName',product_tbl.spec as 'productSpec' from store_tbl,product_tbl where product_tbl.id=store_tbl.product_id order by product_tbl.id 
