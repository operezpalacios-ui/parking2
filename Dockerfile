# 1. Imagen base: Java ya instalado
FROM openjdk:17-jdk-slim

# 2. Crear carpeta dentro del contenedor y copiar el proyecto
WORKDIR /app
COPY . /app

# 3. Compilar la app (si usas Maven)
RUN apt-get update && apt-get install -y maven
RUN mvn package

# 4. Ejecutar la aplicación
CMD ["java", "-cp", "target/classes", "App"]
