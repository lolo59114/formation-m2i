<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercice 5</title>
    <c:import url="/WEB-INF/bootstrap.html" />
</head>
<body>
    <main class="container">
        <div class="col-6 text-bg-dark rounded m-3 p-3">
            <h1>- Add a Dog -</h1>
            <hr>
            <form action="${pageContext.request.contextPath}/exercice5/dog/add" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" value="${dog.getName()}" class="form-control" id="name" name="name" ${readOnly} >
                </div>
                <div class="mb-3">
                    <label for="breed" class="form-label">Breed</label>
                    <input type="text" value="${dog.getBreed()}" class="form-control" id="breed" name="breed" ${readOnly}>
                </div>
                <div class="mb-3">
                    <label for="birthdate" class="form-label">Birth date</label>
                    <input type="date" value="<c:out value="${dog.getBirthDate()}" default="2024-07-12" />" class="form-control" id="birthdate" name="birthdate" ${readOnly}>
                </div>
                <hr>
                <div class="text-end">
                    <c:choose>
                        <c:when test="${dog.getId() > 0}">
                            <button onclick="location.href='${pageContext.request.contextPath}/exercice5/dog/list'" type="button" class="btn btn-warning">Return</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-success">Add Dog</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
