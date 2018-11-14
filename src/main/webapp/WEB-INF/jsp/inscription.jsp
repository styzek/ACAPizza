<%@ include file="include/importTags.jsp"%>

<form:form method="post" action="/ACAPizza/inscription/send" modelAttribute="currentUser">
    <div class="form-row">
        <div class="form-group col-md-6">
            <form:label path="username" for="inputFirstname">Login</form:label>
            <form:input path="username" type="text" class="form-control" id="inputFirstname" placeholder="Login" />
        </div>
        <div class="valid-feedback">
            Looks good!
        </div>
        <div class="form-group col-md-6">
            <form:label path="password" for="inputPassword" >Password</form:label>
            <form:input path="password" type="password" class="form-control" id="inputPassword" placeholder="Password" required="password" minlength="4"/>
        </div>
    </div>

    <div class="form-group">
        <div class="form-row">
            <div class="form-group col-md-6">
                 <form:label path="lastName" for="inputLastname">Name</form:label>
                <form:input path="lastName" type="text" class="form-control" id="inputLastname" placeholder="Name" />
             </div>
            <div class="form-group col-md-6">
                <form:label for="inputEmail" path="email">Email</form:label>
                <form:input path="email" type="email" class="form-control" id="inputEmail" placeholder="Email" required="email"/>
            </div>



        </div>
        <div class="form-row">
            <div class="form-group col-md-10">
                <form:label path="adress" for="inputAddress">Address</form:label>
                <form:input path="adress" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" />
            </div>
            <div class="form-group col-md-2">
                <form:label path="zipCode" for="inputZip">Zip</form:label>
                <form:input path="zipCode" type="text" class="form-control" id="inputZip"/>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form:label path="phone" for="inputPhone">Phone Number</form:label>
            <form:input path="phone" type="text" class="form-control" id="inputPhone" placeholder="ex. 0476579193"  minlength="10"/>
        </div>


    </div>
    <div class="form-group">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck" required>
            <label class="form-check-label" for="gridCheck">
                I accept agreement terms
            </label>
        </div>
    </div>
    <form:button type="submit" class="btn btn-primary" >Sign in</form:button>
</form:form>