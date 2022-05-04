<%--
  Created by IntelliJ IDEA.
  User: Padawan
  Date: 02-May-22
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Contatto</title>
</head>
<header>
    <h3>
        Inserisci nuovo contatto
    </h3>
</header>
<body>
<form action="./inserter" method="POST">
    <div>
        <label>Name</label>
        <input type="text" name="name" placeholder="Enter first name">
    </div>
    <br>
    <div>
        <label>Surname</label>
        <input type="text" name="surname" placeholder="Enter last name">
    </div>
    <br>
    <div>
        <label>Email</label>
        <input type="text" name="email" placeholder="Enter email">
    </div>
    <br>
    <div>
        <label>Phone</label>
        <input type="text" name="phone" placeholder="Enter phone">
    </div>
    <br>
    <div>
        <label>Notes</label>
        <input type="text" name="notes" placeholder="Enter notes">
    </div>
    <br>
    <input type="submit" name="submit" value="Submit">
</form>
</body>
</html>
