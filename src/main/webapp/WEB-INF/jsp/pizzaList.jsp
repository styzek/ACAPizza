<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<!-- Page Heading -->

<div class="float-right">
    <a class="btn btn-primary btn-lg my-2 my-sm-0 ml-1" href="/ACAPizza/pizzaPerso" role="button">Composer ma Pizza!</a>
</div>
<br>
<h1 class="my-4">Nos Pizza</h1>




<div clas="col">


    <div class="d-flex flex-row mt-2">
        <ul class="nav nav-tabs nav-tabs--vertical nav-tabs--left" role="navigation">
            <li class="nav-item">
                <a href="#lorem" class="nav-link active" data-toggle="tab" role="tab" aria-controls="lorem">Lorem</a>
            </li>
            <li class="nav-item">
                <a href="#ipsum" class="nav-link" data-toggle="tab" role="tab" aria-controls="ipsum">Ipsum</a>
            </li>
            <li class="nav-item">
                <a href="#dolor" class="nav-link disabled" data-toggle="tab" role="tab" aria-controls="dolor">Dolor</a>
            </li>
            <li class="nav-item">
                <a href="#sit-amet" class="nav-link" data-toggle="tab" role="tab" aria-controls="sit-amet">Sit Amet</a>
            </li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane fade show active" id="lorem" role="tabpanel">
                <h1>Lorem</h1>

                <p>Aenean sed lacus id mi scelerisque tristique. Nunc sed ex sed turpis fringilla aliquet in in neque. Praesent posuere, neque rhoncus sollicitudin fermentum, erat ligula volutpat dui, nec dapibus ligula lorem ac mauris. Etiam et leo venenatis purus pharetra dictum.</p>

                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin tempor mi ut risus laoreet molestie. Duis augue risus, fringilla et nibh ac, convallis cursus purus. Suspendisse potenti. Praesent pretium eros eleifend posuere facilisis. Proin ut magna vitae nulla suscipit eleifend. Ut bibendum pulvinar sapien, vel tristique felis scelerisque et. Sed elementum sapien magna, placerat interdum lacus placerat ut. Integer varius, ligula bibendum laoreet sollicitudin, eros metus fringilla lectus, quis consequat nisl nibh ut nisi. Aenean dignissim, nibh ac fermentum condimentum, ante nisl rutrum sapien, at commodo eros sapien vulputate arcu. Fusce neque leo, blandit nec lectus eu, vestibulum commodo tellus. Aliquam sem libero, tristique at condimentum ac, luctus nec nulla.</p>
            </div>
            <div class="tab-pane fade" id="ipsum" role="tabpanel">
                <h1>Ipsum</h1>

                <p>Aenean pharetra risus quis placerat euismod. Praesent mattis lorem eget massa euismod sollicitudin. Donec porta nulla ut blandit vehicula. Mauris sagittis lorem nec mauris placerat, et molestie elit vehicula. Donec libero ex, condimentum et mi dapibus, euismod ornare ligula.</p>

                <p>In faucibus tempus ante, et tempor magna luctus id. Ut a maximus ipsum. Duis eu velit nec libero pretium pellentesque. Maecenas auctor hendrerit pulvinar. Donec sed tortor interdum, sodales elit vel, tempor turpis. In tristique vestibulum eros vel congue. Vivamus maximus posuere fringilla. Nullam in est commodo, tristique ligula eu, tincidunt enim. Duis iaculis sodales lectus vitae cursus.</p>
            </div>
            <div class="tab-pane fade" id="dolor" role="tabpanel">
                <h1>Dolor</h1>

                <p>Ut eget lectus tristique, tempus purus sit amet, porta augue. Mauris lobortis sem nec augue ultricies blandit. Nullam sed sem venenatis, pretium urna eget, scelerisque dolor. Morbi nec volutpat leo, quis faucibus tortor. Aenean vel rutrum mauris. Pellentesque lectus massa, tincidunt quis leo non, sodales sagittis nulla. Proin interdum est at nulla laoreet, pulvinar pretium nisl rutrum. In vel elit a risus rhoncus accumsan vulputate non sapien. Sed et rhoncus velit. Nunc commodo augue fermentum, hendrerit neque at, ullamcorper arcu. Nulla tincidunt orci a lectus efficitur elementum. Donec molestie urna vestibulum augue placerat faucibus. In vitae orci vel mauris cursus viverra ac sit amet nisl. Phasellus odio tortor, ullamcorper eget ullamcorper eget, molestie eget justo. Integer elementum purus eget arcu fermentum tincidunt. Nullam erat tellus, dictum sit amet nisi eu, rutrum fermentum odio.</p>
            </div>
            <div class="tab-pane fade" id="sit-amet" role="tabpanel">
                <h1>Sit Amet</h1>

                <p>Aliquam hendrerit nunc vitae nisi efficitur, eu porta sem aliquam. Aenean tincidunt mi sed mi sodales bibendum. Proin dolor ipsum, mollis venenatis velit eu, iaculis laoreet mi. Mauris eget egestas felis, sit amet finibus nunc. Aliquam non dui sit amet erat auctor mollis ac eget ante. Quisque at quam augue. Nulla dignissim, augue nec cursus consequat, mi nulla efficitur augue, vel fringilla turpis quam eu nunc. Quisque rutrum vehicula lacus sodales molestie. Mauris vel felis sit amet erat maximus cursus ut a velit. In hac habitasse platea dictumst. Vestibulum vel neque sit amet nisl finibus fermentum.</p>
            </div>
        </div>
    </div>




</div>





<form:form method="post" action="/ACAPizza/pizza/add" modelAttribute="pizza">

    <c:forEach var="pizza" items="${pizzas}">
        <c:if test="${pizza.iscomposed==false}">
            <div>
            <div>

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

                            <c:forEach var="ingredient" items="${pizza.ingredients}" varStatus="status">
                                ${ingredient.name}
                                <c:if test="${!status.last}">
                                    ,
                                </c:if>

                            </c:forEach>
                        </div>
                    </div>
                        <%--<form:button type="submit" class="btn btn-primary float-right my-5" >Ajouter au panier</form:button>--%>

                    <a href="pizza/add/${pizza.name}">Ajouter au panier</a>
                        <%--<form:button type="submit" >Ajouter au panier</form:button>--%>
                </div>
            </div>

            <hr>
        </c:if>
    </c:forEach>
</form:form>

</div>
