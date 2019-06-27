FROM java8
VOLUME /tmp
ADD demotest.war demotest.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-war","/demotest.war"]
