# Primeira etapa: gerar o jar com man package dentro do container
# A imagem maven jdk esta deprecated, eclipse temurin apresenta vulnerabilidade. Usar amazon corretto
FROM maven:3.8.1-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

RUN ls -la /target/Api-gateway.jar  # Lista o arquivo para verificar se foi criado

# Segunda etapa: acessar o jar gerado na primeira etapa
FROM openjdk:17-jdk-slim
# Para acessar a primeira etapa: --from=build
# O nome Usuario.jar vem da tag finalName do pom.xml que adicionei
COPY --from=build target/Api-gateway.jar app.jar
EXPOSE 8085
CMD ["java", "-jar", "/app.jar"]
