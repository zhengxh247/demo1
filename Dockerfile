FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD springboot_docker_demo.jar springboot_docker_demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot_docker_demo.jar"]
