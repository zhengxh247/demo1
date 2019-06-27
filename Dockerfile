FROM openjdk:8-jdk
ENV JAVA_HOME=/openjdk:8-jdk
ENV PATH=$JAVA_HOME/bin:$PATH
ENV CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
VOLUME /tmp
ADD demotest.war demotest.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-war","/demotest.war"]
