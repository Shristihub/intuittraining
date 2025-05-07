FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8081
COPY /target/docker-catalog-rest.jar product-catalog.jar
ENTRYPOINT [ "java","-jar","product-catalog.jar"]