<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta de partida</title>
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
			Usuario:
			<sec:authentication property="principal.username" />
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<button type="submit" class="btn btn-warning">Salir</button>
			</form:form>
		</div>
		<div>
			<h1>Alta de partidas</h1>
		</div>
	</div>
</div>
<br />

<form:form action="procesar_alta_partida" modelAttribute="form_partida" method="post">
	
	<form:hidden path="idpartida" value="0"/>
	
	&nbsp;&nbsp;&nbsp;&nbsp;Juego:&nbsp; <form:input size="50" path="juego" />*
		<form:errors path="juego" cssClass="error" />
	<br /> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Plazas de:&nbsp; <form:input size="1" path="plazasmin" />
		<form:errors path="plazasmin" cssClass="error" />
	&nbsp; a &nbsp;<form:input size="1" path="plazasmax"/>&nbsp;jugadores*  
		<form:errors path="plazasmax" cssClass="error" />
	<br/> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Fecha:&nbsp; <form:input size="6" path="fechapartida"/>*
		<form:errors path="fechapartida" cssClass="error" />
	<br/> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Horario previsto de:&nbsp; <form:input size="1" path="horainicio"/>
		<form:errors path="horainicio" cssClass="error" />
	&nbsp; a &nbsp;<form:input size="1" path="horafin" />* &nbsp;&nbsp;<font color="red">${form_partida.mensaje}</font>
		<form:errors path="horafin" cssClass="error" />
	<br/> <br />
	
	&nbsp;&nbsp;&nbsp;&nbsp;Comentarios:&nbsp; <form:input size="100" path="comentarios"/>
		<form:errors path="comentarios" cssClass="error" />
	<br/> <br />

	&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-primary mb-1" type="submit" name="Alta" value="Alta" >Alta</button>
	<!--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">${form_partida.mensaje}</font>-->
	<br/><br/>
</form:form>

&nbsp;&nbsp; <a href="cancel">Volver a lista de partidas</a>

</body>
</html>
