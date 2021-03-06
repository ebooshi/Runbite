<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Pedidos" %>
<%@page import="modelo.Platillo" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrito</title>
</head>
<body>
	<h1>Tu carrito</h1>
		<% String cliente = (String)request.getAttribute("cliente"); 
					out.println("Cliente: "+ cliente);
				%>
	<table border="0" width="60%" align="center">
		<tr>
		 <td>Nombre</td>
		 <td>Descripcion</td>
		 <td>Precio</td>
		 <td>Eliminar del Carrito</td>
		</tr>
		<tr>
		<td><br></td>
		<td><br></td>
		<td><br></td>		
		</tr>
		<c:forEach var="carrito" items="${carrito}">
			<tr>
			
				<td><c:out value="${carrito.nombre}"/> <br> </td>
				<td><c:out value="${carrito.descripcion }"/> </td>
				<td> $ <c:out value="${carrito.precio}"/></td>
				<td><input type="button" onClick="location.href='ControladorVerPlatillo?action=eliminar&id=${carrito.id}&cliente=<%=cliente%>'" value="Eliminar"></td>
			</tr>
		</c:forEach>
		<tr>
			<td><br></td>
			<td><br></td>
			<td><br></td>
		</tr>
		<tr>
			<td></td>
			<td align="right">Total: $</td>
			<td> <c:out value="${total}"/> </td>
		</tr>
		<tr>
		<td><br></td>
		<td><br></td>
		<td> <input type="button" onClick=" location.href='controlConfPedido?action=detalles&id=${idPedido}&cliente=<%=cliente%>'" value="Confirmar"> </td> 
		</tr>
	</table>
	<input type="button" onClick="location.href='ControladorVerPlatillo?action=mostrar&cliente=<%=cliente %>'" value="Agregar más platillos"> <br>
	
</body>
</html>