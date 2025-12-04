<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle Artista</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="detalle-container">
        <h1>Detalle Artista</h1>
        <h2>${artista.nombre} ${artista.apellido}</h2>
        <p><strong>Biografía:</strong> ${artista.biografia}</p>

        <h3>Canciones:</h3>
        <ul>
        <c:forEach var="song" items="${artista.canciones}">
            <li>${song.titulo}</li>
        </c:forEach>
        </ul>

        <br>
        <a class="btn btn-secondary" href="/artistas">Volver a lista de artistas</a>

    </div>


    

    
</body>
</html>