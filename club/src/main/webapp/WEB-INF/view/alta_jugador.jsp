<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta de jugador</title>
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
			<h1>Alta de jugador</h1>
		</div>
	</div>
</div>
<br />

<form:form action="procesar_alta_jugador" modelAttribute="form_jugador" method="post">
	
	<form:hidden path="idjugador" value="0"/>
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Usuario:</b>&nbsp; <form:input size="50" path="username" />*
		<form:errors path="username" cssClass="error" />
	<br /> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Nombre:</b>&nbsp; <form:input size="50" path="nombre" />*
		<form:errors path="nombre" cssClass="error" />
		
	<br/> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Num. socio:</b>&nbsp; <form:input size="6" path="numsocio" />*
		<form:errors path="numsocio" cssClass="error" />
		
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Fecha Alta:</b>&nbsp; <form:input size="6" path="fechaalta"/>*
	<form:errors path="fechaalta" cssClass="error" />
	<br /><br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Direccion:</b>&nbsp; <form:input size="50" path="direccion1" />*
		<form:errors path="direccion1" cssClass="error" />
	<br /><br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp; <form:input size="50" path="direccion2" />*
		<form:errors path="direccion2" cssClass="error" />
	<br /> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Teléfono:</b>&nbsp; <form:input size="9" path="telefono" />*
		<form:errors path="telefono" cssClass="error" />
	<br /><br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Perfil:</b>&nbsp; <form:radiobuttons path="tipo"
		items="${form_jugador.listaTipos}" delimiter="&nbsp;&nbsp;&nbsp;"/>
	<br /><br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-primary mb-1" type="submit" name="Alta" value="Alta" >Alta</button>
	&nbsp;&nbsp;&nbsp;&nbsp; <a href="cancel2">Volver a lista de jugadores</a>
	<br/>
</form:form>
&nbsp;&nbsp;<font color="red">${form_jugador.mensaje}</font>

</body>
</html>
