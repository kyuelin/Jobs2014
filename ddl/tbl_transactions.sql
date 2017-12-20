drop table if exists tbl_transactions;
CREATE TABLE IF NOT EXISTS tbl_transactions
  (
     trans_id             INT NOT NULL auto_increment,
     trans_date           VARCHAR(10),
     description          VARCHAR(255),
     original_description VARCHAR(255),
     amount               DECIMAL(10, 2),
     transtype            VARCHAR(255),
     category             VARCHAR(255),
     account_name         VARCHAR(255),
     labels               VARCHAR(255),
     notes                VARCHAR(255),
     PRIMARY KEY (trans_id)
  );

load data local infile '/Users/kennethlin/transactions_1706.csv' into table mysql.tbl_transactions
fields
ENCLOSED BY '"'
terminated by ','
LINES TERMINATED BY '\r'
IGNORE 1 LINES
(trans_date,description, original_description, amount, transtype,category,account_name,labels,notes)
;
