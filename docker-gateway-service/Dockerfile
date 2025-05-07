FROM eclipse-temurin:21-jdk-alpine
EXPOSE 9000
COPY /target/docker-gateway.jar product-gateway.jar
ENTRYPOINT [ "java","-jar","product-gateway.jar"]