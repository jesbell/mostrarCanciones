<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Agregar Canción</title>
</head>

<body>

<nav class="navbar">
    <h2>Agregar Canción</h2>
    <a class="btn add-btn" href="/canciones">Volver a Canciones</a>
</nav>

<div class="form-container">
    <h2>Nueva Canción</h2>

    <form:form method="POST" action="/canciones/procesa/agregar" modelAttribute="cancion">

        <div class="form-group">
            <label>Título:</label>
            <form:input path="titulo" cssClass="input"/>
            <form:errors path="titulo" cssClass="error"/>
        </div>

        <div class="form-group">
            <label>Artista:</label>
            <select name="artistaId" class="input">
                <option value="" disabled 
                <c:if test="${empty param.artistaId}">selected</c:if>
            >-- Selecciona un artista --</option>

            <c:forEach var="artista" items="${listaArtistas}">
                <option value="${artista.id}"
                    <c:if test="${param.artistaId == artista.id}">selected</c:if>
                >
                    ${artista.nombre} ${artista.apellido}
                </option>
            </c:forEach>
        </select>

            <c:if test="${not empty errorArtista}">
                <p class="error">${errorArtista}</p>
            </c:if>

        </div>

        <div class="form-group">
            <label>Álbum:</label>
            <form:input path="album" cssClass="input"/>
            <form:errors path="album" cssClass="error"/>
        </div>

        <div class="form-group">
            <label>Género:</label>
            <form:input path="genero" cssClass="input"/>
            <form:errors path="genero" cssClass="error"/>
        </div>

        <div class="form-group">
            <label>Idioma:</label>
            <form:input path="idioma" cssClass="input"/>
            <form:errors path="idioma" cssClass="error"/>
        </div>

        <button class="btn submit-btn" type="submit">Guardar Canción</button>
    </form:form>
</div>

</body>
</html>

