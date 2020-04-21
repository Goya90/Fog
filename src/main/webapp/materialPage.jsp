<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.inc"%>
<!DOCTYPE html>
<html>
<head>
    <title>Materialeliste</title>
</head>
<body>
<h2>Tak for din bestilling</h2>
<h4>Du har valgt en carport med følgende mål:</h4>
<br>
<h5>Højde: ${requestScope.height} cm, bredde: ${requestScope.width} cm, længde: ${requestScope.length} cm</h5>
<br>
<h4>Materialeliste</h4>
<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Træ og tagplader</th>
                <th scope="col">Længde</th>
                <th scope="col">Antal</th>
                <th scope="col">Enhed</th>
                <th scope="col">Beskrivelse</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="material" items="${requestScope.materialList}">
                <td>${material.}</td>
                <td>${material.length}</td>
                <td>${material.quantity}</td>
                <td>${material.unit}</td>
                <td>${material.description}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <div class="row">
            <div class="col-sm">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Beslag og skruer</th>
                        <th scope="col">Antal</th>
                        <th scope="col">Enhed</th>
                        <th scope="col">Beskrivelse</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="material" items="${requestScope.materialList}">
                        <td>${material.name}</td>
                        <td>${material.quantity}</td>
                        <td>${material.unit}</td>
                        <td>${material.description}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
</body>
<%@include file="includes/footer.inc"%>
</html>
