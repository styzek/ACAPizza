<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>

<!-- Page Heading -->
<h1 class="my-4">Nos Pizza
    <%--<small>Secondary Text</small>--%>
</h1>
<form:form method="post" action="/ACAPizza/pizza/add" modelAttribute="pizza">

<c:forEach var="pizza"  items="${pizzas}" >
<!-- Project One -->

<div class="row">
    <div class="col-md-4">
        <a href="#">
            <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/400x200" alt="">
        </a>
    </div>
    <div class="col-md-2">
       <h3>${pizza.name}</h3>
        <p>Description : ${pizza.description}</p>
        <h4>Prix : ${pizza.price} €</h4>



    </div>
    <div class="col-md-4">
        <div class="mt-4">
        <p><u>Ingredients :</u></p>

        <c:forEach var="ingredient" items="${pizza.ingredients}">
           ${ingredient.name},
        </c:forEach>
        </div>
    </div>
    <div class="col-md-2">

            <a href="pizza/add/${pizza.name}">Ajouter au panier</a>
            <%--<form:button type="submit" >Ajouter au panier</form:button>--%>



    </div>
</div>

    <!-- /.row -->
    <hr>

</c:forEach>
</form:form>

</div>
<!-- /.container -->