FROM openjdk:8-jdk-slim

EXPOSE 8080

ENTRYPOINT ["java", \
    "-Djava.security.egd=file:/dev/./urandom ", \
    "-Xmx512m", \
    "-jar", "/app.jar" \
]

COPY target/*.jar ./app.jar
