FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8083
COPY /target/docker-inventory.jar product-inventory.jar
ENTRYPOINT [ "java","-jar","product-inventory.jar"]