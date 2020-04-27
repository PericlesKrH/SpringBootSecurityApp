<%-- 
    Document   : register-form
    Created on : Apr 24, 2020, 8:08:30 PM
    Author     : perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Register Page</title>
    </head>
    <body align="center">
        <h1>Registration Form</h1>
        <br/>
        <form action="${pageContext.request.contextPath}/admin/registerUser" method="POST" modelAttribute="myuser">
            <form:form action="${pageContext.request.contextPath}/admin/registerUser" method="POST" modelAttribute="myuser">
                <p>
                    <label>Enter a username</label>
                    <form:input path="username"/>
                </p>
                <p>
                    <label>Enter a password</label>
                    <form:input path="password"/>
                </p>
                <p>
                    <label>Enter a role</label>
                    <form:select multiple="true" path="roles">
                        <form:options items="${roles}" />
                    </form:select>
                </p>
                <input type="submit" value="Register">                
            </form:form>

        </form>

    </body>
</html>
