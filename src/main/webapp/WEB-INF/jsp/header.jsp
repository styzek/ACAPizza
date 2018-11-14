<%@ include file="include/importTags.jsp"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">ACAPizza</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/ACAPizza/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ACAPizza/pizza">Pizza's</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ACAPizza/panier">Panier</a>

            </li>

        </ul>
        <spring:url var="localeFr" value="">
            <spring:param name="locale" value="fr" />
        </spring:url>

        <spring:url var="localeEn" value="">
            <spring:param name="locale" value="en" />
        </spring:url>
        


        <div class="col-1">
            <a href="${localeFr}">fr</a>

            <a href="${localeEn}">en</a>
        </div>
        <sec:authorize access="!isAuthenticated()">
            <a class="btn btn-outline-info my-2 my-sm-0 ml-1" href="<spring:url value='/loginPage' />" role="button">Connection</a>

            <a class="btn btn-outline-info my-2 my-sm-0 ml-1" href="/ACAPizza/inscription" role="button">Inscription</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal.username"/>
            <a class="btn btn-outline-info my-2 my-sm-0 ml-1" href="/ACAPizza/logout" role="button">Logout</a>
        </sec:authorize>
    </div>
</nav>

<hr/>
