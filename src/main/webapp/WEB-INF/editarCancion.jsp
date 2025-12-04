<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Canción</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<nav class="navbar">
    <h2>Editar Canción</h2>
    <a class="btn add-btn" href="/canciones">Volver a Canciones</a>
</nav>

<div class="form-container">
    <h3>Editar canción</h3>

    <form:form method="POST" action="/canciones/procesa/editar/${cancion.id}" modelAttribute="cancion">

        <div class="form-group">
            <label>Título:</label>
            <form:input path="titulo" cssClass="input" />
            <form:errors path="titulo" cssClass="error" />
        </div>

        <div class="form-group">
            <label>Artista:</label>
            <select class="input" name="artistaId">
                <option value="">-- Seleccione un artista --</option>
                <c:forEach var="artista" items="${listaArtistas}">
                    <option value="${artista.id}" ${artista.id == artistaId ? 'selected="selected"' : ''}>
                        ${artista.nombre} ${artista.apellido}
                    </option>
                </c:forEach>
            </select>
            <c:if test="${not empty errorArtista}">
                <span class="error">${errorArtista}</span>
            </c:if>
        </div>

        <div class="form-group">
            <label>Álbum:</label>
            <form:input path="album" cssClass="input" />
            <form:errors path="album" cssClass="error" />
        </div>

        <div class="form-group">
            <label>Género:</label>
            <form:input path="genero" cssClass="input" />
            <form:errors path="genero" cssClass="error" />
        </div>

        <div class="form-group">
            <label>Idioma:</label>
            <form:input path="idioma" cssClass="input" />
            <form:errors path="idioma" cssClass="error" />
        </div>

        <button class="btn submit-btn" type="submit">Guardar cambios</button>
    </form:form>
</div>

</body>
</html>
