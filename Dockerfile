FROM maven:3.8.5-jdk-11-slim
WORKDIR /app
COPY . .
EXPOSE 8080
RUN mvn install --no-transfer-progress -DskipTests=true
ENTRYPOINT ["mvn", "spring-boot:run"]
