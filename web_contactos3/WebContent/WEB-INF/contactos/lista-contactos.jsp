<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contactos</title>
</head>
<body>
	<a href="alta_contacto">A�adir contacto</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	${mensaje}
	<br />
	<h1>Contactos actuales</h1>
	<table >
	<tr>
	<td><b>Id</b></td>
	<td><b>Nombre</b></td>
	<td><b>Telefono</b></td>
	<td><b>Email</b></td>
	<td><b>Acciones</b></td>
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
			<td> <a href="${linkBorrar }"onclick="if(!confirm('�Est�seguro?')) return false">Borrar</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>