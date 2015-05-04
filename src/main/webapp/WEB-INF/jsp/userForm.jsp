<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Page</title>
</head>

<body>

<h3><a href="../first">HOME</a></h3>

<h1>Add User</h1>
 
	<form:form method="post"  modelAttribute="user"  action="addUser">
 
		First Name:	<form:input path="userFirstName"></form:input><br/>
 
		Last Name: 	<form:input path="userLastName"></form:input><br/>
 
		<input type="submit" value="Submit">
 
	</form:form>

</body>

</html>