

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">ACAPizza</a>
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

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Login" aria-label="login">
            <input class="form-control mr-sm-2" type="password" placeholder="Password" aria-label="password">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log in</button>
        </form>

        <button class="btn btn-outline-info my-2 my-sm-0 ml-1" href="#">Inscription</button>

    </div>
</nav>

<hr/>
