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
        <style>
            .error{
                color:red;
            }
        </style>
    </head>
    <body align="center">
        <h1>Registration Form</h1>
        <c:if test="${userExistError != null}">
          ${userExistError}
        </c:if>
        <br/>
        <form action="${pageContext.request.contextPath}/admin/registerUser" method="POST" modelAttribute="myuser">
            <form:form action="${pageContext.request.contextPath}/admin/registerUser" method="POST" modelAttribute="myuser">
                <p>
                    <form:input path="username" placeholder="Username"/>
                    <form:errors path="username" cssClass="error"/>
                </p>
                <p>
                    <form:input path="password" placeholder="Password"/>
                    <form:errors path="password" cssClass="error"/>
                </p>
                <p>
                    <form:input path="fname" placeholder="First name"/>
                    <form:errors path="fname" cssClass="error"/>
                </p>
                <p>
                    <form:input path="lname" placeholder="Last name"/>
                    <form:errors path="lname" cssClass="error"/>
                </p>
                <p>
                    <form:input path="email" placeholder="Email"/>
                    <form:errors path="email" cssClass="error"/>
                </p>
                <p>
                    <label>Enter a role</label>
                    <form:select multiple="true" path="roles" itemValue="rid" itemLabel="rname">
                        <form:options items="${roles}" itemLabel="rname" itemValue="rid"/>
                    </form:select>
                </p>
                <input type="submit" value="Register">                
            </form:form>

        </form>

    </body>
</html>

