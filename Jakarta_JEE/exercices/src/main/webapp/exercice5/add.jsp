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
            <h1>- <c:out value="${title}" /> -</h1>
            <hr>
    <c:choose>
        <c:when test="${isNotFound}">
            <p>No dog found with id : ${id}</p>
        </c:when>
        <c:otherwise>
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
                    <c:if test="${dog == null}">
                            <button type="submit" class="btn btn-success">Add Dog</button>
                    </c:if>
                </div>
            </form>
        </c:otherwise>
    </c:choose>
    <c:if test="${isNotFound || dog != null}">
            <div class="text-end">
                <button onclick="location.href='${pageContext.request.contextPath}/exercice5/dog/list'" type="button" class="btn btn-warning">Return</button>
            </div>
    </c:if>
        </div>
    </main>
</body>
</html>
