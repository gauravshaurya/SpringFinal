<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>
	<div align="right">
		Welcome ${sessionScope.uObj.firstName} ${uObj.lastName}
	</div>
	<div align="center">
		<h1>Welcome User</h1>
			<a href="viewProfile">View Profile</a><br/>
			<a href="address">Add Address</a><br/>
			<a href="viewAddresses">View Addresses</a><br/>
			<a href="">Change Password</a>
			<a href="">Logout</a>
	</div>
</body>
</html>