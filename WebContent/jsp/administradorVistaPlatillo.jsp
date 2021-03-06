<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Platillos</title>
</head>
<body>
	<h1>Lista  Platillos</h1>

	<form action="ControladorCRUDMenu?action=editar" method="post">
    		<input type="submit" value="Cancelar" />
	</form>	<br></br> <br></br>
	

				<td><c:out value="ID: ${platillo.id}"/></td><br></br>
				<td><c:out value="Nombre: ${platillo.nombre}"/></td><br></br>
				<td><c:out value="Descripcion: ${platillo.descripcion}"/></td><br></br>
				<td><c:out value="Precio: ${platillo.precio}"/></td><br></br>

	
</body>
</html>