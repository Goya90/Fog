<%@ page import="FogUtil.Initializer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.inc"%>
<%@page import="java.text.DecimalFormat" %>
<%
    if (request.getServletContext().getAttribute("width") == null) {
        request.getServletContext().setAttribute("width", Initializer.getWidthsList());
    }
    if (request.getServletContext().getAttribute("length") == null) {
        request.getServletContext().setAttribute("length", Initializer.getLengthsList());
    }
    if (request.getServletContext().getAttribute("height") == null) {
        request.getServletContext().setAttribute("height", Initializer.getHeightsList());
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome page</title>
</head>
<body>
<br>
<br>
<h3>Vælg carport type og størrelse</h3>
<div class="container-fluid">
    <div id="navbar-two">
        <div class="row">


            <div class="form-group">
                <form name="AddDimensionsCommand" action="FrontController" method="POST">
                    <input type="hidden" name="target" value="AddDimensionsCommand">
                <label for="exampleFormControlSelect1">Vælg bredde:</label>
                <select class="form-control" name="width" id="exampleFormControlSelect1" style="width: 350px">
                    <c:forEach var="width" items="${applicationScope.width}">
                        <option value="${width}">${width} mm.</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="exampleFormControlSelect1">Vælg længde:</label>
                <select class="form-control" name="length" id="exampleFormControlSelect1" style="width: 350px">
                    <c:forEach var="length" items="${applicationScope.length}">
                        <option value="${length}">${length} mm.</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="exampleFormControlSelect1">Vælg højde:</label>
                <select class="form-control" name="height" id="exampleFormControlSelect1" style="width: 350px">
                    <c:forEach var="height" items="${applicationScope.height}">
                        <option value="${height}">${height} mm.</option>
                    </c:forEach>
                </select>
            </div>


            <div class="col-lg-6 col-md-6">
                <ul class="nav">
                    <li class="col-12 px-0">
                        <button class="btn btn-secondary btn-block dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Vælg bredde<sub><i class="fa fa-angle-down" aria-hidden="true"></i></sub></button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">200 cm</a>
                            <a class="dropdown-item" href="#">300 cm</a>
                            <a class="dropdown-item" href="#">400 cm</a>
                            <a class="dropdown-item" href="#">500 cm</a>
                        </div>
                    </li>
                    <br>
                    <br>
                    <br>
                    <li class="col-12 px-0">
                        <button class="btn btn-secondary btn-block dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Vælg længde<sub><i class="fa fa-angle-down" aria-hidden="true"></i></sub></button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">500 cm</a>
                            <a class="dropdown-item" href="#">550 cm</a>
                            <a class="dropdown-item" href="#">600 cm</a>
                            <a class="dropdown-item" href="#">650 cm</a>
                        </div>
                    </li>
                    <br>
                    <br>
                    <br>
                    <li class="col-12 px-0">
                        <button class="btn btn-secondary btn-block dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Vælg højde<sub><i class="fa fa-angle-down" aria-hidden="true"></i></sub></button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">200 cm</a>
                            <a class="dropdown-item" href="#">220 cm</a>
                            <a class="dropdown-item" href="#">240 cm</a>
                            <a class="dropdown-item" href="#">300 cm</a>
                        </div>
                    </li>
                    <br>
                    <br>
                    <br>
                    <li class="col-12 px-0">
                        <button class="btn btn-secondary btn-block dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Vælg tagtype<sub><i class="fa fa-angle-down" aria-hidden="true"></i></sub></button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Fladt tag</a>
                            <a class="dropdown-item" href="#">Tag med rejsning</a>
                        </div>
                    </li>
                    <br>
                    <br>
                    <br>
                    <li class="col-12 px-0">
                        <button class="btn btn-secondary btn-block dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Vælg med eller uden skur<sub><i class="fa fa-angle-down" aria-hidden="true"></i></sub></button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Med skur</a>
                            <a class="dropdown-item" href="#">Uden skur</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<br>
<br>
<style>
    body {font-family: Arial, Helvetica, sans-serif;}
    * {box-sizing: border-box;}
    input[type=text], select, textarea {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-top: 6px;
        margin-bottom: 16px;
        resize: vertical;
    }
    input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type=submit]:hover {
        background-color: #45a049;
    }
    .container {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
</style>
</head>
<body>
<h3>Kontakt detaljer</h3>
<div class="container">
    <form action="/action_page.php">
        <label for="fornavn">Fornavn</label>
        <input type="text" id="fornavn" name="firstname" placeholder="Dit fornavn">
        <label for="efternavn">Efternavn</label>
        <input type="text" id="efternavn" name="lastname" placeholder="Dit efternavn">
        <label for="vej">Vejnavn</label>
        <input type="text" id="vej" name="street" placeholder="Vejnavn">
        <label for="husnummer">Husnummer</label>
        <input type="text" id="husnummer" name="streetno" placeholder="Husnummer">
        <label for="postnr">Postnummer</label>
        <input type="text" id="postnr" name="postnr" placeholder="Postnr">
        <label for="tlfnr">Telefon nr</label>
        <input type="text" id="tlfnr" name="tlfnr" placeholder="Tlfnr">
        <label for="mail">Email</label>
        <input type="email" id="mail" name="mail" placeholder="Email">
        </select>
        <label for="Kommentar">Bemærkninger</label>
        <textarea id="Kommentar" name="Kommentar" placeholder="Din kommentar" style="height:200px"></textarea>
        <input type="submit" value="Send">
    </form>
</div>
</body>
</body>
<%@include file="includes/footer.inc"%>
</html>
