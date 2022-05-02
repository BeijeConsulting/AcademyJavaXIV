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
    <title>Title</title>
</head>
<body>
<form action="./viewer" method="POST">
    <div>
        <label>Order By</label>
        <select name="order">
            <option value="name">Name</option>
            <option value="surname">Surname</option>
        </select>
    </div>
    <br>
    <input type="submit" name="submit" value="Submit">
</form>
</body>
</html>
