<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <c:if test="${patient.getConsultations().size() > 0}">
        <h2>Liste des consultations</h2>
        <c:forEach var="consultation" items="${patient.getConsultations()}">
            <p>
                réf: ${consultation.getIdConsultation()} ;
                date: ${consultation.getCreateDate()} ;
                <a href="${pageContext.request.contextPath}/hospital/consultation/details?id=${consultation.getIdConsultation()}">Détail de la consultation</a>
            </p>
        </c:forEach>
    </c:if>

</div>
