create database if not exists mydb;

use mydb;

create table if not exists users (
  user_id BIGINT,
  first_name STRING,
  last_name STRING,
  company_name STRING,
  address STRING,
  city STRING,
  state STRING,
  post STRING,
  phone1 STRING,
  phone2 STRING,
  email STRING,
  web STRING,
  birth_date STRING
)
PARTITIONED BY (
  `country` STRING
)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
WITH SERDEPROPERTIES (
   "separatorChar" = ",",
   "quoteChar"     = "\""
)
stored as textfile location 'hdfs://namenode:8020/user/hive/warehouse/mydb.db/users';
