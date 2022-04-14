FROM python:3
USER root

RUN apt-get update
RUN apt-get -y install locales && \
    localedef -f UTF-8 -i ja_JP ja_JP.UTF-8
ENV LANG ja_JP.UTF-8
ENV LANGUAGE ja_JP:ja
ENV LC_ALL ja_JP.UTF-8
ENV TZ JST-9
ENV TERM xterm

RUN apt-get update
RUN apt-get install -y vim less libsasl2-dev
RUN pip install --upgrade pip
RUN pip install --upgrade setuptools

RUN apt-get install -y nmap iputils-ping
RUN python -m pip install jupyterlab sasl thrift thrift-sasl pyhive
RUN apt-get update && apt-get install -y libsasl2-modules libsasl2-dev sasl2-bin
