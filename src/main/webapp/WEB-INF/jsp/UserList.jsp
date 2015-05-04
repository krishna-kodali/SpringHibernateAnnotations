<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of all Users</title>
</head>
<body>
<h3><a href="../first">HOME</a></h3>
<p>Please find below the list of Users</p>

	<center>
		<c:forEach items="${users}" var="user">
			
			<h2>${user.userId}: ${user.userFirstName}, ${user.userLastName}</h2><br>
			
			<c:forEach items="${user.roleSet}" var="role">
				<h3>${role.roleId}: ${role.roleName}</h3>
			</c:forEach><br>
		</c:forEach>
		
	</center>
	
</body>
</html>