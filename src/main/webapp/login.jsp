<%--
  Created by IntelliJ IDEA.
  User: lkris
  Date: 20-07-23
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
  Login : <input type="text" name="log" >
  Password : <input type="password" name="pwd">
  <input type="submit" value="Log">

<c:if test="${not empty login}">
    <h2>Logged with succes!</h2>
    <a href="index.jsp">Home</a>
</c:if>

</form>



</body>
</html>