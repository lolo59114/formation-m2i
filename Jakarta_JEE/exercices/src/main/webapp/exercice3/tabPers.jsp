<%@ page import="org.example.exercice3.Personne" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/07/2024
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="personnes" type="java.util.ArrayList<org.example.exercice3.Personne>" scope="request"/>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/bootstrap.html"%>
</head>
<body>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Age</th>
    </tr>
    </thead>
    <tbody>
    <%
        int cpt = 0;
        for(Personne pers : personnes){
            cpt++;
    %>
    <tr>
        <th scope="row"><%= cpt %></th>
        <td><%= pers.getNom() %></td>
        <td><%= pers.getPrenom() %></td>
        <td><%= pers.getAge() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
