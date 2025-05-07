FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8084
COPY /target/docker-info.jar product-info.jar
ENTRYPOINT [ "java","-jar","product-info.jar"]