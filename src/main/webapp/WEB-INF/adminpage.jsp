<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<body>

<h1 class="mt-4 text-center">Medarbejderside, Fogs carporte</h1>
<br>
<h3 class="text-left">Vælg funktion nedenfor:</h3>
<br>


<h3>Velkommen ${sessionScope.email} </h3>
<br>
<form name="showRequests" method="post" action="FrontController">
    <input type="hidden" name="target" value="showRequests">
    <input id="showRequests" type="submit" name="showRequests" value="Vis kundeforespørgsler">
</form>



</body>
<%@include file="../includes/footer.inc"%>