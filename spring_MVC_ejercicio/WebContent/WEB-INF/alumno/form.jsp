<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datos de alumno</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>

<form action="procesar" modelAttribute="alumno">
	Nombre(*):<form:input path="nombre" />
		      <form:errors path="nombre" cssClass="error" />
	<br />
	DNI:<input path="dni"/><br/>
	E-mail:<input path="email"/><br/>
	Becado(S/N):<input path="becado"/><br/>
	Asignatura:<input path="asignatura"/><br/>
	<input type="submit">
	
<br />
</form>

</body>
</html>