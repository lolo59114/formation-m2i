<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/07/2024
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/bootstrap.html"%>
    <title>Titre de ma page bootstrap</title>
</head>
<body>
    <div class="container">
        <div class="mx-auto col-md-6 text-bg-dark rounded-3 p-2">
            <div class="input-group mb-12">
                <span class="input-group text-white">Email:</span>
                <input type="text" class="form-control">
                <span class="input-group-text">@</span>
                <input type="text" class="form-control">
                <select class="form-select-sm" aria-label=".fr">
                    <option value="1" selected>.fr</option>
                    <option value="2">.com</option>
                    <option value="3">.info</option>
                </select>
            </div>
            <hr>
        </div>
    </div>
</body>
</html>
