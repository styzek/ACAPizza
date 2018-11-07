<%@ include file="include/importTags.jsp"%>

<form>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail">Email</label>
            <input type="email" class="form-control" id="inputEmail" placeholder="Email" required>
        </div>
        <div class="valid-feedback">
            Looks good!
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword" >Password</label>
            <input type="password" class="form-control" id="inputPassword" placeholder="Password">
        </div>
    </div>

    <div class="form-group">
        <div class="form-row">
            <div class="form-group col-md-6">
                 <label for="inputLastname">Nom</label>
                <input type="text" class="form-control" id="inputLastname" placeholder="nom">
             </div>
            <div class="form-group col-md-6">
                <label for="inputFirstname">Prenom</label>
                <input type="text" class="form-control" id="inputFirstname" placeholder="prenom">
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
            </div>
            <div class="form-group col-md-2">
                <label for="inputZip">Zip</label>
                <input type="text" class="form-control" id="inputZip">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputPhone">Phone</label>
            <input type="text" class="form-control" id="inputPhone">
        </div>


    </div>
    <div class="form-group">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck">
            <label class="form-check-label" for="gridCheck">
                Check me out
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary" href="/ACAPizza/home">Sign in</button>
</form>