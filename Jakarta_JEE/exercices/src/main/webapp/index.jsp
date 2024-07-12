<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu principal</title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<main class="container m-1">
    <h2><%= "Bonjour ! Vous pouvez choisir l'exercice." %></h2>
    <br>
    <ul class="col-4 list-group">
        <a class="list-group-item list-group-item-action list-group-item-primary" href="exercice1">Exercice 1</a>
        <a class="list-group-item list-group-item-action list-group-item-primary" href="exercice2">Exercice 2</a>
        <a class="list-group-item list-group-item-action list-group-item-primary" href="exercice3/tab-pers">Exercice 3</a>
        <a class="list-group-item list-group-item-action list-group-item-primary" href="exercice4/cat">Exercice 4</a>
        <a class="list-group-item list-group-item-action list-group-item-primary" href="exercice5/dog/list">Exercice 5</a>
    </ul>
</main>
</body>
</html>