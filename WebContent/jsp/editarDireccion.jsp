<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direccion</title>
</head>
<body>
<%
	String id=request.getParameter("id"); 
	String cliente = (String)request.getAttribute("cliente"); 
	out.println("Cliente: "+ cliente);
%>
<h1 align="center">Confirmar Direccion</h1>
	<form action="controlConfPedido?action=editar&id=<%=id%>&cliente=<%=cliente %>" method="post" >
		<table align ="center" >
			<tr>
				<td><label>Calle</label></td>
				<td><input type="text" name="calle" value='<c:out value="${pedidoEditando.calle}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Numero</label></td>
				<td><input type="text" name="numero" value='<c:out value="${pedidoEditando.numero}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Ciudad</label></td>
				<td><input type="text" name="ciudad" value='<c:out value="${pedidoEditando.ciudad}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Municipio</label></td>
				<td><input type="text" name="municipio" value='<c:out value="${pedidoEditando.municipio}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Destinatario</label></td>
				<td><input type="text" name="destinatario" value='<c:out value="${pedidoEditando.destinatario}"></c:out>' ></td>
			</tr>
			<tr>
		
			</tr>	
		</table>
		<br>
		<table align="center">
			<td> <input type="submit" name="editar" value="Guardar" onclick="fun()" ></td>
		</table>
		 
		<script type="text/javascript">
		function fun(){
			alert("Dirección guardada!");
		}
		</script>
	</form>
	<input type="button" onClick="location.href='ControladorVerPlatillo?action=mostrar&cliente=<%=cliente %>'" value="Cancelar"> <br>
	
</body>
</html>