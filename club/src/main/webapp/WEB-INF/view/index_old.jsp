<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Club de juegos Draco</title>

</head>
<body>
	<div class="jumbotron">
		<div class="float-right">
			<form:form action="${pageContext.request.contextPath}/formlogin"
				method="GET">
				<button type="submit" class="btn btn-primary mb-1">Acceso miembros</button>
			</form:form>
		</div>
	</div>
	<!--  <h1>Club de juegos Draco </h1>
	<br>
	<a href="${pageContext.request.contextPath}/formlogin">Acceso socios y colaboradores</a>
	<br>
	<p>Este es un club de juegos de mesa abierto a todo el mundo.</p>
	<p>Te invitamos a que te pases por nuestras instsalacioens y nos conozcas</p>  -->
	
	<!-- <img src="\src\main\webapp\WEB-INF\images\Club_Draco.jpg" width=50%>  -->
	<!--  <img th:src="@{/images/Club_Draco.jpg}"/>  -->
	<!-- <img src="https://example.com/image.jpg"/> -->
	<!--  <img src="https://example.com/image.jpg" width="200" height="267"> -->
	<!-- <img src="${pageContext.request.contextPath}/images/Club_Draco.jpg"> -->
</body>
</html>