<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido!</title>
</head>
<body>
<center>
 	<h1>Bienvenido!</h1>
 	<% String cliente = (String)request.getAttribute("usuario"); 
					out.println("Cliente: "+ cliente);
	%><br>		
	<input type="button" onClick="location.href='ControladorVerPlatillo?action=mostrar&cliente=<%=cliente %>'" value="Continuar al Menu">
	
</center>
</body>
</html>