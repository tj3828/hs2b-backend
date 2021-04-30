FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN echo ${JAR_FILE}
ARG JAR_FILE
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dserver.port=8080", "-Dspring.profiles.active=real", "-jar", "/app.jar"]