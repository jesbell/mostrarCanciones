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

Puedes poblar la base de datos con las siguientes canciones:

```
INSERT INTO canciones 
(album, artista, fecha_actualizacion, fecha_creacion, genero, idioma, titulo)
VALUES
("Mr Simple", "Super Junior", NOW(), NOW(), "Kpop", "Coreano", "Mr. Simple"), 
("Wolf", "EXO", NOW(), NOW(), "Kpop", "Coreano", "XOXO"),
("Fantôme", "Utada Hikaru", NOW(), NOW(), "Jpop", "Japonés", "Sakura Nagashi"),
("Blue Blood", "X Japan", NOW(), NOW(), "Jrock", "Japonés", "Kurenai"),
("Nanno Iro", "YOASOBI", NOW(), NOW(), "Jpop", "Japonés", "Yoru ni Kakeru"),
("Kiss & Cry", "Perfume", NOW(), NOW(), "Jpop", "Japonés", "Flash"),
("Zankyo Reference", "ONE OK ROCK", NOW(), NOW(), "Jrock", "Japonés", "The Beginning");
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