<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h1 align="center">${formLabel}</h1>
<hr/>		
<fieldset>
        <f:form action="${path}/registerUser" method="post" modelAttribute="uObj" >
            <table>
            	<tr>
                    <td>Email ID:</td>
                    <td><f:input path="email"/></td>
                </tr>
             	<tr>
                    <td>First Name:</td>
                    <td><f:input path="firstName" required="true"/></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><f:input path="lastName" required="true"/></td>
                </tr>
                <tr>
                    <td>Gender :</td>
                    <td>
                    <f:radiobutton path="gender" value="M" />Male
                    <f:radiobutton path="gender" value="F" />Female
                    </td>
                </tr>
                <tr>
                    <td>Role:</td>
                    <td><f:input path="role" required="true"/></td>
                </tr>
                
                <c:if test="${uObj.password eq null}">
                <tr>
                    <td>Password:</td>
                    <td><f:input path="password" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="${buttonLabel}"/></td>
                </tr>
                </c:if>
        
            </table>
        </f:form>
        </fieldset>
</body>
</html>