# Etapa 1: Build da aplicação
FROM gradle:8.7.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean bootJar --no-daemon

# Etapa 2: Imagem final para execução
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
# Copie explicitamente o arquivo JSON para o diretório desejado
COPY src/main/resources/data/items.json /app/data/items.json
ENV ITEMS_JSON_PATH=/app/data/items.json

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]