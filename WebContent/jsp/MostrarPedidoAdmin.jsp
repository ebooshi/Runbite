<%@ page import ="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos Administrador</title>

<script>
function alerta(){
	alert("Estado cambiado!");
}

</script>

</head>
<body>

<h1 align="center">Pedidos Administrador</h1>
<% List<Float> total = (List<Float>)(request.getAttribute("total")); 
	int i=0;
%>


<table border="1" width="40%" align="center">
	<td align="center"> Pedido </td>
	
	<td align="center"> Platillos </td> 
	<td align="center"> Estado </td>
	<td align="center"> Cambiar estado</td>
	<c:forEach var="pedido" items="${lista}">
		<tr>
		<td>
		Calle: 
		<c:out value="${pedido.calle}"/> 
		<br>
		Numero:
		<c:out value="${pedido.numero}"/> 
		<br>
		Ciudad:
		<c:out value="${pedido.ciudad}"/>
		<br>
		Municipio: 
		<c:out value="${pedido.destinatario}"/>
		<br>
		Destinatario:
		<c:out value="${pedido.municipio}"/>
		<br>
		Total: <%= total.get(i) %>
		<%i++; %>
		
		</td>
		
		<td align="center">
		<input type="button" value="Platillos" onClick="location.href='controladorEstadoPedido?action=platos&idPedido=${pedido.id}'"/>
		</td>
		<td align="center"><c:out value="${pedido.estado }"/></td>
		<td align="center">
				        
		<input type="radio" value="Listo" onClick="alerta();location.href='controladorEstadoPedido?action=actualizarPedidoAdmin&id=<c:out value="${pedido.id}"/>&ESTADO=Listo';"> Listo 
		    
	    </td>
		 </tr>
	</c:forEach>

</table>

<a href="controladorEstadoPedido?action=index">Regresar al Panel</a>

</body>
</html>

