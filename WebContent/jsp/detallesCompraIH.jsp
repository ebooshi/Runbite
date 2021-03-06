<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>
    Detalles de tu pedido
    </title>
<body >
<% List<Float> total = (List<Float>)(request.getAttribute("total"));
%>

<table align="center">
	<td>
		<h1>Direccion</h1>
	</td>
<tr align="left">
<td>
		Calle: <c:out value="${detalles.calle}"/>
		<br>
		Número: <c:out value="${detalles.numero}"/>
		<br>
		Ciudad: <c:out value="${detalles.ciudad}"/>
		<br>
		Municipio: <c:out value="${detalles.municipio}"/>
		<br>
		Destinatario: <c:out value="${detalles.destinatario}"/> 
		<br>
</td>
</tr>
<tr><td><br></td></tr>
<tr><td><br></td></tr>
<tr>
<td>Total: <%= total.get(0) %></td>
</tr>
<tr></tr>
<tr></tr>
<tr>
<td>
<% 
	String id=request.getParameter("id");
    String cliente = (String)request.getAttribute("cliente"); 
    out.println("Cliente: "+ cliente);
%><br>

<input type="button" onClick="location.href='controlConfPedido?action=shD&id=<%=id%>&cliente=<%=cliente%>'" value="Cambiar Direccion">
</td>

</tr>
<tr>
<td>
<input type="button" onClick="conf();location.href='controlConfPedido?action=index'" value="Confirmar">
<input type="button" onClick="location.href='ControladorVerPlatillo?action=mostrar&cliente=<%=cliente%>'" value="Cancelar" >
</td>
</tr>
</table>

<script>
function conf(){
	alert("Pedido Confirmado!");
	
}
</script>

</body>
</html>

