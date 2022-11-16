FROM openjdk:17-jdk-slim

RUN useradd -ms /bin/bash micronaut

USER micronaut

EXPOSE 5005
EXPOSE 8080

ENV TERM xterm-color

WORKDIR /simple-connect

COPY app/app-entrypoint.sh /
ENTRYPOINT /app-entrypoint.sh

