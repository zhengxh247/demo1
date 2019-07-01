FROM java:8
VOLUME /tmp
ADD demotest.war demotest.war
ENTRYPOINT ["java","-war","target/demotest.war"]
