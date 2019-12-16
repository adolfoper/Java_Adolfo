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
<title>Partidas</title>
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
				<b>Usuario:</b>
				<sec:authentication property="principal.username" />
				<br>
				<form:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					<button type="submit" class="btn btn-primary mb-1">Salir</button>
				</form:form>
				<sec:authorize access="hasRole('ADMINISTRADOR')">
					<br>
					<a href="${pageContext.request.contextPath}/jugador/index_jugadores"
					class="btn btn-warning">Mantenimiento Usuarios</a>
				</sec:authorize>
			</div>
			<div>
				<h1>Partidas abiertas</h1>
			</div>
		</div>
		
		<sec:authorize access="hasAnyRole('SOCIO','ADMINISTRADOR')">
			<a href="${pageContext.request.contextPath}/partida/addpartida"
				class="btn btn-primary mb-1">Crear partida</a>
		</sec:authorize>

		<table class="table table-striped">
			<tr>
				<th>Juego</th>
				<th>Creador</th>
				<th>Fecha partida</th>
				<th>Hora inicio</th>
				<th>Hota fin</th>	
				<th>Plazas</th>		
				<th>Jugadores apuntados</th>
				<th>Comentarios</th>
				<sec:authorize access="hasAnyRole('SOCIO','ADMINISTRADOR')">
					<th>Acciones</th>
				</sec:authorize>
			</tr>

			<c:forEach var="lineas" items="${lineas}">
				<c:url var="linkEditar" value="/partida/updatepartida">
					<c:param name="idpartida" value="${lineas.idpartida }" />
				</c:url>
				<c:url var="linkBorrar" value="/partida/deletepartida">
					<c:param name="idpartida" value="${lineas.idpartida }" />
				</c:url>
				<c:url var="linkApuntados" value="/apuntado/apuntados">
					<c:param name="idpartida" value="${lineas.idpartida }" />
				</c:url>
				<tr>
					<td>${lineas.juego }</td>
					<td>${lineas.creador }</td>
					<td>${lineas.fechapartida }</td>
					<td>${lineas.horainicio }</td>
					<td>${lineas.horafin }</td>
					<td>${lineas.plazas }</td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="${linkApuntados }">${lineas.numApuntados}</a></td>
					<td>${lineas.comentarios }</td>
					<sec:authorize access="hasAnyRole('SOCIO','ADMINISTRADOR')">
						<td>
							<a href="${linkEditar }" class="btn btn-outline-success btn-sm">Editar</a>						
							<a href="${linkBorrar }"
								onclick="if(!confirm('¿Está seguro?')) return false"
								class="btn btn-outline-danger btn-sm">Borrar</a>
						</td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>