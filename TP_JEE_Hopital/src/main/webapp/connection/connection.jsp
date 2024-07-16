<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
    <c:import url="/WEB-INF/bootstrap.html" />
</head>
<body>
<c:import url="/WEB-INF/header.jsp" charEncoding="UTF-8"/>
<main class="container p-0">
    <h1>Se connecter</h1>
    <form action="${pageContext.request.contextPath}/hospital/connection" method="post">
        <div class="mb-3">
            <label for="login" class="form-label">Login :</label>
            <input type="text" class="form-control" id="login" name="login">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password :</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <c:if test="${loginError != null}">
            <p class="text-danger"><c:out value="${loginError}"/></p>
        </c:if>
        <div class="text-start">
            <button type="submit" class="btn btn-primary">Valider</button>
        </div>
    </form>
</main>
<c:import url="/WEB-INF/footer.jsp" charEncoding="UTF-8"/>
</body>
</html>
