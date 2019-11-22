<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editories</title>
</head>

<body>
	<h1>Portal del editor</h1>
	<a>Tiene 4 artículos de colaboradores pendientes de firmar con su nombre.</a>
	<br>
	<br>
<!--<	<p>Usuario: <sec:authentication property="principal.username"/></p>
	<p>Roles: <sec:authentication property="principal.authorities"/></p>
-->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<button type="submit"class="btn btn-warning">Salir</button>
	</form:form>
</body>
</html>