FROM openjdk:latest
COPY ./build/libs/PrometheusGrafanaExample-1.0.jar /opt/application.jar
ENTRYPOINT ["java", "-jar", "/opt/application.jar"]