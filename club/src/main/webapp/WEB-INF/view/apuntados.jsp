<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apuntados a la partida</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
				<h1>Apuntados a la partida</h1>
			</div>
		</div>
		
		<!--  {if ${apuntado} = "true"}
			<a href="${pageContext.request.contextPath}/apuntado/alta_apuntado"
				class="btn btn-primary mb-1">Apuntarse</a>-->


		<table class="table table-striped">
			<tr>
				<th>Numero</th>
				<th>Jugador</th>
				<th>Comentarios</th>
				<th></th>
			</tr>

			<c:forEach var="lineas" items="${lineas}">
				<tr>
					<td>${lineas.orden}</td>
					<td>${lineas.nombre}</td>
					<td>${lineas.comentarios}</td>
					<td>
						<c:if test="${lineas.esUsuario==true}">
  							<p style="background-color: green; color: white; text-align:center;">Apuntado</p>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<br/> <br />
	</div>
	
	<form:form action="procesar_apuntados" modelAttribute="form_apuntado" method="post">

			&nbsp;&nbsp;&nbsp;&nbsp;Comentarios:&nbsp; <form:input size="80" path="comentarios"/>
			<form:errors path="comentarios" cssClass="error" />
			<br/>
	   		<button type="submit" name="Alta" value="Alta">Alta</button>
			<br />
	</form:form>
	
	<c:url var="linkEditar" value="/apuntado/updateapuntado">
			<c:param name="idapuntado" value="${form_apuntado.idapuntado}" />
			<c:param name="comentarios" value="${form_apuntado.comentarios}" />
	</c:url>
	<c:url var="linkBorrar" value="/apuntado/deleteapuntado">
			<c:param name="idapuntado" value="${form_apuntado.idapuntado }" />
	</c:url>
	<c:url var="linkAdd" value="/apuntado/addapuntado">
			<c:param name="idpartida" value="${form_apuntado.idpartida}" />
	</c:url>
			
	<c:if test="${form_apuntado.idapuntado> 0}">
		&nbsp;&nbsp;
		<a href="${linkEditar }" class="btn btn-outline-success btn-sm">Actualizar</a>
		&nbsp;&nbsp;&nbsp;
		<a href="${linkBorrar }"
			onclick="if(!confirm('¿Está seguro?')) return false"
			class="btn btn-outline-danger btn-sm">Desapuntar
		</a>
	</c:if>
	<c:if test="${form_apuntado.idapuntado == 0}">
		<a href="${linkAdd }" class="btn btn-outline-success btn-sm">Añadirse</a>
	</c:if>
	&nbsp;&nbsp;&nbsp;&nbsp;${form_apuntado.mensaje}
	<br>
	&nbsp;&nbsp; <a href="cancel">Volver a lista de partidas</a>
</body>
</html>