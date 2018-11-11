<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>

<!-- Page Heading -->
<h1 class="my-4">Nos Pizza

</h1>
<form:form method="post" action="/ACAPizza/pizza/add" modelAttribute="pizza">
<c:forEach var="pizzas"  items="${pizzas}" >
<!-- Project One -->

<div class="row">
    <div class="col-md-4">
        <a href="#">
            <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/400x200" alt="">
        </a>
    </div>
    <div class="col-md-2">
       <h3>${pizzas.name}</h3>
        <p>Description : ${pizzas.description}</p>
        <h4>Prix : ${pizzas.price} €</h4>



    </div>
    <div class="col-md-4">
        <div class="mt-4">
        <p><u>Ingredients :</u></p>

        <c:forEach var="ingredient" items="${pizzas.ingredients}">
           ${ingredient.name},
        </c:forEach>
        </div>
    </div>
    <div class="col-md-2">


            <form:button type="submit" class="btn btn-primary float-right my-5" >Ajouter au panier</form:button>

    </div>
</div>

    <!-- /.row -->
    <hr>

</c:forEach>
</form:form>

</div>
<!-- /.container -->