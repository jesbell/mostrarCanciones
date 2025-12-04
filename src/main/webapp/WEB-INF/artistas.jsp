<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Document</title>
</head>
<body>
    <nav class="navbar">
        <h2>Artistas</h2>
        <div class="nav-btns">
            <a class="btn add-btn" href="/canciones">Ir a canciones</a>
            <a class="btn add-btn" href="/artistas/formulario/agregar">Agregar Artista</a>
        </div>
        
    </nav>


    <h1>Artistas</h1>
    <table>
        <thead>
            <tr>
                <th>Artista</th>
                <th>Detalle</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="artista" items="${listaArtistas}">
                <tr>
                    <td>${artista.nombre} ${artista.apellido}</td>
                    <td>
                        <a class="btn" href="/artistas/detalle/${artista.id}">Ver Detalles</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>