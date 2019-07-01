FROM java:8
VOLUME /tmp
ADD demotest.jar demotest.jar
ENTRYPOINT ["java","-jar","target/demotest.jar"]
