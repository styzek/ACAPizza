<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>

<!-- Page Heading -->
<h1 class="my-4">Nos Pizza
    <%--<small>Secondary Text</small>--%>
</h1>

<c:forEach var="pizzas"  items="${pizzas}" >
<!-- Project One -->

<div class="row">
    <div class="col-md-4">
        <a href="#">
            <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/400x200" alt="">
        </a>
    </div>
    <div class="col-md-5">
       <h3>${pizzas.name}</h3>
        <p>Description : ${pizzas.description}</p>
        <h4>Prix : ${pizzas.price} €</h4>

    </div>
    <div class="col-md-3">
        <a class="btn btn-primary float-right my-5" href="#">Ajouter au panier</a>
    </div>
</div>

    <!-- /.row -->
    <hr>

</c:forEach>


</div>
<!-- /.container -->