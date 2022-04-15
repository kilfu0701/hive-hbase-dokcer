FROM postgres:14.2

MAINTAINER "BoRu Su <kilfu0701@gmail.com>"

COPY hive-schema-3.1.0.postgres.sql /hive/hive-schema-3.1.0.postgres.sql
COPY pg_hba.conf /tmp/pg_hba.conf
COPY postgresql.conf /tmp/postgresql.conf

COPY init-hive-db.sh /docker-entrypoint-initdb.d/init-user-db.sh
