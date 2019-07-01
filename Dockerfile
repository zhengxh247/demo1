FROM java:8
VOLUME /tmp
ADD demotest.jar demotest.jar
ENTRYPOINT ["java","-jar","/root/.jenkins/workspace/demo_pipeline/env/target
/demotest.jar"]
