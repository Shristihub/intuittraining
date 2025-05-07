FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8888
COPY /target/docker-config.jar product-config.jar
ENTRYPOINT [ "java","-jar","product-config.jar"]