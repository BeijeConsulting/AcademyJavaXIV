<%--
  Created by IntelliJ IDEA.
  User: simonepitossi
  Date: 29/04/22
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Crea Contatto | Java</title>
</head>
<style>
    * {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }

    body {
        font-family: Helvetica, sans-serif;
        background-color: #23272e;
        color: white;
        min-height: 100vh;
    }

    a {
        text-decoration: none;
        color: #fff;
    }

    a:hover {
        text-decoration: none;
    }

    h1 {
        text-align: center;
        padding: 30px 0;
    }

    .container {
        padding: 30px 0;
        width: 80%;
        min-width: 300px;
        margin: 0 auto;
        display: flex;
        justify-content: center;
    }


    .container2 {
        padding: 30px 0;
        width: 80%;
        min-width: 300px;
        margin: 0 auto;
        display: flex;
        justify-content: center;
    }

    .btn {
        display: block;
        padding: 10px 20px;
        border-radius: 4px;
        border: 2px solid white;
        font-size: 20px;
    }

    h2 {
        margin-top: 30px;
        text-align: center;
    }

    form {
        width: 300px;
    }

    input {
        display: block;
        padding: 7px;
        width: 100%;
        margin: 5px 0;
        font-size: 17px;
        border: none;
        border-radius: 5px;
    }

    input:focus {
        outline: none;
    }

    label {
        display: block;
        margin-top: 18px;
    }

    .submit {
        margin: 20px 0;
        color: #fff;
        border: 2px solid #fff;
        background-color: transparent;
        cursor: pointer;
        transition: all .2s;
    }

    .submit:hover {
        background-color: #fff;
        color: #23272e;
    }
</style>
<body>

<%@ include file="header.jsp" %>

<h1>Modifica contatto</h1>

<h2>Dati contatto</h2>
<div class="container">
    <form class="my_form" action="./update_contact" method="POST">
        <label for="fname">Id:</label>
        <input type="number" id="id" name="id" value="<%= request.getParameter("id") %>">
        <label for="fname">Nome:</label>
        <input type="text" id="fname" name="fname" value="<%= request.getParameter("fname") %>">
        <label for="lname">Cognome:</label>
        <input type="text" id="lname" name="lname" value="<%= request.getParameter("lname") %>">
        <label for="phone">Telefono:</label>
        <input type="text" id="phone" name="phone" value="<%= request.getParameter("phone") %>">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= request.getParameter("email") %>">
        <label for="notes">Note:</label>
        <input type="text" id="notes" name="notes" value="><%= request.getParameter("notes") %>">
        <input class="submit" type="submit" value="Update">
    </form>
</div>
<div class="container2">
    <iframe id="inlineFrameExample"
            title="id"
            width="3000"
            height="1500"
            src="http://localhost:8080/TuringWeb/show_contacts_for_delete"
    >

    </iframe>


</div>
</body>
</html>