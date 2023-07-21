<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/application.js"></script>
</head>
<body>
<%--<c:if test="${not empty login}">--%>
    <a href="logout">Logout</a>
<%--</c:if>--%>
<%--<c:if test="${empty login}">--%>
<a href="login.jsp">Log in</a>
<%--</c:if>--%>


<h1>Hello</h1>
<br/>

<a href="add.jsp">Ajout d'un oeuvre au catalogue</a> <br>
<a href="pdf">PDF</a> <br>
<a href="saisie-nombre.jsp">Calculatrice</a> <br>
<a href="catalogue">Afficher le catalogue des oeuvres</a> <br>
</body>
</html>