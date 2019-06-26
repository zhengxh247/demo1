FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD demo.war demo.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-war","/demo.war"]
