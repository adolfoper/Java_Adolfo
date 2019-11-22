<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editorial Faro de Papel</title>

</head>
<body>
	<h1>Editorial Faro de Papel </h1>
	<br>
	<!--<form:form action="${pageContext.request.contextPath}/formlogin"
		method="POST">
		<button type="submit"class="btn btn-warning">Acceso empleados</button>
	</form:form>-->
	<!--<a href="formlogin">Acceso empleados</a> <br /> -->
	<a href="${pageContext.request.contextPath}/formlogin">Acceso empleados</a>
	<h4>Bienvenidos a Editorial Faro de Papel</h4>
	<p>Compre nuestros libros que son muy buenos.</p>
	<p>Nuestra intención no es ganar dinero si no hacer amigos. Nos preocupa mucho todo ese rollo del medio ambiente.</p> 
	<p>Si quieres hacernos llegar tu manuscrito pulsa en el icono invisible.</p>
	
</body>
</html>