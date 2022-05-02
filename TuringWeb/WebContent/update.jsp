<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
  * {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }
  body {
    font-family: Helvetica, Times New Roman;
    background-color: mediumpurple;
    color: black;
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
    /*padding: 30px 0;*/
    width: 80%;
    min-width: 300px;
    margin: 0 auto;
    display: flex;
    justify-content: center;
    margin-top: 20px;
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
    margin-top: 1px;

  }
</style>
<body>
<div class="container">
  <form action="./update" method="post">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="fname" value="John"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="lname" value="Doe"><br>
    <label for="telefono">Telefono:</label><br>
    <input type="text" id="telefono" name="telefono" value="3256225632"><br>
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" value="john.doe@gmail.it"><br>
    <label for="note">Note:</label><br>
    <input type="text" id="note" name="note" value="Ciao sono Doe"><br>
    <label for="id">Id da modificare:</label><br>
    <input type="number" id="id" name="id" value=1><br><br>
    <input type="submit" value="Update">
  </form>
</div>
<div class="container">
  <form action="../TuringWeb" method="post">
    <input type="submit" value="Torna Indietro">
  </form>
</div>
</body>
</html>
