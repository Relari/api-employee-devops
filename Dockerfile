FROM openjdk:11.0-jre-slim
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} *.jar
ENTRYPOINT ["java","-jar","/api-employee-devops.jar"]