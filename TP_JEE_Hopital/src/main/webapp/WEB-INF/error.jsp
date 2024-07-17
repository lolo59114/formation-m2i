<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${errorName}"/></title>
    <c:import url="/WEB-INF/bootstrap.html" />
</head>
<body>
<c:import url="/WEB-INF/header.jsp" charEncoding="UTF-8"/>
<main class="container p-0">
    <div class="row justify-content-center">
        <h1 class="text-center"><c:out value="${errorName}"/></h1>
        <hr>
        <h3 class="text-center"><c:out value="${message}"/></h3>
    </div>
</main>
<c:import url="/WEB-INF/footer.jsp" charEncoding="UTF-8"/>
</body>
</html>