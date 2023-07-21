
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="c" %>--%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
<ul>
    <li>Title : ${work.title}</li>
    <li>Release : ${work.release}</li>
    <li>Gender : ${work.gender}</li>
    <li>Artist : ${work.mainArtist.name}</li>
    <li>Summary : ${work.summary}</li>
    <form action="addToCart" method="post">
        <input type="hidden" name="id" value=${work.id}>
        <input type="submit" value="Add to cart"${work.id}>
    </form>
</ul>
</body>
</html>