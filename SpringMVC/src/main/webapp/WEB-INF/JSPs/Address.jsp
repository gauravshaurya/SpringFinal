<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Page</title>
</head>
<body>
<hr/>		
<fieldset>
		<legend>Address Details</legend>
        <f:form action=address method="post" >
            <table>
            	<tr>
                    <td>House No:</td>
                    <td><f:input path="houseNo" required="true"/></td>
                </tr>
             	<tr>
                    <td>Address Line1:</td>
                    <td><f:input path="address1"  required="true"/></td>
                </tr>
                <tr>
                    <td>Address Line2:</td>
                    <td><f:input path="address2"  required="true"/></td>
                </tr>
                <tr>
                    <td>City :</td>
                    <td><f:input path="city" size="15" required="true"/></td>
                </tr>
                <tr>
                    <td>State:</td>
                 	<td><f:input path="state" size="15" required="true"/></td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td><f:input path="pincode" size="15" required="true"/></td>
                </tr>
                <tr>
                    <td><button type="submit" value="address">Add Address</button></td>
                </tr>
        
            </table>
        </f:form>
        </fieldset>
</body>
</html>