<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Artículos</title>
</head>
<body>
	<h1>Menu</h1><br></br>
		<form action="ControladorCRUDMenu?action=regresar" method="post">
			<div>
    			<input type="submit" class="btn btn-success btn-lg" value="Cancelar" name="regresar" />
			</div>
		</form>			
		<br></br> <br></br>
	

		<c:forEach var="articulo" items="${lista}"><br></br>
				<td><c:out value="ID: ${articulo.id}"/></td><br></br>
				<td><c:out value="Nombre: ${articulo.nombre}"/></td><br></br>
				<td><c:out value="Descripcion: ${articulo.descripcion}"/></td><br></br>
				<td><c:out value="Precio: ${articulo.precio}"/></td><br></br>
				<td><a href="ControladorCRUDMenu?action=showedit&id=<c:out value="${articulo.id}" />">Editar</a></td><br></br>
				<td><a href="ControladorCRUDMenu?action=eliminar&id=<c:out value="${articulo.id}"/>">Eliminar</a> </td>				
				<td><a href="ControladorCRUDMenu?action=ver&id=<c:out value="${articulo.id}"/>">ver</a> </td>	
		</c:forEach>
	
</body>
</html>