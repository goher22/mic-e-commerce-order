FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/mic-e-commerce-order-1.0.0.jar
COPY ${JAR_FILE} app_order.jar
EXPOSE 8000
ENTRYPOINT [ "java", "-jar", "app_order.jar" ]