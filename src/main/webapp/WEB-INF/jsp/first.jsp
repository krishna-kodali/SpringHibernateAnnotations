<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Web App</title>
<h1><b>Welcome to Restful Spring MVC Application</b></h1>
</head>
<body>
	<h1><a href="index.jsp"><b>Index</b></a></h1>
	<h3><a href="createDept.jsp">Create User</a></h3>
	<h3><a href="renameDept.jsp">Rename User</a></h3>
	<h3><a href="getDeptById.jsp">Get User By ID</a></h3>
	<h3><a href="delDeptByName.jsp">Delete User By Name</a></h3>
	<h3><a href="delDeptById.jsp">Delete User By ID</a></h3>
	
	<h3><a href="user/userForm">Get User By Name</a></h3>
	
	<h3><a href = "user/usersList">Click here to get the list of all users</a></h3>
	
	<h3><a href = "user/userForm">Click here to create an User</a></h3>
	
	<h3><a href = "user/renameUserForm">Click here to rename an User</a></h3>
	
	<h3><a href = "upload/uploadForm">Click here to upload a photo for the User</a></h3> 
	
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

</body>
</html>