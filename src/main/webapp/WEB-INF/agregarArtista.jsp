<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Artista</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
    <nav class="navbar">
        <h2>Agregar Artista</h2>
        <a class="btn add-btn" href="/artistas">Volver a Artista</a>
    </nav>

    <div class="form-container">
        <h2>Nuevo Artista</h2>

        <form:form modelAttribute="artista" action="/artistas/procesa/agregar" method="POST">

            <div class="form-group">
                <label>Nombre:</label>
                <form:input path="nombre" class="input"/>
                <br>
                <form:errors path="nombre" cssClass="error" />
            </div>

            <div class="form-group">
                <label>Apellido:</label><br>
                <form:input path="apellido" class="input" />
                <br>
                <form:errors path="apellido" cssClass="error" />
            </div>

            <div class="form-group">
                <label>Biografía:</label><br>
                <form:textarea path="biografia" rows="5" cols="40" class="input"></form:textarea>
                <br>
                <form:errors path="biografia" cssClass="error" />
            </div>
            <button class="btn submit-btn" type="submit">Agregar Artista</button>

        </form:form>

    </div>
    

</body>
</html>
