<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Platillos</title>
</head>
<%@ page import="dao.PedidosDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Platillo" %>

<% List<Platillo> pl ;%>
<body>

<br>
<br>
<c:forEach var="idPlatillos" items="${platillos}"> 
<input type="button" 
	onClick="location.href='controladorEstadoPedido?action=porIdPla&idPlatillo=<c:out value="${idPlatillos}"/>'" 
	value="Platillo : <c:out value="${idPlatillos}"/>" />  <br>


</c:forEach>

</body>
</html>