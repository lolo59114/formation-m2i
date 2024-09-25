<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des patients</title>
    <c:import url="/WEB-INF/bootstrap.html" />
</head>
<body>
<c:import url="/WEB-INF/header.jsp" charEncoding="UTF-8"/>
<main class="container p-0">
    <hr>
    <h2>Ajouter un patient</h2>
<c:choose>
    <c:when test="${isLogged}">
        <form action="${pageContext.request.contextPath}/hospital/patient/add" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="firstName" class="form-label">Prénom :</label>
                <input type="text" class="form-control" id="firstName" name="firstName">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Nom :</label>
                <input type="text" class="form-control" id="lastName" name="lastName">
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Téléphone :</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" >
            </div>
            <div class="mb-3">
                <c:set var = "now" value = "<%= LocalDate.now()%>" />
                <label for="dateOfBirth" class="form-label"> Date de naissance :</label>
                <input type="date" value="<c:out value="${now}" />" class="form-control" id="dateOfBirth" name="dateOfBirth">
            </div>
            <div class="mb-3">
                <label for="picture" class="form-label">Photo :</label>
                <input type="file" class="form-control" id="picture" name="picture" >
            </div>
            <div class="text-start">
                <button type="submit" class="btn btn-primary">Valider</button>
            </div>
        </form>
    </c:when>
    <c:otherwise>
        <div class="text-start">
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/hospital/connection'" class="btn btn-primary">Se connecter</button>
        </div>
    </c:otherwise>
</c:choose>
    <hr>
    <div class="p-3 text-center">
        <h3>Liste des patients</h3>
        <c:choose>
            <c:when test="${patients.size() > 0}">
                <table class="col-12 table table-dark striped">
                    <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Téléphone</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  var="patient" items="${patients}" >
                        <tr>
                            <td><c:out value="${patient.getFirstName() += \" \" += patient.getLastName()}" /></td>
                            <td><c:out value="${patient.getPhoneNumber()}" /></td>
                            <td><a href="${pageContext.request.contextPath}/hospital/patient/details?id=${patient.getIdPatient()}" class="btn btn-primary">Détails</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Pas encore de patient.</p>
            </c:otherwise>
        </c:choose>
    </div>
</main>
<c:import url="/WEB-INF/footer.jsp" charEncoding="UTF-8"/>
</body>
</html>
