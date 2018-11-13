<%@ include file="include/importTags.jsp"%>

<form:form method="post" action="${pageContext.request.contextPath}/loginPage" modelAttribute="currentUser">

    <div class="col-md-5">
        <div class="form-group">
            <form:label path="username" for="exampleInputEmail1">Login</form:label>
            <form:input path="username" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Login"/>
        </div>
        <div class="form-group">
            <form:label path="password" for="exampleInputPassword1">Password</form:label>
            <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
        </div>

        <div>

        <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/ACAPizza/inscription">Sign in</a>
        </div>
    </div>

</form:form>