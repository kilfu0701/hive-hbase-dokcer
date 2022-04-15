# hive-hbase-dokcer

Hive and HBase servers with Docker enviorments.

## Version

- Hadoop 3.3.2
- Hive 3.1.3
- HBase 1.2.6
- Java 8

## How To Use

1. Build up images.
```sh
docker-composer build
```

2. Run all docker images.
```sh
docker-composer up -d
```

3. Enter hive-server and do some operations.
```sh
# from your machine, enter hive-server container
docker-compose exec hive-server /bin/bash


# in hive-server, and enter hive
root@629eb8c58840:/opt/hive# hive 

WARNING: HADOOP_PREFIX has been replaced by HADOOP_HOME. Using value of HADOOP_PREFIX.
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/opt/hive/lib/log4j-slf4j-impl-2.17.1.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/opt/hadoop-3.3.2/share/hadoop/common/lib/slf4j-log4j12-1.7.30.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.apache.logging.slf4j.Log4jLoggerFactory]
Hive Session ID = a77febe9-5296-4075-a02b-692dfbfc371d

Logging initialized using configuration in file:/opt/hive/conf/hive-log4j2.properties Async: true
Hive Session ID = 84be291e-fbd2-44de-b2b0-8eecac0172da
Hive-on-MR is deprecated in Hive 2 and may not be available in the future versions. Consider using a different execution engine (i.e. spark, tez) or using Hive 1.X releases.
hive>
```

or using beeline
```sh
root@17e4cbcf6631:/opt# beeline -u jdbc:hive2://

WARNING: HADOOP_PREFIX has been replaced by HADOOP_HOME. Using value of HADOOP_PREFIX.
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/opt/hive/lib/log4j-slf4j-impl-2.17.1.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/opt/hadoop-3.3.2/share/hadoop/common/lib/slf4j-log4j12-1.7.30.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.apache.logging.slf4j.Log4jLoggerFactory]
Connecting to jdbc:hive2://
22/04/15 07:52:38 [main]: WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Hive Session ID = b5db1a55-306a-415d-9319-4a9ed5b9739a
22/04/15 07:52:38 [main]: WARN session.SessionState: METASTORE_FILTER_HOOK will be ignored, since hive.security.authorization.manager is set to instance of HiveAuthorizerFactory.
Connected to: Apache Hive (version 3.1.3)
Driver: Hive JDBC (version 3.1.3)
Transaction isolation: TRANSACTION_REPEATABLE_READ
Beeline version 3.1.3 by Apache Hive
0: jdbc:hive2://>
```

## (Hive) Create DB/Tables and import sample data

1. Create DB/Table
```sh
# enter into hive-server container
hive -f /table/users.hql
```

2. Import csv data
```sh
# enter hive cli
hive> 

# change db
hive> use mydb;

# load csv data partition by country
hive> LOAD DATA LOCAL INPATH '/tables/data/au-500.csv' OVERWRITE INTO TABLE users PARTITION (country='AU');
hive> LOAD DATA LOCAL INPATH '/tables/data/ca-500.csv' OVERWRITE INTO TABLE users PARTITION (country='CA');
hive> LOAD DATA LOCAL INPATH '/tables/data/uk-500.csv' OVERWRITE INTO TABLE users PARTITION (country='UK');
hive> LOAD DATA LOCAL INPATH '/tables/data/us-500.csv' OVERWRITE INTO TABLE users PARTITION (country='US');
```

3. select some data
```sh
hive> select * from users where country = 'US' LIMIT 10;

OK
first_name	last_name	company_name	address	city	county	state	zip	phone1	phone2	email	web	country	US
James	Butt	Benton, John B Jr	6649 N Blue Gum St	New Orleans	Orleans	LA	70116	504-621-8927	504-845-1427	jbutt@gmail.com	http://www.bentonjohnbjr.com	US	US
Josephine	Darakjy	Chanay, Jeffrey A Esq	4 B Blue Ridge Blvd	Brighton	Livingston	MI	48116	810-292-9388	810-374-9840	josephine_darakjy@darakjy.org	http://www.chanayjeffreyaesq.com	US	US
Art	Venere	Chemel, James L Cpa	8 W Cerritos Ave #54	Bridgeport	Gloucester	NJ	8014	856-636-8749	856-264-4130	art@venere.org	http://www.chemeljameslcpa.com	US	US
Lenna	Paprocki	Feltz Printing Service	639 Main St	Anchorage	Anchorage	AK	99501	907-385-4412	907-921-2010	lpaprocki@hotmail.com	http://www.feltzprintingservice.comUS	US
Donette	Foller	Printing Dimensions	34 Center St	Hamilton	Butler	OH	45011	513-570-1893	513-549-4561	donette.foller@cox.net	http://www.printingdimensions.com	US	US
Simona	Morasca	Chapman, Ross E Esq	3 Mcauley Dr	Ashland	Ashland	OH	44805	419-503-2484	419-800-6759	simona@morasca.com	http://www.chapmanrosseesq.com	US	US
Mitsue	Tollner	Morlong Associates	7 Eads St	Chicago	Cook	IL	60632	773-573-6914	773-924-8565	mitsue_tollner@yahoo.com	http://www.morlongassociates.com	US	US
Leota	Dilliard	Commercial Press	7 W Jackson Blvd	San Jose	Santa Clara	CA	95111	408-752-3500	408-813-1105	leota@hotmail.com	http://www.commercialpress.com	US	US
Sage	Wieser	Truhlar And Truhlar Attys	5 Boston Ave #88	Sioux Falls	Minnehaha	SD	57105	605-414-2147	605-794-4895	sage_wieser@cox.net	http://www.truhlarandtruhlarattys.com	US	US
Time taken: 1.369 seconds, Fetched: 10 row(s)
```

## License
MIT
