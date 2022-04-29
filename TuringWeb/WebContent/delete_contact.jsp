<%--
  Created by IntelliJ IDEA.
  User: simonepitossi
  Date: 29/04/22
  Time: 15:54
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
    <title>Elimina Contatto</title>
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

<h1>Elimina contatto</h1>

<h2>Dati contatto</h2>
<div class="container">
    <form class="my_form" action="./delete_contact" method="POST">
        <label for="id">Id:</label>
        <input type="number" id="id" name="id" value="<%= request.getParameter("id") %>">
        <input class="submit" type="submit" value="Delete">
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
