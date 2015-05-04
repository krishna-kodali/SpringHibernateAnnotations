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

<h1>Add Employee</h1>
 
	<%-- <form:form method="put" action="renameUser" commandName="renameUser">
 
		Old First Name:	<form:input path="oldFirstName"></form:input><br/>
 
		Old Last Name: 	<form:input path="oldLastName"></form:input><br/>
		
		New First Name:	<form:input path="newFirstName"></form:input><br/>
 
		New Last Name: 	<form:input path="newLastName"></form:input><br/>
 
		<input type="submit" value="submit">
 
	</form:form> --%>
	
	<form name="renameUserform" action="renameUser" method="GET">
        Old First Name:	<input type="text" name="oldFirstName"/><br/>
        Old Last Name:	<input type="text" name="oldLastName"/><br/>
        New Last Name:	<input type="text" name="newFirstName"/><br/>
        New Last Name:	<input type="text" name="newLastName"/><br/>
        <input type="submit"/>
    </form>

</body>

</html>