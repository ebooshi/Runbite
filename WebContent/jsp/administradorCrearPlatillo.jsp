<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Platillo</title>
</head>
<body>
	<div class="form-style-2">
		<div class="form-style-2-heading">Registrar Nuevo Platillo</div>
			<form action="ControladorCRUDMenu?action=TRANSREGISTER" method="post"><br></br>
				<div class="form-group">
						<input type="text" name="field1" 
						class="form-control input-lg" placeholder="nombre">
				</div>
				<div class="form-group">
						<input type="text" name="field2" 
						class="form-control input-lg" placeholder="precio">
				</div>
				<div class="form-group">
						<input type="text" name="field3" 
						class="form-control input-lg" placeholder="descripcion">
				</div>
				<div>
						<input type="submit" class="btn btn-success btn-lg" value="Ok" name="agregar">
				</div>
			</form>
			<form action="ControladorCRUDMenu?action=regresar" method="post">
				<div>
    				<input type="submit" class="btn btn-success btn-lg" value="Cancelar" name="regresar" />
				</div>
			</form>	
		</div>
</body>
</html>