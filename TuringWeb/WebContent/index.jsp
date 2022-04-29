<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<h2>Rubrica</h2>
​
<form action="./ServletInsert" method="get">
  <button type="submit">insert</button>
  <button type="submit" formaction="./ServletSelect">select</button>
</form>
<!--  
<form action="./ServletInsert">
  <input type="radio" id="insert" name="insert" value="insert">
  <label for="insert">INSERT</label><br>

  

  <input type="radio" id="select" name="select" value="select" >
  <label for="css">SELECT</label><br>

<input type="submit" value="Submit">

 </form> -->

<!--
<form action="./test">

  <input type="radio" id="select" name="select" value="select" >
  <label for="css">SELECT</label><br>

  <input type="radio" id="update" name="update" value="update">
  <label for="javascript">UPDATE</label><br>

 <input type="radio" id="delete" name="delete" value="delete">
  <label for="javascript">DELETE</label><br>

  <input type="submit" value="Submit">
</form> -->

</body>
</html>