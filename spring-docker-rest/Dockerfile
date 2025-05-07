FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8081
COPY /target/spring-rest.jar greet-restapi.jar
ENTRYPOINT [ "java","-jar","greet-restapi.jar"]