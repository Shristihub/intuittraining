FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8085
COPY /target/docker-cart.jar product-cart.jar
ENTRYPOINT [ "java","-jar","product-cart.jar"]