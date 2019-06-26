FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD demoTest.war demoTest.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-war","/demoTest.war"]
