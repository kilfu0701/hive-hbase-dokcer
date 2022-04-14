FROM postgres:14.2

MAINTAINER "BoRu Su <kilfu0701@gmail.com>"

COPY hive-schema-2.3.0.postgres.sql /hive/hive-schema-2.3.0.postgres.sql
COPY hive-txn-schema-2.3.0.postgres.sql /hive/hive-txn-schema-2.3.0.postgres.sql
COPY pg_hba.conf /tmp/pg_hba.conf
COPY postgres.conf /tmp/postgres.conf

COPY init-hive-db.sh /docker-entrypoint-initdb.d/init-user-db.sh
