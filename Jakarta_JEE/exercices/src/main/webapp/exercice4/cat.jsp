<%@ page import="org.example.exercice4.model.Cat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cats" type="java.util.ArrayList<org.example.exercice4.model.Cat>" scope="request"/>
<html>
<head>
    <title>Les chats c'est le démon</title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
    <main class="container">
        <h2>Liste des chats :</h2>
        <table class="col-12 table table-dark striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Race</th>
                <th scope="col">Favorite meal</th>
                <th scope="col">Bithday</th>
            </tr>
            </thead>
            <tbody>
            <%
                int cpt = 0;
                for(Cat cat : cats){
            %>
            <tr>
                <th scope="row"><%= ++cpt %></th>
                <td><%= cat.getName() %></td>
                <td><%= cat.getRace()%></td>
                <td><%= cat.getFavoriteMeal() %></td>
                <td><%= cat.getBirthDay() %></td>
            </tr>
            <% } %>
            </tbody>
        </table>
        <form class="col-4 text-bg-dark p-3 rounded" action="cat" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="mb-3">
                <label for="race" class="form-label">Race</label>
                <input type="text" class="form-control" id="race" name="race">
            </div>
            <div class="mb-3">
                <label for="favorite-meal" class="form-label">Favorite Meal</label>
                <input type="text" class="form-control" id="favorite-meal" name="favorite-meal">
            </div>
            <div class="mb-3">
                <label for="birthday" class="form-label">Birthday</label>
                <input type="date" class="form-control" id="birthday" name="birthday">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </main>
</body>
</html>
