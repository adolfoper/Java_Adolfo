<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificación de jugador</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
.error {
	color: red;
}
</style>
</head>
<body>

<div class="container">
	<div class="jumbotron">
		<div class="float-right">
			<b>Usuario:</b>
			<sec:authentication property="principal.username" />
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<button type="submit" class="btn btn-primary mb-1">Salir</button>
			</form:form>
		</div>
		<div>
			<h1>Modificación de jugador</h1>
		</div>
	</div>
</div>
<br />

<form:form action="procesar_modif_jugador" modelAttribute="form_jugador" method="post">
	
	<form:hidden path="idjugador"/>
	
	&nbsp;&nbsp;&nbsp;&nbsp;Usuario:&nbsp; <form:input size="50" path="username" />*
		<form:errors path="username" cssClass="error" />
	<br /> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Nombre:&nbsp; <form:input size="50" path="nombre" />*
		<form:errors path="nombre" cssClass="error" />
		
	<br/> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Num. socio:&nbsp; <form:input size="6" path="numsocio" />*
		<form:errors path="numsocio" cssClass="error" />
		
	&nbsp;&nbsp;&nbsp;&nbsp;Fecha Atla:&nbsp; <form:input size="6" path="fechaalta"/>*
	<form:errors path="fechaalta" cssClass="error" />
	<br /><br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Direccion:&nbsp; <form:input size="50" path="direccion1" />*
		<form:errors path="direccion1" cssClass="error" />
	<br /><br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp; <form:input size="50" path="direccion2" />*
		<form:errors path="direccion2" cssClass="error" />
	<br /> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Teléfono:&nbsp; <form:input size="9" path="telefono" />*
		<form:errors path="telefono" cssClass="error" />
	<br /><br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Perfil:&nbsp; <form:radiobuttons path="tipo"
		items="${form_jugador.listaTipos}" delimiter="&nbsp;&nbsp;&nbsp;"/>
	<br /><br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-primary mb-1" type="submit" name="Modificar" value="Modificar" >Modificar</button>
	&nbsp;&nbsp;&nbsp;&nbsp; <a href="cancel2">Volver a lista de jugadores</a>
	<br/>
</form:form>
&nbsp;&nbsp;<font color="red">${form_jugador.mensaje}</font>

</body>
</html>
