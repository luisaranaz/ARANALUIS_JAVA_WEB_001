<%-- 
    Document   : sumaRpta
    Created on : 11/02/2016, 01:17:45 PM
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
        <h1>SUMA</h1>
        <p> Numero 1: <%= request.getAttribute("num1") %></p>
        <p> Numero 2: <%= request.getAttribute("num2") %></p>
        <p> Suma: <%= request.getAttribute("suma") %></p>
    </body>
</html>
