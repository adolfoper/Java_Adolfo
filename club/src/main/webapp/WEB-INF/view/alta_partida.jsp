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
	
	&nbsp&nbsp&nbsp&nbspJuego: <form:input size="50" path="juego" />*
		<form:errors path="juego" cssClass="error" />
	<br /> <br />
	
	&nbsp&nbsp&nbsp&nbspPlazas de: <form:input size="2" path="plazasmin" />
		<form:errors path="plazasmin" cssClass="error" />
	&nbsp a &nbsp<form:input size="2" path="plazasmax"/>&nbspjugadores&nbsp*  
		<form:errors path="plazasmax" cssClass="error" />
	<br/> <br />
	
	&nbsp&nbsp&nbsp&nbspFecha: <form:input size="10" path="fechapartida"/>*
		<form:errors path="fechapartida" cssClass="error" />
	<br/> <br />
	
	&nbsp&nbsp&nbsp&nbspHorario previsto de: <form:input size="5" path="horainicio" value="00:00"/>
		<form:errors path="horainicio" cssClass="error" />
	&nbsp a &nbsp<form:input size="5" path="horafin" value="00:00" />*
		<form:errors path="horafin" cssClass="error" />
	<br/> <br />
	
	&nbsp&nbsp&nbsp&nbspComentarios: <form:input size="100" path="comentarios"/>
		<form:errors path="comentarios" cssClass="error" />
	<br/> <br />

	<br/><br/>
	   &nbsp&nbsp&nbsp&nbsp<button type="submit" name="Alta" value="Alta">Alta</button>
	<br />
</form:form>

<!-- <button type="submit" name="Cancelar" value="Index2">Cancelar</button> -->
<br />
&nbsp&nbsp&nbsp&nbsp<a href="cancel">Volver a lista de partidas</a>

</body>
</html>
