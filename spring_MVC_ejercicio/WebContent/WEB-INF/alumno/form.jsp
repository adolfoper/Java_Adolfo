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
<h1>Alta de alumno</h1>
<br />

<form:form action="procesar" modelAttribute="alumno">
	Nombre: <form:input path="nombre" />*
		       <form:errors path="nombre" cssClass="error" />
	<br /> <br />
	DNI: <form:input path="dni"/>
		 	<form:errors path="dni" cssClass="error" />
	<br/> <br />
	E-mail: <form:input path="email"/>
	<form:errors path="email" cssClass="error" />
	<br/> <br />
	
	Becado: <form:radiobuttons path="becado"
	items="${alumno.listaSN}" />
	<br /><br />
	
	Asignatura: <form:select path="asignatura">
				<form:options items="${alumno.listaAsignaturas}" />
				</form:select>
	<br/><br/>
	<input type="submit"> 
	<br />
</form:form>

</body>
</html>