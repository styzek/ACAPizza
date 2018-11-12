<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>



Compose ta pizza !!
<br>

Nous incluons dans chaque composition : la pate, la sauce tomate et la mozza
<br>

...fais avec ¯\_(ツ)_/¯
<br>
<br>

<form:form method="post" action="/ACAPizza/pizzaPerso/send"  modelAttribute="pizzaCustom">
    <%--<form method="post" name="form_name" id="form_name">--%>
    <div id="checkboxgroup">

        <c:forEach  var="ingredient" items="${ingredients}" varStatus="loop">
            <c:if test="${!(ingredient.name == 'mozzarella' || ingredient.name == 'pate ag' || ingredient.name == 'pate sg' ||
                                                      ingredient.name == 'sauce barbecue' || ingredient.name == 'sauce tomate')}">

            <label class="checkbox-inline">
            <input type="checkbox" id="Check"> ${ingredient.name}
            </label>

                <c:if test="${loop.index =='6'}">
                    <br>
                </c:if>


                    <%--<form:checkboxes path="ingredient" items="${ingredient.name}" />--%>

            </c:if>

        </c:forEach>
    </div>
    <form:button >Commander</form:button>

    </form:form>

<script type="text/javascript">
    onlyOneCheckBox()
</script>