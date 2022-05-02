<%--
  Created by IntelliJ IDEA.
  User: Padawan
  Date: 02-May-22
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Rubrica Home</title>
</head>
<body>
<header>
  <h1>
    Rubrica Web
  </h1>
</header>
<form action="./viewer" method="GET">
  <input type="submit" name="submit" value="View">
</form>
<form action="./inserter" method="GET">
  <input type="submit" name="submit" value="Insert">
</form>

<!--<form action="./test" method="post">-->
<!--  <label for="fname">First name:</label><br>-->
<!--  <input type="text" id="fname" name="fname" value="John"><br>-->
<!--  <label for="lname">Last name:</label><br>-->
<!--  <input type="text" id="lname" name="lname" value="Doe"><br><br>-->
<!--  <input type="submit" value="Submit">-->
<!--</form> -->


</body>
</html>
