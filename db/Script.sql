CREATE TABLE product_tbl(
 id int(4) PRIMARY KEY auto_increment,
 name varchar(16) not null,
 spec varchar(64),
 weight varchar(64),
 remark varchar(64) 
)
auto_increment = 1;

insert into product_tbl(name) VALUES('电容');

CREATE TABLE product_store_tbl(
 product_id int(4) not null,
 total int(10) not null,
 remark VARCHAR(64) ,
 update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (product_id) REFERENCES product_tbl(id)
)

CREATE TABLE product_store_record_tbl(
 product_id int(4) not null,
 instructions VARCHAR(6) not null, #买入
 quantity int(10) not null,
 price DOUBLE ,
 remark VARCHAR(64) ,
 update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (product_id) REFERENCES product_tbl(id)
)