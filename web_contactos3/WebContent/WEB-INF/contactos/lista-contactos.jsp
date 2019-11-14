<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contactos</title>
</head>
<body>
	<a href="alta_contacto">Añadir contacto</a>
	<br />
	<h1>Contactos actuales</h1>
	<table >
	<tr>
	<td>Id</td>
	<td>Nombre</td>
	<td>Telefono</td>
	<td>Email</td>
	<td>Acciones</td>
	</tr>
	
	<c:forEach var="contacto" items="${contactos}">
		<c:url var="linkEditar" value="/modificar_contacto">
			<c:param name="idcontacto" value="${contacto.idcontacto }"/>
		</c:url>
		<c:url var="linkBorrar" value="/borrar_contacto">
			<c:param name="idcontacto" value="${contacto.idcontacto }"/>
		</c:url>
		<tr>
			<td>${contacto.idcontacto }</td>
			<td>${contacto.nombre }</td>
			<td>${contacto.telefono }</td>
			<td>${contacto.email }</td>
			<td> <a href="${linkEditar }">Modificar</a> </td>
			<td> <a href="${linkBorrar }"onclick="if(!confirm('¿Estáseguro?')) return false">Borrar</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>