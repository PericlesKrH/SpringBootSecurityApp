<%-- 
    Document   : admin-home
    Created on : Apr 23, 2020, 9:25:04 PM
    Author     : perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Teacher Page</title>
    </head>
    <body>
        <h1>Welcome Teacher</h1>
        <hr/>
        <p>
            User: <security:authentication property="principal.username"/>
            <br/>
            Role(s):<security:authentication property="principal.authorities"/>
        </p>
        <hr/>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="logout">
        </form:form>
            <form:form action="${pageContext.request.contextPath}" method="POST">
            <input type="submit" value="back">
        </form:form>
    </body>
</html>

