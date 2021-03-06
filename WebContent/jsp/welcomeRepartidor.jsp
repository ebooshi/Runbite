<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido Repartidor</title>
</head>
<body>
	<h1>Bienvenido!</h1>
	<% String repartidor = (String)request.getAttribute("usuario"); 
					out.println("repartidor: "+ repartidor);
	%><br>	
	<input type="button" onClick="location.href='controladorSeleccionPedido?action=rep&repartidor=<%=repartidor%>'" value ="Seleccionar">
</body>
</html>