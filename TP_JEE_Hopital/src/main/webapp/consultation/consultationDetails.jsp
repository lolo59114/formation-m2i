<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Détails d'une consultation</title>
    <c:import url="/WEB-INF/bootstrap.html" />
</head>
<body>
<c:import url="/WEB-INF/header.jsp" charEncoding="UTF-8"/>
<main class="container">
    <div>
        <h2>Patient: ${consultation.getPatient().getFirstName()} ,
            consultation réf: ${consultation.getIdConsultation()} ,
            Date: ${consultation.getCreateDate()}
        </h2>
    </div>
    <div class="bg-light my-2">
        <h4>Fiche Soins</h4>
        <c:choose>
            <c:when test="${empty consultation.getCareSheet()}">
                <h5>Soins à remplir:</h5>
                <div class="ms-2">
                    <form action="updateCareSheet?idConsultation=${consultation.getIdConsultation()}" method="post">
                        <p class="m-0 p-0"><label for="careSheet" class="form-label">Contenu :</label></p>
                        <textarea name="careSheet" id="careSheet" cols="50" rows="10"></textarea>
                        <div class="text-start mt-2">
                            <button type="submit" class="btn btn-primary">Valider</button>
                        </div>
                    </form>
                </div>

            </c:when>
            <c:otherwise>
                <div class="text-start ms-3">
                    <p>${consultation.getCareSheet()}</p>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="bg-light my-2">
        <h4>Préscription</h4>
        <c:choose>
            <c:when test="${empty consultation.getPrescription()}">
        <div class="ms-2">
            <form action="updatePrescription?idConsultation=${consultation.getIdConsultation()}" method="post">
                <p class="m-0 p-0"><label for="prescription" class="form-label">Contenu :</label></p>
                <textarea name="prescription" id="prescription" cols="50" rows="10"></textarea>
                <div class="text-start mt-2">
                    <button type="submit" class="btn btn-primary">Valider</button>
                </div>
            </form>
        </div>
            </c:when>
            <c:otherwise>
        <div class="text-start ms-3">
            <p>${consultation.getPrescription()}</p>
        </div>
            </c:otherwise>
    </c:choose>
    </div>
</main>
<c:import url="/WEB-INF/footer.jsp" charEncoding="UTF-8"/>
</body>
</html>