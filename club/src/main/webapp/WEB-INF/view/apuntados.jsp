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
					<button type="submit" class="btn btn-primary mb-1">Salir</button>
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

			<form:input type="hidden" size="80" path="idpartida"/>
			<form:input type="hidden" size="80" path="idapuntado"/>
			
			&nbsp;&nbsp;&nbsp;&nbsp;Comentarios:&nbsp; <form:input size="80" path="comentarios"/>
			<form:errors path="comentarios" cssClass="error" />
			<br/>
			<br/>
		
			<param name="comentarios" value="${form_apuntado.comentarios}" >
			<param name="idapuntado" value="${form_apuntado.idapuntado}" /> 
			<param name="idpartida" value="${form_apuntado.idpartida}" /> 
			
			<c:if test="${form_apuntado.idapuntado> 0}">
				&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary mb-1" name="accion" value="Actualizar">Actualizar</button>
				&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary mb-1" name="accion" value="Desapuntar">Desapuntar</button>
			</c:if>
			<c:if test="${form_apuntado.idapuntado == 0}">
				&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary mb-1" name="accion" value="Apuntar">Apuntarse</button>
			</c:if>
			<br />	
			&nbsp;&nbsp;&nbsp;&nbsp;${form_apuntado.mensaje}
			<br>
			&nbsp;&nbsp; <a href="cancel">Volver a lista de partidas</a>	
	</form:form>
	
</body>
</html>