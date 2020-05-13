<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<body>

<h1 class="mt-4 text-center">Medarbejderside</h1>
<h3>Velkommen ${sessionScope.email}! </h3>
<br>
<br>
<h5 class="text-left">Vælg funktion nedenfor:</h5>
<br>
<form name="showRequests" method="post" action="FrontController">
    <input type="hidden" name="target" value="showRequests">
    <input id="showRequests" type="submit" name="showRequests" value="Vis kundeforespørgsler">
</form>
<br>
<div class="text-center">
    <form name="logout" method="post" action="FrontController">
        <input type="hidden" name="target" value="logout">
        <button type="submit" class="btn btn-primary">Log af</button>
    </form>
</div>
<%
    request.getServletContext().setAttribute("width", null);
    request.getServletContext().setAttribute("length", null);
    request.getServletContext().setAttribute("height", null);
    request.getServletContext().setAttribute("roofMaterial", null);
    request.getServletContext().setAttribute("shedWidth", null);
    request.getServletContext().setAttribute("shedLength", null);
    request.getServletContext().setAttribute("reqId", null);
    request.getServletContext().setAttribute("total", null);
    //((ArrayList<Material>) session.getAttribute("materialList")).clear();
%>


</body>
<%@include file="../includes/footer.inc"%>
