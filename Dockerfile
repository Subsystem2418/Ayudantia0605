# ---- Etapa 1: Build (compila con Maven y el wrapper del proyecto) ----
    
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copiamos primero los archivos de build para aprovechar el cache de capas
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Copiamos el código fuente y construimos el jar (sin tests)
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# ---- Etapa 2: Runtime (imagen ligera solo con JRE) ----
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app

# Usuario no root por seguridad
RUN useradd -ms /bin/bash spring
USER spring

# Copiamos el jar generado en la etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
