FROM amazoncorretto:21-alpine-jdk

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} application.jar

CMD apt-get update -y

ENTRYPOINT ["java", "-jar", "/application.jar"]