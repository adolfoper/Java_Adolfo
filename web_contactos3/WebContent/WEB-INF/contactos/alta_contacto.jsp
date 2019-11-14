<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta de contacto</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<h1>Alta de contacto</h1>
<br />

<form:form action="procesar_alta" modelAttribute="contacto_web" method="post">
	
	<form:hidden path="idcontacto" value="0"/>
	
	Nombre: <form:input path="nombre" />*
		       <form:errors path="nombre" cssClass="error" />
	<br /> <br />
	
	E-mail: <form:input path="email"/>*
	<form:errors path="email" cssClass="error" />
	<br/> <br />
	
	Teléfono: <form:input path="telefono"/>*
	<form:errors path="telefono" cssClass="error" />
	<br/> <br />

	<br/><br/>
	   <button type="submit" name="Alta" value="Alta">Alta</button>
	<br />
</form:form>

<br />
<a href="lista-contactos">Volver a lista de contactos</a>

</body>
</html>