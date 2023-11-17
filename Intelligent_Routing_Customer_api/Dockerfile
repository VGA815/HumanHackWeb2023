FROM openjdk:8-jre-alpine

# директория
WORKDIR /app

# JAR-файл
COPY target/Intelligent_Routing_Customer_api-0.0.1.jar /app/Intelligent_Routing_Customer_api-0.0.1.jar

# директория DataSet
COPY ML /app/ML

# port
EXPOSE 8080

CMD ["java", "-jar", "Intelligent_Routing_Customer_api-0.0.1.jar"]
