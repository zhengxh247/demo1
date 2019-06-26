FROM openjdk:8-jdk-alpine
MAINTAINER ["zhengxh"]
VOLUME /tmp
ADD demo1.war demo1.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-war","demo1.war"]
