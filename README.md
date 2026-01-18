# Biblioteca API

> 📅 Developed in 2021 | Migrated to GitHub 2025

API REST para gestión de biblioteca con Spring Boot.

## Tecnologías

- Java 11
- Spring Boot 2.5
- Spring Data JPA
- H2 Database (desarrollo)
- Maven

## Ejecución

```bash
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Endpoints

- GET /api/libros - Listar todos los libros
- GET /api/libros/{id} - Obtener libro por ID
- POST /api/libros - Crear nuevo libro
- PUT /api/libros/{id} - Actualizar libro
- DELETE /api/libros/{id} - Eliminar libro

## Base de Datos

H2 Console disponible en: `http://localhost:8080/h2-console`
