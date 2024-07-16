<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="container p-0">
        <div class="bg-success text-white p-3 text-center">
            <h1>Bienvenue à l'Hôpital Princeton-Plainsboro</h1>
        </div>
        <div>
            <nav class="navbar navbar-expand-md bg-secondary justify-content-center">
                <ul class="navbar-nav mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link text-white" aria-current="page" href="${pageContext.request.contextPath}/hospital">Accueil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/hospital/patient/list">Liste des patients</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
