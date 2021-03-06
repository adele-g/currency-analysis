FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /opt/app

ARG JAR_FILE=testTask.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","testTask.jar"]
