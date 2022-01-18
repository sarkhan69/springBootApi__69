FROM openjdk:15
COPY /target/myApi.jar /myApi.jar
ENTRYPOINT ["java","-jar","/myApi.jar"]