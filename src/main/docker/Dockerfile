FROM openjdk:8-jdk-alpine
MAINTAINER ["zhengxh"]
VOLUME /tmp
ADD springboot_docker_demo.jar springboot_docker_demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-war","demo.war"]
