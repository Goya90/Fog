<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.inc"%>
<head>
    <title>Materialeliste</title>
</head>
<body>

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
            <c:forEach var="material" items="${requestScope.materialList}">
                <td>${material.category}</td>
                <td>${material.name}</td>
                <td>${material.description}</td>
                <td>${material.quantity}</td>
                <td>${material.length}</td>
                <td>${material.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<form action="FrontController" method="POST">
    <input type="hidden" name="target" value="drawing">
<div class="text-center">
    <button type="submit" class="btn btn-primary">Vis tegning</button>
</div>
</form>




</body>
<%@include file="includes/footer.inc"%>