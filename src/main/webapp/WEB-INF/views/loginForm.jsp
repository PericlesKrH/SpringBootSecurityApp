<%-- 
    Document   : loginForm
    Created on : Apr 23, 2020, 8:18:21 PM
    Author     : perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
 
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Login Page</title>
        </head>
        <body>
            <h1>Login Page</h1>
            
            <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
                <p>
                    Username: <input type="text" name="username"/>
                </p>
                <p>
                    Password: <input type="password" name="password"/>
                </p>
                <p>
                    <input type="submit" value="Login"/>
                </p>                
            </form:form>     
                
                <c:if test="${param.logout !=null}">
                <i>User logged out</i>
                </c:if>
            <c:if test="${param.error !=null}">
                <i>Invalid username and password</i>
                </c:if>
        </body>
    </html>

