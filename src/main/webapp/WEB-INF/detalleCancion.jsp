<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle cancion</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="detalle-container">
        <h1>Detalle cancion</h1>
        <h2>${cancion.titulo}</h2>
        <p>Artista: ${cancion.artista}</p>
        <p>Album: ${cancion.album}</p>
        <p>Genero: ${cancion.genero}</p>
        <p>Idioma: ${cancion.idioma}</p>
        <a class="btn" href="/canciones/formulario/editar/${cancion.id}">Editar Canción</a>
        <a class="btn btn-secondary" href="/canciones">Volver a canciones</a>
    </div>
    
    
</body>
</html>
