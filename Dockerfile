# Используйте официальный образ Maven с OpenJDK 17
FROM maven:3.8.5-openjdk-17-slim

# Установить рабочую директорию в контейнере
WORKDIR /app

# Скопировать pom.xml и скачивать зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Скопировать весь проект в контейнер
COPY . .

# Собрать проект
RUN mvn clean install --no-transfer-progress -DskipTests=true

# Открыть порт 8080
EXPOSE 8080

# Запустить приложение Spring Boot
CMD ["java", "-jar", "target/chat-0.0.1-SNAPSHOT.jar"]
