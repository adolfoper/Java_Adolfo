<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar contacto</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<h1>Modificar contacto</h1>
<br />

<form:form action="procesar_modificacion" modelAttribute="contacto_web" method="post">
	
	<form:hidden path="idcontacto"/>
	
	<p>
		Nombre: <form:input path="nombre" />*
		        <form:errors path="nombre" cssClass="error" />
	</p>
	
	<p>
		E-mail: <form:input path="email"/>*
		<form:errors path="email" cssClass="error" />
	</p>
	
	<p>
		Teléfono: <form:input path="telefono"/>*
		<form:errors path="telefono" cssClass="error" />
	</p>

	<br/>
	   <button type="submit" name="Guardar" value="Guardar">Guardar</button>
	<br />
</form:form>

<br/>
<a href="">Volver a lista de contactos</a>

</body>
</html>