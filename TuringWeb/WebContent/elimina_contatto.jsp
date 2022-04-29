<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name= "loginForm" method= "post" action="http://localhost:8080/turing/ServletRimuovi">
		ID:<input type= "text" name="id"/> <br />
		<input type="submit" value="Inserisci" />
		</form>
		<br>
		<form name="loginForm" method="get"
		action="http://localhost:8080/turing/rubrica.jsp">
		<input type="submit" value="Torna alla home" />
	</form>
		
</body>
</html>