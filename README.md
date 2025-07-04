# Proyecto de Autenticación - Spring Boot

Este proyecto implementa un sistema de autenticación utilizando Java, Spring Boot y JWT.

## Características

- Registro de usuarios
- Inicio de sesión con generación de JWT
- Validación de credenciales
- Manejo de excepciones personalizadas

## Tecnologías

- Java 17+
- Spring Boot
- Spring Security
- Maven
- JWT

## Estructura del Proyecto

- `com.task.services.auth.service` - Servicios de autenticación
- `com.task.services.auth.repository` - Repositorios de datos
- `com.task.services.auth.dto` - Objetos de transferencia de datos
- `com.task.services.auth.mapper` - Mapeadores de entidades y DTOs
- `com.task.services.auth.config` - Configuración de JWT
- `com.task.services.auth.controller` - Controladores REST
- `com.task.services.exception` - Excepciones personalizadas
- `com.task.services.v1.task` - Servicios de tareas

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/ftapiaco/task.services.git

2. Curl: Se encuentra en el archivo Task.postman_Collection.json.