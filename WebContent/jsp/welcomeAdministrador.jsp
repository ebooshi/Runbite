<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Principal Administradore</title>
</head>
		<form action="ControladorCRUDMenu?action=agregar" method="post">
			<div>
				 <input type="submit" class="btn btn-success btn-lg" value=" agregar" name="agr" >
			</div>
		</form>	
		<form action="ControladorCRUDMenu?action=editar" method="post">
			<div>
				 <input type="submit" class="btn btn-success btn-lg" value="editar Menu" name="edt" >
			</div>
		</form>	
		<form action="ControladorCRUDMenu?action=registrarRepartidor" method="post">
			<div>
				 <input type="submit" class="btn btn-success btn-lg" value="Registrar repartidor" name="reg" >
			</div>
		</form>	
		<form action="controladorEstadoPedido?action=admin" method="post">
			<div>
				 <input type="submit" class="btn btn-success btn-lg" value="  estado  " name="est" >
			</div>
		</form>	
		<form action="ControladorCRUDMenu?action=salir" method="post">
			<div>
				 <input type="submit" class="btn btn-success btn-lg" value=" Salir" name="rgs" >
			</div>
		</form>	
<body>

</body>
</html>