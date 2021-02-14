create table order_info(
	id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	order_name VARCHAR(100),
	customer_id BIGINT(20) NOT NULL,
            price DECIMAL(10,2) DEFAULT 0.00 NOT NULL
);

CREATE SCHEMA IF NOT EXISTS testdb;

CREATE TABLE testdb.message (
id varchar(100) NOT NULL,
destination varchar(1000) NOT NULL,
headers varchar(1000) NOT NULL,
payload varchar(4000) NOT NULL,
published smallint(6) DEFAULT '0',
creation_time bigint(20) DEFAULT NULL,
PRIMARY KEY (id),
KEY message_published_idx (published,id)
);

create table testdb.received_messages (
consumer_id varchar(100) NOT NULL,
message_id varchar(100) NOT NULL,
creation_time bigint(20) DEFAULT NULL,
PRIMARY KEY (consumer_id, message_id)
);