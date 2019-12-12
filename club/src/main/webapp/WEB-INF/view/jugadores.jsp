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
				Usuario:
				<sec:authentication property="principal.username" />
				<br>
				<form:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					<button type="submit" class="btn btn-primary mb-1">Salir</button>
				</form:form>
			</div>
			<div>
				<h1>Usuarios registrados</h1>
			</div>
		</div>
		
		<sec:authorize access="hasAnyRole('SOCIO','ADMINISTRADOR')">
			<a href="${pageContext.request.contextPath}/partida/addpartida"
				class="btn btn-primary mb-1">Alta usuario</a>
		</sec:authorize>

		<table class="table table-striped">
			<tr>
				<th>Usuario</th>
				<th>Num. Socio</th>
				<th>Nombre</th>
				<th>Nivel</th>
				<th>Acciones</th>
			</tr>

			<c:forEach var="lineas" items="${lineas}">
				<c:url var="linkEditar" value="/jugadores/updatejugador">
					<c:param name="username" value="${lineas.username }" />
				</c:url>
				<c:url var="linkBorrar" value="/jugadores/deletejugador">
					<c:param name="username" value="${lineas.username }" />
				</c:url>
				<tr>
					<td>${lineas.username }</td>
					<td>${lineas.numsocio }</td>
					<td>${lineas.nombre }</td>
					<td>${lineas.tipo }</td>
					<td>
						<a href="${linkEditar }" class="btn btn-outline-success btn-sm">Editar</a>
						<a href="${linkBorrar }"
							onclick="if(!confirm('¿Está seguro?')) return false"
							class="btn btn-outline-danger btn-sm">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>