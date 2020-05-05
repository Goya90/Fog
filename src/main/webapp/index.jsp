<%@ page import="FogUtil.Initializer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.inc"%>

<%
    boolean roof = true;

    if (request.getServletContext().getAttribute("width") == null) {
        request.getServletContext().setAttribute("width", Initializer.getWidthsList());
    }
    if (request.getServletContext().getAttribute("length") == null) {
        request.getServletContext().setAttribute("length", Initializer.getLengthsList());
    }
    if (request.getServletContext().getAttribute("height") == null) {
        request.getServletContext().setAttribute("height", Initializer.getHeightsList());
    }
    if (request.getServletContext().getAttribute("shedLength") == null) {
        request.getServletContext().setAttribute("shedLength", Initializer.getShedLengthsList());
    }
    if (request.getServletContext().getAttribute("shedWidth") == null) {
        request.getServletContext().setAttribute("shedWidth", Initializer.getShedWidthsList());
    }
    request.getServletContext().setAttribute("flatRoof", true);
    //if (request.getServletContext().getAttribute("roofMaterial") == null) {
    //request.setAttribute("roofMaterial", Initializer.getRoofMaterialType(roof));
    request.getServletContext().setAttribute("roofMaterial", Initializer.getRoofMaterialType((boolean)request.getServletContext().getAttribute("flatRoof")));
    //request.setAttribute("flatRoof", true);
    //}
    /*if (request.getServletContext().getAttribute("flatRoof") == null) {
        request.getServletContext().setAttribute("flatRoof", true);
    }*/
    //request.getServletContext().setAttribute("flatRoof", true);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Flat roof</title>
</head>
<body>
<br>
<br>
<h3>Design carport med fladt tag</h3>
<br>
<a href="FrontController?target=redirect&destination=slantedRoof">Eller gå til carport med rejsning</a>
<br>
<br>
<div class="container-fluid">
    <div id="navbar-two">
        <div class="row">

            <div class="form-group">
                <form action="FrontController" method="POST">
                    <input type="hidden" name="target" value="request">
                    <label for="exampleFormControlSelect1">Vælg bredde:</label>
                    <select class="form-control" name="width" id="exampleFormControlSelect1" style="width: 350px">
                        <c:forEach var="width" items="${applicationScope.width}">
                            <option value="${width}">${width} mm.</option>
                        </c:forEach>
                    </select>

                    <div class="form-group">
                        <label for="exampleFormControlSelect2">Vælg længde:</label>
                        <select class="form-control" name="length" id="exampleFormControlSelect2" style="width: 350px">
                            <c:forEach var="length" items="${applicationScope.length}">
                                <option value="${length}">${length} mm.</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="exampleFormControlSelect3">Vælg højde:</label>
                        <select class="form-control" name="height" id="exampleFormControlSelect3" style="width: 350px">
                            <c:forEach var="height" items="${applicationScope.height}">
                                <option value="${height}">${height} mm.</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="exampleFormControlSelect4">Vælg materiale til tag:</label>
                        <select class="form-control" name="roofMaterial" id="exampleFormControlSelect4" style="width: 350px">
                            <c:forEach var="roofMaterial" items="${applicationScope.roofMaterial}">
                                <option value="${roofMaterial}">${roofMaterial}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <br>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Vælg bredde til redskabsrum:</label>
                        <select class="form-control" name="shedWidth" id="exampleFormControlSelect5" style="width: 350px">
                            <option value="0" selected>Ønsker ikke redskabsrum </option>
                            <c:forEach var="shedWidth" items="${applicationScope.shedWidth}">
                                <option value="${shedWidth}">${shedWidth} mm.</option>
                            </c:forEach>
                        </select>
                    </div>


                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Vælg længde til redskabsrum:</label>
                        <select class="form-control" name="shedLength" id="exampleFormControlSelect6" style="width: 350px">
                            <option value="0" selected>Ønsker ikke redskabsrum </option>
                            <c:forEach var="shedLength" items="${applicationScope.shedLength}">
                                <option value="${shedLength}">${shedLength} mm.</option>
                            </c:forEach>
                        </select>
                    </div>


                    <br>
                    <h7>NB: Længde og bredde til redskabsrum skal være mindst 30 cm kortere end længde og bredde til carporten</h7>
                    <br>
                    <br>
                    <br>
                    <h3>Indtast dine kontakt detaljer:</h3>
                    <div class="form-group">
                        <label for="name">Navn</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="Dit navn">
                    </div>
                    <div class="form-group">
                        <label for="mail">Email addresse</label>
                        <input type="email" class="form-control" name="mail" id="mail" placeholder="Din E-mail">
                    </div>
                    <div class="form-group">
                        <label for="telno">Telefonnummer</label>
                        <input type="text" class="form-control" name="telno" id="telno" placeholder="Dit telefonnr">
                    </div>
                    <div class="form-group">
                        <label for="comments">Kommentarer</label>
                        <input type="text" class="form-control" name="comments" id="comments" style="height:100px">
                    </div>
                    <br>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Send forespørgsel</button>
                    </div>

                </form>
            </div>
        </div>
    </div>



</div>

<form name="login" action="FrontController" method="POST">
    ${requestScope.error}
    <input type="hidden" name="target" value="login">

    <label for="email">Email:</label>
    <input id="email" type="text" name="email" value="" align="left">
    <label for="password">Password:</label>
    <input id="password" type="password" name="password" value="" align="left">
    <input type="submit" value="Log ind">

</form>
</body>

<%@include file="includes/footer.inc"%>

