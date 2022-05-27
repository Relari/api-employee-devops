FROM openjdk:11.0-jre-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} employee-example-devops.jar
ENTRYPOINT ["java","-jar","/employee-example-devops.jar"]