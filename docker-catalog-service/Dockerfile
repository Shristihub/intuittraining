FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8082
COPY /target/docker-catalog.jar product-catalog.jar
ENTRYPOINT [ "java","-jar","product-catalog.jar"]