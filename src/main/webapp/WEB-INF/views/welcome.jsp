<%-- 
    Document   : welcome
    Created on : Apr 23, 2020, 7:30:08 PM
    Author     : perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Welcome</h1>
        <hr/>
        <p>
            User: <security:authentication property="principal.username"/>
            <br/>
            Role(s):<security:authentication property="principal.authorities"/>
        </p>
        <hr/> 
        <security:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/home">Go to Admin Home page</a>
        </security:authorize>
        <br/>
        <security:authorize access="hasRole('TEACHER')">
        <a href="${pageContext.request.contextPath}/teacher/home">Go to Teacher Home page</a>
        </security:authorize>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="logout">
        </form:form>

    </body>
</html>
