<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Platillo </title>
</head>
<body>

Nombre : <c:out value="${p.nombre}"/><br>
Descripcion: <c:out value="${p.descripcion }"/><br> 
Precio : <c:out value="${p.precio}"/> <br>


</body>
</html>