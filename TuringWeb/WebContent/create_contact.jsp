<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Contact</title>
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
<div class="container">
<form action="./create_contact" method="post">
  <label for="nome">First name:</label><br>
  <input type="text" id="nome" name="nome"><br>
  <label for="cognome">Last name:</label><br>
  <input type="text" id="cognome" name="cognome"><br><br>
   <label for="telefono">Phone number:</label><br>
    <input type="text" id="telefono" name="telefono"><br>
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email"><br><br>
      <label for="note">Note:</label><br>
      <input type="text" id="note" name="note"><br><br>
  <input type="submit" value="Submit">
</form>
</div>

</body>
</html>