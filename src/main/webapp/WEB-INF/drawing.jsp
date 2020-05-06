
<%@ page import="FogUtil.Initializer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<head>
    <title>Tegning</title>
</head>
<body>
<h1>Tegning af carport</h1>
<br>
${requestScope.svgdrawing}
<br>
<br>
<a href="FrontController?target=redirect&destination=index">Til forsiden</a>

</body>
<%@include file="../includes/footer.inc"%>

