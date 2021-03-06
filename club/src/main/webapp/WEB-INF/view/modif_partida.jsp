<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar partida</title>
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
			<h1>Modificar partidar</h1>
		</div>
	</div>
</div>
<br />

<form:form action="procesar_modif_partida" modelAttribute="form_partida" method="post">
	
	<form:hidden path="idpartida"/>
		
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Juego:</b>&nbsp; <form:input size="50" path="juego" />*
		<form:errors path="juego" cssClass="error" />
	<br /> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Plazas de:</b>&nbsp; <form:input size="1" path="plazasmin" />
		<form:errors path="plazasmin" cssClass="error" />
	&nbsp; a &nbsp;<form:input size="1" path="plazasmax"/>&nbsp;jugadores*  
		<form:errors path="plazasmax" cssClass="error" />
	&nbsp;&nbsp;<font color="red">${form_partida.mensaje_plazas}</font>
	<br/> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Fecha:</b>&nbsp; <form:input size="6" path="fechapartida"/>*
		<form:errors path="fechapartida" cssClass="error" />
	<br/> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Horario previsto de:</b>&nbsp; <form:input size="1" path="horainicio"/>
		<form:errors path="horainicio" cssClass="error" />
	&nbsp; a &nbsp;<form:input size="1" path="horafin" />*
		<form:errors path="horafin" cssClass="error" />
	&nbsp;&nbsp;<font color="red">${form_partida.mensaje_horas}</font>
	<br/> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;<b>Comentarios:</b>&nbsp; <form:input size="100" path="comentarios"/>
		<form:errors path="comentarios" cssClass="error" />
	<br/> <br />

	&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-primary mb-1" type="submit" name="Modificar" value="Modificar" >Modificar</button>
	<br/><br/>
</form:form>

&nbsp;&nbsp; <a href="cancel">Volver a lista de partidas</a>

</body>
</html>
