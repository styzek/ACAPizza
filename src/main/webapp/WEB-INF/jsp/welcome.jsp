<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<tiles:insertAttribute name = "main-content" />

<%--<img src='<spring:url value="/images/hello.jpg" />' />--%>
</br>
Ouailquaumme !
</br>
</br>

<form:form id="form" method="post" action="/firstSpring/send" modelAttribute="magicKeyForm">
            <form:label path="magicKey">Magic Key</form:label>
            <form:input path="magicKey" />
            <form:button >Magic Key</form:button>
</form:form>

</body>
</html>