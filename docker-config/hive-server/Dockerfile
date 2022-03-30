FROM ubuntu:20.04

LABEL maintainer="kilfu0701@gmail.com"
LABEL version="1.0"

RUN apt-get update -y
RUN apt-get install -y openjdk-8-jdk vim
RUN apt-get install -y wget curl

RUN wget -qO- https://dlcdn.apache.org/hive/hive-3.1.2/apache-hive-3.1.2-bin.tar.gz | tar xvzf - -C /opt/
RUN mv /opt/apache-hive-3.1.2-bin /opt/hive

RUN wget -qO- https://archive.apache.org/dist/hadoop/common/hadoop-3.1.2/hadoop-3.1.2.tar.gz | tar xvzf - -C /opt/
RUN mv /opt/hadoop-3.1.2 /opt/hadoop
