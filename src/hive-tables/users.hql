create database if not exists mydb;

use mydb;

create table if not exists users (
  user_id BIGINT,
  fisrt_name STRING,
  last_name STRING,
  email STRING,
  account_status STRING,
  country STRING,
  gender STRING
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
