FROM openjdk:8-jre-alpine

# директория
WORKDIR /app

# JAR-файл
COPY target/email_code-0.0.1.jar /app/email_code-0.0.1.jar

# директория DataSet
COPY config /app/config

# port
EXPOSE 8080

CMD ["java", "-jar", "email_code-0.0.1.jar"]
