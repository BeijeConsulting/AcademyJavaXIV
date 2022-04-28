<%@page import="it.beije.turing.web.Contatto"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
      margin: auto 0;
      display: flex;
      justify-content: center;
   }
   .btn {
      display: block;
      padding: 10px 20px;
      border-radius: 4px;
      border: 2px solid white;
      font-size: 20px;
      margin: 20px;
   }
</style>
<body>

<% 
int x = 1;
int y = 4;
int z = x + y;

System.out.println("z = " + z);

//request.getSession();
String fname = (String)session.getAttribute("fname");
String lname = (String)session.getAttribute("lname");


//Contatto contatto = new Contatto();

//out.print("z = " + z);
%>
<br>
<%-- 
x + y =&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= x + y %><br>
<% for (char a = 'a'; a <= 'z'; a++) { %>
	<%= a %>
<% } %>
<br>
<%= x + 3 %>
--%>
<a class="btn">
FNAME = <%= fname %><br>
LNAME = <%= lname %>
</a>
</body>
</html>