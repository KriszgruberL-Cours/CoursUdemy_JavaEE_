<%--
  Created by IntelliJ IDEA.
  User: lkris
  Date: 20-07-23
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajout d'un oeuvre</title>
</head>
<body>
  <form action="addWork" method="post">
    Title : <input type="text" name="title"><br>
    Release : <input type="text" name="release"><br>
    Gender : <input type="text" name="gender"><br>
    Summary : <input type="text" name="artist"><br>
    Artist : <input type="text-area" name="summary"><br>
    <input type="submit" value="Add!">
  </form>
</body>
</html>