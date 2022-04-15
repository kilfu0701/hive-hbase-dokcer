# hive-hbase-dokcer

Hive and HBase servers with Docker enviorments.

## Version

- Hadoop 3.3.2
- Hive 3.1.2
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

## License
MIT
