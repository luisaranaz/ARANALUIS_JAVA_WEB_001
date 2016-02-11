<%-- 
    Document   : multiplicaRpta
    Created on : 11/02/2016, 01:21:39 PM
    Author     : Luis Arana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MULTIPLICACION</h1>
        <p> Numero 1: <%= request.getAttribute("num1") %></p>
        <p> Numero 2: <%= request.getAttribute("num2") %></p>
        <p> Multiplicacion: <%= request.getAttribute("multiplicacion") %></p>
    </body>
</html>
