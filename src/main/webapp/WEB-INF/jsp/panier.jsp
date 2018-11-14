<%@ include file="include/importTags.jsp"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->



<script src="https://use.fontawesome.com/c560c025cf.js"></script>
<div class="container">
    <div class="card shopping-cart">
        <div class="card-header bg-dark text-light">
            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
            Shopping cart
            <a href="/ACAPizza/pizza" class="btn btn-outline-info btn-sm pull-right">Continue shopping</a>
            <div class="clearfix"></div>
        </div>
        <div class="card-body">
            <!-- PRODUCT -->
            <%--<c:if test="">--%>
                <%----%>
            <%--</c:if>--%>

            <c:forEach items="${panier}" var="pizza">

                <%--<c:set value="${pizza.pizzaId}" var="id"/>--%>
            <div class="row">
                <div class="col-12 col-sm-12 col-md-2 text-center">
                    <img class="img-responsive" src="http://placehold.it/120x80" alt="preview" width="120" height="80">
                </div>
                <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                    <h4 class="product-name"><strong>${pizza.key.name}</strong></h4>
                    <h5>
                        <c:forEach var="ingredient" items="${pizza.key.ingredients}" varStatus="status">
                            <small> ${ingredient}</small>
                            <c:if test="${!status.last}" >
                                ,
                            </c:if>
                            <c:if test="${status.last}">

                            </c:if>
                        </c:forEach>
                    </h5>
                </div>
                <div class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
                    <div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 5px">
                        <h6><strong>${pizza.key.price} euro <span class="text-muted">x</span></strong></h6>
                    </div>
                    <div class="col-4 col-sm-4 col-md-4">
                        <div class="quantity">
                            <c:if test="${pizza.value > 1}">
                                <a type="button" value="-" class="btn-sm minus" href="/ACAPizza/panier/removeOne/${pizza.key.name}">-</a>
                            </c:if>

                            ${pizza.value}

                                <a type="button" value="+" class="btn-sm plus" href="/ACAPizza/panier/addOne/${pizza.key.name}">+</a>
                        </div>
                    </div>
                    <div class="col-2 col-sm-2 col-md-2 text-right">
                        <a type="button" class="btn btn-outline-danger btn-xs" href="panier/remove/${pizza.key.name}">
                            <i class="fa fa-trash" aria-hidden="true"></i>
                        </a>
                    </div>
                </div>
            </div>
            <hr>
            </c:forEach>
            <!-- END PRODUCT -->


        </div>
        <div class="card-footer">
            <div class="coupon col-md-5 col-sm-5 no-padding-left pull-left">
                <div class="row">
                    <div class="col-6">
                        <input type="text" class="form-control" placeholder="coupon code">
                    </div>
                    <div class="col-6">
                        <input type="submit" class="btn btn-default" value="Use coupon">
                    </div>
                </div>
            </div>
            <div class="pull-right" style="margin: 10px">
                <a href="" class="btn btn-success pull-right">Checkout</a>
                <div id="paypal-button-container"></div>
                <script src="https://www.paypalobjects.com/api/checkout.js"></script>
                <script>
                    // Render the PayPal button
                    paypal.Button.render({
// Set your environment
                        env: 'sandbox', // sandbox | production

// Specify the style of the button
                        style: {
                            layout: 'horizontal',  // horizontal | vertical
                            size:   'medium',    // medium | large | responsive
                            shape:  'rect',      // pill | rect
                            color:  'blue'       // gold | blue | silver | white | black
                        },

// Specify allowed and disallowed funding sources
//
// Options:
// - paypal.FUNDING.CARD
// - paypal.FUNDING.CREDIT
// - paypal.FUNDING.ELV
                        funding: {
                            allowed: [
                                paypal.FUNDING.CARD,

                            ],
                            disallowed: []
                        },

// PayPal Client IDs - replace with your own
// Create a PayPal app: https://developer.paypal.com/developer/applications/create
                        client: {
                            sandbox: 'ATUaJ2Nsk7scrAAUeZlmCt589Qzz81PwwS335PmtrlpnUb5tXfwr7T5Sc_WFzbVYV0wQ6bANv3EHgCUl',
                            production: 'konrad4595-facilitator@gmail.com'
                        },

                        payment: function (data, actions) {
                            return actions.payment.create({
                                payment: {
                            //         redirect_urls:{
                            //             return_url: 'http://localhost:8082/ACAPizza/panier/process',
                            //             cancel_url:'http://localhost:3000/ACAPizza/panier'
                            // },
                                    transactions: [
                                        {
                                            amount: {
                                                total: '${prixTotal}',
                                                currency: 'EUR'
                                            }
                                        }
                                    ]
                                }
                            });
                        },

                        onAuthorize: function (data, actions) {
                            return actions.payment.execute()
                                .then(function () {
                                    window.alert('Payment Complete!');
                                });
                        }
                    }, '#paypal-button-container');
                </script>
                <div class="pull-right" style="margin: 5px">
                    Total price: <b>${prixTotal}</b>
                </div>
            </div>
        </div>
    </div>
</div>