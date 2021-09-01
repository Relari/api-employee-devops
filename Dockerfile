FROM openjdk:11.0-jre-slim
EXPOSE 8080
ARG JAR_FILE=target/employee-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} employee.jar
ENTRYPOINT ["java","-jar","/employee.jar"]