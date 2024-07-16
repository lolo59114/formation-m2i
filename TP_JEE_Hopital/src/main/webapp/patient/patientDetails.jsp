<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Détails d'un patient</title>
    <c:import url="/WEB-INF/bootstrap.html" />
</head>
<body>
<c:import url="/WEB-INF/header.jsp" charEncoding="UTF-8"/>
<main class="container">
    <div>
        <h2>Infos du patient:</h2>
        <img class="mx-auto d-block " src="${pageContext.request.contextPath}/image/${patient.getPictureName()}" alt="Image patient" width="10%" height="auto"/>
    </div>
    <h5>Nom: ${patient.getFirstName() += " " += patient.getLastName()}</h5>
    <h5>Date de naissance: ${patient.getDateOfBirth()}</h5>
    <h5>Téléphone: ${patient.getPhoneNumber()}</h5>
    <div class="bg-light my-2">
        <h2>Ajouter une consultation</h2>
        <div class="text-start ms-3">
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/hospital/consultation/add?idPatient=${patient.getIdPatient()}'" class="btn btn-primary m-4">Valider</button>
        </div>
    </div>
    <c:import url="/consultation/consultationList.jsp" charEncoding="UTF-8" />
</main>

<c:import url="/WEB-INF/footer.jsp" charEncoding="UTF-8"/>
</body>
</html>
