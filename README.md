# 🎵 Proyecto Spring Boot – Aplicación de Canciones

Este es un proyecto simple en **Spring Boot**, utilizando **JSP**, **Spring MVC**, **JPA/Hibernate** y conexión a MySQL.  
Permite listar canciones, ver detalles y manejar datos desde una base de datos.

---

## 🚀 Requisitos previos

Antes de ejecutar el proyecto, necesitas tener instalado:

- **Java 17 o superior**
- **Maven**
- **MySQL Server**
- **MySQL Workbench** (opcional)
- **IDE recomendado:** Visual Studio Code

---

## 🛠️ Configuración de la base de datos

1. Crea una base de datos llamada:

```sql
CREATE DATABASE canciones_db;
```



2. Asegúrate de configurar tus credenciales en:

src/main/resources/application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/canciones_db?createDatabaseIfNotExist=true
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

## 🎼 Datos iniciales (opcional)

Puedes poblar la base de datos con los siguientes artistas y  canciones:

Artistas, Se crean con el id 1 en adelante
```
INSERT INTO artistas (nombre, apellido, biografia, fecha_creacion, fecha_actualizacion)
VALUES
('Ariana', 'Grande', 'Cantante y actriz estadounidense reconocida por su rango vocal.', NOW(), NOW()),
('Freddie', 'Mercury', 'Legendario vocalista de Queen con una de las voces más icónicas del rock.', NOW(), NOW()),
('Taehyung', 'Kim', 'V de BTS, cantante surcoreano con voz barítono y estilo artístico distintivo.', NOW(), NOW()),
('Shakira', 'Ripoll', 'Cantautora colombiana que fusiona pop y ritmos latinos.', NOW(), NOW()),
('Hikaru', 'Utada', 'Cantante japonesa-estadounidense, influyente en el J-pop.', NOW(), NOW());
```

Algunas canciones

```
INSERT INTO canciones (titulo, artista_id, album, genero, idioma, fecha_creacion, fecha_actualizacion)
VALUES
('Into You', 1, 'Dangerous Woman', 'Pop', 'Inglés', NOW(), NOW()),
('No Tears Left To Cry', 1, 'Sweetener', 'Pop', 'Inglés', NOW(), NOW()),
('Positions', 1, 'Positions', 'Pop', 'Inglés', NOW(), NOW());


INSERT INTO canciones (titulo, artista_id, album, genero, idioma, fecha_creacion, fecha_actualizacion)
VALUES
('Bohemian Rhapsody', 2, 'A Night at the Opera', 'Rock', 'Inglés', NOW(), NOW()),
('We Are the Champions', 2, 'News of the World', 'Rock', 'Inglés', NOW(), NOW()),
('Somebody to Love', 2, 'A Day at the Races', 'Rock', 'Inglés', NOW(), NOW());


INSERT INTO canciones (titulo, artista_id, album, genero, idioma, fecha_creacion, fecha_actualizacion)
VALUES
('Flavor of Life', 5, 'Flavor of Life', 'J-pop', 'Japonés', NOW(), NOW()),
('Automatic', 5, 'First Love', 'J-pop', 'Japonés', NOW(), NOW()),
('First Love', 5, 'First Love', 'J-pop', 'Japonés', NOW(), NOW());;
```

## ▶️ Ejecutar el proyecto

Puedes iniciar la aplicación con:
```
mvn spring-boot:run
```


Luego abre en tu navegador:
```
http://localhost:8080/canciones
```

## 📁 Estructura del proyecto

```

src/
 ├── main/
 │   ├── java/com/.../controladores
 │   ├── java/com/.../modelos
 │   ├── java/com/.../repositorios
 │   ├── java/com/.../servicios
 │   └── webapp/WEB-INF/*.jsp
 └── resources/application.properties


```

## 📝 Notas

Recuerda configurar tus credenciales locales en application.properties.

Las contraseñas NO están incluidas en el repositorio.

## 👥 Autor

- Proyecto desarrollado por Joselyn González como parte de una práctica de Spring Boot para skillnest
- CORE Mostrar Canciones.