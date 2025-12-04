<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Canciones</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <nav class="navbar">
        <h2>Canciones</h2>
        <div class="nav-btns">
            <a class="btn add-btn" href="/artistas">Ir a artistas</a>
            <a class="btn add-btn" href="/canciones/formulario/agregar">Agregar Canción</a>
        </div>
        
    </nav>

    <h1>Canciones</h1>
    <table>
        <thead>
            <tr>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Detalle</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cancion" items="${listaCanciones}">
                <tr>
                    <td>${cancion.titulo}</td>
                    <td>${cancion.artista.nombre} ${cancion.artista.apellido}</td>
                    <td>
                        <a class="btn" href="/canciones/detalle/${cancion.id}">Ver Detalles</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</body>
</html>
