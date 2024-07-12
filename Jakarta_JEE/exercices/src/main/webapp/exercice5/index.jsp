<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercice 5</title>
    <c:import url="/WEB-INF/bootstrap.html"/>
</head>
<body>
    <main class="container">
        <div class="col-6 text-bg-dark rounded m-3 p-3">
            <h1>- Dog List -</h1>
            <hr>
    <c:choose>
        <c:when test="${dogs.size() > 0}">
            <table class="col-12 table table-dark striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Breed</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach  var="dog" items="${dogs}" >
                    <tr>
                        <th scope="row"><c:out value="${dog.getId()}" /></th>
                        <td><c:out value="${dog.getName()}" /></td>
                        <td><c:out value="${dog.getBreed()}" /></td>
                        <td><c:out value="${dog.getBirthDate()}" /></td>
                        <td><button onclick="location.href='${pageContext.request.contextPath}/exercice5/dog/details/${dog.getId()}'" type="button" class="btn btn-primary">Details</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>There is no dog in the database yet.</p>
            <hr>
        </c:otherwise>
    </c:choose>
            <div class="text-end">
                <button onclick="location.href='${pageContext.request.contextPath}/exercice5/dog/add'" type="button" class="btn btn-success">Add a dog</button>
            </div>
        </div>
    </main>
</body>
</html>
