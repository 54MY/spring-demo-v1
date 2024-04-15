# Primera etapa: compila el proyecto
FROM maven:3.8.1-openjdk-8-slim AS build

# Configurar el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml al contenedor
COPY pom.xml .

# Descarga todas las dependencias del proyecto y las almacena en el directorio .m2 del contenedor
RUN mvn dependency:go-offline -B

# Copia todo el código fuente al contenedor
COPY src/ ./src/

# Compila el proyecto
RUN mvn clean package

# Segunda etapa: ejecuta el proyecto
FROM openjdk:8-jre-slim
WORKDIR /app

# Copia el archivo JAR generado por la primera etapa al contenedor
COPY --from=build /app/target/demo-1.0.0-SNAPSHOT.jar .

# Exponer puerto
EXPOSE 9091

# Variable de Zona horaria
ENV TZ=America/La_Paz

# Agergar la zona horaria al contenedor
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone