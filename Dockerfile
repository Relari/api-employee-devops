FROM openjdk:11.0-jre-slim
EXPOSE 8081
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} api-employee-devops.jar
ENTRYPOINT ["java","-jar","/api-employee-devops.jar"]