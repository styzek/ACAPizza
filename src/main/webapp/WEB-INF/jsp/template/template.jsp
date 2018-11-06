<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>${title}</title>
</head>
<body>
<div>
    <tiles:insertAttribute name="header" />
</div>
<div><tiles:insertAttribute name="menu" /></div>
<spring:url var="localeFr" value="">
    <spring:param name="locale" value="fr" />
</spring:url>

<spring:url var="localeEn" value="">
    <spring:param name="locale" value="en" />
</spring:url>


<a href="${localeFr}">fr</a>

<a href="${localeEn}">en</a>



<div class="container">

    <%--<div style="float:left;padding:10px;width:15%;"><tiles:insertAttribute name="menu" /></div>--%>

    <div><tiles:insertAttribute name="main-content" /></div>
</div>

<div style="clear:both">
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>