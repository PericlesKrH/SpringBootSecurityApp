<%-- 
    Document   : admin-home
    Created on : Apr 23, 2020, 9:25:04 PM
    Author     : perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Access Denied Page</title>
    </head>
    <body>
        <h1>Access Denied!</h1>
        <h2>This is Sparta!!</h2>
        <form:form action="${pageContext.request.contextPath}" method="POST">
            <input type="submit" value="back">
        </form:form>
        
    </body>
</html>

