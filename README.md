# Proyecto Challenge Thanksgiving API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)

## Descripción

Esta API permite a los usuarios gestionar los platos de una cena compartida de Acción de Gracias. Está diseñada para facilitar la organización de los platos, permitiendo la creación, visualización, actualización y eliminación de estos. La API está documentada con **Swagger** para facilitar su uso y pruebas.

## Características

- **Creación de platos** con atributos como nombre, tipo de comida, chef y descripción.
- **Visualización de todos los platos**.
- **Visualización de un plato específico** por su ID.
- **Actualización de platos** por su ID.
- **Eliminación de platos** por su ID.
- **Swagger UI** para la documentación interactiva de la API.

## Endpoints Principales

### Platos

- **POST** `/dishes`: Crear un nuevo plato.
- **GET** `/dishes`: Listar todos los platos.
- **GET** `/dishes/{id}`: Obtener un plato específico por su ID.
- **PUT** `/dishes/{id}`: Actualizar un plato existente por su ID.
- **DELETE** `/dishes/{id}`: Eliminar un plato por su ID.

## Documentación con Swagger

La documentación de la API está disponible en el endpoint `/swagger-ui.html`, donde puedes probar los diferentes endpoints y ver la estructura de los datos.

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot**
- **Swagger** para la documentación de la API.
- **JPA** para la persistencia de datos.
- **PostgreSQL** para la base de datos.

## Requisitos

- **Java JDK 21**
- **Maven 3**
- **PostgreSQL 14**

## Pasos para ejecutar el proyecto

1. **Instalar las dependencias** necesarias.

   Asegúrate de tener instalados Java JDK 21, Maven 3 y PostgreSQL 14.

2. **Configurar la base de datos**.

   Crea una base de datos en PostgreSQL y actualiza las credenciales en el archivo `application.properties`.

3. **Construir el proyecto** con Maven.

   ```sh
   mvn clean package
   ```

4. Ejecutar el JAR generado.

```java
java -jar target/thanksgiving.jar
```

5. **Acceder a la documentación de la API** en `http://localhost:8080/swagger-ui.html`.

## Documentacion de la API

Esta API proporciona puntos finales para gestionar los platos de una cena de Acción de Gracias. A continuación se muestran los puntos finales disponibles y sus formatos de solicitud/respuesta esperados.

[Documentación Thanksgiving API](https://m3lb1z.github.io/challenge-thanksgiving/)
