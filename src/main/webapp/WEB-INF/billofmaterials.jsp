<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>
<%@page import="java.text.DecimalFormat" %>
<%@ page import="FunctionLayer.Material" %>
<%@ page import="java.util.ArrayList" %>

<head>
    <title>Materialeliste</title>
</head>

<h2>Tak for din bestilling</h2>
<br>
<h4>Du har valgt en carport med følgende mål:</h4>
<br>
<h5>Højde: ${applicationScope.height} cm, bredde: ${applicationScope.width} cm, længde: ${applicationScope.length} cm</h5>
<br>
<h4>Materialeliste</h4>
<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Kategori</th>
                <th scope="col">Navn</th>
                <th scope="col">Beskrivelse</th>
                <th scope="col">Antal</th>
                <th scope="col">Længde</th>
                <th scope="col">Pris</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            <c:forEach var="material" items="${sessionScope.materialList}">
                <c:if test="${material.category=='Træ'}">
                    <td>${material.category}</td>
                    <td>${material.name}</td>
                    <td>${material.description}</td>
                    <td>${material.quantity}</td>
                    <td>${material.length}</td>
                    <td>${material.price}</td>
                </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Kategori</th>
                <th scope="col">Navn</th>
                <th scope="col">Beskrivelse</th>
                <th scope="col">Antal</th>
                <th scope="col">Pris</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            <c:forEach var="material" items="${sessionScope.materialList}">
                <c:if test="${material.category=='Beslag & skruer'}">
                    <td>${material.category}</td>
                    <td>${material.name}</td>
                    <td>${material.description}</td>
                    <td>${material.quantity}</td>
                    <td>${material.price}</td>
                </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Kategori</th>
                <th scope="col">Navn</th>
                <th scope="col">Beskrivelse</th>
                <th scope="col">Antal</th>
                <th scope="col">Pris</th>
            </tr>
            </thead>
            <tbody>
            <tr>
            <c:forEach var="material" items="${sessionScope.materialList}">
                <c:if test="${material.category=='Tagpakken'}">
                    <td>${material.category}</td>
                    <td>${material.name}</td>
                    <td>${material.description}</td>
                    <td>${material.quantity}</td>
                    <td>${material.price}</td>
                </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<h5 class="text-right">Samlet pris: ${applicationScope.total} kr inklusiv moms
    <br>

   <h3>Behandl kundeforespørgsel:</h3>
    <h2>   ${requestScope.error} </h2>
    <br>
    <h2>Hvis du vil ændre prisen på kundetilbuddet, indtast den nye pris. Hvis ikke, så lad feltet være tomt.</h2>
    <br>
    <form action="FrontController" method="POST">
        <input type="hidden" name="target" value="processrequest">
        <div class="text-left">
            <label for="newprice">Ny pris:</label>
            <input id="newprice" type="text" name="newprice" value="">
            <button type="submit" class="btn btn-primary">Opdater kundeforespørgsel</button>
        </div>
    </form>
    <br>
    <br>
<form action="FrontController" method="POST">
    <input type="hidden" name="target" value="drawing">
    <div class="text-center">
        <button type="submit" class="btn btn-primary">Vis tegning</button>
    </div>
<%
    ((ArrayList<Material>) session.getAttribute("materialList")).clear();
    %>
</form>
<%@include file="../includes/footer.inc"%>