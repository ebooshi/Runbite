<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Platillo</title>
</head>
<body>
<h1>Editar Platillo</h1>
	<form action="ControladorCRUDMenu?action=TRANSEDITAR" method="post" >
		<table>
			<tr>
				<td><label>Id</label></td>
				<td><input type="text" name="id" value="<c:out value="${articulo.id}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre" value='<c:out value="${articulo.nombre}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Descripción</label></td>
				<td><input type="text" name="descripcion" value='<c:out value="${articulo.descripcion}"></c:out>' ></td>
			</tr>			
			<tr>
				<td><label>Precio</label></td>
				<td><input type="text" name="precio" value='<c:out value="${articulo.precio}"></c:out>' ></td>
			</tr>
		</table>
	
		<input type="submit" name="registrar" value="Guardar"> 
	</form>
	
	<form action="ControladorCRUDMenu?action=editar" method="post">
    		<input type="submit" value="Cancelar" />
	</form>	<br></br> <br></br>

</body>
</html>