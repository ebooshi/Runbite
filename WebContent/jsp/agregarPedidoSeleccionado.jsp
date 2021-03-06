<%@ page import ="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seleccionar Pedido</title>
</head>
<body>
	<h1 align="center">Selecciona el/los pedido(s) que deseas entregar </h1>
	<table border="1" align="center" width="40%">
        <td align="center">Pedidos</td>
        <td align="center">Platillo</td>
        <td align="center">Estado</td>
        <td align="center">Seleccionar</td>
        
        <% List<Float> total = (List<Float>)(request.getAttribute("total")); 
			int i=0;
			String repartidor = (String)request.getParameter("repartidor");
			//String repartidor= "mhs@hotmail.com";
			%>
        <c:forEach var="pedido" items="${listaRep}">
        <tr>
            <td>
                Calle: 
                <c:out value="${pedido.calle}" />
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
                
                <br>
            </td>
            <td align="center">
            <input type="button" value="Platillos" onClick="location.href='controladorEstadoPedido?action=platos&idPedido=${pedido.id}'"/>
            </td>
            <td align="center"><c:out value="${pedido.estado }"/></td>
            <td align="center">
					<input type="button" onClick="location.href='controladorSeleccionPedido?action=agregar&id=${pedido.id}&repartidor=<%=repartidor%>&estado=${pedido.estado}'" value="Seleccionar" > 
            </td>
            
        </c:forEach>
	</table>
	<a href="controladorSeleccionPedido?action=index">Cerrar sesion</a>
	
</body>
</html>