FROM openjdk:8-jdk-alpine
RUN mkdir -p app_dir
RUN git clone 
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]