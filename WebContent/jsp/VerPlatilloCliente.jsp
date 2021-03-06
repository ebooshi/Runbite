<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Platillos</title>
</head>
<body>
	<h1>Platillos</h1>
				<% String cliente = (String)request.getAttribute("cliente"); 
					out.println("Cliente: "+ cliente);
				%>	
	<table border="0" width="100%">
	<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	<td align="center"><input type="button" onClick="location.href='ControladorVerPlatillo?action=carrito&cliente=<%=cliente%>'" value="Ver Carrito"></td>
	</tr>
	<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>	
	</tr>
	
		<tr>
		 <td></td>
		 <td align="center">Platillo</td>
		 <td align="center">Descripcion</td>
		 <td align="center">Precio</td>
		 <td align="center">Agregar al carrito</td>
		</tr>
		
		<c:forEach var="articulo" items="${lista}">
			<tr>
				<td></td>
				<td align="center"><c:out value="${articulo.nombre}"/></td>
				<td align="center"><c:out value="${articulo.descripcion}"/></td>
				<td align="center"><c:out value="${articulo.precio}"/></td>
				<td align="center">

<input type="button" onClick="alerta();location.href='ControladorVerPlatillo?action=agregar&idPlatillo=<c:out value="${articulo.id}" />&cliente=<%=cliente%>'" value="Agregar">
				
				</td>
			</tr>
		</c:forEach>
	</table>
	<table align="center">
			<tr>
			<td><a href="ControladorVerPlatillo?action=index" >Salir</a> </td>
			</tr>
	</table>
<script type="text/javascript">

function alerta(){
	alert("Platillo seleccionado");
}

</script>
	
</body>
</html>